package net.osdilites.tekora.block.entities.transporter.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.util.UtilFunctions;

public class TekoraPipeEntity extends BlockEntity {
    private static final float PIPE_DURABILITY = 500.0f;
    private float durability;
    private final float chemResistance;
    private final boolean isPlastic;
    private final float maxTemp;
    public TekoraPipeEntity(BlockPos worldPosition, BlockState blockState, float chemResistance, boolean isPlastic, float maxTemp) {
        super(TekoraBlockEntities.PIPE.get(), worldPosition, blockState);
        this.chemResistance = chemResistance;
        this.isPlastic = isPlastic;
        this.maxTemp = (float)UtilFunctions.fromMcTempToKelvins(maxTemp);
        this.durability = PIPE_DURABILITY;
    }

    public TekoraPipeEntity(BlockPos worldPosition, BlockState blockState) {
        this(worldPosition, blockState, 0.8f, false, 12.0f);
    }

    public void tick(Level level, BlockPos pos, BlockState blockState) {
        if (!level.isClientSide()) {
            float degradationRate = 0; // todo, make a fluid container and use the values in that
            float diff = (float)UtilFunctions.getBiomeTemperature(level, pos) - maxTemp; // todo, we'll also use fluid temperature
            float tempInduced = diff > 0 ? (1 + diff + 4 * diff * diff) : 1;
            durability -= degradationRate * chemResistance * tempInduced * 0.05f;
        }
    }
}

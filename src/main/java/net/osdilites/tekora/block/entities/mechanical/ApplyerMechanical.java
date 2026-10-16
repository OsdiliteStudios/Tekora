package net.osdilites.tekora.block.entities.mechanical;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.item.TekoraItems;
import org.jspecify.annotations.Nullable;

public class ApplyerMechanical extends AbstractModularMachine{
    public static final MapCodec<ApplyerMechanical> CODEC = simpleCodec(ApplyerMechanical::new);

    private ApplyerMechanical(Properties properties) {
        super(properties);
    }

    public ApplyerMechanical() {
        this(Properties.ofFullCopy(Blocks.STONECUTTER).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, "assembler"))));
    }

    @Override
    public Item getAssocItem() {
        return TekoraItems.APPLYING_SHAFT.get();
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ApplyerMechanicalEntity(blockPos, blockState);
    }

    @Override 
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type) {
        return createTickerHelper(type, TekoraBlockEntities.APPLYER.get(), (lvl, pos, state, block) -> block.tick(lvl, pos, state));
    }
}

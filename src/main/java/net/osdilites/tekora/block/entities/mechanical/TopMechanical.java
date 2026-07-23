package net.osdilites.tekora.block.entities.mechanical;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.Tekora;
import org.jspecify.annotations.Nullable;

public class TopMechanical extends AbstractModularMachine {
    private static final MapCodec<TopMechanical> CODEC = simpleCodec(TopMechanical::new);

    private TopMechanical(Properties properties) {
        super(properties);
    }

    public TopMechanical() {
        this(Properties.ofFullCopy(Blocks.CRAFTER).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, "mechanical_top"))));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TopMechanicalEntity(blockPos, blockState);
    }
}

package net.osdilites.tekora.block.entities;

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
import org.jetbrains.annotations.Nullable;

public class Depot extends BaseEntityBlock {
    public static final MapCodec<Depot> CODEC = simpleCodec(Depot::new);

    protected Depot(Properties pProperties) {
        super(pProperties);
    }

    public Depot() {
        this(Properties.ofFullCopy(Blocks.STONE_BRICKS).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, "depot"))));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new DepotEntity(pPos, pState);
    }
}

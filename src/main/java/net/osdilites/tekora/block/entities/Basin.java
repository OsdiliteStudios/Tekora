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

public class Basin extends BaseEntityBlock {
    public static final MapCodec<Basin> CODEC = simpleCodec(Basin::new);

    protected Basin(Properties pProperties) {
        super(pProperties);
    }

    public Basin() {
        this(Properties.ofFullCopy(Blocks.CAULDRON).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, "basin"))));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BasinEntity(pPos, pState);
    }
}

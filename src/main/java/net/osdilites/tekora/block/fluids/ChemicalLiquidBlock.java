package net.osdilites.tekora.block.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;
import net.osdilites.tekora.fluid.types.ChemicalFluidType;
import net.osdilites.tekora.fluid.types.TekoraFluidTypes;
import org.jspecify.annotations.Nullable;

public class ChemicalLiquidBlock extends LiquidBlock implements EntityBlock {
    public ChemicalLiquidBlock(FlowingFluid fluid, String str) {
        super(fluid, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, str))));
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pType) {
        return pType == TekoraBlockEntities.CHEMICAL_LIQUID.get() ? (level, pos, state, block) -> ((ChemicalLiquidBlockEntity)block).tick(level, pos, state) : null;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ChemicalLiquidBlockEntity(fluid.getFluidType() instanceof ChemicalFluidType type ? type : (ChemicalFluidType)TekoraFluidTypes.WATER_TYPE.get(), blockPos, blockState);
    }
}

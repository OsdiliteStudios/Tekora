package net.osdilites.tekora.block.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.datagen.tags.TekoraTags;
import net.osdilites.tekora.fluid.ChemicalFluid;
import net.osdilites.tekora.fluid.ChemicalFluidType;

public class ChemicalLiquidBlock extends LiquidBlock {
    public ChemicalLiquidBlock(FlowingFluid fluid, String str) {
        super(fluid, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, str))));
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        super.entityInside(state, level, pos, entity, effectApplier, isPrecise);
        if (fluid instanceof ChemicalFluid chemFluid && chemFluid.getFluidType() instanceof ChemicalFluidType type && entity instanceof LivingEntity living) {
            if (TekoraTags.Entities.getsHarmed(type, living)) {
                type.effectLivingBad(living);
            } else if (TekoraTags.Entities.getsPowered(type, living)) {
                type.effectLivingGood(living);
            }
        }
    }
}

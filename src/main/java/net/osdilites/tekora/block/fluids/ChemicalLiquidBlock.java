package net.osdilites.tekora.block.fluids;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.osdilites.tekora.Tekora;

public class ChemicalLiquidBlock extends LiquidBlock {
    public ChemicalLiquidBlock(FlowingFluid fluid, String str) {
        super(fluid, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, str))));
    }
}

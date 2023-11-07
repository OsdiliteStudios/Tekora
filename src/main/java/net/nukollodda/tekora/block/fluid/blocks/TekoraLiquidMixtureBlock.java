package net.nukollodda.tekora.block.fluid.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.registries.ForgeRegistries;
import net.nukollodda.tekora.block.fluid.TekoraFluidType;
import net.nukollodda.tekora.util.FluidFunctions;

import java.util.function.Supplier;

public class TekoraLiquidMixtureBlock extends TekoraLiquidBlock {
    private final String postBoilLeftover;

    public TekoraLiquidMixtureBlock(Supplier<? extends FlowingFluid> pFluid, String pSolid, String pBoilLeftover) {
        super(pFluid, pSolid);
        this.postBoilLeftover = pBoilLeftover;
    }

    public TekoraLiquidMixtureBlock(Supplier<? extends FlowingFluid> pFluid, String pSolid) {
        this(pFluid, pSolid, "");
    }

    // final parameter determines that the fluid in question's second param is the evaporation leftover material rather than the solid form.
    public TekoraLiquidMixtureBlock(Supplier<? extends FlowingFluid> pFluid, String pBoilLeftover, boolean ignored) {
        this(pFluid, "", pBoilLeftover);
    }

    public TekoraLiquidMixtureBlock(Supplier<? extends FlowingFluid> pFluid) {
        this(pFluid, "", "");
    }

    public Item getItemLeftover() {
        ResourceLocation meltedKey = new ResourceLocation(this.postBoilLeftover);
        if (ForgeRegistries.ITEMS.containsKey(meltedKey)) {
            return ForgeRegistries.ITEMS.getValue(meltedKey);
        }
        return null;
    }

    public Block getBlockLeftover() {
        ResourceLocation meltedKey = new ResourceLocation(this.postBoilLeftover);
        if (ForgeRegistries.BLOCKS.containsKey(meltedKey)) {
            return ForgeRegistries.BLOCKS.getValue(meltedKey);
        }
        return null;
    }

    @Override
    protected void onBoil(Level pLevel, BlockPos pPos, TekoraFluidType pType, float pPressure) {
        FluidFunctions.applyBoilingEffectsToEntities(pLevel, pPos, pType, pPressure);
        if (getBlockLeftover() != null) {
            pLevel.setBlock(pPos, getBlockLeftover().defaultBlockState(), 3);
        } else if (getItemLeftover() != null) {
            pLevel.addFreshEntity(new ItemEntity(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(),
                    new ItemStack(getItemLeftover())));
        }
    }
}

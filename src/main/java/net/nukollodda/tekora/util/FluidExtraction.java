package net.nukollodda.tekora.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.registries.ForgeRegistries;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.item.typical.IonicParts;

public class FluidExtraction {
    private static final Block[] SOLVENTS = new Block[]{Blocks.WATER};

    public static LiquidBlock getPureForm(IonicParts.Ions pIon, int pBiomeTemp, int pBoilingPoint) {
        String type = "_gas";
        if (pBiomeTemp < pBoilingPoint) {
            type = "_fluid";
        }
        ResourceLocation meltedKey = new ResourceLocation(Tekora.MODID, "block.tekora." + pIon.toString().toLowerCase() + type);
        if (ForgeRegistries.BLOCKS.containsKey(meltedKey) &&
                ForgeRegistries.BLOCKS.getValue(meltedKey) instanceof LiquidBlock liquid) {
            return liquid;
        }
        return null;
    }
}

package net.tekoramods.tekora.fluid;

import net.minecraft.resources.ResourceLocation;
import net.tekoramods.tekora.Tekora;

public class TekoraFluidTextures {
    public static final ResourceLocation WATER_STILL_RL = ResourceLocation.withDefaultNamespace("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = ResourceLocation.withDefaultNamespace("block/water_flow");
    public static final ResourceLocation LAVA_STILL_RL = ResourceLocation.withDefaultNamespace("block/lava_still");
    public static final ResourceLocation LAVA_FLOWING_RL = ResourceLocation.withDefaultNamespace("block/lava_flow");
    public static final ResourceLocation WATER_OVERLAY = ResourceLocation.withDefaultNamespace("block/water_overlay");

    // fluid texture registration
    public static final ResourceLocation GAS_RL = ResourceLocation.fromNamespaceAndPath(Tekora.MODID, "block/gas");
}

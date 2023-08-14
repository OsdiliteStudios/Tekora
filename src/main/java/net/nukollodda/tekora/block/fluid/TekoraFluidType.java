package net.nukollodda.tekora.block.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.nukollodda.tekora.block.fluid.data.TekoraFluidData;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.function.Consumer;

public class TekoraFluidType extends FluidType {
    private final ResourceLocation stillTexture;
    private final ResourceLocation flowingTexture;
    private final ResourceLocation overlayTexture;
    private final int tintColor;
    private final Vector3f fogColor;
    private final TekoraFluidData fluidData;
    private final boolean isGas;

    public TekoraFluidType(final ResourceLocation overlayTexture, final int tintColor,
                           final Properties properties, final TekoraFluidData data, final boolean isGas) {
        super(properties);
        this.stillTexture = isGas ? TekoraFluidTextures.GAS_RL : getTemperature() > 700 ? TekoraFluidTextures.LAVA_STILL_RL : TekoraFluidTextures.WATER_STILL_RL;
        this.flowingTexture = isGas ? TekoraFluidTextures.GAS_RL : getTemperature() > 700 ? TekoraFluidTextures.LAVA_FLOWING_RL : TekoraFluidTextures.WATER_FLOWING_RL;
        this.overlayTexture = overlayTexture;
        this.tintColor = tintColor;
        this.fogColor = colorToVector(tintColor);
        this.fluidData = data;
        this.isGas = isGas;

    }

    private Vector3f colorToVector(int hexVal) {
        int red = hexVal / 0x10000;
        int green = (hexVal - (red * 0x10000)) / 0x100;
        int blue = hexVal - ((red * 0x10000) + (green * 0x100));
        return new Vector3f(red / 255f, green / 255f, blue / 255f);
    }

    public boolean isGas() {
        return isGas;
    }

    public ResourceLocation getStillTexture() {
        return stillTexture;
    }

    public ResourceLocation getFlowingTexture() {
        return flowingTexture;
    }

    public ResourceLocation getOverlayTexture() {
        return overlayTexture;
    }

    public int getTintColor() {
        return tintColor;
    }

    public Vector3f getFogColor() {
        return fogColor;
    }

    public TekoraFluidData getFluidData() {
        return fluidData;
    }

    public float getSpecificHeat() {
        return fluidData.getSpecificHeat(isGas);
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return stillTexture;
            }
            @Override
            public ResourceLocation getFlowingTexture() {
                return flowingTexture;
            }
            @Override
            public ResourceLocation getOverlayTexture() {
                return overlayTexture;
            }

            @Override
            public ResourceLocation getOverlayTexture(FluidStack stack) {
                return overlayTexture;
            }

            @Override
            public int getTintColor() {
                return tintColor;
            }
            @Override
            public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level,
                                                    int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return fogColor;
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick,
                                        float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart(1f);
                RenderSystem.setShaderFogEnd(6f);
            }
        });
    }
}

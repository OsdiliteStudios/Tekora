package net.nukollodda.tekora.block.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
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
    private final ResourceLocation overlayTexture = TekoraFluidTextures.WATER_OVERLAY;
    private final int tintColor;
    private final Vector3f fogColor;
    private final TekoraFluidData fluidData;
    private final boolean isGas;

    public TekoraFluidType(final Properties properties, final TekoraFluidData data, final boolean isGas) {
        super(properties);
        this.stillTexture = isGas ? TekoraFluidTextures.GAS_RL : getTemperature() > 798 ? TekoraFluidTextures.LAVA_STILL_RL : TekoraFluidTextures.WATER_STILL_RL;
        this.flowingTexture = isGas ? TekoraFluidTextures.GAS_RL : getTemperature() > 798 ? TekoraFluidTextures.LAVA_FLOWING_RL : TekoraFluidTextures.WATER_FLOWING_RL;
        this.tintColor = isGas ? data.getGasColor() : data.getLiquidColor();
        this.fogColor = colorToVector(isGas ? data.getGasColor() : data.getLiquidColor());
        this.fluidData = data;
        this.isGas = isGas;
    }

    private Vector3f colorToVector(int hexVal) {
        int red = hexVal / 0x10000;
        int green = hexVal / 0x100 % 256;
        int blue = hexVal % 256;
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

    public boolean doesBurn(float pTemp, float pPressure) {
        return switch (fluidData.getBurnability()) {
            case 1 -> getMeltingPoint() > pTemp;
            case 2 -> getBoilingPoint(pPressure) > pTemp;
            default -> false;
        };
    }

    public float burnTemp() {
        return switch (fluidData.getBurnability()) {
            case 1 -> getMeltingPoint();
            case 2 -> getBoilingPoint(0);
            default -> -1;
        };
    }

    public String getName() {
        return isGas ? fluidData.getGasName() : fluidData.getLiquidName();
    }

    public float getSpecificHeat() {
        return fluidData.getSpecificHeat(isGas);
    }

    public float getMeltingPoint() {
        return fluidData.getMeltingPoint();
    }

    public float getBoilingPoint(float pPressure) {
        return fluidData.getBoilingPoint(pPressure);
    }

    public float getFusionHeat() {
        return fluidData.getFusionHeat();
    }

    public float getVaporizationHeat() {
        return fluidData.getVaporizationHeat();
    }

    public boolean isMetallic() {
        return fluidData.isMetallic();
    }

    public MobEffect[] getEffects() {
        return fluidData.getEffects();
    }

    public int getFluidDmg() {
        return fluidData.getFluidDmg();
    }

    public int getReactivity() {
        return (fluidData.doesDecompose() ? 1 : 0) + (int)(fluidData.getAcidity() + fluidData.getBasicity()) / 18;
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

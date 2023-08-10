package net.nukollodda.tekora.block.fluid.data;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.nukollodda.tekora.block.TekoraBlocks;

public class TekoraFluidPresets {
    public static final TekoraFluidData HYDROGEN = new TekoraFluidData(new TekoraFluidData.Properties()
            .setGasForm(TekoraBlocks.HYDROGEN_GAS_BLOCK.get())
            .setMeltingPoint(14)
            .setBoilingCoefficient(9)
            .setBoilingPower(0.538f)
            .setLowestPossibleBoilingPoint(11)
            .setSpecificHeatOfLiquid(10)
            .setSpecificHeatOfGas(1.374f)
            .setHeatOfFusion(4110)
            .setHeatOfVaporization(47500)
            .setAcidity(6.9f));

    public static final TekoraFluidData NITROGEN = new TekoraFluidData(new TekoraFluidData.Properties()
            .setGasForm(TekoraBlocks.NITROGEN_GAS_BLOCK.get())
            .setMeltingPoint(63)
            .setBoilingCoefficient(28)
            .setBoilingPower(0.368f)
            .setLowestPossibleBoilingPoint(50)
            .setSpecificHeatOfLiquid(1610)
            .setSpecificHeatOfGas(1.12f)
            .setHeatOfFusion(21000)
            .setHeatOfVaporization(160593));

    public static final TekoraFluidData OXYGEN = new TekoraFluidData(new TekoraFluidData.Properties()
            .setGasForm(TekoraBlocks.OXYGEN_GAS_BLOCK.get())
            .setMeltingPoint(54)
            .setBoilingCoefficient(4)
            .setBoilingPower(0.042f)
            .setLowestPossibleBoilingPoint(51)
            .setSpecificHeatOfLiquid(1050)
            .setSpecificHeatOfGas(1.3f)
            .setHeatOfFusion(16000)
            .setHeatOfVaporization(244000)
            .addEffects(new MobEffect[]{
                    MobEffects.BLINDNESS,
                    MobEffects.DAMAGE_BOOST,
                    MobEffects.DIG_SPEED,
                    MobEffects.MOVEMENT_SPEED,
                    MobEffects.HUNGER
            }));

    public static final TekoraFluidData FLUORINE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setGasForm(TekoraBlocks.FLUORINE_GAS_BLOCK.get())
            .setMeltingPoint(54)
            .setBoilingCoefficient(33)
            .setBoilingPower(0.451f)
            .setLowestPossibleBoilingPoint(52)
            .setSpecificHeatOfLiquid(1230)
            .setSpecificHeatOfGas(2.8f)
            .setHeatOfFusion(19600)
            .setHeatOfVaporization(259000)
            .setAcidity(3)
            .setFluidDmg(3)
            .addEffects(new MobEffect[]{
                    MobEffects.BLINDNESS,
                    MobEffects.HUNGER,
                    MobEffects.WEAKNESS,
                    MobEffects.WITHER,
                    MobEffects.CONFUSION
            }));

    public static final TekoraFluidData CHLORINE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setGasForm(TekoraBlocks.CHLORINE_GAS_BLOCK.get())
            .setMeltingPoint(172)
            .setBoilingCoefficient(68)
            .setBoilingPower(0.458f)
            .setLowestPossibleBoilingPoint(171)
            .setSpecificHeatOfLiquid(2919)
            .setSpecificHeatOfGas(0.423f)
            .setHeatOfFusion(135000)
            .setHeatOfVaporization(432000)
            .setAcidity(13)
            .setFluidDmg(2)
            .addEffects(new MobEffect[]{
                    MobEffects.BLINDNESS,
                    MobEffects.HUNGER,
                    MobEffects.WEAKNESS,
                    MobEffects.WITHER,
                    MobEffects.CONFUSION
            }));


    public static final TekoraFluidData OZONE = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData WATER = new TekoraFluidData(new TekoraFluidData.Properties()
            .setSolidForm(Blocks.ICE)
            .setLiquidForm((LiquidBlock) Blocks.WATER)
            .setGasForm(TekoraBlocks.STEAM_BLOCK.get())
            .setMeltingPoint(273)
            .setBoilingCoefficient(160)
            .setBoilingPower(0.348f)
            .setLowestPossibleBoilingPoint(213)
            .setSpecificHeatOfLiquid(4170)
            .setSpecificHeatOfGas(1.996f)
            .setHeatOfFusion(333000)
            .setHeatOfVaporization(2250000)
    );

    public static final TekoraFluidData HYDROGEN_SULFIDE = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData HYDROGEN_FLUORIDE = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData HYDROGEN_CHLORIDE = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData HYDROGEN_CYANIDE = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData AMMONIA = new TekoraFluidData(new TekoraFluidData.Properties()
            .setSpecificHeatOfGas(0.4f));

    public static final TekoraFluidData PHOSPHINE = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData NITRIC_ACID = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData PHOSPHORIC_ACID = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData SULFURIC_ACID = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData CARBON_MONOXIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(68)
            .setDefiniteBoilingPoint(82)
            .setSpecificHeatOfGas(1.04f));

    public static final TekoraFluidData CARBON_DIOXIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setSpecificHeatOfGas(0.846f));

    public static final TekoraFluidData SULFUR_DIOXIDE = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData ACETIC_ACID = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData ETHANOL = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData ACETONE = new TekoraFluidData(new TekoraFluidData.Properties());

    public static final TekoraFluidData OXYGEN_DIFLUORIDE = new TekoraFluidData(new TekoraFluidData.Properties());
    public static final TekoraFluidData MERCURY = new TekoraFluidData(new TekoraFluidData.Properties()
            .setLiquidForm(TekoraBlocks.MERCURY_FLUID_BLOCK.get())
            .setMeltingPoint(234)
            .setDefiniteBoilingPoint(630)
            .setSpecificHeatOfLiquid(1930)
            .setSpecificHeatOfGas(1890)
            .setHeatOfFusion(153000)
            .setHeatOfVaporization(3970000)
            .addEffects(new MobEffect[]{
                    MobEffects.HUNGER,
                    MobEffects.WEAKNESS,
                    MobEffects.WITHER,
                    MobEffects.CONFUSION,
                    MobEffects.MOVEMENT_SLOWDOWN,
                    MobEffects.DIG_SLOWDOWN
            })
            .metallic());
}

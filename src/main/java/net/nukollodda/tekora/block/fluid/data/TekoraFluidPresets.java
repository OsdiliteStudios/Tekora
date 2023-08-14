package net.nukollodda.tekora.block.fluid.data;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class TekoraFluidPresets {
    /** I am very likely wrong with all the boiling coefficients, powers, and zero pressure boiling points
     * until I can come up with an equation that utilizes the critical temperature and pressure, this will
     * have to do for now
     */
    // https://www.engineeringtoolbox.com/triple-point-d_1926.html triple points for substances
    public static final TekoraFluidData HYDROGEN = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(14)
            .setBoilingCoefficient(9)
            .setBoilingPower(0.538f)
            .setLowestPossibleBoilingPoint(11)
            .setSpecificHeatOfLiquid(10)
            .setSpecificHeatOfGas(1.374f)
            .setHeatOfFusion(4.11f)
            .setHeatOfVaporization(47.5f)
            .setColor(0xA1F2D9D2));
    // liquid density = 71

    public static final TekoraFluidData DEUTERIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(19)
            .setBoilingCoefficient(9)
            .setBoilingPower(0.433f)
            .setLowestPossibleBoilingPoint(11)
            .setSpecificHeatOfLiquid(10)
            .setSpecificHeatOfGas(1.374f)
            .setHeatOfFusion(4.11f)
            .setHeatOfVaporization(47.5f)
            .setColor(0xA1C2EE));

    public static final TekoraFluidData NITROGEN = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(63)
            .setBoilingCoefficient(28)
            .setBoilingPower(0.368f)
            .setLowestPossibleBoilingPoint(50)
            .setSpecificHeatOfLiquid(1610)
            .setSpecificHeatOfGas(1.12f)
            .setHeatOfFusion(21)
            .setHeatOfVaporization(161)
            .setColor(0xC7DBE1));
    // liquid density = 807

    public static final TekoraFluidData OXYGEN = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(54)
            .setBoilingCoefficient(4)
            .setBoilingPower(0.042f)
            .setLowestPossibleBoilingPoint(51)
            .setSpecificHeatOfLiquid(1050)
            .setSpecificHeatOfGas(1.3f)
            .setHeatOfFusion(16)
            .setHeatOfVaporization(244)
            .addEffects(new MobEffect[]{
                    MobEffects.BLINDNESS,
                    MobEffects.DAMAGE_BOOST,
                    MobEffects.DIG_SPEED,
                    MobEffects.MOVEMENT_SPEED,
                    MobEffects.HUNGER})
            .setColor(0x58A4D6));
    // liquid density = 1141

    public static final TekoraFluidData FLUORINE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(54)
            .setBoilingCoefficient(33)
            .setBoilingPower(0.451f)
            .setLowestPossibleBoilingPoint(52)
            .setSpecificHeatOfLiquid(1230)
            .setSpecificHeatOfGas(2.8f)
            .setHeatOfFusion(19.6f)
            .setHeatOfVaporization(259)
            .setFluidDmg(3)
            .addEffects(new MobEffect[]{
                    MobEffects.BLINDNESS,
                    MobEffects.HUNGER,
                    MobEffects.WEAKNESS,
                    MobEffects.WITHER,
                    MobEffects.CONFUSION})
            .setColor(0xC5E55E));
    // liquid density = 1505

    public static final TekoraFluidData CHLORINE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(172)
            .setBoilingCoefficient(68)
            .setBoilingPower(0.458f)
            .setLowestPossibleBoilingPoint(171)
            .setSpecificHeatOfLiquid(2919)
            .setSpecificHeatOfGas(0.423f)
            .setHeatOfFusion(135)
            .setHeatOfVaporization(432)
            .setFluidDmg(2)
            .addEffects(new MobEffect[]{
                    MobEffects.BLINDNESS,
                    MobEffects.HUNGER,
                    MobEffects.WEAKNESS,
                    MobEffects.WITHER,
                    MobEffects.CONFUSION})
            .setColor(0xA1E639));
    // liquid density = 1468

    public static final TekoraFluidData BROMINE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(266)
            .setBoilingCoefficient(82)
            .setBoilingPower(0.57f)
            .setLowestPossibleBoilingPoint(250)
            .setSpecificHeatOfLiquid(1478)
            .setSpecificHeatOfGas(1.74f)
            .setHeatOfFusion(205)
            .setHeatOfVaporization(585)
            .setColor(0x290D03));
    // liquid density = 3120
    // gas density = 8

    public static final TekoraFluidData IODINE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(387)
            .setBoilingCoefficient(111)
            .setBoilingPower(0.47f)
            .setLowestPossibleBoilingPoint(346)
            .setSpecificHeatOfLiquid(71)
            .setSpecificHeatOfGas(12.1f)
            .setHeatOfFusion(174)
            .setHeatOfVaporization(559)
            .setColor(0x24074D));
    // liquid density = 1320
    // gas density = 11

    public static final TekoraFluidData OZONE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(81)
            .setDefiniteBoilingPoint(161)
            .setSpecificHeatOfLiquid(2410)
            .setSpecificHeatOfGas(1.64f)
            .setColor(0xA7D1F2));
    // liquid density = 1354
    // gas density = 2

    public static final TekoraFluidData WATER = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(273)
            .setBoilingCoefficient(160)
            .setBoilingPower(0.348f)
            .setLowestPossibleBoilingPoint(213)
            .setSpecificHeatOfLiquid(4170)
            .setSpecificHeatOfGas(1.996f)
            .setHeatOfFusion(333)
            .setHeatOfVaporization(2250)
            .setLiquidColor(0x304FA5)
            .setGasColor(0xDFDFDF));

    public static final TekoraFluidData HYDROGEN_SULFIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(188)
            .setBoilingCoefficient(73.6f)
            .setBoilingPower(0.291f)
            .setLowestPossibleBoilingPoint(140)
            .setSpecificHeatOfLiquid(931)
            .setSpecificHeatOfGas(1.31f)
            .setHeatOfFusion(59.5f)
            .setHeatOfVaporization(302)
            .setColor(0xF1F2BB));
    // liquid density = 854
    // gas density = 2

    public static final TekoraFluidData HYDROGEN_FLUORIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(190)
            .setDefiniteBoilingPoint(293)
            .setHeatOfFusion(227)
            .setHeatOfVaporization(35.4f)
            .setColor(0x3B6527));
    // note: all viscosity values hereafter are for the gas phase
    // liquid density = 990
    // gas density = 1.15
    // normal bp = 292.6

    public static final TekoraFluidData HYDROGEN_CHLORIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(159)
            .setBoilingCoefficient(48)
            .setBoilingPower(0.466f)
            .setLowestPossibleBoilingPoint(140)
            .setSpecificHeatOfLiquid(1328)
            .setSpecificHeatOfGas(1.19f)
            .setHeatOfFusion(43.6f)
            .setHeatOfVaporization(183)
            .setColor(0x74DF94));
    // liquid density = 1190
    // gas density = 1.49
    // viscosity = 311
    // normal bp = 188

    public static final TekoraFluidData HYDROGEN_CYANIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(260)
            .setBoilingCoefficient(59)
            .setBoilingPower(0.166f)
            .setLowestPossibleBoilingPoint(240)
            .setSpecificHeatOfGas(10.1f)
            .setColor(0x56390B));
    // liquid density = 687
    // gas density = 7.61
    // viscosity = (liquid)183
    // normal bp = 299

    public static final TekoraFluidData AMMONIA = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(195)
            .setBoilingCoefficient(77)
            .setBoilingPower(0.311f)
            .setLowestPossibleBoilingPoint(163)
            .setSpecificHeatOfLiquid(3000)
            .setSpecificHeatOfGas(2.06f)
            .setHeatOfFusion(209)
            .setHeatOfVaporization(872)
            .setLiquidColor(0x28BABA)
            .setGasColor(0x754A06));
    // liquid density = 632
    // gas density = 1
    // viscosity = 266
    // normal bp = 239.81

    public static final TekoraFluidData PHOSPHINE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(140)
            .setDefiniteBoilingPoint(186)
            .setSpecificHeatOfGas(8.53f)
            .setHeatOfVaporization(429)
            .setColor(0xC7BDAF));
    // liquid density =
    // gas density = 1.379
    // viscosity = 110
    // normal bp = 185.5

    // note: all tekora oxyacids decompose before becoming a gas

    public static final TekoraFluidData NITRIC_ACID = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(231)
            .setBoilingCoefficient(175)
            .setBoilingPower(0.983f)
            .setLowestPossibleBoilingPoint(220)
            .setSpecificHeatOfLiquid(1920)
            .setHeatOfFusion(59.9f)
            .setHeatOfVaporization(937)
            .setColor(0x834C18));
    // liquid density = 1510
    // gas density =
    // viscosity = (liquid) 1200
    // normal bp = 395

    public static final TekoraFluidData PHOSPHORIC_ACID = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(294)
            .setDefiniteBoilingPoint(600)
            .setSpecificHeatOfLiquid(2493)
            .setColor(0x85530F));
    // liquid density = 1685
    // viscosity = 147
    // normal bp = 431.15

    public static final TekoraFluidData SULFURIC_ACID = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(283)
            .setBoilingCoefficient(328)
            .setBoilingPower(0.5f)
            .setLowestPossibleBoilingPoint(283)
            .setSpecificHeatOfLiquid(2450)
            .setHeatOfFusion(221)
            .setColor(0x9C811A));
    // liquid density = 1830
    // viscosity = (liquid) 26700
    // normal bp = 610

    public static final TekoraFluidData CARBON_MONOXIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(68)
            .setBoilingCoefficient(26)
            .setBoilingPower(0.41f)
            .setLowestPossibleBoilingPoint(56)
            .setSpecificHeatOfGas(1.19f)
            .setHeatOfFusion(10.1f)
            .setHeatOfVaporization(170)
            .setColor(0x786A65));
    // liquid density = 789
    // gas density = 1
    // viscosity =
    // normal bp = 82
    // triple point pressure = 0.152

    public static final TekoraFluidData CARBON_DIOXIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(217)
            .setBoilingCoefficient(42)
            .setBoilingPower(0.263f)
            .setLowestPossibleBoilingPoint(153)
            .setSpecificHeatOfLiquid(2202)
            .setSpecificHeatOfGas(1.686f)
            .setHeatOfFusion(100)
            .setHeatOfVaporization(197)
            .setColor(0x727272));
    // liquid density = 1101
    // gas density = 2
    // viscosity = 1470

    public static final TekoraFluidData SULFUR_DIOXIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(201)
            .setBoilingCoefficient(103)
            .setBoilingPower(0.223f)
            .setLowestPossibleBoilingPoint(160)
            .setSpecificHeatOfLiquid(1910)
            .setSpecificHeatOfGas(3.6f)
            .setHeatOfFusion(183)
            .setHeatOfVaporization(558)
            .setColor(0xE1CA53));
    // liquid density = 1435
    // gas density = 2.629
    // viscosity =
    // normal bp = 263
    // triple point pressure = 0.016

    public static final TekoraFluidData SULFUR_TRIOXIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(290)
            .setBoilingCoefficient(68)
            .setBoilingPower(0.23f)
            .setLowestPossibleBoilingPoint(250)
            .setSpecificHeatOfGas(3.12f)
            .setHeatOfFusion(0.23f)
            .setHeatOfVaporization(93.5f)
            .setColor(0x4D1616));
    // liquid density = 1970
    // gas density = 3.57
    // viscosity =
    // normal bp = 318

    public static final TekoraFluidData ACETIC_ACID = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(290)
            .setDefiniteBoilingPoint(391)
            .setSpecificHeatOfLiquid(2152)
            .setSpecificHeatOfGas(1.06f)
            .setHeatOfFusion(189)
            .setHeatOfVaporization(399)
            .setColor(0xDBDBDB));
    // liquid density = 1050
    // gas density =
    // viscosity = 1040
    // normal bp = 391

    public static final TekoraFluidData ETHANOL = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(159)
            .setBoilingCoefficient(192)
            .setBoilingPower(0.5f)
            .setLowestPossibleBoilingPoint(159)
            .setSpecificHeatOfLiquid(1610)
            .setSpecificHeatOfGas(2.7f)
            .setHeatOfFusion(0.53f)
            .setHeatOfVaporization(1.88f)
            .setColor(0xBB8048));
    // liquid density = 789
    // gas density = 1.59
    // viscosity = 1720
    // normal bp = 351.52

    public static final TekoraFluidData ACETONE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(178)
            .setDefiniteBoilingPoint(329)
            .setSpecificHeatOfLiquid(1690)
            .setSpecificHeatOfGas(3.33f)
            .setHeatOfFusion(0.436f)
            .setHeatOfVaporization(1.28f)
            .setColor(0x857C74));
    // liquid density = 784
    // gas density = 2.58
    // viscosity = 3311
    // normal bp = 329

    public static final TekoraFluidData OXYGEN_DIFLUORIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(49)
            .setDefiniteBoilingPoint(128)
            .setSpecificHeatOfGas(1.52f)
            .setColor(0x9CB2AD));
    // liquid density = 1521
    // gas density = 1.9
    // viscosity =
    // normal bp = 128.35

    // https://www.engineeringtoolbox.com/liquid-metal-boiling-points-specific-heat-d_1893.html - metal specific heats
    public static final TekoraFluidData ALUMINUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(933)
            .setDefiniteBoilingPoint(2743)
            .setSpecificHeatOfLiquid(3190)
            .setHeatOfFusion(1020)
            .setColor(0xE9F7F7));
    // liquid aluminum density =

    public static final TekoraFluidData GALLIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(303)
            .setDefiniteBoilingPoint(2673)
            .setSpecificHeatOfLiquid(834)
            .setHeatOfFusion(22.4f)
            .setColor(0x9A9A9A));
    // liquid gallium density =
    public static final TekoraFluidData MERCURY = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(234)
            .setDefiniteBoilingPoint(630)
            .setSpecificHeatOfLiquid(1930)
            .setSpecificHeatOfGas(1890)
            .setHeatOfFusion(153)
            .setHeatOfVaporization(3970)
            .setColor(0x9A9A9A)
            .addEffects(new MobEffect[]{
                    MobEffects.HUNGER,
                    MobEffects.WEAKNESS,
                    MobEffects.WITHER,
                    MobEffects.CONFUSION,
                    MobEffects.MOVEMENT_SLOWDOWN,
                    MobEffects.DIG_SLOWDOWN
            }));
}

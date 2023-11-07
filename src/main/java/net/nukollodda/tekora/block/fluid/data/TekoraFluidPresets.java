package net.nukollodda.tekora.block.fluid.data;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class TekoraFluidPresets {
    /** I am very likely wrong with all the boiling coefficients, powers, and zero pressure boiling points
     * until I can come up with an equation that utilizes the critical temperature and pressure, this will
     * have to do for now */
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
            .setColor(0xA1F2D9D2)
            .setName("hydrogen"));
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
            .setColor(0xA1C2EE)
            .setName("deuterium"));

    public static final TekoraFluidData NITROGEN = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(63)
            .setBoilingCoefficient(28)
            .setBoilingPower(0.368f)
            .setLowestPossibleBoilingPoint(50)
            .setSpecificHeatOfLiquid(1610)
            .setSpecificHeatOfGas(1.12f)
            .setHeatOfFusion(21)
            .setHeatOfVaporization(161)
            .setColor(0xC7DBE1)
            .setName("nitrogen"));
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
            .setColor(0x58A4D6)
            .setName("oxygen"));
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
            .setColor(0xC5E55E)
            .setName("fluorine"));
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
            .setColor(0xA1E639)
            .setName("chlorine"));
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
            .setColor(0x290D03)
            .setName("bromine"));
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
            .setColor(0x24074D)
            .setName("iodine"));
    // liquid density = 1320
    // gas density = 11

    public static final TekoraFluidData OZONE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(81)
            .setDefiniteBoilingPoint(161)
            .setSpecificHeatOfLiquid(2410)
            .setSpecificHeatOfGas(1.64f)
            .setColor(0xA7D1F2)
            .setName("ozone"));
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
            .setGasColor(0xDFDFDF)
            .setGasName("steam"));

    public static final TekoraFluidData HYDROGEN_SULFIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(188)
            .setBoilingCoefficient(73.6f)
            .setBoilingPower(0.291f)
            .setLowestPossibleBoilingPoint(140)
            .setSpecificHeatOfLiquid(931)
            .setSpecificHeatOfGas(1.31f)
            .setHeatOfFusion(59.5f)
            .setHeatOfVaporization(302)
            .setAcidity(7)
            .setColor(0xF1F2BB)
            .setName("hydrogen_sulfide"));
    // liquid density = 854
    // gas density = 2

    // note: all viscosity values hereafter are for the gas phase
    public static final TekoraFluidData HYDROGEN_FLUORIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(190)
            .setDefiniteBoilingPoint(293)
            .setHeatOfFusion(227)
            .setHeatOfVaporization(35.4f)
            .setAcidity(3.17f)
            .setColor(0x3B6527)
            .addEffects(new MobEffect[]{
                    MobEffects.BLINDNESS,
                    MobEffects.HUNGER,
                    MobEffects.WEAKNESS,
                    MobEffects.WITHER,
                    MobEffects.CONFUSION})
            .setLiquidName("hydrofluoric_acid")
            .setGasName("hydrogen_fluoride"));
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
            .setAcidity(-5.9f)
            .setBasicity(17)
            .setColor(0x74DF94)
            .setLiquidName("hydrochloric_acid")
            .setGasName("hydrogen_chloride"));

    public static final TekoraFluidData HYDROGEN_CYANIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(260)
            .setBoilingCoefficient(59)
            .setBoilingPower(0.166f)
            .setLowestPossibleBoilingPoint(240)
            .setSpecificHeatOfGas(10.1f)
            .setAcidity(9.21f)
            .setColor(0x56390B)
            .addEffects(new MobEffect[]{
                    MobEffects.HUNGER,
                    MobEffects.WEAKNESS,
                    MobEffects.WITHER,
                    MobEffects.CONFUSION,
                    MobEffects.MOVEMENT_SLOWDOWN,
                    MobEffects.POISON})
            .setLiquidName("prussic_acid")
            .setGasName("hydrogen_cyanide"));

    public static final TekoraFluidData AMMONIA = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(195)
            .setBoilingCoefficient(77)
            .setBoilingPower(0.311f)
            .setLowestPossibleBoilingPoint(163)
            .setSpecificHeatOfLiquid(3000)
            .setSpecificHeatOfGas(2.06f)
            .setHeatOfFusion(209)
            .setHeatOfVaporization(872)
            .setAcidity(9.24f)
            .setBasicity(4.75f)
            .setLiquidColor(0x28BABA)
            .setGasColor(0x754A06).addEffects(new MobEffect[]{
                    MobEffects.HUNGER,
                    MobEffects.WEAKNESS,
                    MobEffects.POISON,
                    MobEffects.CONFUSION,
                    MobEffects.MOVEMENT_SLOWDOWN}
            )
            .setName("ammonia", (byte)1));

    public static final TekoraFluidData PHOSPHINE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(140)
            .setDefiniteBoilingPoint(186)
            .setSpecificHeatOfGas(8.53f)
            .setHeatOfVaporization(429)
            .setColor(0xC7BDAF)
            .setName("phosphine"));
    // liquid density =
    // gas density = 1.379
    // viscosity = 110
    // normal bp = 185.5

    // note: all tekora oxyacids decompose before becoming a gas

    public static final TekoraFluidData NITRIC_ACID = new TekoraFluidData(new TekoraFluidData.Properties()
            .decomposesInsteadOfBoiling()
            .setMeltingPoint(231)
            .setBoilingCoefficient(175)
            .setBoilingPower(0.983f)
            .setLowestPossibleBoilingPoint(220)
            .setSpecificHeatOfLiquid(1920)
            .setHeatOfFusion(59.9f)
            .setHeatOfVaporization(937)
            .setAcidity(-1.4f)
            .setColor(0x834C18)
            .setName("nitric_acid", (byte)0));

    public static final TekoraFluidData PHOSPHORIC_ACID = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(294)
            .setDefiniteBoilingPoint(600)
            .setSpecificHeatOfLiquid(2493)
            .setColor(0x85530F)
            .setName("phosphoric_acid", (byte)2));
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
            .setAcidity(-2.8f)
            .setColor(0x9C811A)
            .setName("sulfuric_acid", (byte)2));

    public static final TekoraFluidData CARBON_MONOXIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(68)
            .setBoilingCoefficient(26)
            .setBoilingPower(0.41f)
            .setLowestPossibleBoilingPoint(56)
            .setSpecificHeatOfGas(1.19f)
            .setHeatOfFusion(10.1f)
            .setHeatOfVaporization(170)
            .setColor(0x786A65)
            .setName("carbon_monoxide", (byte)1));
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
            .setColor(0x727272)
            .setName("carbon_dioxide", (byte)1));
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
            .setColor(0xE1CA53)
            .setName("sulfur_dioxide", (byte)1));
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
            .setColor(0x4D1616)
            .setName("sulfur_trioxide", (byte)1));
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
            .setAcidity(4.76f)
            .setColor(0xDBDBDB)
            .setName("acetic_acid", (byte)2));
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
            .setColor(0xBB8048)
            .setName("ethanol", (byte)2));
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
            .setColor(0x857C74)
            .setName("acetone", (byte)2));
    // liquid density = 784
    // gas density = 2.58
    // viscosity = 3311
    // normal bp = 329

    public static final TekoraFluidData OXYGEN_DIFLUORIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setMeltingPoint(49)
            .setDefiniteBoilingPoint(128)
            .setSpecificHeatOfGas(1.52f)
            .setColor(0x9CB2AD)
            .setName("oxygen_difluoride"));
    // liquid density = 1521
    // gas density = 1.9
    // viscosity =
    // normal bp = 128.35

    // note for Tekora metals, ones with melting points above 2048K will not be added, density will always be g/L
    public static final TekoraFluidData LITHIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(454)
            .setDefiniteBoilingPoint(1615)
            .setHeatOfFusion(41)
            .setColor(0xC5BEB1)
            .setName("lithium"));
    // density = 512
    // viscosity =

    public static final TekoraFluidData BERYLLIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1560)
            .setDefiniteBoilingPoint(2744)
            .setSpecificHeatOfLiquid(2)
            .setHeatOfFusion(65)
            .setColor(0x757E71)
            .setName("beryllium"));
    // density = 1690
    // viscosity =

    public static final TekoraFluidData SODIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(270)
            .setDefiniteBoilingPoint(1156)
            .setHeatOfFusion(64)
            .setColor(0xABABB0)
            .setName("sodium"));
    // density = 927
    // viscosity =

    public static final TekoraFluidData MAGNESIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(923)
            .setDefiniteBoilingPoint(1363)
            .setHeatOfFusion(130)
            .setColor(0xA7A7A7)
            .setName("magnesium"));
    // density = 1584
    // viscosity =
    public static final TekoraFluidData ALUMINUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(933)
            .setDefiniteBoilingPoint(2743)
            .setHeatOfFusion(122)
            .setColor(0xE9F7F7)
            .setName("aluminum"));

    public static final TekoraFluidData SILICON = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1687)
            .setDefiniteBoilingPoint(3538)
            .setHeatOfFusion(549)
            .setColor(0x66667E)
            .setName("silicon"));
    // density = 2570
    // viscosity =

    public static final TekoraFluidData POTASSIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(337)
            .setDefiniteBoilingPoint(1032)
            .setHeatOfFusion(110)
            .setColor(0xE1DAD0)
            .setName("potassium"));
    // density = 829
    // viscosity =

    public static final TekoraFluidData CALCIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1115)
            .setDefiniteBoilingPoint(1757)
            .setHeatOfFusion(248)
            .setColor(0xDBDBDB)
            .setName("calcium"));
    // density = 1378
    // viscosity =

    public static final TekoraFluidData SCANDIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1814)
            .setDefiniteBoilingPoint(3109)
            .setHeatOfFusion(226)
            .setColor(0xE5E7E0)
            .setName("scandium"));
    // density = 2800
    // viscosity =

    public static final TekoraFluidData TITANIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1941)
            .setDefiniteBoilingPoint(3560)
            .setHeatOfFusion(165)
            .setColor(0x5E5F67)
            .setName("titanium"));
    // density = 4110
    // viscosity =

    public static final TekoraFluidData MANGANESE = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1519)
            .setDefiniteBoilingPoint(2334)
            .setHeatOfFusion(119)
            .setColor(0xCEB6CE)
            .setName("manganese"));
    // density = 5950
    // viscosity =

    public static final TekoraFluidData IRON = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1811)
            .setDefiniteBoilingPoint(3134)
            .setHeatOfFusion(110)
            .setColor(0xF09432)
            .setName("iron"));
    // density = 6980
    // viscosity =

    public static final TekoraFluidData COBALT = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1769)
            .setDefiniteBoilingPoint(3200)
            .setHeatOfFusion(122)
            .setColor(0x2D67BA)
            .setName("cobalt"));
    // density = 7750
    // viscosity =

    public static final TekoraFluidData NICKEL = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1728)
            .setDefiniteBoilingPoint(3186)
            .setHeatOfFusion(131)
            .setColor(0xC5C1A4)
            .setName("nickel"));
    // density = 7810
    // viscosity =

    public static final TekoraFluidData COPPER = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1358)
            .setDefiniteBoilingPoint(2835)
            .setHeatOfFusion(107)
            .setColor(0xFC9982)
            .setName("copper"));
    // density = 8020
    // viscosity =

    public static final TekoraFluidData ZINC = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(693)
            .setDefiniteBoilingPoint(1180)
            .setHeatOfFusion(72.8f)
            .setColor(0xD9D8CD)
            .setName("zinc"));
    // density = 6570
    // viscosity =
    public static final TekoraFluidData GALLIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(303)
            .setDefiniteBoilingPoint(2673)
            .setHeatOfFusion(63.9f)
            .setColor(0x9A9A9A)
            .setName("gallium"));

    public static final TekoraFluidData GERMANIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1211)
            .setDefiniteBoilingPoint(3106)
            .setHeatOfFusion(479)
            .setColor(0x7E7E67)
            .setName("germanium"));
    // density = 5600
    // viscosity =

    public static final TekoraFluidData ARSENIC = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1090)
            .setBoilingCoefficient(127)
            .setBoilingPower(0.267f)
            .setLowestPossibleBoilingPoint(760)
            .setHeatOfFusion(351)
            .setColor(0x706C5C)
            .setName("arsenic"));
    // density = 5220
    // viscosity =

    public static final TekoraFluidData RUBIDIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(312)
            .setDefiniteBoilingPoint(961)
            .setSpecificHeatOfLiquid(2)
            .setHeatOfFusion(128)
            .setColor(0xBDB1AB)
            .setName("rubidium"));
    // density = 1460
    // viscosity =

    public static final TekoraFluidData STRONTIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1050)
            .setDefiniteBoilingPoint(1655)
            .setHeatOfFusion(274)
            .setColor(0xCFE1E5)
            .setName("strontium"));
    // density = 2375
    // viscosity =

    public static final TekoraFluidData YTTRIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1795)
            .setDefiniteBoilingPoint(3618)
            .setHeatOfFusion(239)
            .setColor(0x92988A)
            .setName("yttrium"));
    // density = 4240
    // viscosity =

    public static final TekoraFluidData PALLADIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1828)
            .setDefiniteBoilingPoint(3236)
            .setHeatOfFusion(172)
            .setColor(0xD8D4D1)
            .setName("palladium"));
    // density = 10380
    // viscosity =

    public static final TekoraFluidData SILVER = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1235)
            .setDefiniteBoilingPoint(2435)
            .setHeatOfFusion(131)
            .setColor(0xD0D0D0)
            .setName("silver"));
    // density = 9320
    // viscosity =

    public static final TekoraFluidData CADMIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(594)
            .setDefiniteBoilingPoint(1040)
            .setHeatOfFusion(87.3f)
            .setColor(0x3C403C)
            .setName("cadmium"));
    // density = 7996
    // viscosity =

    public static final TekoraFluidData INDIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(430)
            .setDefiniteBoilingPoint(2345)
            .setHeatOfFusion(53.7f)
            .setColor(0x9EAEAE)
            .setName("indium"));
    // density = 7020
    // viscosity =

    public static final TekoraFluidData TIN = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(505)
            .setDefiniteBoilingPoint(2875)
            .setHeatOfFusion(119)
            .setColor(0xEAEAEA)
            .setName("tin"));
    // density = 6990
    // viscosity =

    public static final TekoraFluidData ANTIMONY = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(904)
            .setDefiniteBoilingPoint(1860)
            .setHeatOfFusion(369)
            .setColor(0xBAB5C3)
            .setName("antimony"));
    // density = 6530
    // viscosity =

    public static final TekoraFluidData TELLURIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(723)
            .setDefiniteBoilingPoint(1264)
            .setHeatOfFusion(392)
            .setColor(0x6F807C)
            .setName("tellurium"));
    // density = 5700
    // viscosity =

    public static final TekoraFluidData CESIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(302)
            .setDefiniteBoilingPoint(944)
            .setSpecificHeatOfLiquid(2)
            .setHeatOfFusion(151)
            .setColor(0xC9C8BD)
            .setName("cesium"));
    // density = 1843
    // viscosity =

    public static final TekoraFluidData BARIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1000)
            .setDefiniteBoilingPoint(2170)
            .setSpecificHeatOfLiquid(2)
            .setHeatOfFusion(293)
            .setColor(0x4B4B4B)
            .setName("barium"));
    // density = 3338
    // viscosity =

    public static final TekoraFluidData LANTHANUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1191)
            .setDefiniteBoilingPoint(3737)
            .setHeatOfFusion(150)
            .setColor(0xF4F4F4)
            .setName("lanthanum"));
    // density = 5940
    // viscosity =

    public static final TekoraFluidData CERIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1071)
            .setDefiniteBoilingPoint(3697)
            .setHeatOfFusion(117)
            .setColor(0xE0E3DB)
            .setName("cerium"));
    // density = 6550
    // viscosity =

    public static final TekoraFluidData PRASEODYMIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1204)
            .setDefiniteBoilingPoint(3793)
            .setHeatOfFusion(149)
            .setColor(0xDCE8D6)
            .setName("praseodymium"));
    // density = 6500
    // viscosity =

    public static final TekoraFluidData NEODYMIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1294)
            .setDefiniteBoilingPoint(3347)
            .setHeatOfFusion(149)
            .setColor(0xEDE4F4)
            .setName("neodymium"));
    // density = 6890
    // viscosity =

    public static final TekoraFluidData SAMARIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1347)
            .setDefiniteBoilingPoint(2067)
            .setHeatOfFusion(181)
            .setColor(0xF0ECDD)
            .setName("samarium"));
    // density = 7160
    // viscosity =

    public static final TekoraFluidData EUROPIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1095)
            .setDefiniteBoilingPoint(1802)
            .setHeatOfFusion(273)
            .setColor(0xCAD2C4)
            .setName("europium"));
    // density = 5130
    // viscosity =

    public static final TekoraFluidData GADOLINIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1586)
            .setDefiniteBoilingPoint(3546)
            .setHeatOfFusion(214)
            .setColor(0xBDC9C4)
            .setName("gadolinium"));
    // density = 7400
    // viscosity =

    public static final TekoraFluidData TERBIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1629)
            .setDefiniteBoilingPoint(3503)
            .setHeatOfFusion(211)
            .setColor(0xCFD2C7)
            .setName("terbium"));
    // density = 7650
    // viscosity =

    public static final TekoraFluidData DYSPROSIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1685)
            .setDefiniteBoilingPoint(2840)
            .setHeatOfFusion(215)
            .setColor(0xE7E0E2)
            .setName("dysprosium"));
    // density = 8370
    // viscosity =

    public static final TekoraFluidData HOLMIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1747)
            .setDefiniteBoilingPoint(2973)
            .setHeatOfFusion(336)
            .setColor(0xA3A3A3)
            .setName("holmium"));
    // density = 8340
    // viscosity =

    public static final TekoraFluidData ERBIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1802)
            .setDefiniteBoilingPoint(3141)
            .setHeatOfFusion(376)
            .setColor(0xA7A2A2)
            .setName("erbium"));
    // density = 8860
    // viscosity =

    public static final TekoraFluidData THULIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1818)
            .setDefiniteBoilingPoint(3141)
            .setHeatOfFusion(332)
            .setColor(0xAEABA4)
            .setName("thulium"));
    // density = 8560
    // viscosity =

    public static final TekoraFluidData YTTERBIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1092)
            .setDefiniteBoilingPoint(1469)
            .setHeatOfFusion(213)
            .setColor(0xBDBCB2)
            .setName("ytterbium"));
    // density = 6210
    // viscosity =

    public static final TekoraFluidData LUTETIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1936)
            .setDefiniteBoilingPoint(3675)
            .setHeatOfFusion(414)
            .setColor(0xACB5B8)
            .setName("lutetium"));
    // density = 9300
    // viscosity =

    public static final TekoraFluidData PLATINUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(2042)
            .setDefiniteBoilingPoint(4098)
            .setHeatOfFusion(219)
            .setColor(0xB1B9CE)
            .setName("platinum"));
    // density = 19770
    // viscosity =

    public static final TekoraFluidData GOLD = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1337)
            .setDefiniteBoilingPoint(3129)
            .setHeatOfFusion(143)
            .setColor(0xFDF55F)
            .setName("gold"));
    // density = 17310
    // viscosity =

    public static final TekoraFluidData MERCURY = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(234)
            .setDefiniteBoilingPoint(630)
            .setSpecificHeatOfGas(1)
            .setHeatOfFusion(33.9f)
            .setHeatOfVaporization(875)
            .setColor(0x9A9A9A)
            .addEffects(new MobEffect[]{
                    MobEffects.HUNGER,
                    MobEffects.WEAKNESS,
                    MobEffects.WITHER,
                    MobEffects.CONFUSION,
                    MobEffects.MOVEMENT_SLOWDOWN,
                    MobEffects.DIG_SLOWDOWN
            })
            .setName("mercury"));

    public static final TekoraFluidData THALLIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(577)
            .setDefiniteBoilingPoint(1746)
            .setHeatOfFusion(75.4f)
            .setColor(0xE4F0E8)
            .setName("thallium"));
    // density = 11220
    // viscosity =

    public static final TekoraFluidData LEAD = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(601)
            .setDefiniteBoilingPoint(2022)
            .setHeatOfFusion(92.7f)
            .setColor(0x879FD8)
            .setName("lead"));
    // density = 10660
    // viscosity =

    public static final TekoraFluidData BISMUTH = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(545)
            .setDefiniteBoilingPoint(1837)
            .setHeatOfFusion(235)
            .setColor(0x9E9F94)
            .setName("bismuth"));
    // density = 10050
    // viscosity =

    public static final TekoraFluidData THORIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(2023)
            .setDefiniteBoilingPoint(5061)
            .setHeatOfFusion(274)
            .setColor(0x525252)
            .setName("thorium"));
    // density = 11700
    // viscosity =

    public static final TekoraFluidData PROTACTINIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1845)
            .setDefiniteBoilingPoint(4000)
            .setHeatOfFusion(186)
            .setColor(0xDCD7BE)
            .setName("protactinium"));
    // density = 15370
    // viscosity =

    public static final TekoraFluidData URANIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(1408)
            .setDefiniteBoilingPoint(4404)
            .setHeatOfFusion(126)
            .setColor(0xA8BDA2)
            .setName("uranium"));
    // density = 17300
    // viscosity =

    public static final TekoraFluidData NEPTUNIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(917)
            .setDefiniteBoilingPoint(4175)
            .setHeatOfFusion(63.5f)
            .setColor(0x8FDFBC)
            .setName("neptunium"));
    // density = 19380
    // viscosity =

    public static final TekoraFluidData PLUTONIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(913)
            .setDefiniteBoilingPoint(3501)
            .setHeatOfFusion(41.4f)
            .setColor(0xDFCDB7)
            .setName("plutonium"));
    // density = 16630
    // viscosity =

    public static final TekoraFluidData AMERICIUM = new TekoraFluidData(new TekoraFluidData.Properties()
            .metallic()
            .setMeltingPoint(2284)
            .setDefiniteBoilingPoint(3400)
            .setHeatOfFusion(291)
            .setColor(0xDFC2C2)
            .setName("americium"));
    // density = 12000
    // viscosity =
}

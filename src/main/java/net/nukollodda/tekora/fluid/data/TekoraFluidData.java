package net.nukollodda.tekora.fluid.data;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

import java.util.ArrayList;
import java.util.List;

// will be removed in a future version, with the data replaced by json files.
public class TekoraFluidData {
    private final String liquidName;
    private final String gasName;
    private final int liquidSpecificHeat;
    private final float gasSpecificHeat;
    private final float vapHeat;
    private final float fusHeat;
    private final float melting;
    private final float boilingCoefficient;
    private final float boilingPower;
    private final float boilingLowest;
    private final boolean isMetallic;
    private final int fluidDmg;
    private final MobEffect[] effects;
    private final int liquidColor;
    private final int gasColor;
    private final float hydrogenationRate;
    private final boolean decompose;
    private final int burnability;
    private final float radioactivity;
    public TekoraFluidData(Properties properties) {
        this.liquidName = properties.liquidName;
        this.gasName = properties.gasName;
        this.liquidSpecificHeat = properties.liquidSpecificHeat;
        this.gasSpecificHeat = properties.gasSpecificHeat;
        this.vapHeat = properties.vapHeat;
        this.fusHeat = properties.fusHeat;
        this.melting = properties.melting;
        this.boilingCoefficient = properties.boilingCoefficient;
        this.boilingPower = properties.boilingPower;
        this.boilingLowest = properties.boilingLowest;
        this.isMetallic = properties.isMetallic;
        this.fluidDmg = properties.fluidDmg;
        this.effects = properties.effects;
        this.liquidColor = properties.liquidColor;
        this.gasColor = properties.gasColor;
        this.hydrogenationRate = properties.hydrogenationRate;
        this.decompose = properties.decompose;
        this.burnability = properties.burns;
        this.radioactivity = properties.radioactivity;
    }

    public float getSpecificHeat(boolean isGas) {
        return isGas ? gasSpecificHeat : liquidSpecificHeat;
    }

    public float getFusionHeat() {
        return fusHeat;
    }

    public float getVaporizationHeat() {
        return vapHeat;
    }

    public float getMeltingPoint() {
        return melting;
    }

    public float getBoilingPoint(float pressure) {
        return boilingCoefficient * (float)Math.pow(pressure, boilingPower) + boilingLowest;
    }

    public boolean isMetallic() {
        return isMetallic;
    }

    public int getFluidDmg() {
        return fluidDmg;
    }

    public MobEffect[] getEffects() {
        return effects;
        // note: once this reaches the fluid type class, the temperature and state of matter will affect
        // the time period and amplification of the effects
    }

    public float getRadioactivity() {
        return radioactivity;
    }

    public int getLiquidColor() {
        return this.liquidColor;
    }

    public int getGasColor() {
        return this.gasColor;
    }

    public float getHydrogenationRate() {
        return hydrogenationRate;
    }

    public int getBurnability() {
        return burnability;
    }

    public String getLiquidName() {
        return liquidName;
    }

    public String getGasName() {
        return gasName;
    }

    public boolean doesDecompose() {
        return decompose;
    }

    public static final class Properties {
        /** All temperature values are measured in kelvins
         * specific heat is measured in J/L K
         * heat of fusion and vaporization are measured in J/L
         */

        // determines energy generated in Tekora reactors
        // should all be measured in J/L K
        private String liquidName;
        private String gasName;
        private int liquidSpecificHeat = 4170;
        private float gasSpecificHeat = 1.996f;

        // the enthalpies of fusion and heat needs to be set to kJ/L K
        private float fusHeat = 3.33f;
        private float vapHeat = 2250;

        // more biome related vars
        private float melting = 273;
        private float boilingCoefficient = 160;
        private float boilingPower = 0.348f;
        private float boilingLowest = 213;
        private boolean isMetallic = false;

        private int fluidDmg = 0;
        private MobEffect[] effects = null;
        private float healthHazard = 0;

        // possible replacements, rate of hydrogenation/dehydrogenation, along with oxidation/reduction properties
        private float hydrogenationRate = 0;

        private int liquidColor;
        private int gasColor;
        private boolean decompose = false;
        private int burns = 0;
        private float radioactivity = 0;
        private float amountOfGasPerLiquid = 1000;

        private Properties() {}

        public Properties setLiquidName(String pName) {
            this.liquidName = pName;
            return this;
        }

        public Properties setGasName(String pName) {
            this.gasName = pName;
            return this;
        }

        /** Specific heat (Cp) is the amount of energy, joules,
         * required to increase a liter of a material to a degree kelvin higher.
         * Liquids have a different and a significantly large specific heat than gases
         */
        public Properties setSpecificHeatOfLiquid(int liquidSpecificHeat) throws IllegalArgumentException {
            if (liquidSpecificHeat < 0)
                throw new IllegalArgumentException("Number Must Be Positive");
            this.liquidSpecificHeat = liquidSpecificHeat;
            return this;
        }

        public Properties setSpecificHeatOfGas(float gasSpecificHeat) throws IllegalArgumentException {
            if (gasSpecificHeat < 0)
                throw new IllegalArgumentException("Number Must Be Positive");
            this.gasSpecificHeat = gasSpecificHeat;
            return this;
        }

        /** The heat of vaporization and fusion are both measured in kJ/L
         * since they're measured in liters, the liquid density is used instead of the gas density
         */
        public Properties setHeatOfVaporization(float vapHeat) throws IllegalArgumentException {
            if (vapHeat < 0)
                throw new IllegalArgumentException("Number Must Be Positive");
            this.vapHeat = vapHeat;
            return this;
        }

        public Properties setHeatOfFusion(float fusHeat) throws IllegalArgumentException {
            if (fusHeat < 0)
                throw new IllegalArgumentException("Number Must Be Positive");
            this.fusHeat = fusHeat;
            return this;
        }

        /** @param melting Melting point of a substance measured in kelvins
         *          * For materials that magically don't freeze, set it to zero or under.
         */
        public Properties setMeltingPoint(float melting) {
            this.melting = Math.max(melting, 0);
            return this;
        }

        /** For Tekora fluids, the functions below may be changed in the future to account for supercritical fluids.
         * @param coefficient Difference between a material's vacuum boiling point and boiling point at standard pressures.
         * */
        public Properties setBoilingCoefficient(float coefficient) {
            this.boilingCoefficient = coefficient;
            return this;
        }

        /** Used to calculate when something boils,
         * this may not be accurate but should be sufficient for the purposes of Tekora
         * @param power the power of the triple equation, recommended to be a value between 0 and 1
          * */
        public Properties setBoilingPower(float power) {
            this.boilingPower = Math.max(Math.min(power, 2), 0);
            return this;
        }

        /** The value below sets the lowest possible boiling point of a material
         * ie when there is no pressure.
         * While the Tekora base mod may not use this property, it will be useful to define
         * properties of future Tekora addons.
         * @param boilingLowest boiling point of a substance in kelvins
         */
        public Properties setLowestPossibleBoilingPoint(float boilingLowest) {
            this.boilingLowest = Math.min(Math.max(boilingLowest, 0), 8192);
            return this;
        }

        public Properties metallic() {
            this.liquidSpecificHeat = 1;
            this.isMetallic = true;
            return this;
        }

        /* Will be removed at some point
         * Assuming the triple points of all fluids can be found.
         */
        public Properties setDefiniteBoilingPoint(float boilingPoint) {
            this.boilingCoefficient = 0;
            this.boilingPower = 0;
            this.boilingLowest = boilingPoint;
            return this;
        }

        public Properties setHealthHazard(int healthHazard) {
            if (healthHazard < 0) {
                throw new IllegalArgumentException("Number Must Be Positive");
            }
            this.fluidDmg = healthHazard;
            List<MobEffect> mobEffects = new ArrayList<>();
            switch (healthHazard) {
                case 4: mobEffects.add(MobEffects.WITHER);
                case 3:
                    mobEffects.add(MobEffects.HUNGER);
                    mobEffects.add(MobEffects.BLINDNESS);
                    mobEffects.add(MobEffects.POISON);
                case 2:
                    mobEffects.add(MobEffects.DIG_SLOWDOWN);
                    mobEffects.add(MobEffects.WEAKNESS);
                    mobEffects.add(MobEffects.CONFUSION);
                case 1: mobEffects.add(MobEffects.MOVEMENT_SLOWDOWN);
            }
            this.effects = mobEffects.toArray(new MobEffect[]{});
            return this;
        }

        /** use setReactivness instead
         */
        @Deprecated
        public Properties setHydrogenationRate(float hydrogenationRate) {
            this.hydrogenationRate = hydrogenationRate;
            this.fluidDmg += (int)Math.round(Math.pow(hydrogenationRate / 7, 2));
            return this;
        }

        public Properties setReactiviness(float reactiviness) {
            return this;
        }

        public Properties setColor(int color) {
            this.liquidColor = color;
            this.gasColor = color;
            return this;
        }

        public Properties setLiquidColor(int color) {
            this.liquidColor = color;
            return this;
        }

        public Properties setGasColor(int color) {
            this.gasColor = color;
            return this;
        }

        /*Some substances decompose instead of melting, (pure carbonic acid and some xenon compounds are examples),
        * this is due to change in the future. */
        public Properties decomposesInsteadOfBoiling() {
            this.decompose = true;
            return this;
        }

        public Properties doesNotBoil() {
            return setDefiniteBoilingPoint(8192);
        }
        public Properties setName(String pName) {
            return setName(pName, (byte)3);
        }

        // may be replaced with flammability
        public Properties setFlammable(boolean postBoil) {
            this.burns = (byte)(postBoil ? 2 : 1);
            return this;
        }

        public Properties setFlammability(int flammability) {
            this.burns = flammability;
            return this;
        }

        /** @param pName String: name of the substance
         * @param pRename byte: 0 renames neither fluid nor gas, 1 renames liquid, 2 renames gas, 3 renames both
         * */
        public Properties setName(String pName, byte pRename) {
            if (pRename % 2 == 0) {
                this.liquidName = pName;
            } else if (this.melting > 700) {
                this.liquidName = "molten_" + pName;
            } else {
                this.liquidName = pName + "_fluid";
            }
            this.gasName = pName + (pRename >= 2 ? (this.boilingLowest > 350 ? "_vapor" : "_gas") : "");
            return this;
        }

        /*Will be used for tritium*/
        public Properties setRadioactivity(float radioactivity) {
            this.radioactivity = radioactivity;
            return this;
        }

        /** @param amountOfGasPerLiquid how many liters of gas is emitted after boiling a single liter of liquid.
         *                               It is equivalent to the density of liquid divided by density of gas.
         *  This detail will be used for future Tekora machines.
         * */
        public Properties setAmountOfGasPerLiquid(float amountOfGasPerLiquid) {
            this.amountOfGasPerLiquid = amountOfGasPerLiquid;
            return this;
        }

        // only used for Tekora Mixtures - note molar ratios will be taken into consideration in the future
        public static Properties of(TekoraFluidData... pDatas) {
            Properties properties = new Properties();
            properties.decompose = true;
            int length = pDatas.length;
            float pHSum = 0;
            int liquidRed = 0, liquidGreen = 0, liquidBlue = 0, gasRed = 0, gasGreen = 0, gasBlue = 0;
            int fluidDmgSum = 0;
            float bp = 0, bPower = 0, bCoef = 0;
            for (TekoraFluidData data : pDatas) {
                pHSum += data.getHydrogenationRate();
                fluidDmgSum += data.getFluidDmg();

                liquidRed += (data.getLiquidColor() / 0x10000);
                liquidGreen += (data.getLiquidColor() / 0x100) % 256;
                liquidBlue += data.getLiquidColor() % 256;
                gasRed += (data.getGasColor() / 0x10000);
                gasGreen += (data.getGasColor() / 0x100) % 256;
                gasBlue += data.getGasColor() % 256;
                bp += data.boilingLowest;
                bPower += data.boilingPower;
                bCoef += data.boilingCoefficient;
            }
            properties.hydrogenationRate = pHSum / length;
            properties.liquidColor = (liquidRed / length * 0x10000) + (liquidGreen / length * 0x100) + (liquidBlue / length);
            properties.gasColor = (gasRed / length * 0x10000) + (gasGreen / length * 0x100) + (gasBlue / length);
            properties.boilingLowest = bp / length;
            properties.boilingPower = bPower / length;
            properties.boilingCoefficient = bCoef / length;
            return properties.setHealthHazard(fluidDmgSum / length);
        }

        public static Properties create() {
            return new Properties();
        }
    }
}

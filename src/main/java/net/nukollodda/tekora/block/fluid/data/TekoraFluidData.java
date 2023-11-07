package net.nukollodda.tekora.block.fluid.data;

import net.minecraft.world.effect.MobEffect;

import java.util.ArrayList;

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
    private final float acidity;
    private final float basicity;
    private final boolean decompose;
    private final byte burnability;
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
        this.acidity = properties.acidity;
        this.basicity = properties.basicity;
        this.decompose = properties.decompose;
        this.burnability = properties.burns;
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

    public int getLiquidColor() {
        return this.liquidColor;
    }

    public int getGasColor() {
        return this.gasColor;
    }

    public float getAcidity() {
        return acidity;
    }

    public float getBasicity() {
        return basicity;
    }

    public byte getBurnability() {
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
        /* All temperature values are measured in kelvins
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

        // vars that affects entities

        private int fluidDmg = 0;
        private MobEffect[] effects = null;

        // if the acidity is too high, non-noble/non-glass pipes will break when the fluid passes through it
        private float acidity; // measured in pKa (acid dissociation constant)

        // basicity has a high tendency to kill organisms
        private float basicity; // measured in pKb (base dissociation constant)

        private int liquidColor;
        private int gasColor;
        private boolean decompose = false;
        private byte burns = 0; // 0 - doesn't burn at all, 1 - burn at melting point, 2 - burn at boiling point
        /* Specific heat (Cp) is the amount of energy, joules,
         * required to increase a liter of a material to a kelvin higher
         */
        public Properties setLiquidName(String pName) {
            this.liquidName = pName;
            return this;
        }

        public Properties setGasName(String pName) {
            this.gasName = pName;
            return this;
        }

        public Properties setSpecificHeatOfLiquid(int liquidSpecificHeat) {
            this.liquidSpecificHeat = liquidSpecificHeat;
            return this;
        }

        public Properties setSpecificHeatOfGas(float gasSpecificHeat) {
            this.gasSpecificHeat = gasSpecificHeat;
            return this;
        }
        /* Note: The heat of vaporization and fusion should be set
         * from J/L to kJ/L for more efficient storage
         */

        public Properties setHeatOfVaporization(float vapHeat) {
            this.vapHeat = vapHeat;
            return this;
        }

        public Properties setHeatOfFusion(float fusHeat) {
            this.fusHeat = fusHeat;
            return this;
        }

        public Properties setMeltingPoint(float melting) {
            this.melting = melting;
            return this;
        }

        public Properties setBoilingCoefficient(float coefficient) {
            this.boilingCoefficient = coefficient;
            return this;
        }

        public Properties setBoilingPower(float power) {
            this.boilingPower = Math.max(Math.min(power, 1), 0);
            return this;
        }

        // The substances boiling point in outer space
        public Properties setLowestPossibleBoilingPoint(float boilingLowest) {
            this.boilingLowest = Math.min(Math.max(boilingLowest, 0), 8192);
            return this;
        }

        public Properties metallic() {
            this.liquidSpecificHeat = 1;
            this.isMetallic = true;
            return this;
        }

        // for fluids where the triple diagrams cannot be found
        public Properties setDefiniteBoilingPoint(float boilingPoint) {
            this.boilingCoefficient = 0;
            this.boilingPower = 0;
            this.boilingLowest = boilingPoint;
            return this;
        }

        public Properties setFluidDmg(int fluidDmg) {
            this.fluidDmg = fluidDmg;
            return this;
        }

        public Properties addEffects(MobEffect[] effects) {
            this.effects = effects;
            return this;
        }

        public Properties setAcidity(float acidity) {
            this.acidity = acidity;
            return this;
        }

        public Properties setBasicity(float basicity) {
            this.basicity = basicity;
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

        // only used for Tekora Mixtures - note molar ratios will be taken into consideration in the future
        public Properties setComponents(TekoraFluidData... pDatas) {
            this.decompose = true;
            int length = pDatas.length;
            float aciditySum = 0, basicitySum = 0;
            int liquidRed = 0, liquidGreen = 0, liquidBlue = 0, gasRed = 0, gasGreen = 0, gasBlue = 0;
            int fluidDmgSum = 0;
            float bp = 0, bPower = 0, bCoef = 0;
            ArrayList<MobEffect> effects = new ArrayList<>();
            for (TekoraFluidData data : pDatas) {
                aciditySum += data.getAcidity();
                basicitySum += data.getBasicity();
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
                if (data.effects != null) {
                    for (MobEffect effect : data.effects) {
                        if (!effects.contains(effect))
                            effects.add(effect);
                    }
                }
            }
            this.effects = effects.toArray(new MobEffect[0]);
            this.acidity = aciditySum / length;
            this.basicity = basicitySum / length;
            this.fluidDmg = fluidDmgSum / length;
            this.liquidColor = (liquidRed / length * 0x10000) + (liquidGreen / length * 0x100) + (liquidBlue / length);
            this.gasColor = (gasRed / length * 0x10000) + (gasGreen / length * 0x100) + (gasBlue / length);
            this.boilingLowest = bp / length;
            this.boilingPower = bPower / length;
            this.boilingCoefficient = bCoef / length;
            return this;
        }

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

        public Properties setFlammable(boolean postBoil) {
            this.burns = (byte)(postBoil ? 2 : 1);
            return this;
        }

        // 0(00) - neither, 1(01) - rename liquid, 2(10) - rename gas, 3(11) - rename both

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
    }
}

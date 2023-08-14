package net.nukollodda.tekora.block.fluid.data;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;

public class TekoraFluidData {
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
    private int liquidColor;
    private int gasColor;

    public TekoraFluidData(Properties properties) {
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

    private static float multiply(float num1, float num2) {
        return num1 * num2;
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

    public static final class Properties {
        /* All temperature values are measured in kelvins
         * specific heat is measured in J/L K
         * heat of fusion and vaporization are measured in J/L
         */

        // determines energy generated in Tekora reactors
        // should all be measured in J/L K
        private int liquidSpecificHeat = 4170;
        private float gasSpecificHeat = 1.996f;

        // the enthalpies of fusion and heat needs to be set to kJ/L K
        private float fusHeat = 333;
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


        /* Specific heat (Cp) is the amount of energy, joules,
         * required to increase a liter of a material to a kelvin higher
         */

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
            this.boilingPower = power;
            return this;
        }

        // The substances boiling point in outer space
        public Properties setLowestPossibleBoilingPoint(float boilingLowest) {
            this.boilingLowest = boilingLowest;
            return this;
        }

        public Properties metallic() {
            this.isMetallic = true;
            return this;
        }

        // for temporary purposes
        public Properties setDefiniteBoilingPoint(float boilingPoint) {
            this.boilingCoefficient = 0;
            this.boilingPower = 1;
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
    }
}

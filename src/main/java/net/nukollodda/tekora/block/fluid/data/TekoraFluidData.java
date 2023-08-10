package net.nukollodda.tekora.block.fluid.data;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;

public class TekoraFluidData {
    private final Block solidForm;
    private final LiquidBlock liquidForm;
    private final LiquidBlock gasForm;
    private final int liquidSpecificHeat;
    private final float gasSpecificHeat;
    private final int vapHeat;
    private final int fusHeat;
    private final float acidity;
    private final float melting;
    private final float boilingCoefficient;
    private final float boilingPower;
    private final float boilingLowest;
    private final boolean isMetallic;
    private final int fluidDmg;
    private final MobEffect[] effects;

    public TekoraFluidData(Properties properties) {
        this.solidForm = properties.solidForm;
        this.liquidForm = properties.liquidForm;
        this.gasForm = properties.gasForm;
        this.liquidSpecificHeat = properties.liquidSpecificHeat;
        this.gasSpecificHeat = properties.gasSpecificHeat;
        this.vapHeat = properties.vapHeat;
        this.fusHeat = properties.fusHeat;
        this.acidity = properties.acidity;
        this.melting = properties.melting;
        this.boilingCoefficient = properties.boilingCoefficient;
        this.boilingPower = properties.boilingPower;
        this.boilingLowest = properties.boilingLowest;
        this.isMetallic = properties.isMetallic;
        this.fluidDmg = properties.fluidDmg;
        this.effects = properties.effects;
    }

    public Block getSolidForm() {
        return solidForm;
    }

    public LiquidBlock getLiquidForm() {
        return liquidForm;
    }

    public LiquidBlock getGasForm() {
        return gasForm;
    }

    public float getSpecificHeat(boolean isGas) {
        return isGas ? gasSpecificHeat : liquidSpecificHeat;
    }

    public int getFusionHeat() {
        return fusHeat;
    }

    public int getVaporizationHeat() {
        return vapHeat;
    }

    public float getAcidity() {
        return acidity;
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

    public static final class Properties {
        /* All temperature values are measured in kelvins
         * specific heat is measured in J/L K
         * heat of fusion and vaporization are measured in J/L
         */

        // determines biome based conditions
        private Block solidForm = null;
        private LiquidBlock liquidForm = null;
        private LiquidBlock gasForm;

        // determines energy generated in Tekora reactors
        // should all be measured in J/L
        private int liquidSpecificHeat = 4170;
        private float gasSpecificHeat = 1.996f;
        private int fusHeat = 333000;
        private int vapHeat = 2250000;

        // determines whether it can flow throw a pipe
        private float acidity = 7;

        // more biome related vars
        private float melting = 273;
        private float boilingCoefficient = 160;
        private float boilingPower = 0.348f;
        private float boilingLowest = 213;
        private boolean isMetallic = false;

        // vars that affects entities

        private int fluidDmg = 0;
        private MobEffect[] effects = null;

        public Properties setSolidForm(Block solidForm) {
            this.solidForm = solidForm;
            return this;
        }

        public Properties setLiquidForm(LiquidBlock liquidForm) {
            this.liquidForm = liquidForm;
            return this;
        }

        public Properties setGasForm(LiquidBlock gasForm) {
            this.gasForm = gasForm;
            return this;
        }

        public Properties setSpecificHeatOfLiquid(int liquidSpecificHeat) {
            this.liquidSpecificHeat = liquidSpecificHeat;
            return this;
        }

        /* Specific heat (Cp) is the amount of energy, joules,
         * required to increase a liter of a material to a kelvin higher
         */

        public Properties setSpecificHeatOfGas(float gasSpecificHeat) {
            this.gasSpecificHeat = gasSpecificHeat;
            return this;
        }

        public Properties setHeatOfVaporization(int vapHeat) {
            this.vapHeat = vapHeat;
            return this;
        }

        public Properties setHeatOfFusion(int fusHeat) {
            this.fusHeat = fusHeat;
            return this;
        }

        public Properties setAcidity(float acidity) {
            this.acidity = acidity;
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

        public Properties setLowestPossibleBoilingPoint(float boilingLowest) {
            this.boilingLowest = boilingLowest;
            return this;
        }

        public Properties metallic() {
            this.isMetallic = true;
            return this;
        }

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
    }
}

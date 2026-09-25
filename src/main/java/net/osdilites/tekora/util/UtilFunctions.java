package net.osdilites.tekora.util;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import net.osdilites.tekora.item.TekoraItems;
import net.osdilites.tekora.item.typical.IonicCompoundItem;

public class UtilFunctions {
    public static double IDEAL_GAS_CONST = 8.31446261815324; // J/mol K
    public static double IDEAL_GAS_CONST_BARS = 0.083144; // L bar/mol K

    // The values below assume that the block has a blockstate of Direction.UP (or Direction.Axis.Y)
    public static VoxelShape[] generateShapeForAllRotations(double pX1, double pY1, double pZ1, double pX2, double pY2, double pZ2) {
        VoxelShape[] shapes = new VoxelShape[6];
        shapes[0] = Block.box(pY1, pX1, pZ1, pY2, pX2, pZ2);
        shapes[1] = Block.box(pX1, pY1, pZ1, pX2, pY2, pZ2);
        shapes[2] = Block.box(pX1, pZ1, pY1, pX2, pZ2, pY2);
        shapes[3] = Block.box(16 - pY2, 16 - pX2, 16 - pZ2, 16 - pY1, 16 - pX1, 16 - pZ1);
        shapes[4] = Block.box(16 - pX2, 16 - pY2, 16 - pZ2, 16 - pX1, 16 - pY1, 16 - pZ1);
        shapes[5] = Block.box(16 - pX2, 16 - pZ2, 16 - pY2, 16 - pX1, 16 - pZ1, 16 - pY1);
        return shapes;
        // the array is outputted in the order [east, up, south, west, down, north]
    }

    public static double distance(BlockPos a, BlockPos b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        double dz = a.getZ() - b.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static float fitAngleInRange(float angle) {
        float tau = 2 * (float)Math.PI;

        angle %= tau;
        if (angle <= 0) angle += 2 * tau;
        return angle;
    }

    @SafeVarargs
    public static <T> boolean matches(T item, T... vals) {
        for (T val : vals) {
            if (val == item) return true;
        }
        return false;
    }

    public static Item getItemFromGearType(GearType type) {
        return switch (type) {
            case ALUMINUM -> TekoraItems.ALUMINUM_GEAR.get();
            case BRASS -> TekoraItems.BRASS_GEAR.get();
            case BRONZE -> TekoraItems.BRONZE_GEAR.get();
            case STEEL -> TekoraItems.STEEL_GEAR.get();
            case PLASTIC -> TekoraItems.PLASTIC_GEAR.get();
            case WOOD -> TekoraItems.WOODEN_GEAR.get();
            default -> null;
        };
    }

    public static Item getItemPartFromGearType(GearType type) {
        return switch (type) {
            case ALUMINUM -> TekoraItems.ALUMINUM_GEAR.get();
            case BRASS -> TekoraItems.BRASS_GEAR.get();
            case BRONZE -> TekoraItems.BRONZE_GEAR.get();
            case STEEL -> TekoraItems.STEEL_GEAR.get();
            case PLASTIC -> TekoraItems.PLASTIC_GEAR.get();
            case WOOD -> TekoraItems.WOODEN_GEAR.get();
            default -> null;
        };
    }

    public static double getPressure(Level level) { // bars (or hundred kPa)
        if (level != null && !level.isClientSide()) {
            ResourceKey<Level> type = level.dimension();
            if (type.equals(Level.OVERWORLD)) {
                return 1.013;
            } else if (type.equals(Level.NETHER)) {
                return 2.0;
            } else if (type.equals(Level.END)) {
                return 0.5;
            } else {
                // todo, use dimension jsons to find value.
            }

        }
        return 1.013;
    }

    public static double getAirHeatTransfer(Level level) { // J/g K
        if (level != null && !level.isClientSide()) {
            ResourceKey<Level> type = level.dimension();
            if (type.equals(Level.OVERWORLD)) {
                return 1005;
            } else if (type.equals(Level.NETHER)) {
                return 1200;
            } else if (type.equals(Level.END)) {
                return 1500;
            } else {
                // todo, use dimension jsons to find value.
            }

        }
        return 0;
    }

    public static double getAirResTorque(Level level, double radius, double velocity) {
        double pressure = getPressure(level);
        // todo, beyond air resistance, we need to wonder about friction applied by blocks in contact with the block.
        //  This could be done by hard coding it (as in using class hierarchies etc) or the use of json files for datapack creators or mods.
        return -0.5 * pressure * radius * velocity; // this value inputted in air resistance
    }

    public static double fromMcTempToKelvins(double mcTemp) {
        return mcTemp * 25 + 273.15;
    }

    public static double fromMcTempToCelsius(double mcTemp) {
        return mcTemp * 25;
    }

    public static double fromMcTempToFahrenheit(double mcTemp) {
        return mcTemp * 45 + 32;
    }

    public static double fromFahrenheitToMcTemp(double fahrenheit) {
        return (fahrenheit - 32) / 45;
    }

    public static double fromCelsiusToMcTemp(double celsius) {
        return celsius / 25;
    }

    public static double fromKelvinsToMcTemp(double kelvins) {
        return (kelvins - 273.15) / 25;
    }

    public static double getMoleCountFromIngredient(Ingredient ing) {
        Item item = ing.getValues().get(0).value();
        if (item instanceof IonicCompoundItem chemicalItem) {
            return chemicalItem.getMoles();
        } else {
            // todo, use JSON to derive the value
        }
        return 1;
    }
}

package net.osdilites.tekora.util;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.client.model.standalone.StandaloneModelLoader;
import net.neoforged.neoforge.model.data.ModelData;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import net.osdilites.tekora.item.TekoraItems;

public class UtilFunctions {
    public static double IDEAL_GAS_CONST = 8.134; // todo, figure out the units for this

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
}

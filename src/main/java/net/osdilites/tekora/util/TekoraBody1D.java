package net.osdilites.tekora.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.transporter.rotational.RotationalAbstractEntity;

import java.util.List;

// This is a class used for the shafts, gears, and other 1D mech contraptions in Tekora.
public class TekoraBody1D {
    public double torque;

    @Deprecated
    public double mass;
    private double velocity;
                      // If axis == x | y | z
    private int f; // a =        y | x | x
    private int g; // b =        z | z | y
    private int pA;
    private int pB;
    private final Direction.Axis axis;
    private BlockPos start;
    private BlockPos end;

    @Deprecated
    private List<Double> masses;
    public TekoraBody1D(Direction.Axis axis, BlockPos start, BlockPos end, List<Double> masses) {
        this.axis = axis;
        this.start = start;
        this.end = end;
        int a;
        int b;
        if (axis == Direction.Axis.X) {
            f = start.getY();
            g = start.getZ();
            if (end.getY() == f && end.getZ() == g) {
                a = start.getX();
                b = end.getX();
            } else {
                a = start.getX();
                b = start.getX();
                Tekora.LOGGER.debug("Invalid positions for the end points {} with respect to {}, thus this object will ignore the end position.",end.toShortString(), start.toShortString());
            }
        } else if (axis == Direction.Axis.Y) {
            f = start.getX();
            g = start.getZ();
            if (end.getX() == f && end.getZ() == g) {
                a = start.getY();
                b = end.getY();
            } else {
                a = start.getY();
                b = start.getY();
                Tekora.LOGGER.debug("Invalid positions for the end points {} with respect to {}, thus this object will ignore the end position.",end.toShortString(), start.toShortString());
            }
        } else {
            f = start.getX();
            g = start.getY();
            if (end.getX() == f && end.getY() == g) {
                a = start.getZ();
                b = end.getZ();
            } else {
                a = start.getZ();
                b = start.getZ();
                Tekora.LOGGER.debug("Invalid positions for the end points {} with respect to {}, thus this object will ignore the end position.",end.toShortString(), start.toShortString());
            }
        }

        this.pA = Math.min(a, b);
        this.pB = Math.max(a, b);
        this.masses = masses;
    }

    /** A method that splits the mass and force of the object using the endpoints
     * */
    // In the future when Tekora starts supporting multidimensional bodies,
    // the split function would only get called if you have two parts connected
    // by one block and that it is broken.
    public void split(Level pLevel, BlockPos pPos) {
        boolean isValid;
        int val;
        BlockPos newEnd;
        BlockPos newStart;
        int newA;
        switch (axis) {
            case X -> {
                val = pPos.getX();
                isValid = pPos.getY() == f && pPos.getZ() == g;
                newEnd = pPos.west();
                newStart = pPos.east();
                newA = newEnd.getX();
            }
            case Y -> {
                val = pPos.getY();
                isValid = pPos.getX() == f && pPos.getZ() == g;
                newEnd = pPos.below();
                newStart = pPos.above();
                newA = newEnd.getY();
            }
            default -> {
                val = pPos.getZ();
                isValid = pPos.getX() == f && pPos.getY() == g;
                newEnd = pPos.north();
                newStart = pPos.south();
                newA = newEnd.getZ();
            }
        }

        if (isValid && suffDiff(pA, pB, val)) {
            if (pPos.equals(start)) {
                this.start = newStart;
                masses.removeFirst();
            } else if (pPos.equals(end)) {
                this.end = newEnd;
                masses.removeLast();
            } else {
                int split = (val - pA);
                int end = (pB - pA);
                TekoraBody1D newBody = new TekoraBody1D(axis, newStart, this.end, masses.subList(split + 1, end));
                newBody.torque = 0;
                masses = masses.subList(0, split);
                torque = 0;
                this.end = newEnd;
                for (int i = newA; i <= pB; i++) {
                    BlockPos checkedPos = switch (axis) {
                        case X -> new BlockPos(i, pPos.getY(), pPos.getZ());
                        case Y -> new BlockPos(pPos.getX(), i, pPos.getZ());
                        default -> new BlockPos(pPos.getX(), pPos.getY(), i);
                    };
                    BlockEntity checkedEnt = pLevel.getBlockEntity(checkedPos);
                    if (checkedEnt instanceof RotationalAbstractEntity rotEnt) {
                        rotEnt.setBody(newBody);
                    }
                }
            }
        }
    }

    /** A method that joins the mass and force of the object using the endpoints*/
    public void join(TekoraBody1D pObj, BlockPos pPos, double mass) {
        boolean isValid = pObj.axis == axis;

        double val;
        switch (axis) {
            case X -> {
                val = pPos.getX();
                isValid = isValid && pPos.getY() == f && pPos.getZ() == g;
            }
            case Y -> {
                val = pPos.getY();
                isValid = isValid && pPos.getX() == f && pPos.getZ() == g;
            }
            default -> {
                val = pPos.getZ();
                isValid = isValid && pPos.getX() == f && pPos.getY() == g;
            }
        }

        if (isValid && (suffDiff(pObj.pA, pObj.pB, val) || suffDiff(pA, pB, val))) {
            double doa = Math.abs(pObj.pA - val);
            double dob = Math.abs(pObj.pB - val);
            double dca = Math.abs(pA - val);
            double dcb = Math.abs(pB - val);
            if (dca < dcb) {
                pA = doa < dob ? pObj.pA : pObj.pB;
            } else {
                pB = doa < dob ? pObj.pA : pObj.pB;
            }

            this.mass += pObj.mass + mass;
            torque += pObj.torque;
        } else {
            Tekora.LOGGER.debug("Object joining mismatch at: {}", pPos.toShortString());
        }
    }

    public void join(BlockPos pPos, double mass) {
        boolean isValid;
        double val;
        switch (axis) {
            case X -> {
                val = pPos.getX();
                isValid = pPos.getY() == f && pPos.getZ() == g;
            }
            case Y -> {
                val = pPos.getY();
                isValid = pPos.getX() == f && pPos.getZ() == g;
            }
            default -> {
                val = pPos.getZ();
                isValid = pPos.getX() == f && pPos.getY() == g;
            }
        }
        isValid = isValid && suffDiff(pA, pB, val);
        if (isValid) {
            this.mass += mass;
        } else {
            Tekora.LOGGER.debug("Object joining mismatch at: {}", pPos.toShortString());
        }
    }

    private static boolean suffDiff(double a, double b, double val) {
        return Math.abs(a - val) == 1 || Math.abs(b - val) == 1;
    }

    private static boolean withinRange(double a, double b, double val) {
        return (a <= val && val <= b) || (b <= val && val <= a);
    }

    public void addForce(BlockPos pPos, double force) {
        boolean isValid;
        double val;
        switch (axis) {
            case X -> {
                val = pPos.getX();
                isValid = pPos.getY() == f && pPos.getZ() == g;
            }
            case Y -> {
                val = pPos.getY();
                isValid = pPos.getX() == f && pPos.getZ() == g;
            }
            default -> {
                val = pPos.getZ();
                isValid = pPos.getX() == f && pPos.getY() == g;
            }
        }
        if (isValid && (withinRange(pA, pB, val))) {
            double center = (pA + pB) / 2; // todo, we'll switch this to a more accurate formula in the future
            torque = (val - center) * force;
        }
    }

    public void reset() {
        torque = 0;
    }

    public boolean isStart(BlockPos pPos) {
        return pPos.equals(start);
    }

    public void tick() {
        // todo, make it tick.
    }
}
package net.osdilites.tekora.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.transporter.rotational.RotationalAbstractEntity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// This is a class used for the shafts, gears, and other 1D mech contraptions in Tekora.
public class TekoraBody1D {
    public double moment;
    private double velocity = 0;
                   // If axis == x | y | z
    private int f; // a =        y | x | x
    private int g; // b =        z | z | y
    private int pA;
    private int pB;
    private final Direction.Axis axis;
    private BlockPos start;
    private BlockPos end; // the end and pB are not properly defined
    private float oldAngle;
    private float angle;
    private final Level level;

    private final ArrayList<Double> moments;
    public TekoraBody1D(Level level, Direction.Axis axis, BlockPos start, BlockPos end, ArrayList<Double> moments) {
        this.level = level;
        this.axis = axis;
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
        if (a < b) {
            this.pA = a;
            this.pB = b;
            this.start = start;
            this.end = end;
        } else {
            this.pA = b;
            this.pB = a;
            this.start = end;
            this.end = start;
        }
        this.moments = moments;
        for (double mom : moments) {
            this.moment += mom;
        }
    }

    /** A method that splits the mass and force of the object using the endpoints
     * */
    public void split(BlockPos pPos, RotationalAbstractEntity pEntity) {
        boolean isValid;
        int val;
        BlockPos newEnd;
        BlockPos newStart;
        int newA;

        int x = pPos.getX();
        int y = pPos.getY();
        int z = pPos.getZ();
        // basic variable diagram
        // start (original) -> newEnd :split: newStart -> end (original)
        switch (axis) {
            case X -> {
                val = x;
                isValid = y == f && z == g;
                newEnd = pPos.west();
                newStart = pPos.east();
                newA = newStart.getX();
            }
            case Y -> {
                val = y;
                isValid = x == f && z == g;
                newEnd = pPos.below();
                newStart = pPos.above();
                newA = newStart.getY();
            }
            default -> {
                val = z;
                isValid = x == f && y == g;
                newEnd = pPos.north();
                newStart = pPos.south();
                newA = newStart.getZ();
            }
        }

        if (isValid) {
            if (pPos.equals(start)) {
                if (pEntity.isBodyTicker()) {
                    BlockEntity newEnt = level.getBlockEntity(newStart);
                    if (newEnt instanceof RotationalAbstractEntity newRot) {
                        newRot.updateTickerStatus();
                    }
                }
                this.start = newStart;
                if (!moments.isEmpty()) moment -= moments.removeFirst(); // todo 1
                else moment = 0;
            } else if (pPos.equals(end)) {
                if (pEntity.isBodyTicker()) {
                    BlockEntity newEnt = level.getBlockEntity(start);
                    if (newEnt instanceof RotationalAbstractEntity newRot) {
                        newRot.updateTickerStatus();
                    }
                }
                this.end = newEnd;
                if (!moments.isEmpty()) moment -= moments.removeLast(); // todo 1
                else moment = 0;
            } else {
                int split = (val - pA);
                int end = (pB - pA);
                TekoraBody1D newBody = new TekoraBody1D(level, axis, newStart, this.end, new ArrayList<>(moments.subList(split+1, end)));
                for (int i = end; i >= split; i--) { // todo 2
                    if (!moments.isEmpty()) moment -= moments.removeLast();
                    else {
                        moment = 0;
                        break;
                    }
                }
                this.end = newEnd;
                for (int i = newA; i <= pB; i++) {
                    BlockPos checkedPos = switch (axis) {
                        case X -> new BlockPos(i, f, g);
                        case Y -> new BlockPos(f, i, g);
                        default -> new BlockPos(f, g, i);
                    };
                    BlockEntity checkedEnt = level.getBlockEntity(checkedPos);
                    if (checkedEnt instanceof RotationalAbstractEntity newRot) {
                        newRot.setBody(newBody);
                    }
                }
            }
        }
    }

    /** A method that joins the mass and force of the object using the endpoints*/
    public void join(TekoraBody1D pObj, BlockPos pPos, double momentInertia) {
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
                if (doa < dob) {
                    pA = pObj.pA;
                    start = pObj.start;
                    moments.addFirst(momentInertia);
                    moments.addAll(0,  pObj.moments);
                } else {
                    pB = pObj.pB;
                    end = pObj.end;
                    moments.addLast(momentInertia);
                    moments.addAll(pObj.moments);
                }
            } else if (dca > dcb) {
                if (doa > dob) {
                    pA = pObj.pA;
                    start = pObj.start;
                    moments.addFirst(momentInertia);
                    moments.addAll(0,  pObj.moments);
                } else {
                    pB = pObj.pB;
                    end = pObj.end;
                    moments.addLast(momentInertia);
                    moments.addAll(pObj.moments);
                }
            }

            moment += momentInertia;
            for (double mom : pObj.moments) {
                moment += mom;
            }
        } else {
            Tekora.LOGGER.debug("Object joining mismatch at: {}, suffdiff coords: pA: {}, pB: {}, newVal: {}", pPos.toShortString(), pA, pB, val);
        }
    }

    /** A method that joins the mass and force of the object by extending out from the end point*/
    public void join(BlockPos pPos, double momentInertia) {
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
            if (val < pA) {
                pA--;
                start = pPos;
                moments.addFirst(momentInertia);
            } else if (val > pB) {
                pB++;
                end = pPos;
                moments.add(momentInertia);
            }
            moment += momentInertia;
        } else {
            Tekora.LOGGER.debug("Object joining mismatch at: {}, suffdiff coords: pA: {}, pB: {}, newVal: {}", pPos.toShortString(), pA, pB, val);
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
        if (isValid && moment != 0 && (withinRange(pA, pB, val))) {
            velocity += force / moment;
        }
    }

    // useful when a new body suddenly gets defined and an arbitrary ticker has to be set.
    public boolean isStart(BlockPos pPos) {
        return pPos.equals(start);
    }

    public void tick() {
        oldAngle = angle;
        angle += (float) velocity;
    }

    public float getAngle() {
        return angle;
    }

    public float getOldAngle() {
        return oldAngle;
    }

    public double getVelocity() {
        return velocity;
    }

    public Queue<RotationalAbstractEntity> getEntities() {
        LinkedList<RotationalAbstractEntity> entities = new LinkedList<>();
        for (int i = pA; i <= pB; i++) {
            BlockPos pos = switch (axis) {
                case X -> new BlockPos(i, f, g);
                case Y -> new BlockPos(f, i, g);
                case Z -> new BlockPos(f, g, i);
            };
            if (level.getBlockEntity(pos) instanceof RotationalAbstractEntity newRot) {
                entities.add(newRot);
            } // todo, implement a proper else statement
        }
        return entities;
    }

    // for debugging purposes
    public String toShortString() {
        return "axis: " + axis + ", start: " + start + ", end: " + end;
    }

    @Override
    public String toString() {
        return toShortString() + ", velocity: " + velocity;
    }
}
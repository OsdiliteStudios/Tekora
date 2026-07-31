package net.osdilites.tekora.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.mechanical.AbstractModularMachineEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.RotationalAbstractEntity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// This is a class used for the shafts and any potential shaft extension blocks like hand cranks or waterwheels in Tekora.
public class TekoraBody1D {
    private double moment;
    private double velocity = 0; // m/tick
                   // If axis == x | y | z
    private final int f; // a =        y | x | x
    private final int g; // b =        z | z | y
    private int pA;
    private int pB;
    private final Direction.Axis axis;
    private BlockPos start;
    private BlockPos end; // the end and pB are not properly defined
    private float oldAngle;
    private float angle;
    private final Level level;

    private double attachedMoment = 0;

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
        updateMoment();
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
                newStart = pPos.south();
                newEnd = pPos.north();
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
                pEntity.updateTickerStatus();
                this.start = newStart;
                pA++;
                if (!moments.isEmpty()) moments.removeFirst();
            } else if (pPos.equals(end)) {
                if (pEntity.isBodyTicker()) {
                    BlockEntity newEnt = level.getBlockEntity(start);
                    if (newEnt instanceof RotationalAbstractEntity newRot) {
                        newRot.updateTickerStatus();
                    }
                }
                this.end = newEnd;
                pB--;
                if (!moments.isEmpty()) moments.removeLast();
            } else {
                int split = (val - pA);
                int end = (pB - pA) + 1;
                if (moments.size() == end) {
                    TekoraBody1D newBody = new TekoraBody1D(level, axis, newStart, this.end, new ArrayList<>(end > split + 1 ? moments.subList(split+1, end) : List.of()));
                    for (int i = end-1; i >= split; i--) {
                        moments.removeLast();
                    }
                    this.end = newEnd;
                    for (int i = newA; i <= pB; i++) {
                        BlockPos checkedPos = switch (axis) {
                            case X -> new BlockPos(i, f, g);
                            case Y -> new BlockPos(f, i, g);
                            case Z -> new BlockPos(f, g, i);
                        };
                        BlockEntity checkedEnt = level.getBlockEntity(checkedPos);
                        if (checkedEnt instanceof RotationalAbstractEntity newRot) {
                            newRot.setBody(newBody);
                        }
                    }
                }
                pB = val - 1;
            }
            updateMoment();
        }
    }

    public void trimFirst() {
        if (!moments.isEmpty()) moments.removeFirst();
        updateMoment();
        pA++;
        start = switch (axis) {
            case X -> start.east();
            case Y -> start.above();
            case Z -> start.south();
        };
        BlockEntity newFirst = level.getBlockEntity(start);
        if (newFirst instanceof RotationalAbstractEntity newRot) {
            newRot.updateTickerStatus();
        }
    }

    public void trimLast() {
        if (!moments.isEmpty()) moments.removeLast();
        updateMoment();
        pB--;
        end = switch (axis) {
            case X -> end.west();
            case Y -> end.below();
            case Z -> end.north();
        };
    }

    /** A method that joins the mass and force of the object using the endpoints*/
    public void join(TekoraBody1D pObj, BlockPos pPos, double momentInertia) {
        boolean isValid = pObj.axis == axis && pObj != this;

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

        if (isValid) {
            if (val <= pA && val >= pObj.pB) {
                // curr is after the joining val, pObj is before the joining val.
                if (val < pA && val > pObj.pB) moments.addFirst(momentInertia); // ensures no additional moments is added
                moments.addAll(0, pObj.moments);
                BlockPos oldStart = start;
                pA = pObj.pA;
                start = pObj.start;
                if (level.getBlockEntity(start) instanceof RotationalAbstractEntity ent) {
                    ent.updateTickerStatus();
                    if (level.getBlockEntity(oldStart) instanceof RotationalAbstractEntity oldEnt) {
                        oldEnt.updateTickerStatus();
                    }
                }
            } else if (val >= pB && val <= pObj.pA) {
                // curr is before the joining val, pObj is after the joining val.
                if (val > pB && val < pObj.pA) moments.add(momentInertia);
                moments.addAll(pObj.moments);
                BlockPos oldStart = pObj.start;
                pB = pObj.pB;
                end = pObj.end;
                if (level.getBlockEntity(oldStart) instanceof RotationalAbstractEntity oldEnt) {
                    oldEnt.updateTickerStatus();
                }
            }
            updateMoment();
        } else {
            Tekora.LOGGER.debug("Objects joining mismatch at: " + pPos.toShortString() + ", suffdiff coords: pA: " + pA + ", pB: " + pB + ", newVal: " + val);
        }
    }

    /** A method that joins the mass and force of the object by extending out from the end point*/
    public void join(BlockPos pPos, double momentInertia) {
        if (level.getBlockEntity(pPos) instanceof RotationalAbstractEntity rotEnt) {
            if (rotEnt.hasBody()) {
                join(rotEnt.getBody(), pPos, momentInertia);
            } else {
                BlockState state = level.getBlockState(pPos);
                if ((state.hasProperty(BlockStateProperties.FACING) && state.getValue(BlockStateProperties.FACING).getAxis() == axis) ||
                        (state.hasProperty(BlockStateProperties.AXIS) && state.getValue(BlockStateProperties.AXIS) == axis)) {
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
                    if (isValid) {
                        if (val <= pA) {
                            pA = (int)val;
                            start = pPos;
                            moments.addFirst(momentInertia);
                        } else if (val >= pB) {
                            pB = (int)val;
                            end = pPos;
                            moments.add(momentInertia);
                        }
                        updateMoment();
                    } else {
                        Tekora.LOGGER.debug("Objects attachment mismatch at: " + pPos.toShortString() + ", suffdiff coords: pA: " + pA + ", pB: " + pB + ", newVal: " + val);
                    }
                }
            }
        }
    }

    private static boolean withinRange(double a, double b, double val) {
        return (a <= val && val <= b) || (b <= val && val <= a);
    }

    // Units is in kg * m^2 / (time)^2,
    // we don't know whether time will be in seconds since
    // we need to define seconds relative to Minecraft ticks.
    public void addTorque(BlockPos pPos, double torque) {
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

        if (moment == 0) throw new IllegalStateException("Moment cannot be 0");
        if (isValid && withinRange(pA, pB, val)) {
            velocity += torque * 0.05 / moment;
        }
    }

    // useful when a new body suddenly gets defined and an arbitrary ticker has to be set.
    public boolean isStart(BlockPos pPos) {
        return pPos.equals(start);
    }

    public BlockPos getStart() {
        return start;
    }

    public void tick() {
        if (velocity == 0 || Double.isNaN(velocity) || Double.isInfinite(velocity)) {
            angle = 0;
            oldAngle = angle;
        } else if (Double.isNaN(angle) || Double.isNaN(oldAngle) || Double.isInfinite(angle) || Double.isInfinite(oldAngle)) {
            oldAngle = 0;
            angle = (float)velocity;
        } else {
            oldAngle = angle;
            angle += (float)velocity;
        }
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
            } // else {
            //    split(pos, null);
            // }
        }
        return entities;
    }

    public void load(ValueInput input) {
        this.velocity = input.getDoubleOr("velocity", 0);
    }

    public void save(ValueOutput output) {
        output.putDouble("velocity", velocity);
    }

    public void setMoment(int loc, double moment) {
        int ni = loc - pA;
        if (ni < moments.size() && ni >= 0) {
            this.moments.set(ni, moment);
            updateMoment();
        }
    }

    public boolean axisMatch(Direction.Axis axis) {
        return axis == this.axis;
    }

    public double getMoment() {
        return moment;
    }

    public void checkAttached() {
        if (axis == Direction.Axis.Y && level.getBlockEntity(start.below()) instanceof AbstractModularMachineEntity ent) {
            attachedMoment = ent.getSingularMoment();
        } else {
            attachedMoment = 0;
        }
        updateMoment();
    }

    public boolean hasAttachment() {
        return axis == Direction.Axis.Y && level.getBlockEntity(start.below()) instanceof AbstractModularMachineEntity;
    }

    private void updateMoment() {
        if (axis == Direction.Axis.Y && level.getBlockEntity(start.below()) instanceof AbstractModularMachineEntity ent) {
            attachedMoment = ent.getSingularMoment();
        } else {
            attachedMoment = 0;
        }
        double val = attachedMoment;
        for (double m : moments) {
            val += m;
        }
        double orgI = moment;
        velocity = velocity * (val / (val + orgI));
        moment = val;
    }

    @Override
    public String toString() {
        // for Debugging purposes
        return "\n  id: " + hashCode() + "\n  velocity: " + velocity + ", oldRot: " + oldAngle + ", newRot: " + angle +
                "\n  moment of inertia: " + moment + ", attached moment of inertia: " + attachedMoment + "\n  moments array: " + moments +
                "\n  axis: " + axis + ", starts: " + pA + ", ends: " + pB;
    }
}
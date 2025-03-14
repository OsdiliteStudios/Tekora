package net.tekoramods.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tekoramods.tekora.block.entities.mechanical.AbstractMechanicalEntity;
import net.tekoramods.tekora.util.UtilFunctions;

public abstract class RotationalAbstractEntity extends AbstractMechanicalEntity {
    protected double force;
    protected Double totalMass;
    
    public RotationalAbstractEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, double pComponentMass) {
        super(pType, pPos, pBlockState, pComponentMass);
    }

    private double totalMassOfDir(Level pLevel, BlockPos pPos, Direction pDir) {
        BlockPos dirPos = UtilFunctions.posFromDir(pPos, pDir);
        BlockEntity ent = pLevel.getBlockEntity(dirPos);
        double added = 0;
        if (ent instanceof RotationalAbstractEntity rotational && rotational.sameAxis(pDir.getAxis())) {
            added += rotational.totalMassOfDir(pLevel, dirPos, pDir);
        }
        return added;
    }

    private double getTotalMass(Level pLevel, BlockPos pPos, Direction d1, Direction d2) {
        if (totalMass == null) {
            double mass = totalMassOfDir(pLevel, pPos, d1) + totalMassOfDir(pLevel, pPos, d2) + componentMass();
            setTotalMass(pLevel, pPos, d1, mass);
            setTotalMass(pLevel, pPos, d2, mass);
            return totalMass = mass;
        }
        return totalMass;
    }

    private void setTotalMass(Level pLevel, BlockPos pPos, Direction pDir, double pMass) {
        BlockPos newPos = UtilFunctions.posFromDir(pPos, pDir);
        BlockEntity ent = pLevel.getBlockEntity(newPos);
        if (ent instanceof RotationalAbstractEntity rotational && rotational.sameAxis(pDir.getAxis())) {
            rotational.setTotalMass(pLevel, newPos, pDir, pMass);
        }
        totalMass = pMass;
    }

    public double getTotalMass() {
        BlockState state = getBlockState();
        if (state.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
            Direction.Axis axis = state.getValue(AbstractTekoraAxialBlock.AXIS);
            return getTotalMass(getLevel(), getBlockPos(), UtilFunctions.dirFromAxis(axis, false), UtilFunctions.dirFromAxis(axis, true));
        }
        throw new IllegalStateException("The block located at " + getBlockPos() + " does not contain the facing property.");
    }

    public double getForce() {
        return force;
    }

    public boolean sameAxis(Direction.Axis pAxis) {
        BlockState state = getBlockState();
        if (state.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
            Direction.Axis axis = state.getValue(AbstractTekoraAxialBlock.AXIS);
            return axis.equals(pAxis);
        }
        return false;
    }

    void reset() {
        totalMass = null;
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (!pLevel.isClientSide) {
            if (pState.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
                Direction.Axis axis = pState.getValue(AbstractTekoraAxialBlock.AXIS);

//                double mass = switch (axis) {
//                    case X -> getTotalMass(pLevel, pPos, Direction.EAST, Direction.WEST);
//                    case Y -> getTotalMass(pLevel, pPos, Direction.UP, Direction.DOWN);
//                    case Z -> getTotalMass(pLevel, pPos, Direction.NORTH, Direction.SOUTH);
//                };

                if (axis == Direction.Axis.X) {
                    double temp = 0;
                    BlockEntity east = pLevel.getBlockEntity(pPos.east());
                    if (east instanceof RotationalAbstractEntity ent) {
                        temp = ent.getForce();
                    }
                    BlockEntity west = pLevel.getBlockEntity(pPos.west());
                    if (west instanceof RotationalAbstractEntity ent && ent.getForce() > temp) {
                        temp = ent.getForce();
                    }
                    force = temp;
                } else if (axis == Direction.Axis.Y) {
                    double temp = 0;
                    BlockEntity up = pLevel.getBlockEntity(pPos.above());
                    if (up instanceof RotationalAbstractEntity ent) {
                        temp = ent.getForce();
                    }
                    BlockEntity down = pLevel.getBlockEntity(pPos.below());
                    if (down instanceof RotationalAbstractEntity ent && ent.getForce() > temp) {
                        temp = ent.getForce();
                    }
                    force = temp;
                } else if (axis == Direction.Axis.Z) {
                    double temp = 0;
                    BlockEntity north = pLevel.getBlockEntity(pPos.north());
                    if (north instanceof RotationalAbstractEntity ent) {
                        temp = ent.getForce();
                    }
                    BlockEntity south = pLevel.getBlockEntity(pPos.south());
                    if (south instanceof RotationalAbstractEntity ent && ent.getForce() > temp) {
                        temp = ent.getForce();
                    }
                    force = temp;
                }
            }
        }
    }
}

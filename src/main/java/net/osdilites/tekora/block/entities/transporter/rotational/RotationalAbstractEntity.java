package net.osdilites.tekora.block.entities.transporter.rotational;

import com.google.common.util.concurrent.AtomicDouble;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.mechanical.AbstractMechanicalEntity;
import net.osdilites.tekora.util.TekoraBody1D;
import net.osdilites.tekora.util.UtilFunctions;

public abstract class RotationalAbstractEntity extends AbstractMechanicalEntity {
    @Deprecated
    protected double force;
    protected TekoraBody1D body;

    @Deprecated
    protected AtomicDouble totalMass;
    private float velocity;
    private float rotation; // todo, attach this later on to the force and acceleration values related to this block entity
    private BlockPos pA;
    private BlockPos pB;

    public RotationalAbstractEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, double pComponentMass) {
        super(pType, pPos, pBlockState, pComponentMass);
    }

    @Deprecated
    private double totalMassOfDir(Level pLevel, BlockPos pPos, Direction pDir) {
        BlockPos dirPos = UtilFunctions.posFromDir(pPos, pDir);
        BlockEntity ent = pLevel.getBlockEntity(dirPos);
        double added = 0;
        if (ent instanceof RotationalAbstractEntity rotational && rotational.sameAxis(pDir.getAxis())) {
            added += rotational.totalMassOfDir(pLevel, dirPos, pDir);
        }
        return added;
    }

    @Deprecated
    private double getTotalMass(Level pLevel, BlockPos pPos, Direction d1, Direction d2) {
        if (totalMass == null) {
            double mass = totalMassOfDir(pLevel, pPos, d1) + totalMassOfDir(pLevel, pPos, d2) + componentMass();
            setTotalMass(pLevel, pPos, d1, mass);
            setTotalMass(pLevel, pPos, d2, mass);
            totalMass.set(mass);
        }
        return totalMass.get();
    }

    @Deprecated
    private void setTotalMass(Level pLevel, BlockPos pPos, Direction pDir, double pMass) {
        BlockPos newPos = UtilFunctions.posFromDir(pPos, pDir);
        BlockEntity ent = pLevel.getBlockEntity(newPos);
        if (ent instanceof RotationalAbstractEntity rotational && rotational.sameAxis(pDir.getAxis())) {
            rotational.setTotalMass(pLevel, newPos, pDir, pMass);
        }
        totalMass.set(pMass);
    }

    // for optimization purposes, this can be written in the block rather than the block entity object
    // also, it will be used to calculate the center point, only the center point
    @Deprecated
    public double getTotalMass() {
        BlockState state = getBlockState();
        if (state.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
            Direction.Axis axis = state.getValue(AbstractTekoraAxialBlock.AXIS);
            return getTotalMass(getLevel(), getBlockPos(), UtilFunctions.dirFromAxis(axis, false), UtilFunctions.dirFromAxis(axis, true));
        }
        throw new IllegalStateException("The block located at " + getBlockPos() + " does not contain the facing property.");
    }

    public TekoraBody1D combine(RotationalAbstractEntity pOther, BlockPos pPos, double mass) {
        body.join(pOther.body, pPos, mass);
        return body;
    }

    public TekoraBody1D combine(BlockPos pPos, double mass) {
        body.join(pPos, mass);
        return body;
    }

    public void setEndpointA(BlockPos pos) {
        pA = pos;
    }

    public void setEndpointB(BlockPos pos) {
        pB = pos;
    }

    public BlockPos getEndpointA() {
        return pA;
    }

    public BlockPos getEndpointB() {
        return pB;
    }

    public void setBody(TekoraBody1D body) {
        this.body = body;
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
        if (!pLevel.isClientSide()) {
            if (pState.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
                double rc = componentRadius();
                double mc = componentMass();

                BlockPos pos = getBlockPos();
                double x0 = (pA.getX() + pB.getX()) / 2.0;
                double y0 = (pA.getY() + pB.getY()) / 2.0;
                double z0 = (pA.getZ() + pB.getZ()) / 2.0;

                double x1 = pos.getX();
                double y1 = pos.getY();
                double z1 = pos.getZ();

                double r = Math.sqrt(Math.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2) + Math.pow(z1 - z0, 2));
                // angular acceleration = 2rF/(MR^2)
                // in the formula, M is the mass is of the cogwheel by itself
                //                 R the radius is of the cogwheel by itself
                //                 r is the distance from the cogwheel to the center of the shaft
                //                 F is the force applied
                this.velocity += (float) (2 * r * force / (mc * rc * rc));
                // todo, make it so that force and acceleration always tries to get to 0 over time.
                this.force = 0; // code used to ensure that force becomes 0 to simulate a force stop being applied.
            }
        }
    }

    public float getRenderingRotation() {
        rotation += velocity * 3.6f; // 3.6 is the change in time in seconds/tick
        if (rotation >= 2 * Math.PI) {
            rotation -= (float) (2 * Math.PI);
        } else if (rotation < 0) {
            rotation += (float) (2 * Math.PI);
        }
        return rotation;
    }

    public void setForce(double force) {
        this.body.addForce(getBlockPos(), force);
    }

    public abstract double componentResistance();
}

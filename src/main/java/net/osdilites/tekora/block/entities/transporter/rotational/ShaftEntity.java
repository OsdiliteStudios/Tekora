package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.block.entities.mechanical.AbstractModularMachineEntity;
import net.osdilites.tekora.data.Partners;
import net.osdilites.tekora.data.TekoraComponents;

import java.util.ArrayList;
import java.util.HashMap;

public class ShaftEntity extends RotationalAbstractEntity {
    public static final double STEEL_I = 13.63; // mech age crafting
    public static final double BRONZE_I = 15.28;
    public static final double STAINLESS_STEEL_I = 13.89; // steam age crafting
    public static final double ALUMINUM_I = 4.69; // substitute for stainless steel
    public static final double NICHROME_I = 14.58; // used for electric age crafting along with nuclear power plants
    public static final double ALTIVLOY_I = 7.13; // for high-pressure stuff

    // in Tekora, steel is made by combining 3 coal chunk and an iron ingot in a kiln furnace
    // a stainless steel ingot requires 4 steel + 1 chromium ingot
    // nichrome is 4 nickel + 1 chromium ingot.
    // altivloy is 6 aluminum ingots + 4 vanadium ingots + 1 titanium ingot

    private final HashMap<Item, ArrayList<BlockPos>> attachedPartners;
    private final double moment;

    public ShaftEntity(BlockPos pPos, BlockState pState) {
        // WARNING: unsafe, only use in the registration
        this(pPos, pState, pState.getBlock() instanceof Shaft shaft ? shaft.getMoment() : 0);
    }

    public ShaftEntity(BlockPos pPos, BlockState pBlockState, double moment) {
        super(TekoraBlockEntities.SHAFT.get(), pPos, pBlockState);
        attachedPartners = new HashMap<>();
        this.moment = moment;
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (body != null && pLevel.getBlockEntity(pPos) instanceof RotationalAbstractEntity ent && pState.hasProperty(AbstractTekoraAxialBlock.AXIS)
                && pState.getValueOrElse(Shaft.GEAR_TYPE, GearType.NONE) != GearType.NONE) {
            Direction.Axis axis = pState.getValue(AbstractTekoraAxialBlock.AXIS);
            double orgV = componentRadius() * body.getVelocity();
            double tot = 0;

            if (pState.getValueOrElse(Shaft.IS_LARGE, false)) {
                // if i == -2 or 2, j != k
                // if i == 0, j == k
                int x = pPos.getX();
                int y = pPos.getY();
                int z = pPos.getZ();
                for (int i = -2; i <= 2; i += 2) {
                    for (int j = -2; j <= 2; ++j) {
                        for (int k = -2; k <= 2; ++k) {
                            if (((i == 0 && j != 0 && k != 0) || (i != 0 && ((j == 0) != (k == 0))))
                                    && ((Math.abs(j) == 2) != (Math.abs(k) == 2))) {
                                BlockPos newPos = switch (axis) {
                                    case X -> new BlockPos(x+i, y+j, z+k);
                                    case Y -> new BlockPos(x+j, y+i, z+k);
                                    case Z -> new BlockPos(x+j, y+k, z+i);
                                };
                                if (pLevel.getBlockEntity(newPos) instanceof ShaftEntity cog) {
                                    BlockState analyzedState = cog.getBlockState();
                                    if (analyzedState.getValueOrElse(Shaft.GEAR_TYPE, GearType.NONE) != GearType.NONE
                                            && ((analyzedState.getValueOrElse(Shaft.IS_LARGE, false) && Math.abs(i) == 2 || Math.abs(j) == 2 || Math.abs(k) == 2)
                                            || (!analyzedState.getValueOrElse(Shaft.IS_LARGE, false) && Math.abs(i) < 2 && Math.abs(j) < 2 && Math.abs(k) < 2))) {
                                        tot += contact(pLevel, pPos, pPos.above(), orgV, cog);
                                    } else {
                                        pLevel.removeBlockEntity(newPos);
                                    }
                                }
                            }
                        }
                    }
                }
                body.addTorque(pPos, tot);
            } else {
                BlockEntity up = pLevel.getBlockEntity(pPos.above());
                BlockEntity down = pLevel.getBlockEntity(pPos.below());
                BlockEntity north = pLevel.getBlockEntity(pPos.north());
                BlockEntity south = pLevel.getBlockEntity(pPos.south());
                BlockEntity east = pLevel.getBlockEntity(pPos.east());
                BlockEntity west = pLevel.getBlockEntity(pPos.west());
                if (axis == Direction.Axis.X) {
                    tot += contact(pLevel, pPos, pPos.above(), orgV, up);
                    tot += contact(pLevel, pPos, pPos.below(), orgV, down);
                    tot += contact(pLevel, pPos, pPos.north(), orgV, north);
                    tot += contact(pLevel, pPos, pPos.south(), orgV, south);
                } else if (axis == Direction.Axis.Y) {
                    tot += contact(pLevel, pPos, pPos.east(), orgV, east);
                    tot += contact(pLevel, pPos, pPos.west(), orgV, west);
                    tot += contact(pLevel, pPos, pPos.north(), orgV, north);
                    tot += contact(pLevel, pPos, pPos.south(), orgV, south);
                } else if (axis == Direction.Axis.Z) {
                    tot += contact(pLevel, pPos, pPos.east(), orgV, east);
                    tot += contact(pLevel, pPos, pPos.west(), orgV, west);
                    tot += contact(pLevel, pPos, pPos.above(), orgV, up);
                    tot += contact(pLevel, pPos, pPos.below(), orgV, down);
                }
                body.addTorque(pPos, tot);
            }

            if (components().has(TekoraComponents.PARTNERS)) {
                Partners partners = components().get(TekoraComponents.PARTNERS);
                if (partners != null) {
                    for (BlockPos p : partners.partners()) {
                        BlockState partnerState = pLevel.getBlockState(p);
                        if (partnerState.hasProperty(TekoraBlockStates.GEAR_TYPE)) {
                            GearType gearType = partnerState.getValue(TekoraBlockStates.GEAR_TYPE);
                            if (gearType == GearType.NONE) continue;

                            double moment = partnerState.getValueOrElse(TekoraBlockStates.IS_LARGE, false) ? gearType.getLargeMoment() : gearType.getSmallMoment();
                            // todo, figure an equation to figure what to do with the moment.
                        }
                    }
                }
            }
        }
        super.tick(pLevel, pPos, pState);
    }

    private double contact(Level pLevel, BlockPos curPos, BlockPos otherPos, double selfV, BlockEntity ent) {
        if (curPos.asLong() >= otherPos.asLong()) return 0;

        if (ent instanceof ShaftEntity cog && canBeCog() && cog.canBeCog()) {
            BlockState otherState = pLevel.getBlockState(otherPos);
            BlockState selfState = pLevel.getBlockState(curPos);
            if (otherState.hasProperty(BlockStateProperties.AXIS) && selfState.hasProperty(BlockStateProperties.AXIS)) {
                Direction.Axis otherVal = otherState.getValue(BlockStateProperties.AXIS);
                Direction.Axis selfVal = selfState.getValue(BlockStateProperties.AXIS);
                if (otherVal == selfVal) {
                    double r1 = componentRadius();
                    double r2 = cog.componentRadius();

                    double otherV = r2 * cog.body.getVelocity();
                    double slipV = selfV + otherV;
                    double j = slipV / (Math.pow(r1, 2) / body.getMoment() + Math.pow(r2, 2) / cog.body.getMoment());
                    double factor = -j / 0.05;
                    cog.body.addTorque(otherPos, r2 * factor);
                    return r1 * factor;
                }
            }
        } else if (ent instanceof AbstractModularMachineEntity machine) {
            BlockState selfState = pLevel.getBlockState(curPos);
            if (selfState.hasProperty(BlockStateProperties.AXIS) && selfState.getValue(BlockStateProperties.AXIS) == Direction.Axis.Y) {
                double r1 = componentRadius();
                double r2 = machine.componentRadius();

                double otherV = r2 * machine.getVelocity();
                double slipV = selfV + otherV;
                double j = slipV / (Math.pow(r1, 2) / body.getMoment() + Math.pow(r2, 2) / machine.getMoment());
                double factor = -j / 0.05;
                machine.addTorque(r2 * factor);
                return r1 * factor;
            }
        }
        return 0;
    }

    public boolean canBeCog() {
        BlockState state = getBlockState();
        return state.getValueOrElse(Shaft.GEAR_TYPE, GearType.NONE) != GearType.NONE;
    }

    @Override
    public double getMoment() {
        BlockState state = getBlockState();
        if (state.hasProperty(Shaft.GEAR_TYPE)) {
            GearType gearType = state.getValue(Shaft.GEAR_TYPE);
            return moment + (state.getValueOrElse(Shaft.IS_LARGE, false) ? gearType.getLargeMoment() : gearType.getSmallMoment());
        }
        return moment;
    }

    @Override
    public double componentRadius() {
        BlockState state = getBlockState();
        boolean canBeCog = state.getValueOrElse(Shaft.GEAR_TYPE, GearType.NONE) != GearType.NONE;
        boolean isLarge = state.getValueOrElse(Shaft.IS_LARGE, false);
        return canBeCog ? isLarge ? 1 : 0.5 : 0.125;
    }

    public HashMap<Item, ArrayList<BlockPos>> getAttachedPartners() {
        return attachedPartners;
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
    }

    @Override
    public void setChanged() {
        super.setChanged();
        BlockState state = getBlockState();
        if (body != null && state.hasProperty(TekoraBlockStates.GEAR_TYPE) && state.hasProperty(BlockStateProperties.AXIS)) {
            GearType gearType = state.getValue(TekoraBlockStates.GEAR_TYPE);
            double added = state.getValueOrElse(TekoraBlockStates.IS_LARGE, false) ? gearType.getLargeMoment() : gearType.getSmallMoment();
            double newVal = added + getMoment();
            BlockPos pos = getBlockPos();
            Direction.Axis axis = state.getValue(BlockStateProperties.AXIS);
            int loc = switch (axis) {
                case X -> pos.getX();
                case Y -> pos.getY();
                case Z -> pos.getZ();
            };
            if (body.axisMatch(axis)) body.setMoment(loc, newVal);
        }
    }
}

package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
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

public class ShaftEntity extends AbstractShaftConnectableEntity {
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
        if (body != null && pLevel.getBlockEntity(pPos) instanceof AbstractShaftConnectableEntity && pState.hasProperty(AbstractShaftConnectableBlock.AXIS)
                && pState.getValueOrElse(Shaft.GEAR_TYPE, GearType.NONE) != GearType.NONE) {
            Direction.Axis axis = pState.getValue(AbstractShaftConnectableBlock.AXIS);
            double orgV = componentRadius() * body.getVelocity();
            double tot = 0;

            if (pState.getValueOrElse(Shaft.IS_LARGE, false)) {
                // if i == -2 or 2, j != k
                // if i == 0, j == k
//                int x = pPos.getX();
//                int y = pPos.getY();
//                int z = pPos.getZ();
//                for (int i = -2; i <= 2; i += 2) {
//                    for (int j = -2; j <= 2; ++j) {
//                        for (int k = -2; k <= 2; ++k) {
//                            if (((i == 0 && j != 0 && k != 0) || (i != 0 && ((j == 0) != (k == 0))))
//                                    && ((Math.abs(j) == 2) != (Math.abs(k) == 2))) {
//                                BlockPos newPos = switch (axis) {
//                                    case X -> new BlockPos(x+i, y+j, z+k);
//                                    case Y -> new BlockPos(x+j, y+i, z+k);
//                                    case Z -> new BlockPos(x+j, y+k, z+i);
//                                };
//                                if (pLevel.getBlockEntity(newPos) instanceof ShaftEntity cog) {
//                                    BlockState analyzedState = cog.getBlockState();
//                                    if (analyzedState.getValueOrElse(Shaft.GEAR_TYPE, GearType.NONE) != GearType.NONE
//                                            && ((analyzedState.getValueOrElse(Shaft.IS_LARGE, false) && Math.abs(i) == 2 || Math.abs(j) == 2 || Math.abs(k) == 2)
//                                            || (!analyzedState.getValueOrElse(Shaft.IS_LARGE, false) && Math.abs(i) < 2 && Math.abs(j) < 2 && Math.abs(k) < 2))) {
//                                        tot += contact(pLevel, pPos, pPos.above(), orgV, cog);
//                                    } else {
//                                        pLevel.removeBlockEntity(newPos);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }

                // TODO: fix contact logic to make large gears work, make small gears rotate large gears, make large gears rotate other large gears on different axis

                if (axis == Direction.Axis.X) {
                    tot += rotateNeighbor(pLevel, pPos, orgV, 0, -1, -1); // doesnt work on (-z)
                    tot += rotateNeighbor(pLevel, pPos, orgV, 0, -1,  1);
                    tot += rotateNeighbor(pLevel, pPos, orgV, 0,  1, -1); // doesnt work (-z)
                    tot += rotateNeighbor(pLevel, pPos, orgV, 0,  1,  1);
                } else if (axis == Direction.Axis.Y) {
                    tot += rotateNeighbor(pLevel, pPos, orgV, -1, 0, -1); // doesnt work (-x)
                    tot += rotateNeighbor(pLevel, pPos, orgV, -1, 0,  1); // doesnt work (-x)
                    tot += rotateNeighbor(pLevel, pPos, orgV,  1, 0, -1);
                    tot += rotateNeighbor(pLevel, pPos, orgV,  1, 0,  1);
                } else if (axis == Direction.Axis.Z) {
                    tot += rotateNeighbor(pLevel, pPos, orgV, -1, -1, 0); // doesnt on (-x)
                    tot += rotateNeighbor(pLevel, pPos, orgV, -1,  1, 0); // doesnt on (-x)
                    tot += rotateNeighbor(pLevel, pPos, orgV,  1, -1, 0); // Works
                    tot += rotateNeighbor(pLevel, pPos, orgV,  1,  1, 0); // Works
                }

            } else {
                // Small gear rotation logic
                if (axis == Direction.Axis.X) {
                    tot += rotateNeighbor(pLevel, pPos, orgV,  0,  1,  0);
                    tot += rotateNeighbor(pLevel, pPos, orgV,  0, -1,  0);
                    tot += rotateNeighbor(pLevel, pPos, orgV,  0,  0, -1);
                    tot += rotateNeighbor(pLevel, pPos, orgV,  0,  0,  1);
                } else if (axis == Direction.Axis.Y) {
                    tot += rotateNeighbor(pLevel, pPos, orgV,  1,  0,  0);
                    tot += rotateNeighbor(pLevel, pPos, orgV, -1,  0,  0);
                    tot += rotateNeighbor(pLevel, pPos, orgV,  0,  0, -1);
                    tot += rotateNeighbor(pLevel, pPos, orgV,  0,  0,  1);
                } else if (axis == Direction.Axis.Z) {
                    tot += rotateNeighbor(pLevel, pPos, orgV,  1,  0,  0);
                    tot += rotateNeighbor(pLevel, pPos, orgV, -1,  0,  0);
                    tot += rotateNeighbor(pLevel, pPos, orgV,  0,  1,  0);
                    tot += rotateNeighbor(pLevel, pPos, orgV,  0, -1,  0);
                }
            }
            body.addTorque(pPos, tot);
            pLevel.sendBlockUpdated(pPos, pState, pState, 3);

            if (components().has(TekoraComponents.PARTNERS)) {
                Partners partners = components().get(TekoraComponents.PARTNERS);
                if (partners != null) {
                    for (BlockPos p : partners.partners()) {
                        BlockState partnerState = pLevel.getBlockState(p);
                        if (partnerState.hasProperty(TekoraBlockStates.GEAR_TYPE)) {
                            GearType gearType = partnerState.getValue(TekoraBlockStates.GEAR_TYPE);
                            if (gearType == GearType.NONE) continue;

                            double moment = partnerState.getValueOrElse(TekoraBlockStates.IS_LARGE, false) ? gearType.getLargeMoment() : gearType.getSmallMoment();
                            // todo, make the chain and conveyor belt implementation here
                        }
                    }
                }
            }
        }
        super.tick(pLevel, pPos, pState);
    }

    private double rotateNeighbor(Level level, BlockPos originalPos, double orgV, int xOffset, int yOffset, int zOffset) {
        BlockPos neighborPos = originalPos.offset(xOffset, yOffset, zOffset);
        BlockEntity neighbor = level.getBlockEntity(neighborPos);

        return contact(level, originalPos, neighborPos, orgV, neighbor);
    }

    private double contact(Level pLevel, BlockPos curPos, BlockPos otherPos, double selfV, BlockEntity ent) {
    // TODO: fix the line below
        // i assume it was meant for preventing duplication of contacts, as preventing
        // a small gear rotating a small gear, causing that gear to rotate the gear that rotated it
        // currently it's preventing large gears from spinning some small gears (Depending on the large gear's axis)
            // deleting it causes large gears to work fine (since small gears don't check to rotate large gears yet)
            // but deleting it also means small gears double contact each other, and spin extremely fast
            // you can find the list of what gears don't work in the gear logic above

        if (curPos.asLong() >= otherPos.asLong()) return 0;

        if (ent instanceof ShaftEntity cog && canBeCog() && cog.canBeCog()) {
            BlockState otherState = pLevel.getBlockState(otherPos);
            BlockState selfState = pLevel.getBlockState(curPos);
            if (otherState.hasProperty(BlockStateProperties.AXIS) && selfState.hasProperty(BlockStateProperties.AXIS) && otherState.getValueOrElse(TekoraBlockStates.GEAR_TYPE, GearType.NONE) != GearType.NONE) {
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
        } else if (ent instanceof AbstractModularMachineEntity machine && machine.getBlockState().getValueOrElse(TekoraBlockStates.GEAR_TYPE, GearType.NONE) != GearType.NONE) {
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

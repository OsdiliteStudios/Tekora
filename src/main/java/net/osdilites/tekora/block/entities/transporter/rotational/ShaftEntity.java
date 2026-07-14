package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

import java.util.ArrayList;
import java.util.HashMap;

public class ShaftEntity extends RotationalAbstractEntity {
    public static final double STEEL_I = 1543.307391075986; // mech age crafting
    public static final double STAINLESS_STEEL_I = 0; // steam age crafting
    //public static final double NICHROME_I = 0; // used for electric age crafting along with nuclear power plants
    //public static final double ALUMINUM_I = 0; // substitute for stainless steel
    //public static final double TITANIUM_I = 0; // for high-pressure stuff

    private final HashMap<Item, ArrayList<BlockPos>> attachedPartners;
    private final double moment;

    public ShaftEntity(BlockPos pPos, BlockState pBlockState, double moment) {
        super(TekoraBlockEntities.SHAFT.get(), pPos, pBlockState);
        attachedPartners = new HashMap<>();
        this.moment = moment;
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (body != null && pLevel.getBlockEntity(pPos) instanceof RotationalAbstractEntity ent && pState.hasProperty(AbstractTekoraAxialBlock.AXIS)
                && pState.hasProperty(Shaft.GEAR_TYPE) && pState.getValue(Shaft.GEAR_TYPE) != GearType.NONE) {
            Direction.Axis axis = pState.getValue(AbstractTekoraAxialBlock.AXIS);
            double orgV = ent.componentRadius() * ent.getBody().getVelocity();
            double c = 512;
            double tot = 0;

            if (pState.hasProperty(Shaft.IS_LARGE) && pState.getValue(Shaft.IS_LARGE)) {
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
                                    if (analyzedState.hasProperty(Shaft.GEAR_TYPE) && analyzedState.getValue(Shaft.GEAR_TYPE) != GearType.NONE
                                            && analyzedState.hasProperty(Shaft.IS_LARGE)
                                            && ((analyzedState.getValue(Shaft.IS_LARGE) && Math.abs(i) == 2 || Math.abs(j) == 2 || Math.abs(k) == 2)
                                            || (!analyzedState.getValue(Shaft.IS_LARGE) && Math.abs(i) < 2 && Math.abs(j) < 2 && Math.abs(k) < 2))) {
                                        tot += contact(pLevel, pPos, pPos.above(), orgV, c, cog);
                                    } else {
                                        pLevel.removeBlockEntity(newPos);
                                    }
                                }
                            }
                        }
                    }
                }
                body.addForce(pPos, tot);
            } else {
                BlockEntity up = pLevel.getBlockEntity(pPos.above());
                BlockEntity down = pLevel.getBlockEntity(pPos.below());
                BlockEntity north = pLevel.getBlockEntity(pPos.north());
                BlockEntity south = pLevel.getBlockEntity(pPos.south());
                BlockEntity east = pLevel.getBlockEntity(pPos.east());
                BlockEntity west = pLevel.getBlockEntity(pPos.west());
                if (axis == Direction.Axis.X) {
                    if (up instanceof ShaftEntity cog && cog.canBeCog())
                        tot += contact(pLevel, pPos, pPos.above(), orgV, c, cog);
                    if (down instanceof ShaftEntity cog && cog.canBeCog())
                        tot += contact(pLevel, pPos, pPos.below(), orgV, c, cog);
                    if (north instanceof ShaftEntity cog && cog.canBeCog())
                        tot += contact(pLevel, pPos, pPos.north(), orgV, c, cog);
                    if (south instanceof ShaftEntity cog && cog.canBeCog())
                        tot += contact(pLevel, pPos, pPos.south(), orgV, c, cog);
                } else if (axis == Direction.Axis.Y) {
                    if (east instanceof ShaftEntity cog && cog.canBeCog())
                        tot += contact(pLevel, pPos, pPos.east(), orgV, c, cog);
                    if (west instanceof ShaftEntity cog && cog.canBeCog())
                        tot += contact(pLevel, pPos, pPos.west(), orgV, c, cog);
                    if (north instanceof ShaftEntity cog && cog.canBeCog())
                        tot += contact(pLevel, pPos, pPos.north(), orgV, c, cog);
                    if (south instanceof ShaftEntity cog && cog.canBeCog())
                        tot += contact(pLevel, pPos, pPos.south(), orgV, c, cog);
                } else if (axis == Direction.Axis.Z) {
                    if (east instanceof ShaftEntity cog && cog.canBeCog())
                        tot += contact(pLevel, pPos, pPos.east(), orgV, c, cog);
                    if (west instanceof ShaftEntity cog && cog.canBeCog())
                        tot += contact(pLevel, pPos, pPos.west(), orgV, c, cog);
                    if (up instanceof ShaftEntity cog && cog.canBeCog())
                        tot += contact(pLevel, pPos, pPos.above(), orgV, c, cog);
                    if (down instanceof ShaftEntity cog && cog.canBeCog())
                        tot += contact(pLevel, pPos, pPos.below(), orgV, c, cog);
                }
                body.addForce(pPos, tot);
            }
            // todo, add a component to deal with the math for the parts regarding the "attached partners"
        }
        super.tick(pLevel, pPos, pState);
    }

    private double contact(Level pLevel, BlockPos curPos, BlockPos otherPos, double selfV, double c, ShaftEntity cog) {
        if (curPos.asLong() >= otherPos.asLong()) return 0;
        BlockState otherState = pLevel.getBlockState(otherPos);
        BlockState selfState = pLevel.getBlockState(curPos);
        if (otherState.hasProperty(BlockStateProperties.AXIS) && selfState.hasProperty(BlockStateProperties.AXIS)) {
            Direction.Axis otherVal = otherState.getValue(BlockStateProperties.AXIS);
            Direction.Axis selfVal = selfState.getValue(BlockStateProperties.AXIS);
            if (otherVal == selfVal) {
                double otherV = cog.componentRadius() * cog.body.getVelocity();
                double slipV = selfV + otherV;
                double contactForce = -c * slipV;
                cog.body.addForce(otherPos, contactForce);
                if (cog.body.getVelocity() == 0) cog.body.adjustAngle(body.getAngle());
                return contactForce;
            }
        }
        return 0;
    }

    public boolean canBeCog() {
        BlockState state = getBlockState();
        return state.hasProperty(Shaft.GEAR_TYPE) && state.getValue(Shaft.GEAR_TYPE) != GearType.NONE;
    }

    @Override
    public double getMoment() {
        BlockState state = getBlockState();
        if (state.hasProperty(Shaft.GEAR_TYPE)) {
            GearType gearType = state.getValue(Shaft.GEAR_TYPE);
            if (state.hasProperty(Shaft.IS_LARGE)) {
                return moment + (state.getValue(Shaft.IS_LARGE) ? gearType.getLargeMoment() : gearType.getSmallMoment());
            }
            return moment + gearType.getSmallMoment();
        }
        return moment;
    }

    @Override
    public double componentRadius() {
        BlockState state = getBlockState();
        boolean canBeCog = state.hasProperty(Shaft.GEAR_TYPE) && state.getValue(Shaft.GEAR_TYPE) != GearType.NONE;
        boolean isLarge = state.hasProperty(Shaft.IS_LARGE) && state.getValue(Shaft.IS_LARGE);
        return canBeCog ? isLarge ? 1 : 0.5 : 0.125;
    }

    public HashMap<Item, ArrayList<BlockPos>> getAttachedPartners() {
        return attachedPartners;
    }

    public void addAttachedPartner(Item item, BlockPos partner) {
        if (level != null && level.getBlockEntity(partner) instanceof ShaftEntity shaft) {
            attachedPartners.getOrDefault(item, new ArrayList<>()).add(partner);
            shaft.attachedPartners.getOrDefault(item, new ArrayList<>()).add(getBlockPos());
        }
    }
}

package net.osdilites.tekora.block.entities.transporter.rotational;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.util.UtilFunctions;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Shaft extends AbstractShaftConnectableBlock {
    public static final MapCodec<Shaft> CODEC = simpleCodec(p -> new Shaft(p, 0));

    private static final VoxelShape SHAPE_X = box(0, 6, 6, 16, 10, 10);
    private static final VoxelShape SHAPE_Y = box(6, 0, 6, 10, 16, 10);
    private static final VoxelShape SHAPE_Z = box(6, 6, 0, 10, 10, 16);

    private static final VoxelShape SHAPE_W_GEAR_X = Shapes.join(
            SHAPE_X,
            box(7, 0, 0, 9, 16, 16),
            (b1, b2) -> b1 || b2);
    private static final VoxelShape SHAPE_W_GEAR_Y = Shapes.join(
            SHAPE_Y,
            box(0, 7, 0, 16, 9, 16),
            (b1, b2) -> b1 || b2);
    private static final VoxelShape SHAPE_W_GEAR_Z = Shapes.join(
            SHAPE_Z,
            box(0, 0, 7, 16, 16, 9),
            (b1, b2) -> b1 || b2);

    public static final EnumProperty<GearType> GEAR_TYPE = TekoraBlockStates.GEAR_TYPE;
    public static final BooleanProperty IS_LARGE = TekoraBlockStates.IS_LARGE;

    private final double moment;

    private Shaft(Properties properties, double moment) {
        super(properties);
        this.moment = moment;
    }

    public Shaft(String pName, double moment) {
        this(Properties.ofFullCopy(Blocks.IRON_BARS).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, pName))), moment);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(GEAR_TYPE);
        pBuilder.add(IS_LARGE);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext).setValue(GEAR_TYPE, GearType.NONE).setValue(IS_LARGE, false);
    }

    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        Level level = params.getLevel();
        List<ItemStack> drops = super.getDrops(state, params);
        if (!level.isClientSide() && state.hasProperty(GEAR_TYPE)) {
            GearType type = state.getValue(GEAR_TYPE);
            if (type != GearType.NONE && state.hasProperty(IS_LARGE)) {
                Item item = UtilFunctions.getItemFromGearType(type);
                if (item != null) {
                    if (state.getValue(IS_LARGE)) {
                        Item part = UtilFunctions.getItemFromGearType(type);
                        if (part != null) {
                            drops.add(new ItemStack(part, 4));
                        }
                    }
                    drops.add(new ItemStack(item, 1));
                }
            }
        }
        return drops;
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pState.hasProperty(AXIS)) {
            Direction.Axis axis = pState.getValue(AXIS);
            if (pState.hasProperty(GEAR_TYPE) && pState.getValue(GEAR_TYPE) != GearType.NONE) {
                return switch (axis) {
                    case X -> SHAPE_W_GEAR_X;
                    case Y -> SHAPE_W_GEAR_Y;
                    case Z -> SHAPE_W_GEAR_Z;
                };
            }
            return switch (axis) {
                case X -> SHAPE_X;
                case Y -> SHAPE_Y;
                case Z -> SHAPE_Z;
            };
        }
        return SHAPE_Y;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @org.jspecify.annotations.Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ShaftEntity(blockPos, blockState, moment);
    }

    public double getMoment() {
        return moment;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pType) {
        return createTickerHelper(pType, TekoraBlockEntities.SHAFT.get(), (level, pos, state, block) -> block.tick(level, pos, state));
    }
}

package net.osdilites.tekora.block.entities.transporter.rotational;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.util.UtilFunctions;
import org.jetbrains.annotations.Nullable;

public class HandCrank extends AbstractTekoraAxialBlock { // todo, change the axial block thing
    public static final MapCodec<HandCrank> CODEC = simpleCodec(HandCrank::new);

    public static EnumProperty<Direction> FACING = BlockStateProperties.FACING;

    private static final VoxelShape[] COMPS_A = UtilFunctions.generateShapeForAllRotations(7, 0, 7, 9, 6, 9);
    private static final VoxelShape[] COMPS_B = UtilFunctions.generateShapeForAllRotations(7, 6, 6, 9, 8, 10);

    private static final VoxelShape SHAPE_EAST = Shapes.or(COMPS_A[0], COMPS_B[0]);
    private static final VoxelShape SHAPE_UP = Shapes.or(COMPS_A[1], COMPS_B[1]);
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(COMPS_A[2], COMPS_B[2]);
    private static final VoxelShape SHAPE_WEST = Shapes.or(COMPS_A[3], COMPS_B[3]);
    private static final VoxelShape SHAPE_DOWN = Shapes.or(COMPS_A[4], COMPS_B[4]);
    private static final VoxelShape SHAPE_NORTH = Shapes.or(COMPS_A[5], COMPS_B[5]);

    private HandCrank(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));

    }

    public HandCrank(String pName, int cat) {
        this(Properties.ofFullCopy(switch (cat) {
            case 1 -> Blocks.OAK_WOOD;
            case 2 -> Blocks.TINTED_GLASS;
            default -> Blocks.IRON_BLOCK;
        }).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, pName))));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(FACING);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext).setValue(FACING, pContext.getNearestLookingDirection().getOpposite());
    }

    @Override
    protected InteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        BlockEntity te = pLevel.getBlockEntity(pPos);
        if (te instanceof HandCrankEntity crankEnt) {
            crankEnt.addToForce(10); // todo, use math to determine this number
        }
        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pState.hasProperty(FACING)) {
            Direction direction = pState.getValue(FACING);
            return switch(direction) {
                case NORTH -> SHAPE_NORTH;
                case SOUTH -> SHAPE_SOUTH;
                case EAST -> SHAPE_EAST;
                case WEST -> SHAPE_WEST;
                case DOWN -> SHAPE_DOWN;
                default -> SHAPE_UP;
            };
        }
        return SHAPE_UP;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return getShape(state, level, pos, context);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new HandCrankEntity(pPos, pState);
    }

    @Override
    public @org.jspecify.annotations.Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type) {
        return createTickerHelper(type, TekoraBlockEntities.HAND_CRANK.get(), (lvl, pos, state, block) -> block.tick(lvl, pos, state));
    }
}

package net.osdilites.tekora.block.entities.transporter.fluid;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import org.jspecify.annotations.Nullable;

public class TekoraPipe extends BaseEntityBlock {
    protected static final IntegerProperty CONNECTION = TekoraBlockStates.CONNECTION;
    public static final MapCodec<TekoraPipe> CODEC = simpleCodec(TekoraPipe::new);

    private static final VoxelShape CENTER = Block.box(4, 4, 4, 12, 12, 12);

    private static final VoxelShape EAST = Shapes.or(
            Block.box(0, 4, 4, 8, 12, 12),
            Block.box(0, 3, 3, 2, 13, 13)
    );
    private static final VoxelShape WEST = Shapes.or(
            Block.box(8, 4, 4, 16, 12, 12),
            Block.box(14, 3, 3, 16, 13, 13)
    );
    private static final VoxelShape NORTH = Shapes.or(
            Block.box(4, 4, 0, 12, 12, 8),
            Block.box(3, 3, 0, 13, 13, 2)
    );
    private static final VoxelShape SOUTH = Shapes.or(
            Block.box(4, 4, 8, 12, 12, 16),
            Block.box(3, 3, 14, 13, 13, 16)
    );
    private static final VoxelShape ABOVE = Shapes.or(
            Block.box(4, 0, 4, 12, 8, 12),
            Block.box(3, 0, 3, 13, 2, 13)
    );
    private static final VoxelShape BELOW = Shapes.or(
            Block.box(4, 8, 4, 12, 16, 12),
            Block.box(3, 14, 3, 13, 16, 13)
    );

    private static final VoxelShape[] SHAPES = shapes();

    private static VoxelShape[] shapes() {
        VoxelShape[] shapes = new VoxelShape[64];
        for (int a = 0; a < 2; a++) {
            VoxelShape joined = a == 0 ? CENTER : EAST;
            for (int b = 0; b < 2; b++) {
                joined = b == 0 ? joined : Shapes.or(joined, WEST);
                for (int c = 0; c < 2; c++) {
                    joined = c == 0 ? joined : Shapes.or(joined, ABOVE);
                    for (int d = 0; d < 2; d++) {
                        joined = d == 0 ? joined : Shapes.or(joined, BELOW);
                        for (int e = 0; e < 2; e++) {
                            joined = e == 0 ? joined : Shapes.or(joined, NORTH);
                            for (int f = 0; f < 2; f++) {
                                joined = f == 0 ? joined : Shapes.or(joined, SOUTH);
                                int val = f + e * 2 + d * 4 + c * 8 + b * 16 + a * 32;
                                shapes[val] = joined;
                            }
                        }
                    }
                }
            }
        }
        // boolean structure
        // [isEast, isWest, isAbove, isBelow, isNorth, isSouth]
        return shapes;
    }

    private final float chemResistance;
    private final boolean isPlastic;
    private final float maxTemp; // in Minecraft temperature units

    // here's the chemical coefficients for each metal
    //Copper 0.8
    //Steel 1.5
    //Brass 0.7
    //Aluminum 1.0
    //Titanium 0.1

    private TekoraPipe(Properties properties) {
        super(properties.noOcclusion().requiresCorrectToolForDrops());
        registerDefaultState(defaultBlockState().setValue(CONNECTION, 0));
        this.chemResistance = 0.8f;
        this.isPlastic = false;
        this.maxTemp = 12.0f;
    }

    public TekoraPipe(String name, float chemResistance, boolean isPlastic, float maxTemp) {
        super(Properties.ofFullCopy(Blocks.COPPER_BLOCK.waxed().exposed()).noOcclusion().requiresCorrectToolForDrops()
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, name))));
        registerDefaultState(defaultBlockState().setValue(CONNECTION, 0));
        this.chemResistance = chemResistance;
        this.isPlastic = isPlastic;
        this.maxTemp = maxTemp;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(CONNECTION);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);
        changeState(level, state, pos);
    }

    @Override
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(state, level, pos, neighbor);
        if (level instanceof Level world) changeState(world, state, pos);
    }

    private void changeState(Level level, BlockState state, BlockPos pos) {
        BlockState newState = state;
        int orgVal = state.getValueOrElse(CONNECTION, 0);
        BlockState aboveState = level.getBlockState(pos.above());
        newState = newState.setValue(CONNECTION, aboveState.is(this) && aboveState.hasProperty(CONNECTION) ? orgVal | 0b001000 : orgVal & 0b110111);

        BlockState belowState = level.getBlockState(pos.below());
        newState = newState.setValue(CONNECTION, belowState.is(this) && belowState.hasProperty(CONNECTION) ? orgVal | 0b000100 : orgVal & 0b111011);

        BlockState northState = level.getBlockState(pos.north());
        newState = newState.setValue(CONNECTION, northState.is(this) && northState.hasProperty(CONNECTION) ? orgVal | 0b000010 : orgVal & 0b111101);

        BlockState southState = level.getBlockState(pos.south());
        newState = newState.setValue(CONNECTION, southState.is(this) && southState.hasProperty(CONNECTION) ? orgVal | 0b000001 : orgVal & 0b111110);

        BlockState eastState = level.getBlockState(pos.east());
        newState = newState.setValue(CONNECTION, eastState.is(this) && eastState.hasProperty(CONNECTION) ? orgVal | 0b100000 : orgVal & 0b011111);

        BlockState westState = level.getBlockState(pos.west());
        newState = newState.setValue(CONNECTION, westState.is(this) && westState.hasProperty(CONNECTION) ? orgVal | 0b010000 : orgVal & 0b101111);

        level.setBlock(pos, newState, 3);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(CONNECTION, 0);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (state.hasProperty(CONNECTION)) {
            return SHAPES[state.getValue(CONNECTION)];
        }
        return CENTER;
    }

    @Override
    public void destroy(LevelAccessor level, BlockPos pos, BlockState state) {
        super.destroy(level, pos, state);
        // todo, make it so that if fluid exists in the block entity, that would cause a lingering effect based on the effects of the fluid
        // todo, make it so the durability gets stored as an nbt value.
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TekoraPipeEntity(blockPos, blockState, chemResistance, isPlastic, maxTemp);
    }

    @Override
    public @org.jetbrains.annotations.Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type) {
        return createTickerHelper(type, TekoraBlockEntities.PIPE.get(), (lvl, pos, state, block) -> block.tick(lvl, pos, state));
    }
}

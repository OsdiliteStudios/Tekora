package net.osdilites.tekora.block.entities.transporter.rotational;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.util.UtilFunctions;
import org.jetbrains.annotations.Nullable;

public class HandCrank extends AbstractTekoraAxialBlock {
    public static final MapCodec<HandCrank> CODEC = simpleCodec(HandCrank::new);

    private static final VoxelShape[] COMPS_A = UtilFunctions.generateShapeForAllRotations(7, 0, 7, 9, 6, 9);
    private static final VoxelShape[] COMPS_B = UtilFunctions.generateShapeForAllRotations(7, 6, 6, 9, 8, 10);
    private static final VoxelShape[] COMPS_C = UtilFunctions.generateShapeForAllRotations(6, 5, 10, 10, 9, 15);
    private static final VoxelShape[] COMPS_D = UtilFunctions.generateShapeForAllRotations(7, 6, 15, 9, 12, 17);

    private static final VoxelShape SHAPE_X = Shapes.join(
            Shapes.join(COMPS_A[0], COMPS_B[0], (b1, b2) -> b1 || b2),
            Shapes.join(COMPS_C[0], COMPS_D[0], (b1, b2) -> b1 || b2),
            (b1, b2) -> b1 || b2);

    private static final VoxelShape SHAPE_Y = Shapes.join(
            Shapes.join(COMPS_A[1], COMPS_B[1], (b1, b2) -> b1 || b2),
            Shapes.join(COMPS_C[1], COMPS_D[1], (b1, b2) -> b1 || b2),
            (b1, b2) -> b1 || b2);

    private static final VoxelShape SHAPE_Z = Shapes.join(
            Shapes.join(COMPS_A[2], COMPS_B[2], (b1, b2) -> b1 || b2),
            Shapes.join(COMPS_C[2], COMPS_D[2], (b1, b2) -> b1 || b2),
            (b1, b2) -> b1 || b2);

    private HandCrank(Properties properties) {
        super(properties);
    }

    public HandCrank(String pName, int cat) {
        super(Properties.ofFullCopy(switch (cat) {
            case 1 -> Blocks.OAK_WOOD;
            case 2 -> Blocks.TINTED_GLASS;
            default -> Blocks.IRON_BLOCK;
        }).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, pName))));
    }

    @Override
    protected InteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (!pLevel.isClientSide()) {
            BlockEntity te = pLevel.getBlockEntity(pPos);
            if (te instanceof HandCrankEntity crankEnt) {
                crankEnt.addToForce(10); // todo, use math to determine this number
            }
        }
        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new HandCrankEntity(pPos, pState);
    }
}

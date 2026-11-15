package net.osdilites.tekora.block.entities.thermal;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import org.jspecify.annotations.Nullable;

public class CombustionChamber extends AbstractThermalMachine {
    public static final MapCodec<CombustionChamber> CODEC = simpleCodec(CombustionChamber::new);

    private CombustionChamber(Properties properties) {
        super(properties, "combustion_chamber");
    }

    public CombustionChamber() {
        this(BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CombustionChamberEntity(blockPos, blockState);
    }
    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, ItemStack toolStack, boolean willHarvest, FluidState fluid) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CombustionChamberEntity chamber) {
            chamber.drops(); // todo, if the basin contains a toxic chemical, a new fog should appear around the basin damaging the player
        }
        return super.onDestroyedByPlayer(state, level, pos, player, toolStack, willHarvest, fluid);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            BlockEntity entity = level.getBlockEntity(pos);
            if (entity instanceof CombustionChamberEntity chamber) {
                player.openMenu(new SimpleMenuProvider(chamber, chamber.getDisplayName()), pos);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide() ? null : createTickerHelper(pBlockEntityType, TekoraBlockEntities.COMBUSTION_CHAMBER.get(), (level1, pos, state, entity) ->
                entity.tick(level1, pos, state));
    }
}

package net.osdilites.tekora.block.entities.mechanical;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.item.TekoraItems;
import org.jspecify.annotations.Nullable;

public class PrinterMechanical extends AbstractModularMachine {
    public static final MapCodec<PrinterMechanical> CODEC = simpleCodec(PrinterMechanical::new);

    private PrinterMechanical(Properties properties) {
        super(properties);
    }

    @Override
    public Item getAssocItem() {
        return TekoraItems.INK_PRESS_SHAFT.get();
    }

    public PrinterMechanical() {
        this(Properties.ofFullCopy(Blocks.STONECUTTER).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, "printer"))));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PrinterMechanicalEntity(blockPos, blockState);
    }

    // Printers can hold items inside!
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        // TODO: possibly move this method to abstract modular machine class, and change instanceof check 

        // return SUCCESS here so client doesn't attempt to place blocks instead of open menu 
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity entity = level.getBlockEntity(pos);

        Block block = level.getBlockState(entity.getBlockPos().below()).getBlock();
        // so that gears can still be placed on use (no shift required)
        if (!block.equals(TekoraBlocks.DEPOT.get())) {
            return InteractionResult.PASS;
        }

        if (entity instanceof PrinterMechanicalEntity printer) {
            player.openMenu(new SimpleMenuProvider(printer, printer.getDisplayName()), pos);
        }
        
        return InteractionResult.SUCCESS;
    }

    // TODO: move this also?
    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, ItemStack toolStack, boolean willHarvest, FluidState fluid) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof PrinterMechanicalEntity printer) {
            printer.drops();
        }
        return super.onDestroyedByPlayer(state, level, pos, player, toolStack, willHarvest, fluid);
    }

    @Override
    public @org.jetbrains.annotations.Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type) {
        return createTickerHelper(type, TekoraBlockEntities.PRINTER.get(), (lvl, pos, state, block) -> block.tick(lvl, pos, state));
    }
}

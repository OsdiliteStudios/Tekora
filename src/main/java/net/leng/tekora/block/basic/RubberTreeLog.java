package net.leng.tekora.block.basic;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.leng.tekora.item.typical.WireItem;

public class RubberTreeLog extends RotatedPillarBlock {
    private static final int MAX = 4;
    public static IntegerProperty SAPPED = IntegerProperty.create("sapped", 0, MAX);
    public static BooleanProperty SAPPEABLE = BooleanProperty.create("sappeable");
    public RubberTreeLog() {
        super(Properties.ofFullCopy(Blocks.JUNGLE_LOG)); // when registering to loot table, this block drops a jungle log.
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        ItemStack stack = pPlayer.getItemInHand(pHand);
        Item item = stack.getItem();
        int count = stack.getCount();
        if (pState.hasProperty(SAPPEABLE) && pState.hasProperty(SAPPED) && pState.getValue(SAPPEABLE)) {
            if (item instanceof WireItem wire && wire.getCable() != Items.AIR) {
                ItemStack newWire = new ItemStack(wire.getCable(), count);
                Inventory inv = pPlayer.getInventory();
                inv.setItem(inv.getSlotWithRemainingSpace(stack), newWire);
                pPlayer.playSound(SoundEvents.BEEHIVE_ENTER);
                int sapped = pState.getValue(SAPPED) + 1;
                pState.setValue(SAPPEABLE, false);
                if (sapped < MAX - 1) {
                    pState.setValue(SAPPED, sapped);
                } else {
                    BlockState state = Blocks.JUNGLE_LOG.defaultBlockState().setValue(AXIS, pState.getValue(AXIS));
                    pLevel.setBlock(pPos, state, 3);
                }
            }
        } else if (item instanceof AxeItem axe) {
            pLevel.setBlock(pPos, Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState().setValue(AXIS, pState.getValue(AXIS)), 3);
            // player gets rubber
            pPlayer.playSound(SoundEvents.AXE_STRIP);
            //axe.setDamage(stack, stack.getDamageValue() + 1);
        }
        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(SAPPED, SAPPEABLE);
        super.createBlockStateDefinition(pBuilder);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        this.defaultBlockState().setValue(SAPPED, 0).setValue(SAPPEABLE, true);
        return super.getStateForPlacement(pContext);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(4) == 1 && !pState.getValue(SAPPEABLE)) {
            pState.setValue(SAPPEABLE, true);
        }
    }
}

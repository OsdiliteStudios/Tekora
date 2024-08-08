package net.tekoramods.tekora.block.entity.blocks.connecters;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.entity.entities.connectors.EnergyCableFacadeEntity;
import org.jetbrains.annotations.Nullable;

public class EnergyCableFacade extends EnergyCable {
    public EnergyCableFacade(float strength, int color, int capacity) {
        super(strength, color, capacity);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new EnergyCableFacadeEntity(pPos, pState, getCapacity());
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pLevel.getBlockEntity(pPos) instanceof EnergyCableFacadeEntity facade) {
            BlockState mimicBlock = facade.getMimicBlock();
            if (mimicBlock != null) {
                return mimicBlock.getShape(pLevel, pPos, pContext);
            }
        }
        return super.getShape(pState, pLevel, pPos, pContext);
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        ResourceLocation facadeLoc = new ResourceLocation(Tekora.MODID, pState.getBlock().getName() + "_facade");
        if (ForgeRegistries.ITEMS.containsKey(facadeLoc)) {
            Item facadeItem = ForgeRegistries.ITEMS.getValue(facadeLoc);
            if (facadeItem != null) {
                ItemStack item = new ItemStack(facadeItem);
                BlockState mimic = pBlockEntity instanceof EnergyCableFacadeEntity facade ? facade.getMimicBlock() : Blocks.COBBLESTONE.defaultBlockState();
                CompoundTag tag = item.getOrCreateTag();
                CompoundTag nbt = NbtUtils.writeBlockState(mimic);
                tag.put("mimic", nbt);
                item.setTag(tag);
                popResource(pLevel, pPos, item);
            }
        }
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        BlockState defaultState = state.getBlock().defaultBlockState();
        BlockState newState = calculateState(level, pos, defaultState);
        return level.setBlock(pos, newState, level.isClientSide() ? Block.UPDATE_ALL + Block.UPDATE_IMMEDIATE : Block.UPDATE_ALL);
    }
}

package net.nukollodda.tekora.item.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.nukollodda.tekora.block.entity.blocks.connecters.AbstractConnector;

public class WrenchItem extends Item {
    private final boolean advanced;
    public WrenchItem(boolean pAdvanced) {
        super(new Properties().durability(pAdvanced ? 2000 : 1000));
        this.advanced = pAdvanced;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if (player != null) {
            Level level = pContext.getLevel();
            ItemStack item = pContext.getItemInHand();
            Direction direction = player.getDirection();
            BlockPos pos = pContext.getClickedPos();
            BlockState state = level.getBlockState(pos);
            BlockEntity entity = level.getBlockEntity(pos);
            if (state.getBlock() instanceof AbstractConnector connector) {
                connector.changeBlockState(state, direction);
                if (!this.advanced) this.setDamage(item, item.getDamageValue() + 1);
            } else if (this.advanced && entity != null &&
                    (entity.getCapability(ForgeCapabilities.ENERGY).isPresent() ||
                            entity.getCapability(ForgeCapabilities.FLUID_HANDLER).isPresent())) {
                player.sendSystemMessage(state.getBlock().getName());
            }
        }
        return super.useOn(pContext);
    }
}

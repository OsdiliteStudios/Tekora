package net.osdilites.tekora.item.uiitems;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class ManuscriptItem extends Item {
    public ManuscriptItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        // todo, makes a gui pop out out of the corresponding ids.
        return super.use(level, player, hand);
    }
}

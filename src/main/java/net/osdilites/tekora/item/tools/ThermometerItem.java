package net.osdilites.tekora.item.tools;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.osdilites.tekora.TekoraConfig;
import net.osdilites.tekora.block.entities.IHeatSensitive;
import net.osdilites.tekora.item.typical.TekoraItem;
import net.osdilites.tekora.util.UtilFunctions;

public class ThermometerItem extends TekoraItem {
    public ThermometerItem() {
        super("thermometer");
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player == null) return InteractionResult.PASS;

        BlockEntity ent = context.getLevel().getBlockEntity(context.getClickedPos());
        if (ent instanceof IHeatSensitive sensitive) {
            double mcTemp = UtilFunctions.fromKelvinsToMcTemp(sensitive.getTemperature()); // used for color-coding
            TextColor color;
            if (mcTemp < 0.0) {
                color = TextColor.DARK_BLUE;
            } else if (mcTemp < 0.4) {
                color = TextColor.BLUE;
            } else if (mcTemp < 0.6) {
                color = TextColor.AQUA;
            } else if (mcTemp < 1.0) {
                color = TextColor.GREEN;
            } else if (mcTemp < 1.6) {
                color = TextColor.GOLD;
            } else {
                color = TextColor.RED;
            }
            Component temperature = (switch (TekoraConfig.UNIT.get()) {
                case "C" -> Component.literal(String.format("%.1f°C", UtilFunctions.fromMcTempToCelsius(mcTemp)));
                case "F" -> Component.literal(String.format("%.1f°F", UtilFunctions.fromMcTempToFahrenheit(mcTemp)));
                case "M" -> Component.literal(String.format("%.2f", mcTemp));
                default -> Component.literal(String.format("%.1fK", sensitive.getTemperature()));
            }).withColor(color);
            player.sendOverlayMessage(Component.translatable("tekora.tooltip.temperature").append(temperature));
        }
        return super.useOn(context);
    }
}

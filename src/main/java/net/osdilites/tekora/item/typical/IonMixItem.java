package net.osdilites.tekora.item.typical;

import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import net.osdilites.tekora.data.Solutes;
import net.osdilites.tekora.data.TekoraComponents;

import java.util.Optional;

public class IonMixItem extends TekoraItem {
    public IonMixItem() {
        super("salt_mixture");
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack itemStack) {
        if (itemStack.getComponents().has(TekoraComponents.SOLUTES_LIST)) {
            Solutes solutes = itemStack.getComponents().get(TekoraComponents.SOLUTES_LIST);
            TooltipComponent component;
        }
        return super.getTooltipImage(itemStack);
    }
}

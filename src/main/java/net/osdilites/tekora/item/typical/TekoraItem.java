package net.osdilites.tekora.item.typical;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.osdilites.tekora.Tekora;

public class TekoraItem extends Item {
    public TekoraItem(String pName) {
        super(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Tekora.MODID, pName))));
    }

    public TekoraItem(boolean fireRes, String pName) {
        super((fireRes ? new Item.Properties().fireResistant() : new Item.Properties()).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Tekora.MODID, pName))));
    }
}

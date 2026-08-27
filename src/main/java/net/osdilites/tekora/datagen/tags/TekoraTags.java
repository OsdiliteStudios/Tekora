package net.osdilites.tekora.datagen.tags;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TekoraTags {
    public static class Items {
        public static final TagKey<Item> INGOTS_STEEL = tag("ingots/steel");
        public static final TagKey<Item> PLATES_STEEL = tag("plates/steel");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath("c", name));
        }
    }
    public static class Blocks {}
}

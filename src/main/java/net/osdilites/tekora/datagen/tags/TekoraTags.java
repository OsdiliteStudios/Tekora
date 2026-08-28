package net.osdilites.tekora.datagen.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.osdilites.tekora.Tekora;

public class TekoraTags {
    public static class Items {
        public static final TagKey<Item> INGOTS_STEEL = tag("ingots/steel");
        public static final TagKey<Item> PLATES_STEEL = tag("plates/steel");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath("c", name));
        }
    }
    public static class Blocks {}
    public static class Entities {
        public static final TagKey<EntityType<?>> OXYGEN_LETHAL = tekoraTag("poisonedby/oxygen"); // this is for Tekora Space

        public static final TagKey<EntityType<?>> SO2_LETHAL = tekoraTag("poisonedby/so2");

        private static TagKey<EntityType<?>> tekoraTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Tekora.MODID, name));
        }
    }
}

package net.osdilites.tekora.datagen.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.fluid.ChemicalFluidType;

public class TekoraTags {
    public static class Items {
        public static final TagKey<Item> INGOTS_STEEL = tag("ingots/steel");
        public static final TagKey<Item> PLATES_STEEL = tag("plates/steel");
        public static final TagKey<Item> RODS_STEEL = tag("rods/steel");
        public static final TagKey<Item> FUMES_ON_SMELT = tag("fumes_on_smelt");
        public static final TagKey<Item> SALT = tag("salt");

        public static final TagKey<Item> BLINDING_FUMES_ON_SMELT = tekoraTag("blinding_fumes_on_smelt");
        public static final TagKey<Item> TOXIC_FUMES_ON_SMELT = tekoraTag("toxic_fumes_on_smelt");
        public static final TagKey<Item> WEAKENING_FUMES_ON_SMELT = tekoraTag("weakening_fumes_on_smelt");
        public static final TagKey<Item> RADIOACTIVE_FUMES_ON_SMELT = tekoraTag("radioactive_fumes_on_smelt");
        public static final TagKey<Item> CHEMICAL_SALT = tekoraTag("salt");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath("c", name));
        }

        private static TagKey<Item> tekoraTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(Tekora.MODID, name));
        }
    }
    public static class Blocks {}
    public static class Entities {
        public static final TagKey<EntityType<?>> OXYGEN_LETHAL = tekoraTag("harmedby/oxygen"); // this is for Tekora Space

        public static final TagKey<EntityType<?>> SO2_LETHAL = tekoraTag("harmedby/sulfur_dioxide");
        public static final TagKey<EntityType<?>> SULFURIC_ACID_LETHAL = tekoraTag("harmedby/sulfuric_acid");

        public static final TagKey<EntityType<?>> OXYGEN_HEALS = tekoraTag("poweredby/oxygen");

        private static TagKey<EntityType<?>> tekoraTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Tekora.MODID, name));
        }

        public static boolean getsHarmed(ChemicalFluidType type, LivingEntity entity) {
            Identifier loc = NeoForgeRegistries.FLUID_TYPES.getKey(type);
            if (loc != null) {
                String path = loc.getPath();
                int end = path.contains("/") ? path.lastIndexOf('/') + 1 : 0;
                return entity.is(tekoraTag("harmedby/" + path.substring(end)));
            }
            return false;
        }

        public static boolean getsPowered(ChemicalFluidType type, LivingEntity entity) {
            Identifier loc = NeoForgeRegistries.FLUID_TYPES.getKey(type);
            if (loc != null) {
                String path = loc.getPath();
                int end = path.contains("/") ? path.lastIndexOf('/') + 1 : 0;
                return entity.is(tekoraTag("poweredby/" + path.substring(end)));
            }
            return false;
        }
    }
}

package net.nukollodda.tekora.tiers;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.nukollodda.tekora.item.TekoraItems;

import java.util.function.Supplier;

public enum TekoraArmors implements ArmorMaterial {
    BORON("boron", 45, new int[]{4, 8, 10, 4}, 10, SoundEvents.ARMOR_EQUIP_GENERIC,
            5, 0.1f, () -> Ingredient.of(TekoraItems.BORON_PIECE.get())),
    PLATINUM("platinum", 33, new int[]{2, 4, 6, 2}, 20, SoundEvents.ARMOR_EQUIP_GOLD,
            2, 0, () -> Ingredient.of(TekoraItems.PLATINUM_INGOT.get())),
    SILVER("silver", 4, new int[]{1, 2, 3, 1}, 13, SoundEvents.ARMOR_EQUIP_GOLD,
            0, 0, () -> Ingredient.of(TekoraItems.SILVER_INGOT.get())),
    TITANIUM("titanium", 41, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_NETHERITE,
            4, 0.1f, () -> Ingredient.of(TekoraItems.TITANIUM_INGOT.get())),
    BRONZE("bronze", 13, new int[]{2, 4, 6, 2}, 12, SoundEvents.ARMOR_EQUIP_IRON,
            1, 0, () -> Ingredient.of(TekoraItems.BRONZE_INGOT.get())),
    STEEL("steel", 15, new int[]{2, 4, 6, 2}, 8, SoundEvents.ARMOR_EQUIP_IRON,
            1, 0, () -> Ingredient.of(TekoraItems.STEEL_INGOT.get())),
    TUNGSTEN_STEEL("tungsten_steel", 37, new int[]{3, 6, 8, 3}, 8, SoundEvents.ARMOR_EQUIP_NETHERITE,
            3, 0.3f, () -> Ingredient.of(TekoraItems.TUNGSTEN_STEEL_INGOT.get())),
    VANASTEEL("vanasteel", 39, new int[]{4, 8, 10, 4}, 10, SoundEvents.ARMOR_EQUIP_IRON,
            3, 0.1f, () -> Ingredient.of(TekoraItems.VANASTEEL_INGOT.get())),
    HAZMAT("hazmat", 15, new int[]{2, 4, 6, 2}, 10, SoundEvents.ARMOR_EQUIP_LEATHER,
            4, 0.2f, () -> Ingredient.EMPTY),
    SCUBA("scuba", 20, new int[]{2, 4, 6, 2}, 10, SoundEvents.ARMOR_EQUIP_IRON,
            5, 0, () -> Ingredient.EMPTY);

    private static final int[] ARMOR_VALS = {13, 15, 16, 11};

    private final String name;
    private final int[] slotProtection;
    private final int durabilityFactor, enchantmentValue;
    private final SoundEvent sounds;
    private final float toughness, knockbackRes;
    private final Ingredient repairItem;

    private TekoraArmors(String name, int durabilityFactor, int[] slotProtect, int enchantVal, SoundEvent sound, float tough, float knockRes, Supplier<Ingredient> repair) {
        this.name = name;
        this.durabilityFactor = durabilityFactor;
        this.slotProtection = slotProtect;
        this.enchantmentValue = enchantVal;
        this.sounds = sound;
        this.toughness = tough;
        this.knockbackRes = knockRes;
        this.repairItem = repair.get();
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return ARMOR_VALS[pType.ordinal()] * durabilityFactor;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.slotProtection[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sounds;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairItem;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackRes;
    }
}

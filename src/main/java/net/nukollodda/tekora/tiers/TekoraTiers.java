package net.nukollodda.tekora.tiers;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.nukollodda.tekora.datagen.tags.TekoraTags;
import net.nukollodda.tekora.item.TekoraItems;

import java.util.function.Supplier;

public enum TekoraTiers implements Tier {
    // ingredient will be set to tags some day, just not now
    BORON(6, 3069, 14.5f, 6.5f, 10,
            () -> Ingredient.of(TekoraItems.BORON_PIECE.get())),
    PLATINUM(3, 560, 12.0f, 2.0f, 20,
            () -> Ingredient.of(TekoraTags.Items.PLATINUM_INGOT)),
    SILVER(0, 250, 12.0f, 1.0f, 13,
            () -> Ingredient.of(TekoraTags.Items.SILVER_INGOT)),
    TITANIUM(5, 2890, 6.0f, 5.0f, 10,
            () -> Ingredient.of(TekoraTags.Items.TITANIUM_INGOT)),
    THORIUM(3, 1010, 5.75f, 6.0f, 8,
            () -> Ingredient.of(TekoraTags.Items.THORIUM_INGOT)),
    BRONZE(2, 200, 6.75f, 2.5f, 12,
            () -> Ingredient.of(TekoraTags.Items.BRONZE_INGOT)),
    STEEL(2, 420, 6.5f, 2.5f, 8,
            () -> Ingredient.of(TekoraTags.Items.STEEL_INGOT)),
    TUNGSTEN_STEEL(4, 3012, 4.5f, 5.325f, 8,
            () -> Ingredient.of(TekoraTags.Items.TUNGSTEN_STEEL_INGOT)),
    VANASTEEL(6, 2760, 5.0f, 5.125f, 10,
            () -> Ingredient.of(TekoraTags.Items.VANASTEEL_INGOT)),
    STEAM(4, 2000, 5.0f, 5f, 10, () -> Ingredient.EMPTY),
    ELECTRIC(5, 4500, 6.5f, 6f, 10, () -> Ingredient.EMPTY),
    LASER(6, 6000, 7.25f, 7f, 10, () -> Ingredient.EMPTY),
    QUANTUM(8, 8000, 9f, 8f, 10, () -> Ingredient.EMPTY);

    /*
    tool ranges
    atk mod:
    axe - 5.0f-7.0f (the higher the val, the lower the tier)
    hoe - -tool tier level

    speed mod:
    axe - 3.0f-3.2f (the higher the val, the lower the tier)
     */

    private final int level, uses, enchantmentvalue;
    private final float speed, damage;
    private final Ingredient repairIngredient;

    TekoraTiers(int lvl, int dura, float speed, float dmg, int enchantval, Supplier<Ingredient> ingredient) {
        this.level = lvl;
        this.uses = dura;
        this.speed = speed;
        this.damage = dmg;
        this.enchantmentvalue = enchantval;
        this.repairIngredient = ingredient.get();
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentvalue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}

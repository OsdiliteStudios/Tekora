package net.nukollodda.tekora.tiers;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.nukollodda.tekora.item.TekoraItems;

import java.util.function.Supplier;

public enum TekoraTiers implements Tier {
    // ingredient will be set to tags some day, just not now
    BORON(6, 3069, 14.5f, 6.5f, 10,
            () -> Ingredient.of(TekoraItems.BORON_PIECE.get())),
    PLATINUM(3, 560, 12.0f, 2.0f, 20,
            () -> Ingredient.of(TekoraItems.PLATINUM_INGOT.get())),
    SILVER(0, 250, 12.0f, 1.0f, 13,
            () -> Ingredient.of(TekoraItems.SILVER_INGOT.get())),
    TITANIUM(5, 2890, 6.0f, 5.0f, 10,
            () -> Ingredient.of(TekoraItems.TITANIUM_INGOT.get())),
    THORIUM(3, 1010, 5.75f, 6.0f, 8,
            () -> Ingredient.of(TekoraItems.THORIUM_INGOT.get())),
    BRONZE(2, 200, 6.75f, 2.5f, 12,
            () -> Ingredient.of(TekoraItems.BRONZE_INGOT.get())),
    STEEL(2, 420, 6.5f, 2.5f, 8,
            () -> Ingredient.of(TekoraItems.STEEL_INGOT.get())),
    TUNGSTEN_STEEL(4, 3012, 4.5f, 5.325f, 8,
            () -> Ingredient.of(TekoraItems.TUNGSTEN_STEEL_INGOT.get())),
    VANASTEEL(6, 2760, 5.0f, 5.125f, 10,
            () -> Ingredient.of(TekoraItems.VANASTEEL_INGOT.get()));

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

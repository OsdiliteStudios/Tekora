package net.osdilites.tekora.item.typical;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;
import net.osdilites.tekora.Tekora;
import org.jspecify.annotations.Nullable;

public class TekoraSmeltableItem extends Item {
    private final int burnTime;
    public TekoraSmeltableItem(String pName, int burnTime) {
        super(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Tekora.MODID, pName))));
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues) {
        return burnTime;
    }
}

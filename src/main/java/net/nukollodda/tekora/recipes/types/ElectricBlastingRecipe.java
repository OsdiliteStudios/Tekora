package net.nukollodda.tekora.recipes.types;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.nukollodda.tekora.Tekora;
import org.jetbrains.annotations.Nullable;

public class ElectricBlastingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public ElectricBlastingRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }
        return recipeItems.get(0).test(pContainer.getItem(0));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ElectricBlastingRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return ElectricBlastingRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<ElectricBlastingRecipe> {
        public static final ElectricBlastingRecipe.Type INSTANCE = new ElectricBlastingRecipe.Type();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "blasting");

    }

    public static class Serializer implements RecipeSerializer<ElectricBlastingRecipe> {
        public static final ElectricBlastingRecipe.Serializer INSTANCE = new ElectricBlastingRecipe.Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "blasting");

        @Override
        public ElectricBlastingRecipe fromJson(ResourceLocation pId, JsonObject pJson) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pJson, "ingredients"); // make the input number matter
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new ElectricBlastingRecipe(pId, output, inputs);
        }

        @Override
        public @Nullable ElectricBlastingRecipe fromNetwork(ResourceLocation pId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }
            ItemStack output = pBuffer.readItem();
            return new ElectricBlastingRecipe(pId, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, ElectricBlastingRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.getIngredients().size());

            for (Ingredient ing : pRecipe.getIngredients()) {
                ing.toNetwork(pBuffer);
            }
        }
    }
}

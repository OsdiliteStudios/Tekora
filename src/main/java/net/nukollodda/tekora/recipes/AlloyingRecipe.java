package net.nukollodda.tekora.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
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

public class AlloyingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;
    public AlloyingRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }
    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }
        boolean hasIng1 = false, hasIng2 = false, hasIng3 = false;
        int nullCounter = 0;
        Ingredient item;
        for (int i = 0; i < 3; i++) {
            item = recipeItems.get(i);
            if (!hasIng1) hasIng1 = item.test(pContainer.getItem(1));
            if (!hasIng2) hasIng2 = item.test(pContainer.getItem(2));
            if (!hasIng3) hasIng3 = item.test(pContainer.getItem(3));
            if (pContainer.getItem(i+1).isEmpty()) nullCounter++;
        } // note: there is a null recipe bug here
        return hasIng1 && hasIng2 && hasIng3 && nullCounter < 2;
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
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<AlloyingRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "alloying";
    }

    public static class Serializer implements RecipeSerializer<AlloyingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "alloying");

        @Override
        public AlloyingRecipe fromJson(ResourceLocation pId, JsonObject pJson) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pJson, "ingredients"); // make the input number matter
            NonNullList<Ingredient> inputs = NonNullList.withSize(3, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                if (i < ingredients.size()) inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            return new AlloyingRecipe(pId, output, inputs);
        }

        @Override
        public @Nullable AlloyingRecipe fromNetwork(ResourceLocation pId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            ItemStack output = pBuffer.readItem();
            return new AlloyingRecipe(pId, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, AlloyingRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.getIngredients().size());

            for (Ingredient ing : pRecipe.getIngredients()) {
                ing.toNetwork(pBuffer);
            }
        }
    }
}

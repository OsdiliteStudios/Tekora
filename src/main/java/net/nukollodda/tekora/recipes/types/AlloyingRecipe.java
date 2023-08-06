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

public class AlloyingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<ItemStack> recipeItems;
    public AlloyingRecipe(ResourceLocation id, ItemStack output, NonNullList<ItemStack> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }
    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }
        boolean hasIng = true;
        int ingNum = 0;
        int nullCounter = 0;
        ItemStack prevItem;
        ItemStack curItem;
        ItemStack postItem;

        for (ItemStack recItem : recipeItems) {
            for (int i = 1; i < 4; i++) {
                curItem = pContainer.getItem(i);
                prevItem = pContainer.getItem(i-1 >= 1 ? i-1 : 3+i);
                postItem = pContainer.getItem(i+1 < 4 ? i+1 : 1);
                if (curItem.isEmpty()) nullCounter++;
                if (recItem.equals(curItem)) {
                    ingNum = curItem.getCount() + (curItem.equals(prevItem) ? prevItem.getCount() : 0) +
                            (curItem.equals(postItem) ? postItem.getCount() : 0);
                }
            }
            hasIng = hasIng && ingNum >= recItem.getCount();
            ingNum = 0;
        }
        return hasIng && nullCounter < 2;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.withSize(recipeItems.size(), Ingredient.EMPTY);
        for (int i = 0; i < recipeItems.size(); i++) {
            ingredients.set(i, Ingredient.of(recipeItems.get(i)));
        }
        return ingredients;
    }

    public NonNullList<ItemStack> getInputs() {
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
            NonNullList<ItemStack> inputs = NonNullList.withSize(3, ItemStack.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                if (i < ingredients.size()) inputs.set(i, Ingredient.fromJson(ingredients.get(i)).getItems()[0]);
            }
            return new AlloyingRecipe(pId, output, inputs);
        }

        @Override
        public @Nullable AlloyingRecipe fromNetwork(ResourceLocation pId, FriendlyByteBuf pBuffer) {
            NonNullList<ItemStack> inputs = NonNullList.withSize(pBuffer.readInt(), ItemStack.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer).getItems()[0]);
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

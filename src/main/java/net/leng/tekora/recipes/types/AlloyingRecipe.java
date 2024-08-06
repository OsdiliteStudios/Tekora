package net.leng.tekora.recipes.types;

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
import net.leng.tekora.Tekora;
import org.jetbrains.annotations.Nullable;

public class AlloyingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;
    private final NonNullList<Integer> recipeRatio;
    public AlloyingRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems, NonNullList<Integer> recipeRatio) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.recipeRatio = recipeRatio;
    }
    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }
        boolean hasIng = recipeItems.size() > 0;
        int ingNum;
        ItemStack curItem;
        Ingredient ing;
        boolean[] skipped = new boolean[pContainer.getContainerSize() - 1];
        for (int i = 0; i < recipeItems.size(); i++) {
            if (!hasIng) break;
            ing = recipeItems.get(i);
            ingNum = 0;
            for (int j = 1; j < pContainer.getContainerSize()-1; j++) {
                curItem = pContainer.getItem(j);
                if (skipped[j]) continue;
                if (curItem.isEmpty()) {
                    continue;
                }
                if (isInvalidItem(curItem)) {
                    hasIng = false;
                    break;
                }
                if (ing.test(curItem)) {
                    ingNum += curItem.getCount();
                    skipped[j] = true;
                }
            }
            hasIng = ingNum >= recipeRatio.get(i) && hasIng;
        }
        return hasIng;
    }

    protected boolean isInvalidItem(ItemStack pItem) {
        boolean isCor = false;
        for (Ingredient ing : recipeItems) {
            isCor = ing.test(pItem);
            if (isCor) break;
        }
        return !isCor;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    public int[] getRecipeRatio() {
        int[] ratio = new int[recipeRatio.size()];
        for (int i = 0; i < ratio.length; i++) {
            ratio[i] = recipeRatio.get(i);
        }
        return ratio;
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
                new ResourceLocation(Tekora.MODID, Type.ID);

        @Override
        public AlloyingRecipe fromJson(ResourceLocation pId, JsonObject pJson) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pJson, "ingredients"); // make the input number matter
            JsonObject ing;
            int arraySize = Math.min(ingredients.size(), 3);
            NonNullList<Ingredient> inputs = NonNullList.withSize(arraySize, Ingredient.EMPTY);
            NonNullList<Integer> inputRat = NonNullList.withSize(arraySize, 0);

            for (int i = 0; i < inputs.size(); i++) {
                if (i < ingredients.size()) {
                    ing = ingredients.get(i).getAsJsonObject();
                    inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
                    inputRat.set(i, ing.has("count") ? ing.get("count").getAsInt() : 1);
                }
            }
            return new AlloyingRecipe(pId, output, inputs, inputRat);
        }

        @Override
        public @Nullable AlloyingRecipe fromNetwork(ResourceLocation pId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
            NonNullList<Integer> inputRat = NonNullList.withSize(pBuffer.readInt(), 0);
            Ingredient ing;
            for (int i = 0; i < inputs.size(); i++) {
                ing = Ingredient.fromNetwork(pBuffer);
                inputs.set(i, ing);
                inputRat.set(i, ing.getItems().length > 0 && ing.getItems()[0].getCount() > 0 ? ing.getItems()[0].getCount() : 1);
            }
            return new AlloyingRecipe(pId, pBuffer.readItem(), inputs, inputRat);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, AlloyingRecipe pRecipe) {
            NonNullList<Ingredient> ings = pRecipe.getIngredients();
            pBuffer.writeInt(ings.size());
            Ingredient ing;

            for (int i = 0; i < ings.size(); i++) {
                ing = ings.get(i);
                ing.toNetwork(pBuffer);
                pBuffer.writeInt(pRecipe.recipeRatio.get(i));
            }
            pBuffer.writeItem(pRecipe.output);
        }
    }
}

package net.nukollodda.tekora.recipes;

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

public class CrushingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;
    
    public CrushingRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
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
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }
    
    public static class Type implements RecipeType<CrushingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "crushing");
        
    }
    
    public static class Serializer implements RecipeSerializer<CrushingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "crushing");

        @Override
        public CrushingRecipe fromJson(ResourceLocation pId, JsonObject pJson) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "output"));
            /*
            ItemStack catalyst = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "catalyst"));
            ItemStack ingredient = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "ingredient"));

            should replace the inputs section
             */

            JsonArray ingredients = GsonHelper.getAsJsonArray(pJson, "ingredients"); // make the input number matter
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            return new CrushingRecipe(pId, output, inputs);
        }

        @Override
        public @Nullable CrushingRecipe fromNetwork(ResourceLocation pId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            ItemStack output = pBuffer.readItem();
            return new CrushingRecipe(pId, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, CrushingRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.getIngredients().size());

            for (Ingredient ing : pRecipe.getIngredients()) {
                ing.toNetwork(pBuffer);
            }
        }
    }
}

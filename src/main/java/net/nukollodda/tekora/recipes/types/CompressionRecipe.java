package net.nukollodda.tekora.recipes.types;

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

public class CompressionRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient recipeItem;
    
    public CompressionRecipe(ResourceLocation id, ItemStack output, Ingredient recipeItem) {
        this.id = id;
        this.output = output;
        this.recipeItem = recipeItem;
    }
    
    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }
        return recipeItem.test(pContainer.getItem(0));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(this.recipeItem);
    }

    public Ingredient getRecipeItem() {
        return recipeItem;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return this.output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pAccess) {
        return this.output;
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
    
    public static class Type implements RecipeType<CompressionRecipe> {
        public static final Type INSTANCE = new Type();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "compression");
        
    }
    
    public static class Serializer implements RecipeSerializer<CompressionRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "compression");

        @Override
        public CompressionRecipe fromJson(ResourceLocation pId, JsonObject pJson) {
            JsonObject outObj = GsonHelper.getAsJsonObject(pJson, "output");
            ItemStack output = ShapedRecipe.itemStackFromJson(outObj);
            JsonObject ingredients = GsonHelper.getAsJsonObject(pJson, "ingredient");
            return new CompressionRecipe(pId, output, Ingredient.fromJson(ingredients));
        }

        @Override
        public @Nullable CompressionRecipe fromNetwork(ResourceLocation pId, FriendlyByteBuf pBuffer) {
            Ingredient input = Ingredient.fromNetwork(pBuffer);
            ItemStack output = pBuffer.readItem();
            return new CompressionRecipe(pId, output, input);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, CompressionRecipe pRecipe) {
            pRecipe.recipeItem.toNetwork(pBuffer);
        }
    }
}

package net.tekoramods.tekora.recipes.types;

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
import net.tekoramods.tekora.Tekora;
import org.jetbrains.annotations.Nullable;

public class ExtrusionRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient recipeItem;

    public ExtrusionRecipe(ResourceLocation id, ItemStack output, Ingredient recipeItem) {
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
        return this.output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return this.output.copy();
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

    public static class Type implements RecipeType<ExtrusionRecipe> {
        public static final ExtrusionRecipe.Type INSTANCE = new ExtrusionRecipe.Type();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "extrusion");

    }

    public static class Serializer implements RecipeSerializer<ExtrusionRecipe> {
        public static final ExtrusionRecipe.Serializer INSTANCE = new ExtrusionRecipe.Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "extrusion");
        @Override
        public ExtrusionRecipe fromJson(ResourceLocation pId, JsonObject pJson) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "output"));
            JsonObject ingredient = GsonHelper.getAsJsonObject(pJson, "ingredient");
            return new ExtrusionRecipe(pId, output, Ingredient.fromJson(ingredient));
        }

        @Override
        public @Nullable ExtrusionRecipe fromNetwork(ResourceLocation pId, FriendlyByteBuf pBuffer) {
            Ingredient input = Ingredient.fromNetwork(pBuffer);
            ItemStack output = pBuffer.readItem();
            return new ExtrusionRecipe(pId, output, input);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, ExtrusionRecipe pRecipe) {
            pRecipe.recipeItem.toNetwork(pBuffer);
            pBuffer.writeItem(pRecipe.output);
        }
    }
}

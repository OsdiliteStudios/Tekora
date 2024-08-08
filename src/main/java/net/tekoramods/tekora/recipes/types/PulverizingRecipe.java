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

public class PulverizingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final float extraOutputChance;
    private final ItemStack residue;
    private final float extraResidueChance;
    private final Ingredient recipeItem;

    public PulverizingRecipe(ResourceLocation id, ItemStack output, float extraOutputChance, Ingredient recipeItem, ItemStack residue,
                             float extraResidueChance) {
        this.id = id;
        this.output = output;
        this.extraOutputChance = extraOutputChance;
        this.recipeItem = recipeItem;
        this.residue = residue;
        this.extraResidueChance = extraResidueChance;
    }
    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }
        return recipeItem.test(pContainer.getItem(0));
    }

    public float getExtraOutputChance() {
        return extraOutputChance;
    }

    public float getExtraResidueChance() {
        return extraResidueChance;
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

    public ItemStack getResidue() {
        return this.residue.copy();
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

    public static class Type implements RecipeType<PulverizingRecipe> {
        public static final PulverizingRecipe.Type INSTANCE = new PulverizingRecipe.Type();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "pulverization");

    }

    public static class Serializer implements RecipeSerializer<PulverizingRecipe> {
        public static final PulverizingRecipe.Serializer INSTANCE = new PulverizingRecipe.Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "pulverization");
        @Override
        public PulverizingRecipe fromJson(ResourceLocation pId, JsonObject pJson) {
            JsonObject outObj = GsonHelper.getAsJsonObject(pJson, "output");
            ItemStack output = ShapedRecipe.itemStackFromJson(outObj);
            float outChance = outObj.has("chance") ? outObj.get("chance").getAsFloat() : 1f;

            ItemStack residue = ItemStack.EMPTY;
            float resChance = 0;

            if (pJson.has("residue")) {
                JsonObject resObj = GsonHelper.getAsJsonObject(pJson, "residue");
                residue = ShapedRecipe.itemStackFromJson(resObj);
                resChance = resObj.has("chance") ? resObj.get("chance").getAsFloat() : 0.25f;
            }

            return new PulverizingRecipe(pId, output, outChance,
                    Ingredient.fromJson(GsonHelper.getAsJsonObject(pJson, "ingredient")), residue, resChance);
        }

        @Override
        public @Nullable PulverizingRecipe fromNetwork(ResourceLocation pId, FriendlyByteBuf pBuffer) {
            Ingredient input = Ingredient.fromNetwork(pBuffer);
            ItemStack output = pBuffer.readItem();
            ItemStack residue = pBuffer.readItem();
            float outputCnt = pBuffer.readFloat();
            float residueCnt = pBuffer.readFloat();
            return new PulverizingRecipe(pId, output, outputCnt, input, residue, residueCnt);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, PulverizingRecipe pRecipe) {
            pRecipe.recipeItem.toNetwork(pBuffer);
            pBuffer.writeItem(pRecipe.output);
            pBuffer.writeItem(pRecipe.residue);
            pBuffer.writeFloat(pRecipe.extraOutputChance);
            pBuffer.writeFloat(pRecipe.extraResidueChance);
        }
    }
}

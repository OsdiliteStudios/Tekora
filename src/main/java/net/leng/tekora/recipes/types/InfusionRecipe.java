package net.leng.tekora.recipes.types;

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

public class InfusionRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient input;
    private final Ingredient catalyst;
    private final int inputAmount;
    private final int catalystAmount;
    public InfusionRecipe(ResourceLocation id, ItemStack output, Ingredient input, Ingredient catalyst, int inputAmt, int catalystAmt) {
        this.id = id;
        this.output = output;
        this.input = input;
        this.catalyst = catalyst;
        this.inputAmount = inputAmt;
        this.catalystAmount = catalystAmt;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        ItemStack in = pContainer.getItem(1);
        ItemStack cat = pContainer.getItem(2);

        return input.test(in) && inputAmount <= in.getCount()
                && catalyst.test(cat) && catalystAmount <= cat.getCount(); // brain of the recipe
    }

    public Ingredient getCatalyst() {
        return catalyst;
    }

    public Ingredient getInput() {
        return input;
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public int getCatalystAmount() {
        return catalystAmount;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(input, catalyst);
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

    public static class Type implements RecipeType<InfusionRecipe> {
        public Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "infusion";
    }

    public static class Serializer implements RecipeSerializer<InfusionRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, Type.ID);

        @Override
        public InfusionRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
            JsonObject jsonInput = GsonHelper.getAsJsonObject(pJson, "input");
            JsonObject jsonCatalyst = GsonHelper.getAsJsonObject(pJson, "catalyst");

            int inAmt = jsonInput.has("count") ? jsonInput.get("count").getAsInt() : 1;
            int catAmt = jsonCatalyst.has("count") ? jsonCatalyst.get("count").getAsInt() : 1;
            Ingredient input = Ingredient.fromJson(jsonInput);
            Ingredient catalyst = Ingredient.fromJson(jsonCatalyst);
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "output"));
            return new InfusionRecipe(pRecipeId, output, input, catalyst, inAmt, catAmt);
        }

        @Override
        public @Nullable InfusionRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            Ingredient input = Ingredient.fromNetwork(pBuffer);
            Ingredient catalyst = Ingredient.fromNetwork(pBuffer);
            int inAmt = pBuffer.readInt();
            int catAmt = pBuffer.readInt();
            ItemStack output = pBuffer.readItem();
            return new InfusionRecipe(pRecipeId, output, input, catalyst, inAmt, catAmt);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, InfusionRecipe pRecipe) {
            pRecipe.getInput().toNetwork(pBuffer);
            pRecipe.getCatalyst().toNetwork(pBuffer);
            pBuffer.writeInt(pRecipe.inputAmount);
            pBuffer.writeInt(pRecipe.catalystAmount);
            pBuffer.writeItem(pRecipe.output);
        }
    }
}

package net.tekoramods.tekora.recipes.types;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.util.FluidFunctions;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CentrifugeRecipe implements Recipe<ItemFluidContainer> {
    private final ResourceLocation id;
    private ItemStack lightest;
    private ItemStack midLight;
    private ItemStack midHeavy;
    private ItemStack heaviest;
    private final NonNullList<Float> outputProbabilities;
    private final NonNullList<FluidStack> fluidOutputs;
    private final FluidStack recipeFluid;
    private final Ingredient recipeItem;
    private final int inputCnt;

    public CentrifugeRecipe(ResourceLocation id, NonNullList<ItemStack> outputs, NonNullList<Float> outProbability,
                            NonNullList<FluidStack> fluidOutputs, Ingredient recipeItem, FluidStack recipeFluid, int inputCnt) {
        this.id = id;
        this.lightest = !outputs.isEmpty() ? outputs.get(0) : ItemStack.EMPTY;
        this.midLight = outputs.size() > 1 ? outputs.get(1) : ItemStack.EMPTY;
        this.midHeavy = outputs.size() > 2 ? outputs.get(2) : ItemStack.EMPTY;
        this.heaviest = outputs.size() > 3 ? outputs.get(3) : ItemStack.EMPTY;
        this.recipeItem = recipeItem;
        this.outputProbabilities = outProbability;
        this.fluidOutputs = fluidOutputs;
        this.recipeFluid = recipeFluid;
        this.inputCnt = inputCnt;
    }

    public FluidStack getRecipeFluid() {
        return recipeFluid;
    }

    public Ingredient getRecipeItem() {
        return recipeItem;
    }

    @Override
    public boolean matches(ItemFluidContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }
        return recipeItem.test(pContainer.getItem(0));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(this.recipeItem);
    }

    @Override
    public ItemStack assemble(ItemFluidContainer pContainer, RegistryAccess pRegistryAccess) {
        return this.lightest; // DO NOT USE IN THIS CASE
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pAccess) {
        return this.lightest.copy();
    }
    public int getRecipeFluidAmt() {
        return recipeFluid.getAmount();
    }

    public ItemStack getLightest() {
        return lightest;
    }

    public ItemStack getMidLight() {
        return midLight;
    }

    public ItemStack getMidHeavy() {
        return midHeavy;
    }

    public ItemStack getHeaviest() {
        return heaviest;
    }

    public List<Float> getOutputProbabilities() {
        return outputProbabilities;
    }

    public int getInputCount() {
        return inputCnt;
    }

    public List<FluidStack> getFluidOutputs() {
        return fluidOutputs;
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

    public static class Type implements RecipeType<CentrifugeRecipe> {
        public static final Type INSTANCE = new Type();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "centrifuge");

    }

    public static class Serializer implements RecipeSerializer<CentrifugeRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "centrifuge");

        @Override
        public CentrifugeRecipe fromJson(ResourceLocation pId, JsonObject pJson) {
            NonNullList<FluidStack> fluidOutputs = NonNullList.create();
            if (pJson.has("fluid_outputs")) {
                JsonArray fluidOuts = GsonHelper.getAsJsonArray(pJson, "fluid_outputs");
                int fluidArrSize = Math.min(fluidOuts.size(), 4);
                fluidOutputs = NonNullList.withSize(fluidArrSize, FluidStack.EMPTY);
                for (int i = 0; i < fluidOutputs.size(); i++) {
                    if (i < fluidOuts.size()) {
                        fluidOutputs.set(i, FluidFunctions.readFluid(fluidOuts.getAsJsonObject()));
                    }
                }
            }
            NonNullList<ItemStack> outputs = NonNullList.create();
            NonNullList<Float> outProb = NonNullList.create();
            if (pJson.has("outputs")) {
                JsonArray outs = GsonHelper.getAsJsonArray(pJson, "outputs");
                int arraySize = Math.min(outs.size(), 4);
                outputs = NonNullList.withSize(arraySize, ItemStack.EMPTY);
                outProb = NonNullList.withSize(arraySize, 0f);
                for (int i = 0; i < outputs.size(); i++) {
                    if (i < arraySize) {
                        JsonObject obj = outs.get(i).getAsJsonObject();
                        outputs.set(i, ShapedRecipe.itemStackFromJson(obj));
                        outProb.set(i, obj.get("chance").getAsFloat());
                    }
                }
            }
            JsonObject ingredient = GsonHelper.getAsJsonObject(pJson, "ingredient");
            int ingAmt = ingredient.has("count") ? ingredient.get("count").getAsInt() : 1;
            FluidStack inpFluid = FluidFunctions.readFluid(pJson.getAsJsonObject("fluid"));
            return new CentrifugeRecipe(pId, outputs, outProb, fluidOutputs, Ingredient.fromJson(ingredient), inpFluid, ingAmt);
        }

        @Override
        public @Nullable CentrifugeRecipe fromNetwork(ResourceLocation pId, FriendlyByteBuf pBuffer) {
            NonNullList<ItemStack> outputs = NonNullList.of(pBuffer.readItem(), pBuffer.readItem(), pBuffer.readItem(),
                    pBuffer.readItem());
            NonNullList<FluidStack> fluids = NonNullList.create();
            NonNullList<Float> outProb = NonNullList.create();

            for (int i = 0; i < 4; i++) {
                outProb.add(pBuffer.readFloat());
                //fluids.add(pBuffer.readFluidStack());
            }
            Ingredient input = Ingredient.fromNetwork(pBuffer);
            int inputCnt = pBuffer.readInt();
            //FluidStack inputFluid = pBuffer.readFluidStack();

            return new CentrifugeRecipe(pId, outputs, outProb, fluids, input, FluidStack.EMPTY, inputCnt);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, CentrifugeRecipe pRecipe) {
            pBuffer.writeItem(pRecipe.getLightest());
            pBuffer.writeItem(pRecipe.getMidLight());
            pBuffer.writeItem(pRecipe.getMidHeavy());
            pBuffer.writeItem(pRecipe.getHeaviest());
            for (int i = 0; i < 4; i++) {
                pBuffer.writeFloat(i < pRecipe.outputProbabilities.size() ? pRecipe.outputProbabilities.get(i) : 0f);
                //pBuffer.writeFluidStack(i < pRecipe.fluidOutputs.size() ? pRecipe.fluidOutputs.get(i) : FluidStack.EMPTY);
            }
            pRecipe.recipeItem.toNetwork(pBuffer);
            pBuffer.writeInt(pRecipe.inputCnt);
            //pBuffer.writeFluidStack(pRecipe.recipeFluid);
        }
    }
}

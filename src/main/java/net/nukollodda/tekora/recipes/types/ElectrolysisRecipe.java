package net.nukollodda.tekora.recipes.types;

import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.util.FluidFunctions;
import org.jetbrains.annotations.Nullable;

public class ElectrolysisRecipe implements Recipe<ItemFluidContainer> {
    private final ResourceLocation id;
    private final FluidStack recipeFluid;
    private final Ingredient recipeItem;
    private final int inputCnt;
    private final ItemStack cation;
    private final ItemStack anion;
    private final FluidStack cationicFluid;
    private final FluidStack anionicFluid;
    public ElectrolysisRecipe(ResourceLocation id, ItemStack cation, ItemStack anion, FluidStack cationicFluid, FluidStack anionicFluid,
                              Ingredient recipeItem, int inputCnt, FluidStack recipeFluid) {
        this.id = id;
        this.recipeFluid = recipeFluid;
        this.recipeItem = recipeItem;
        this.inputCnt = inputCnt;
        this.cation = cation;
        this.anion = anion;
        this.cationicFluid = cationicFluid;
        this.anionicFluid = anionicFluid;
    }
    @Override
    public boolean matches(ItemFluidContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide) {
            return false;
        }
        return pContainer.getFluid(0).containsFluid(recipeFluid) &&
                (recipeItem.test(pContainer.getItem(1)) && pContainer.getItem(1).getCount() == this.inputCnt);
    }

    @Override
    public ItemStack assemble(ItemFluidContainer pContainer, RegistryAccess pRegistryAccess) {
        return this.cation.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return false;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return this.cation.copy();
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public ItemStack getCation() {
        return cation;
    }

    public ItemStack getAnion() {
        return anion;
    }

    public FluidStack getCationicFluid() {
        return cationicFluid;
    }

    public FluidStack getAnionicFluid() {
        return anionicFluid;
    }

    public static class Type implements RecipeType<ElectrolysisRecipe> {
        public static final Type INSTANCE = new Type();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "electrolysis");

    }

    public static class Serializer implements RecipeSerializer<ElectrolysisRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Tekora.MODID, "electrolysis");
        @Override
        public ElectrolysisRecipe fromJson(ResourceLocation pId, JsonObject pJson) {
            Ingredient ing = Ingredient.EMPTY;
            int count = 1;
            if (pJson.has("ingredient")) {
                ing = Ingredient.fromJson(pJson.get("ingredient"));
                if (pJson.getAsJsonObject("ingredient").has("count")) {
                    count = pJson.getAsJsonObject("ingredient").get("count").getAsInt();
                }
            }
            FluidStack fluidIng = pJson.has("fluid_ingredient") ?
                    FluidFunctions.readFluid(pJson.getAsJsonObject("fluid_ingredient")) : FluidStack.EMPTY;
            ItemStack cation = ShapedRecipe.itemStackFromJson(pJson.getAsJsonObject("cation"));
            ItemStack anion = ShapedRecipe.itemStackFromJson(pJson.getAsJsonObject("anion"));
            FluidStack cationFluid = FluidFunctions.readFluid(pJson.getAsJsonObject("cation_fluid"));
            FluidStack anionFluid = FluidFunctions.readFluid(pJson.getAsJsonObject("anion_fluid"));
            return new ElectrolysisRecipe(pId, cation, anion, cationFluid, anionFluid, ing, count, fluidIng);
        }

        @Override
        public @Nullable ElectrolysisRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            return null;
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, ElectrolysisRecipe pRecipe) {
            pBuffer.writeItem(pRecipe.getCation());
            pBuffer.writeItem(pRecipe.getAnion());
            pBuffer.writeFluidStack(pRecipe.getCationicFluid());
            pBuffer.writeFluidStack(pRecipe.getAnionicFluid());

            pRecipe.recipeItem.toNetwork(pBuffer);
            pBuffer.writeFluidStack(pRecipe.recipeFluid);
        }
    }
}

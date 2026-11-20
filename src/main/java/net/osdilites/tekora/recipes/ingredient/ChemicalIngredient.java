package net.osdilites.tekora.recipes.ingredient;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.data.SoluteKey;
import net.osdilites.tekora.data.Solutes;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

// todo, figure out how gas and dissolution behavior works
public record ChemicalIngredient(Either<MaterialIngredient, ChemDataIngredient> input) {
    public static final Codec<ChemicalIngredient> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.either(MaterialIngredient.CODEC, ChemDataIngredient.CODEC).fieldOf("input").forGetter(ChemicalIngredient::input)
            ).apply(instance, ChemicalIngredient::new)
    );

    private static final StreamCodec<RegistryFriendlyByteBuf, Either<MaterialIngredient, ChemDataIngredient>>
            GENERAL_STREAM_CODEC = StreamCodec.of(
            (buf, either) -> either.ifLeft(
                    ingredient -> {
                        buf.writeBoolean(true);
                        MaterialIngredient.STREAM_CODEC.encode(buf, ingredient);
                    }
            ).ifRight(
                    solute -> {
                        buf.writeBoolean(false);
                        ChemDataIngredient.STREAM_CODEC.encode(buf, solute);
                    }
            ),
            buf -> buf.readBoolean()
                    ? Either.left(MaterialIngredient.STREAM_CODEC.decode(buf))
                    : Either.right(ChemDataIngredient.STREAM_CODEC.decode(buf))
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ChemicalIngredient> STREAM_CODEC = StreamCodec.composite(
            GENERAL_STREAM_CODEC, ChemicalIngredient::input,
            ChemicalIngredient::new
    );

    // Helper methods to easily query the machineType during reaction checks
    @Deprecated
    public boolean isSolute() { return false; }

    public boolean isData() { return input.right().isPresent(); }
    public boolean isMaterial() { return input.left().isPresent(); }

    public @NonNull MaterialIngredient asMaterial() { return input.left().orElseThrow(); }

    @Contract(pure = true)
    @Deprecated
    public @Nullable SoluteKey asSolute() { return null; }

    public @NonNull ChemDataIngredient asData() {
        return input.right().orElseThrow();
    }

    public boolean test(SoluteKey solute) {
        if (isData()) {
            ChemDataIngredient data = asData();
            return data.isSingular() && data.asSingular().equals(solute);
        }
        return false;
    }

    public boolean test(Solutes solutes) {
        if (isData()) {
            ChemDataIngredient data = asData();
            return data.isSingular() && data.asMap().equals(solutes);
        }
        return false;
    }

    public boolean test(FluidStack fluid) {
        if (isMaterial()) {
            MaterialIngredient material = asMaterial();
            return material.isFluid() && material.asFluid().test(fluid);
        }
        return false;
    }

    public boolean test(ItemStack item) {
        if (isMaterial()) {
            MaterialIngredient material = asMaterial();
            return material.isItem() && material.asItem().test(item);
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChemicalIngredient(Either<MaterialIngredient, ChemDataIngredient> input1)) {
            return input.equals(input1);
        }
        return false;
    }

    public boolean affectsQ() {
        return isSolute();
    }

    // replace with of
    @Deprecated
    public static @NonNull ChemicalIngredient liquidSolute(@NonNull SoluteKey data) {
        return of(data);
    }

    // replace with of
    @Deprecated
    public static @NonNull ChemicalIngredient solidSolute(@NonNull SoluteKey data) {
        return of(data);
    }

    @Contract("_ -> new") // used for solids
    public static @NonNull ChemicalIngredient of(SoluteKey data) {
        return new ChemicalIngredient(Either.right(ChemDataIngredient.of(data)));
    }

    @Contract("_ -> new") // used for dissolved/aqueous solutes and gases
    public static @NonNull ChemicalIngredient of(Solutes solutes) {
        return new ChemicalIngredient(Either.right(ChemDataIngredient.of(solutes)));
    }

    @Contract("_ -> new") // used for liquids
    public static @NotNull ChemicalIngredient of(@NotNull Fluid fluid) {
        return new ChemicalIngredient(Either.left(MaterialIngredient.of(FluidIngredient.of(fluid))));
    }

    @Contract("_ -> new") // used for items
    public static @NotNull ChemicalIngredient of(@NotNull ItemLike item) {
        return new ChemicalIngredient(Either.left(MaterialIngredient.of(Ingredient.of(item))));
    }

    @Deprecated
    public static @Nullable ChemicalIngredient of(MaterialIngredient ingredient) {
        return null;
    }
}
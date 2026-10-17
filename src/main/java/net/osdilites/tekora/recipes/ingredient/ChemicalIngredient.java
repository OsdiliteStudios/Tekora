package net.osdilites.tekora.recipes.ingredient;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.data.SoluteKey;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

// todo, figure out how gas and dissolution behavior works
public record ChemicalIngredient(Either<MaterialIngredient, SoluteIngredient> input) {
    public static final Codec<ChemicalIngredient> CODEC = Codec.either(
            MaterialIngredient.CODEC,
            SoluteIngredient.CODEC
    ).xmap(ChemicalIngredient::new, ChemicalIngredient::input);

    private static final StreamCodec<RegistryFriendlyByteBuf, Either<MaterialIngredient, SoluteIngredient>>
            GENERAL_STREAM_CODEC = StreamCodec.of(
            (buf, either) -> either.ifLeft(
                    ingredient -> {
                        buf.writeBoolean(true);
                        MaterialIngredient.STREAM_CODEC.encode(buf, ingredient);
                    }
            ).ifRight(
                    solute -> {
                        buf.writeBoolean(false);
                        SoluteIngredient.STREAM_CODEC.encode(buf, solute);
                    }
            ),
            buf -> buf.readBoolean()
                    ? Either.left(MaterialIngredient.STREAM_CODEC.decode(buf))
                    : Either.right(SoluteIngredient.STREAM_CODEC.decode(buf))
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ChemicalIngredient> STREAM_CODEC = StreamCodec.composite(
            GENERAL_STREAM_CODEC,
            ChemicalIngredient::input,
            ChemicalIngredient::new
    );

    // Helper methods to easily query the machineType during reaction checks
    public boolean isSolute() { return input.right().isPresent(); }
    public boolean isMaterial() { return input.left().isPresent(); }

    public MaterialIngredient asMaterial() { return input.left().orElseThrow(); }
    public SoluteIngredient asSolute() { return input.right().orElseThrow(); }

    public boolean test(SoluteKey solute) {
        return isSolute() && asSolute().test(solute);
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
        if (obj instanceof ChemicalIngredient(Either<MaterialIngredient, SoluteIngredient> input1)) {
            return input.equals(input1);
        }
        return false;
    }

    public boolean affectsQ() {
        return isSolute() && !asSolute().isSolid();
    }

    public static @NonNull ChemicalIngredient liquidSolute(@NonNull SoluteKey data) {
        return new ChemicalIngredient(Either.right(SoluteIngredient.liquidSolute(data)));
    }

    public static @NonNull ChemicalIngredient solidSolute(@NonNull SoluteKey data) {
        return new ChemicalIngredient(Either.right(SoluteIngredient.solidSolute(data)));
    }

    @Contract("_ -> new")
    public static @NotNull ChemicalIngredient of(@NotNull Fluid fluid) {
        return new ChemicalIngredient(Either.left(MaterialIngredient.of(FluidIngredient.of(fluid))));
    }

    @Contract("_ -> new")
    public static @NotNull ChemicalIngredient of(@NotNull ItemStack item) {
        return new ChemicalIngredient(Either.left(MaterialIngredient.of(Ingredient.of(item.getItem()))));
    }

    @Contract("_ -> new")
    public static @NonNull ChemicalIngredient of(MaterialIngredient ingredient) {
        return new ChemicalIngredient(Either.left(ingredient));
    }
}
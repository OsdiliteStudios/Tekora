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
public record ChemicalIngredient(Either<MaterialIngredient, SoluteIngredient> input) {
    public static final Codec<ChemicalIngredient> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.either(MaterialIngredient.CODEC, SoluteIngredient.CODEC).fieldOf("input").forGetter(ChemicalIngredient::input)
            ).apply(instance, ChemicalIngredient::new)
    );

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
            GENERAL_STREAM_CODEC, ChemicalIngredient::input,
            ChemicalIngredient::new
    );

    // Helper methods to easily query the machineType during reaction checks
    public boolean isSolute() { return input.right().isPresent(); }

    @Deprecated
    public boolean isData() { return input.right().isPresent(); }
    public boolean isMaterial() { return input.left().isPresent(); }

    public @NonNull MaterialIngredient asMaterial() { return input.left().orElseThrow(); }

    // please use asSoluteIngredient instead
    @Deprecated
    @Contract(pure = true)
    public @NotNull SoluteKey asSolute() { return input.right().orElseThrow().value(); }

    public SoluteIngredient asSoluteIngredient() {
        return input.right().orElseThrow();
    }

    @Deprecated
    public @Nullable SoluteKey asData() {
        return null;
    }

    public boolean test(SoluteKey solute) {
        if (isData()) {
            SoluteKey data = asData();
            return data.equals(solute);
        }
        return false;
    }

    @Deprecated
    public boolean test(Solutes solutes) {
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
        if (obj instanceof ChemicalIngredient(Either<MaterialIngredient, SoluteIngredient> input1)) {
            if (input1.left().isPresent() && input.left().isPresent()) {
                return input1.left().get().equals(input.left().get());
            } else if (input1.right().isPresent() && input.right().isPresent()) {
                return input1.right().get().equals(input.right().get());
            }
        }
        return false;
    }

    public boolean affectsQ() {
        return isSolute();
    }


    // replace with of
    @Deprecated
    public static @NonNull ChemicalIngredient liquidSolute(@NonNull SoluteKey data) {
        return of(SoluteIngredient.of(data,SoluteIngredient.LIQUID));
    }

    // replace with of
    @Deprecated
    public static @NonNull ChemicalIngredient solidSolute(@NonNull SoluteKey data) {
        return of(SoluteIngredient.of(data,SoluteIngredient.SOLID));
    }

    @Contract("_ -> new")
    public static @NonNull ChemicalIngredient of(SoluteIngredient data) {
        return new ChemicalIngredient(Either.right(data));
    }

    @Deprecated
    @Contract("_ -> new")
    public static @NonNull ChemicalIngredient of(SoluteKey data) {
        return new ChemicalIngredient(Either.right(SoluteIngredient.of(data, SoluteIngredient.SOLVATED)));
    }

    @Contract("_ -> new")
    public static @NonNull ChemicalIngredient of(SoluteKey data, String state) {
        return new ChemicalIngredient(Either.right(SoluteIngredient.of(data, state)));
    }

    @Deprecated
    public static @Nullable ChemicalIngredient of(Solutes solutes) {
        return null;
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
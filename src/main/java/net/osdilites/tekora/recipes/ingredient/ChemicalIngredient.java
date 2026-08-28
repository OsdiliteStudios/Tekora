package net.osdilites.tekora.recipes.ingredient;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

public record ChemicalIngredient(Either<Ingredient, FluidIngredient> input) {
    public static final Codec<ChemicalIngredient> CODEC = Codec.either(
            Ingredient.CODEC,
            FluidIngredient.CODEC
    ).xmap(ChemicalIngredient::new, ChemicalIngredient::input);

    public static final StreamCodec<RegistryFriendlyByteBuf, ChemicalIngredient> STREAM_CODEC = StreamCodec.composite(
            StreamCodec.of(
                    (buf, either) -> either.ifLeft(ing -> {
                        buf.writeBoolean(true);
                        Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ing);
                    }).ifRight(fluid -> {
                        buf.writeBoolean(false);
                        FluidIngredient.STREAM_CODEC.encode(buf, fluid);
                    }),
                    buf -> buf.readBoolean()
                            ? Either.left(Ingredient.CONTENTS_STREAM_CODEC.decode(buf))
                            : Either.right(FluidIngredient.STREAM_CODEC.decode(buf))
            ),
            ChemicalIngredient::input,
            ChemicalIngredient::new
    );

    // Helper methods to easily query the machineType during reaction checks
    public boolean isFluid() { return input.right().isPresent(); }
    public boolean isItem() { return input.left().isPresent(); }

    public Ingredient asItem() { return input.left().orElseThrow(); }
    public FluidIngredient asFluid() { return input.right().orElseThrow(); }

    public double getMol() {
        // todo, for solids and liquids we'll use mol/L to find the values
        // all solid items either has 0.111 L or 0.25 L depending on the machineType.
        // quartz and amethyst has 0.25L, diamonds meanwhile will have 0.111L
        // for liquids, mB is the same as a mL.
        if (isFluid()) {
            // use of Mols here
        } else if (isItem()) {
            // use in mols
        }
        return 0;
    }
}
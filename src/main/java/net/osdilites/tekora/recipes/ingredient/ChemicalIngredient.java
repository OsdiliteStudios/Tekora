package net.osdilites.tekora.recipes.ingredient;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.data.IonValue;

// todo, figure out how gas and dissolution behavior works
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChemicalIngredient(Either<Ingredient, FluidIngredient> input1)) {
            return input.equals(input1);
        }
        return false;
    }
}
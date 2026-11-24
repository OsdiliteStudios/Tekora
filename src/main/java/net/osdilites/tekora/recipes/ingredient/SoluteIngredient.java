package net.osdilites.tekora.recipes.ingredient;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.osdilites.tekora.data.SoluteKey;
import org.jspecify.annotations.NonNull;

import java.util.function.Predicate;

public final class SoluteIngredient implements Predicate<SoluteKey> {
    // TODO, could change this to enums
    public static final String SOLID = "SOLID";
    public static final String LIQUID = "LIQUID";
    public static final String SOLVATED = "SOLVATED";
    public static final String GAS = "GAS";
    public static final String SOLVICRITICAL = "SOLVICRITICAL";
    public static final String SUPERCRITICAL = "SUPERCRITICAL";

    public static final Codec<SoluteIngredient> CODEC = RecordCodecBuilder.create((
            instance) -> instance.group(
            SoluteKey.CODEC.fieldOf("value").forGetter(SoluteIngredient::value),
            Codec.STRING.fieldOf("state").forGetter(SoluteIngredient::state)
    ).apply(instance, SoluteIngredient::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, SoluteIngredient> STREAM_CODEC = StreamCodec.composite(
            SoluteKey.STREAM_CODEC, SoluteIngredient::value,
            ByteBufCodecs.STRING_UTF8, SoluteIngredient::state,
            SoluteIngredient::new
    );
    private final SoluteKey value;
    private final String state;

    private SoluteIngredient(SoluteKey key, String state) {
        this.value = key;
        this.state = state;
    }

    public SoluteKey value() {
        return value;
    }

    public String state() {
        return state;
    }

    @Override
    public boolean test(@NonNull SoluteKey soluteData) {
        return value.equals(soluteData);
    }

    public static @NonNull SoluteIngredient of(@NonNull SoluteKey data, String state) {
        if (data.charge() != 0 && state.equals(SOLID)) {
            // this case is for testing purposes and will be removed in the final product.
            throw new IllegalArgumentException("Cannot have a charged solid");
        }
        if (state.equals(SOLID) || state.equals(LIQUID) || state.equals(SOLVATED) || state.equals(GAS) || state.equals(SOLVICRITICAL) || state.equals(SUPERCRITICAL)) {
            return new SoluteIngredient(data, state);
        } else {
            throw new IllegalArgumentException("Invalid state of matter");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SoluteIngredient ing) {
            return value.equals(ing.value) && state.equals(ing.state);
        }
        return super.equals(obj);
    }
}

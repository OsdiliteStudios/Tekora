package net.osdilites.tekora.recipes.ingredient;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.osdilites.tekora.data.SoluteKey;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.function.Predicate;

public class SoluteIngredient implements Predicate<SoluteKey> {
    public static final Codec<SoluteIngredient> CODEC = RecordCodecBuilder.create((
            instance) -> instance.group(
            Codec.STRING.fieldOf("formula").forGetter(SoluteIngredient::getFormula),
            Codec.INT.fieldOf("charge").forGetter(SoluteIngredient::getCharge),
            Codec.BOOL.fieldOf("is_solid").forGetter(SoluteIngredient::isSolid)
    ).apply(instance, SoluteIngredient::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, SoluteIngredient> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, SoluteIngredient::getFormula,
            ByteBufCodecs.INT, SoluteIngredient::getCharge,
            ByteBufCodecs.BOOL, SoluteIngredient::isSolid,
            SoluteIngredient::new
    );
    private final String formula;
    private final int charge;
    private final boolean isSolid;

    private SoluteIngredient(String formula, int charge, boolean isSolid) {
        this.formula = formula;
        this.charge = charge;
        this.isSolid = isSolid;
    }

    protected String getFormula() {
        return formula;
    }

    protected int getCharge() {
        return charge;
    }

    protected boolean isSolid() {
        return isSolid;
    }

    @Override
    public boolean test(@NonNull SoluteKey soluteData) {
        return formula.equals(soluteData.formula()) && charge == soluteData.charge();
    }

    public static @NonNull SoluteIngredient liquidSolute(@NonNull SoluteKey data) {
        return new SoluteIngredient(data.formula(), data.charge(), false);
    }

    public static @NotNull SoluteIngredient solidSolute(@NotNull SoluteKey data) {
        return new SoluteIngredient(data.formula(), data.charge(), true);
    }
}

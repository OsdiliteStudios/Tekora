package net.osdilites.tekora.datagen.modelcases;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.ItemStack;
import net.osdilites.tekora.item.tools.ThermometerItem;
import net.osdilites.tekora.util.UtilFunctions;
import org.jspecify.annotations.Nullable;

public record BiomeTemperature() implements RangeSelectItemModelProperty {
    public static final MapCodec<BiomeTemperature> MAP_CODEC = MapCodec.unit(new BiomeTemperature());

    @Override
    public float get(ItemStack stack, @Nullable ClientLevel level, @Nullable ItemOwner owner, int seed) {
        if (owner != null && stack.getItem() instanceof ThermometerItem thermometer) {
            float upper = thermometer.getUpperBound();
            float lower = thermometer.getLowerBound();
            if (upper <= lower) {
                return 0.5f;
            }
            float increment = (upper - lower)/10.0f;
            float index = (float)UtilFunctions.getBiomeTemperature(owner.level(), BlockPos.containing(owner.position())) - lower;
            return Mth.clamp(1 - index / increment, 0.0f, 1.0f);
        }
        return 0.5f;
    }

    @Override
    public MapCodec<BiomeTemperature> type() {
        return MAP_CODEC;
    }
}

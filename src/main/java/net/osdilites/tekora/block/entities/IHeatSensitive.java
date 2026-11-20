package net.osdilites.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.osdilites.tekora.util.UtilFunctions;
import org.jspecify.annotations.NonNull;

public interface IHeatSensitive {
    // these functions should return constants stored in any objects inheriting this interface
    float getHeatCapacity(); // in joules per liters (J/L)
    float getConductivity(); // in watts per meter Kelvins (W/m K)
    float getContactArea(); // meters squared

    // this function should return a value that is always subject to change in any objects inheriting this interface
    float getTemperature(); // in Kelvins (K)

    default float getTotalTempDiff(Level level, BlockPos pos, float biomeTemp) {
        float totalDiff = 0;
        for (Direction direction : Direction.values()) {
            totalDiff += level.getBlockEntity(pos.relative(direction)) instanceof IHeatSensitive sensitive
                    ? getTransferHeat(sensitive)
                    : getCoolingDiff(biomeTemp, UtilFunctions.getHeatTransferCoeff(level));
        }
        return totalDiff;
    }

    private float getTransferHeat(@NonNull IHeatSensitive other) {
        float k1 = getConductivity();
        float k2 = other.getConductivity();
        if (k1 + k2 == 0) return 0;

        float deltaTemp = other.getTemperature() - getTemperature();
        float kEff = 2 * k1 * k2 / (k1 + k2);
        float area = Math.min(getContactArea(), other.getContactArea());

        return kEff * area * deltaTemp * 0.05f / getHeatCapacity();
    }

    private float getCoolingDiff(float envTemp, float transfer) {
        if (getHeatCapacity() <= 0) {
            return 0;
        }
        return transfer * getContactArea() * (envTemp - getTemperature()) * 0.05f / getHeatCapacity();
    }
}

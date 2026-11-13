package net.osdilites.tekora.block.entities;

import org.jspecify.annotations.NonNull;

public interface IHeatSensitive {
    // these functions should return constants stored in any objects inheriting this interface
    float getHeatCapacity(); // in joules per liters (J/L)
    float getConductivity(); // in watts per meter Kelvins (W/m K)
    float getContactArea(); // meters squared

    // this function should return a value that is always subject to change in any objects inheriting this interface
    float getTemperature(); // in Kelvins (K)

    default float getTransferHeat(@NonNull IHeatSensitive other) {
        float k1 = getConductivity();
        float k2 = other.getConductivity();
        if (k1 + k2 == 0) return getTemperature();

        float deltaTemp = other.getTemperature() - getTemperature();
        float kEff = 2 * k1 * k2 / (k1 + k2);
        float area = Math.min(getContactArea(), other.getContactArea());

        return kEff * area * deltaTemp * 0.05f / getHeatCapacity();
    }

    default float getCoolingDiff(float envTemp, float transfer) {
        return transfer * getContactArea() * (getTemperature() - envTemp) * 0.05f / getHeatCapacity();
    }
}

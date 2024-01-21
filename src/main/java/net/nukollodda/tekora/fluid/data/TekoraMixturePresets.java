package net.nukollodda.tekora.fluid.data;

public class TekoraMixturePresets {
    public static final TekoraFluidData AMMONIA_HYDROXIDE = new TekoraFluidData(new TekoraFluidData.Properties()
            .setComponents(TekoraFluidPresets.AMMONIA, TekoraFluidPresets.WATER)
            .setMeltingPoint(182)
            .setName("ammonium_hydroxide", (byte)0));

    public static final TekoraFluidData AQUA_REGIA = new TekoraFluidData(new TekoraFluidData.Properties()
            .setComponents(TekoraFluidPresets.HYDROGEN_CHLORIDE, TekoraFluidPresets.NITRIC_ACID)
            .setMeltingPoint(231)
            .setName("aqua_regia", (byte)0));
}

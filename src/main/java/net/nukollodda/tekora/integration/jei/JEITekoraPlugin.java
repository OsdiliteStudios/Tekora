package net.nukollodda.tekora.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;
import net.nukollodda.tekora.Tekora;

//@JeiPlugin
public class JEITekoraPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Tekora.MODID, "jei_plugin");
    }
}

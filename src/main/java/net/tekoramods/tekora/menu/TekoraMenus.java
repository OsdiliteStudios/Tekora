package net.tekoramods.tekora.menu;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tekoramods.tekora.Tekora;

public class TekoraMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Tekora.MODID);
    // list of menus (guis) to implement:
    // presser, printing press, miller, cutter, grinder
    // involves fluids: mixer, centrifuge, kiln furnace(maybe), crucible(maybe done), boiler
    // late stage menus (guis) to implement(most if not all here involves fluids):
    // extruder, froth floater, air compressor, stove(maybe), distillation chamber, tank, diffusion chamber, fluid chamber
    // electrolysis chamber, magnetic separator, cooler, things related to power generation (albeit boilers are part of some of the generators)

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}

package net.osdilites.tekora.menu;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;

import java.util.function.Supplier;

public class TekoraMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, Tekora.MODID);
    // list of menus (guis) to implement:
    // presser, printing press, miller, cutter, grinder
    // involves fluids: mixer, centrifuge, kiln furnace(maybe), crucible(maybe done), boiler
    // late stage menus (guis) to implement(most if not all here involves fluids):
    // extruder, froth floater, air compressor, stove(maybe), distillation chamber, tank, diffusion chamber, fluid chamber
    // electrolysis chamber, magnetic separator, cooler, things related to power generation (albeit boilers are part of some of the generators)
    public static final Supplier<MenuType<KilnFurnaceMenu>> KILN_FURNACE_MENU = MENUS.register("kiln_furnace",
            () -> IMenuTypeExtension.create(KilnFurnaceMenu::new));

    public static final Supplier<MenuType<BasinMenu>> BASIN_MENU = MENUS.register("basin",
            () -> IMenuTypeExtension.create(BasinMenu::new));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}

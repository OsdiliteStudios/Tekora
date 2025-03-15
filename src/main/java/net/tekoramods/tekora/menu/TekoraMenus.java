package net.tekoramods.tekora.menu;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.Tekora;

public class TekoraMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, Tekora.MODID);
    // list of menus (guis) to implement:
    // presser, printing press, miller, cutter, grinder
    // involves fluids: mixer, centrifuge, kiln furnace(maybe), crucible(maybe done), boiler
    // late stage menus (guis) to implement(most if not all here involves fluids):
    // extruder, froth floater, air compressor, stove(maybe), distillation chamber, tank, diffusion chamber, fluid chamber
    // electrolysis chamber, magnetic separator, cooler, things related to power generation (albeit boilers are part of some of the generators)
    public static final RegistryObject<MenuType<KilnFurnaceMenu>> KILN_FURNACE_MENU = MENUS.register("kiln_furnace",
            () -> IForgeMenuType.create(KilnFurnaceMenu::new));

    //    public static final RegistryObject<MenuType<FluidInputMenu>> FLUID_INPUT_MENU = MENUS.register("fluid_input",
    //            () -> IForgeMenuType.create(FluidInputMenu::new));
    //    public static final RegistryObject<MenuType<FluidOutputMenu>> FLUID_OUTPUT_MENU = MENUS.register("fluid_output",
    //            () -> IForgeMenuType.create(FluidOutputMenu::new));
        public static final RegistryObject<MenuType<ItemTransportMenu>> ITEM_TRANSPORT_MENU = MENUS.register("item_transport_menu",
                () -> IForgeMenuType.create(ItemTransportMenu::new));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}

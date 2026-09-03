package net.osdilites.tekora.menu;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;

public class TekoraMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, Tekora.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<KilnFurnaceMenu>> KILN_FURNACE_MENU =
            MENUS.register("kiln_furnace", () -> IMenuTypeExtension.create(KilnFurnaceMenu::new));

    public static final DeferredHolder<MenuType<?>, MenuType<BasinMenu>> BASIN_MENU =
            MENUS.register("basin", () -> IMenuTypeExtension.create(BasinMenu::new));

    public static final DeferredHolder<MenuType<?>, MenuType<DepotMenu>> DEPOT_MENU =
            MENUS.register("depot", () -> IMenuTypeExtension.create(DepotMenu::new));

    public static final DeferredHolder<MenuType<?>, MenuType<DeployerMenu>> PRINTER_MENU =
            MENUS.register("printer", () -> IMenuTypeExtension.create(DeployerMenu::new));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}

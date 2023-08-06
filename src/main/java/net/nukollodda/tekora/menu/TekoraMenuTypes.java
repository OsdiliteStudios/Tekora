package net.nukollodda.tekora.menu;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;

public class TekoraMenuTypes {
    public static final DeferredRegister<MenuType<?>> MOD_MENU_TYPES =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Tekora.MODID);

    public static final RegistryObject<MenuType<AlloyFurnaceMenu>> ALLOY_FURNACE_MENU =
            registerMenuType(AlloyFurnaceMenu::new, "alloy_furnace_menu");

    public static final RegistryObject<MenuType<InfusionFurnaceMenu>> INFUSION_FURNACE_MENU =
            registerMenuType(InfusionFurnaceMenu::new, "infusion_furnace_menu");

    public static final RegistryObject<MenuType<ElectricFurnaceMenu>> ELECTRIC_FURNACE_MENU =
            registerMenuType(ElectricFurnaceMenu::new, "electric_furnace_menu");

    public static final RegistryObject<MenuType<CrusherMenu>> CRUSHER_MENU =
            registerMenuType(CrusherMenu::new, "crusher_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(
            IContainerFactory<T> factory, String name) {
        return MOD_MENU_TYPES.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MOD_MENU_TYPES.register(eventBus);
    }
}

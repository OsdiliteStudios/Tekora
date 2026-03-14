package net.osdilites.tekora.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.transporter.rotational.AbstractTekoraAxialBlock;
import net.osdilites.tekora.block.entities.transporter.rotational.RotationalAbstractEntity;
import net.osdilites.tekora.block.entities.thermal.AbstractThermalMachine;
import net.osdilites.tekora.item.typical.*;
import net.minecraft.world.item.*;
import net.osdilites.tekora.Tekora;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Function;

public class TekoraItems {
  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, Tekora.MODID);

  public static final RegistryObject<Item> AQUAMARINE = registerItem("aquamarine");
  public static final RegistryObject<Item> BAUXITE = registerItem("bauxite");
  //public static final RegistryObject<Item> CHROMITE = registerItem("chromite");
  public static final RegistryObject<Item> CINNABAR = registerItem("cinnabar");
  //public static final RegistryObject<Item> COLTAN = registerItem("coltan");
  public static final RegistryObject<Item> DOLOMITE = registerItem("dolomite");
  public static final RegistryObject<Item> FLUORITE = registerItem("fluorite");
  public static final RegistryObject<Item> HALITE = registerItem("halite");
  //public static final RegistryObject<Item> MONAZITE = registerItem("monazite");
  //public static final RegistryObject<Item> PYROLUSITE = registerItem("pyrolusite");
  public static final RegistryObject<Item> RUBY = registerItem("ruby");
  //public static final RegistryObject<Item> RUTILE = registerItem("rutile");
  public static final RegistryObject<Item> SAPPHIRE = registerItem("sapphire");
  //public static final RegistryObject<Item> URANINITE = registerItem("uraninite");
  public static final RegistryObject<Item> WOLFRAMITE = registerItem("wolframite");
  //public static final RegistryObject<Item> ZIRCON = registerItem("zircon");

  public static final RegistryObject<Item> RAW_LEAD = registerItem("raw_lead");
  public static final RegistryObject<Item> RAW_NICKEL = registerItem("raw_nickel");
  public static final RegistryObject<Item> RAW_SILVER = registerItem("raw_silver");
  public static final RegistryObject<Item> RAW_PLATINUM = registerItem("raw_platinum");
  public static final RegistryObject<Item> RAW_TIN = registerItem("raw_tin");
  public static final RegistryObject<Item> RAW_ZINC = registerItem("raw_zinc");

  // "ingots" left to add: antimony, arsenic, silicon
  public static final RegistryObject<Item> ALUMINUM_INGOT = registerItem("aluminum_ingot");
  public static final RegistryObject<Item> BISMUTH_INGOT = registerItem("bismuth_ingot");
  public static final RegistryObject<Item> COBALT_INGOT = registerItem("cobalt_ingot");
  public static final RegistryObject<Item> LEAD_INGOT = registerItem("lead_ingot");
  public static final RegistryObject<Item> MAGNESIUM_INGOT = registerItem("magnesium_ingot");
  public static final RegistryObject<Item> MANGANESE_INGOT = registerItem("manganese_ingot");
  public static final RegistryObject<Item> MOLYBDENUM_INGOT = registerItem("molybdenum_ingot");
  public static final RegistryObject<Item> NICKEL_INGOT = registerItem("nickel_ingot");
  public static final RegistryObject<Item> PLATINUM_INGOT = registerItem("platinum_ingot");
  public static final RegistryObject<Item> POTASSIUM_INGOT = registerItem("potassium_ingot");
  public static final RegistryObject<Item> SILVER_INGOT = registerItem("silver_ingot");
  public static final RegistryObject<Item> SODIUM_INGOT = registerItem("sodium_ingot");
  public static final RegistryObject<Item> TIN_INGOT = registerItem("tin_ingot");
  public static final RegistryObject<Item> TUNGSTEN_INGOT = registerItem("tungsten_ingot");
  public static final RegistryObject<Item> ZINC_INGOT = registerItem("zinc_ingot");

  public static final RegistryObject<Item> BRASS_INGOT = registerItem("brass_ingot");
  public static final RegistryObject<Item> BRONZE_INGOT = registerItem("bronze_ingot");
  public static final RegistryObject<Item> CONSTANTAN_INGOT = registerItem("constantan_ingot");
  public static final RegistryObject<Item> ELECTRUM_INGOT = registerItem("electrum_ingot");
  public static final RegistryObject<Item> INVAR_INGOT = registerItem("invar_ingot");
  public static final RegistryObject<Item> STEEL_INGOT = registerItem("steel_ingot");
  public static final RegistryObject<Item> PEWTER_INGOT = registerItem("pewter_ingot");
  public static final RegistryObject<Item> TUNGSTEN_STEEL_INGOT = registerItem("tungsten_steel_ingot");

  public static final RegistryObject<Item> FIRE_BRICK = registerItem("fire_brick"); // infused clay in a furnace
  public static final RegistryObject<Item> INFUSED_CLAY = registerItem("infused_clay"); // two parts clay, two parts bauxite

  public static final RegistryObject<Item> DEBUG_ITEM = ITEMS.register("debug_item", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Tekora.MODID, "debug_item")))) {
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
      Level lvl = pContext.getLevel();
      if (!lvl.isClientSide) {
        BlockPos pos = pContext.getClickedPos();
        BlockEntity ent = lvl.getBlockEntity(pos);
        BlockState state = lvl.getBlockState(pos);
        Player player = pContext.getPlayer();
        String msg = "";
        if (player != null) {
          if (ent instanceof RotationalAbstractEntity rotational){
            msg += "Object has a force of " + rotational.getForce() + " kg m/s^2\n";
          }
          if (state.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
            Direction.Axis axis = state.getValue(AbstractTekoraAxialBlock.AXIS);
            msg += "Object has an axis of rotation at the " + axis + " axis\n";
          }
          if (state.hasProperty(AbstractThermalMachine.LIT)) {
            msg += "Object is currently " + (state.getValue(AbstractThermalMachine.LIT) ? "" : "not ") + "lit\n";
          }
          if (!msg.isEmpty()) {
            player.displayClientMessage(Component.literal(msg), false);
            return InteractionResult.CONSUME;
          }
        }
        return InteractionResult.PASS;
      }
      return super.useOn(pContext);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
      pTooltipComponents.add(Component.literal("§kEnse chane no es relan din yebale, id salia es por les cerclader de Tekora et les tuime pruba."));
      super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
  }); // must be commented out if Tekora is released.

  private static RegistryObject<Item> registerItem(String name) {
    return ITEMS.register(name, () -> new TekoraItem(name));
  }

  private static RegistryObject<Item> registerFireresItem(String name) {
    return ITEMS.register(name, () -> new TekoraItem(true, name));
  }

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
package net.tekoramods.tekora.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tekoramods.tekora.block.entities.transporter.rotational.AbstractTekoraAxialBlock;
import net.tekoramods.tekora.block.entities.transporter.rotational.RotationalAbstractEntity;
import net.tekoramods.tekora.block.entities.thermal.AbstractThermalMachine;
import net.tekoramods.tekora.item.typical.*;
import net.minecraft.world.item.*;
import net.tekoramods.tekora.Tekora;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class TekoraItems {
  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, Tekora.MODID);

  public static final RegistryObject<Item> AQUAMARINE = ITEMS.register("aquamarine", TekoraItem::new);
  public static final RegistryObject<Item> BAUXITE = ITEMS.register("bauxite", TekoraItem::new);
  //public static final RegistryObject<Item> CHROMITE = ITEMS.register("chromite", TekoraItem::new);
  public static final RegistryObject<Item> CINNABAR = ITEMS.register("cinnabar", TekoraItem::new);
  //public static final RegistryObject<Item> COLTAN = ITEMS.register("coltan", TekoraItem::new);
  public static final RegistryObject<Item> DOLOMITE = ITEMS.register("dolomite", TekoraItem::new);
  public static final RegistryObject<Item> FLUORITE = ITEMS.register("fluorite", TekoraItem::new);
  public static final RegistryObject<Item> HALITE = ITEMS.register("halite", TekoraItem::new);
  //public static final RegistryObject<Item> MONAZITE = ITEMS.register("monazite", TekoraItem::new);
  //public static final RegistryObject<Item> PYROLUSITE = ITEMS.register("pyrolusite", TekoraItem::new);
  public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", TekoraItem::new);
  //public static final RegistryObject<Item> RUTILE = ITEMS.register("rutile", TekoraItem::new);
  public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", TekoraItem::new);
  //public static final RegistryObject<Item> URANINITE = ITEMS.register("uraninite", TekoraItem::new);
  public static final RegistryObject<Item> WOLFRAMITE = ITEMS.register("wolframite", TekoraItem::new);
  //public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", TekoraItem::new);

  public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead", TekoraItem::new);
  public static final RegistryObject<Item> RAW_NICKEL = ITEMS.register("raw_nickel", TekoraItem::new);
  public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver", TekoraItem::new);
  public static final RegistryObject<Item> RAW_PLATINUM = ITEMS.register("raw_platinum", TekoraItem::new);
  public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", TekoraItem::new);
  public static final RegistryObject<Item> RAW_ZINC = ITEMS.register("raw_zinc", TekoraItem::new);

  // "ingots" left to add: antimony, arsenic, silicon
  public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", TekoraItem::new);
  public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot", TekoraItem::new);
  public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", TekoraItem::new);
  public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", TekoraItem::new);
  public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot", TekoraItem::new);
  public static final RegistryObject<Item> MANGANESE_INGOT = ITEMS.register("manganese_ingot", TekoraItem::new);
  public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot", TekoraItem::new);
  public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", TekoraItem::new);
  public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", TekoraItem::new);
  public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot", TekoraItem::new);
  public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", TekoraItem::new);
  public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot", TekoraItem::new);
  public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", TekoraItem::new);
  public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", TekoraItem::new);
  public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", TekoraItem::new);

  public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot", TekoraItem::new);
  public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", TekoraItem::new);
  public static final RegistryObject<Item> CONSTANTAN_INGOT = ITEMS.register("constantan_ingot", TekoraItem::new);
  public static final RegistryObject<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot", TekoraItem::new);
  public static final RegistryObject<Item> INVAR_INGOT = ITEMS.register("invar_ingot", TekoraItem::new);
  public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", TekoraItem::new);
  public static final RegistryObject<Item> PEWTER_INGOT = ITEMS.register("pewter_ingot", TekoraItem::new);
  public static final RegistryObject<Item> TUNGSTEN_STEEL_INGOT = ITEMS.register("tungsten_steel_ingot", TekoraItem::new);

  public static final RegistryObject<Item> FIRE_BRICK = ITEMS.register("fire_brick", TekoraItem::new); // infused clay in a furnace
  public static final RegistryObject<Item> INFUSED_CLAY = ITEMS.register("infused_clay", TekoraItem::new); // two parts clay, two parts bauxite

  public static final RegistryObject<Item> DEBUG_ITEM = ITEMS.register("debug_item", () -> new TekoraItem() {
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
            player.sendSystemMessage(Component.literal(msg));
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

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
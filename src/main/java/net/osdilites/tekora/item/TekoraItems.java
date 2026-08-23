package net.osdilites.tekora.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.mechanical.AbstractModularMachineEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.AbstractShaftConnectableBlock;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import net.osdilites.tekora.block.entities.transporter.rotational.AbstractShaftConnectableEntity;
import net.osdilites.tekora.block.entities.thermal.AbstractThermalMachine;
import net.minecraft.world.item.*;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.item.typical.*;
import net.osdilites.tekora.util.TekoraShaftBody;

import java.util.function.Consumer;

public class TekoraItems {
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Tekora.MODID);

  public static final DeferredHolder<Item, Item> WOODEN_GEAR = ITEMS.register("wooden_gear", () -> new GearItem("wooden_gear", GearType.WOOD, true));
  public static final DeferredHolder<Item, Item> ALUMINUM_GEAR = ITEMS.register("aluminum_gear", () -> new GearItem("aluminum_gear", GearType.ALUMINUM, false));
  public static final DeferredHolder<Item, Item> BRASS_GEAR = ITEMS.register("brass_gear", () -> new GearItem("brass_gear", GearType.BRASS, false));
  public static final DeferredHolder<Item, Item> BRONZE_GEAR = ITEMS.register("bronze_gear", () -> new GearItem("bronze_gear", GearType.BRONZE, false));
  public static final DeferredHolder<Item, Item> PLASTIC_GEAR = ITEMS.register("plastic_gear", () -> new GearItem("plastic_gear", GearType.PLASTIC, true));
  public static final DeferredHolder<Item, Item> STEEL_GEAR = ITEMS.register("steel_gear", () -> new GearItem("steel_gear", GearType.STEEL, false));

  public static final DeferredHolder<Item, Item> WOODEN_GEAR_PART = ITEMS.register("wooden_gear_part", () -> new GearPartItem("wooden_gear_part", GearType.WOOD, true));
  public static final DeferredHolder<Item, Item> ALUMINUM_GEAR_PART = ITEMS.register("aluminum_gear_part", () -> new GearPartItem("aluminum_gear_part", GearType.ALUMINUM, false));
  public static final DeferredHolder<Item, Item> BRASS_GEAR_PART = ITEMS.register("brass_gear_part", () -> new GearPartItem("brass_gear_part", GearType.BRASS, false));
  public static final DeferredHolder<Item, Item> BRONZE_GEAR_PART = ITEMS.register("bronze_gear_part", () -> new GearPartItem("bronze_gear_part", GearType.BRONZE, false));
  public static final DeferredHolder<Item, Item> PLASTIC_GEAR_PART = ITEMS.register("plastic_gear_part", () -> new GearPartItem("plastic_gear_part", GearType.PLASTIC, true));
  public static final DeferredHolder<Item, Item> STEEL_GEAR_PART = ITEMS.register("steel_gear_part", () -> new GearPartItem("steel_gear_part", GearType.STEEL, false));

  public static final DeferredHolder<Item, Item> CRUSHING_WHEEL = ITEMS.register("crushing_wheel", () -> new MachinePartItem("crushing_wheel", TekoraBlocks.CRUSHER.get()));
  public static final DeferredHolder<Item, Item> WHISK = ITEMS.register("whisk", () -> new MachinePartItem("whisk", TekoraBlocks.MIXER.get()));
  public static final DeferredHolder<Item, Item> PRESS_SHAFT = ITEMS.register("press_shaft", () -> new MachinePartItem("press_shaft", TekoraBlocks.PRESS.get()));
  public static final DeferredHolder<Item, Item> INK_PRESS_SHAFT = ITEMS.register("ink_press_shaft", () -> new  MachinePartItem("ink_press_shaft", TekoraBlocks.PRINTER.get()));
  public static final DeferredHolder<Item, Item> CUTTER_SHAFT = ITEMS.register("cutter_shaft", () -> new MachinePartItem("cutter_shaft", TekoraBlocks.CUTTER.get()));

  public static final DeferredHolder<Item, Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new TekoraItem(true, "steel_ingot"));
  public static final DeferredHolder<Item, Item> STEEL_PLATE = ITEMS.register("steel_plate", () -> new TekoraItem(true, "steel_plate"));
  public static final DeferredHolder<Item, Item> WRENCH = ITEMS.register("wrench", () -> new WrenchItem("wrench", 560));

  // public static final DeferredHolder<Item, Item> MANUSCRIPT = ITEMS.register("manuscript", ManuscriptItem::new); // a loot item intended to allow Tekora to be playable without JEI

  public static final DeferredHolder<Item, Item> DEBUG_ITEM = ITEMS.register("debug_item", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Tekora.MODID, "debug_item")))) {
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
      Level lvl = pContext.getLevel();
      if (!lvl.isClientSide()) {
        BlockPos pos = pContext.getClickedPos();
        BlockEntity ent = lvl.getBlockEntity(pos);
        BlockState state = lvl.getBlockState(pos);
        Player player = pContext.getPlayer();
        if (player != null) {
          String msg = state.getBlock() + "\n";
          if (ent instanceof AbstractShaftConnectableEntity rotational) {
            TekoraShaftBody body = rotational.getBody();
            msg += "Object has a id of " + rotational.getBodyHashcode();
            msg += (rotational.isBodyTicker() ? " and ticks the body\n" : "\n");
            msg += "Object properties " + body + "\n";
          }
          if (ent instanceof AbstractModularMachineEntity modular) {
            GearType type = modular.getBlockState().getValueOrElse(TekoraBlockStates.GEAR_TYPE, GearType.NONE);
            msg += "Object has a geartype of " + type + "\n";
            msg += "Object has a velocity of " + modular.getVelocity() + "\n";
          }
          if (state.hasProperty(AbstractShaftConnectableBlock.AXIS)) {
            Direction.Axis axis = state.getValue(AbstractShaftConnectableBlock.AXIS);
            msg += "Object has an axis of rotation at the " + axis + " axis\n";
          }
          if (state.hasProperty(AbstractThermalMachine.LIT)) {
            msg += "Object is currently " + (state.getValue(AbstractThermalMachine.LIT) ? "" : "not ") + "lit\n";
          }
          if (state.hasProperty(TekoraBlockStates.GEAR_TYPE)) {
            msg += "Gear Type: " + state.getValue(TekoraBlockStates.GEAR_TYPE) + "\n";
          }
          if (state.hasProperty(TekoraBlockStates.IS_LARGE)) {
            msg += (state.getValue(TekoraBlockStates.IS_LARGE) ? "The gear is large" : "The gear is normal sized" )+ "\n";
          }
          player.sendSystemMessage(Component.literal(msg));
          return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
      }
      return super.useOn(pContext);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
      builder.accept(Component.literal("§kEnse chane no es relan din yebale, id salia es por cerclader de Tekora i tuime pruba."));
      super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
  }); // must be commented out if Tekora is released.

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
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
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.transporter.rotational.AbstractTekoraAxialBlock;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import net.osdilites.tekora.block.entities.transporter.rotational.RotationalAbstractEntity;
import net.osdilites.tekora.block.entities.thermal.AbstractThermalMachine;
import net.minecraft.world.item.*;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.item.typical.GearItem;
import net.osdilites.tekora.item.typical.MachinePartItem;

import java.util.function.Consumer;

public class TekoraItems {
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Tekora.MODID);

  public static final DeferredHolder<Item, Item> WOODEN_GEAR = ITEMS.register("wooden_gear", () -> new GearItem("wooden_gear", GearType.WOOD));
  public static final DeferredHolder<Item, Item> BRASS_GEAR = ITEMS.register("brass_gear", () -> new GearItem("brass_gear", GearType.BRASS));
  public static final DeferredHolder<Item, Item> STEEL_GEAR = ITEMS.register("steel_gear", () -> new GearItem("steel_gear", GearType.STEEL));

  public static final DeferredHolder<Item, Item> CRUSHING_WHEEL = ITEMS.register("crushing_wheel", () -> new MachinePartItem("crushing_wheel", null));
  public static final DeferredHolder<Item, Item> MIXER_SHAFT = ITEMS.register("mixer_shaft", () -> new MachinePartItem("mixer_shaft", TekoraBlocks.MIXER.get()));
  public static final DeferredHolder<Item, Item> PRESSER_SHAFT = ITEMS.register("presser_shaft", () -> new MachinePartItem("presser_shaft", null));
  public static final DeferredHolder<Item, Item> PRINTER_SHAFT = ITEMS.register("printer_shaft", () -> new  MachinePartItem("printer_shaft", null));

  public static final DeferredHolder<Item, Item> DEBUG_ITEM = ITEMS.register("debug_item", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Tekora.MODID, "debug_item")))) {
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
      Level lvl = pContext.getLevel();
      if (!lvl.isClientSide()) {
        BlockPos pos = pContext.getClickedPos();
        BlockEntity ent = lvl.getBlockEntity(pos);
        BlockState state = lvl.getBlockState(pos);
        Player player = pContext.getPlayer();
        String msg = "";
        if (player != null) {
          if (ent instanceof RotationalAbstractEntity rotational) {
            msg += "Object has a id of " + rotational.getBodyHashcode();
            msg += (rotational.isBodyTicker() ? " and ticks the body\n" : "\n");
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
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
      builder.accept(Component.literal("§kEnse chane no es relan din yebale, id salia es por cerclader de Tekora et tuime pruba."));
      super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
  }); // must be commented out if Tekora is released.

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
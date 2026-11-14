package net.osdilites.tekora.item.tools;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.TekoraConfig;
import net.osdilites.tekora.block.entities.IHeatSensitive;
import net.osdilites.tekora.item.typical.TekoraItem;
import net.osdilites.tekora.util.UtilFunctions;
import org.jspecify.annotations.Nullable;

public class ThermometerItem extends Item {
    // note, both lower bound and upper bound are in mc temp not kelvins
    private final float lowerBound;
    private final float upperBound;
    private final Holder<MobEffect> effect;
    public ThermometerItem(String name, float lowerBound, float upperBound, Holder<MobEffect> effect) {
        super(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Tekora.MODID, name))));
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.effect = effect;
    }
    public ThermometerItem(String name, float lowerBound, float upperBound) {
        this(name, lowerBound, upperBound, null);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (level.isClientSide()) return InteractionResult.PASS;

        Player player = context.getPlayer();
        if (player == null) return InteractionResult.PASS;

        BlockEntity ent = level.getBlockEntity(context.getClickedPos());
        if (ent instanceof IHeatSensitive sensitive) {
            double mcTemp = UtilFunctions.fromKelvinsToMcTemp(sensitive.getTemperature()); // used for color-coding
            TextColor color;

            int state = 0;
            if (mcTemp < lowerBound) {
                state = -1;
                mcTemp = lowerBound;
            } else if (mcTemp > upperBound) {
                state = 1;
                mcTemp = upperBound;
            } else if (Double.isInfinite(mcTemp) || Double.isNaN(mcTemp)) {
                state = -2;
            }

            if (state == -2) {
                player.sendOverlayMessage(Component.translatable("tekora.tooltip.temperature.unreliable"));
            } else {
                if (state == -1 || mcTemp < 0.0) {
                    color = TextColor.DARK_BLUE;
                } else if (state == 0) {
                    if (mcTemp < 0.4) {
                        color = TextColor.BLUE;
                    } else if (mcTemp < 0.6) {
                        color = TextColor.AQUA;
                    } else if (mcTemp < 1.0) {
                        color = TextColor.GREEN;
                    } else if (mcTemp < 1.6) {
                        color = TextColor.GOLD;
                    } else {
                        color = TextColor.RED;
                    }
                } else {
                    color = TextColor.RED;
                }

                MutableComponent premsg = switch (state) {
                    case -1 -> Component.translatable("tekora.tooltip.temperature.toocold");
                    case 1 -> Component.translatable("tekora.tooltip.temperature.toohot");
                    default -> null;
                };
                Component temperature = (switch (TekoraConfig.UNIT.get()) {
                    case "C" -> Component.literal(String.format("%.1f°C", UtilFunctions.fromMcTempToCelsius(mcTemp)));
                    case "F" ->
                            Component.literal(String.format("%.1f°F", UtilFunctions.fromMcTempToFahrenheit(mcTemp)));
                    case "M" -> Component.literal(String.format("%.2f", mcTemp));
                    default -> Component.literal(String.format("%.1fK", sensitive.getTemperature()));
                }).withColor(color);
                player.sendOverlayMessage(Component.translatable("tekora.tooltip.temperature").append(premsg != null ? premsg.append(temperature) : temperature));
            }
        }
        return super.useOn(context);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        super.inventoryTick(itemStack, level, owner, slot);
        double mcTemp = UtilFunctions.getBiomeTemperature(level, owner.blockPosition());
        if (mcTemp > this.upperBound) {
            owner.playSound(SoundEvents.GLASS_BREAK);
            if (effect != null) {
                AreaEffectCloud cloud = new AreaEffectCloud(level, owner.getX(), owner.getY(), owner.getZ());
                cloud.setRadius(0.5f);
                cloud.addEffect(new MobEffectInstance(effect, 120));
            }
            itemStack.setCount(itemStack.count() - 1);
        }
    }

    public float getLowerBound() {
        return lowerBound;
    }

    public float getUpperBound() {
        return upperBound;
    }
}

package net.nukollodda.tekora.item.tools.thorium;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface RadioactiveTools {
    boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker);
}

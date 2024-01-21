package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nukollodda.tekora.item.typical.ICompounds;
import net.nukollodda.tekora.item.typical.IonicParts;
import net.nukollodda.tekora.util.DustUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Thorium extends AbstractRadioactiveItem {
    public Thorium() {
        super(new Item.Properties().fireResistant());
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("msg.tekora.rad"));
        pTooltipComponents.add(AbstractRadioactiveItem.radComponent(getRadiation(pStack)));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public double getRadiation(ItemStack pStack) {
        return Isotopes.TH232.getRadiationVal();
    }

    @Override
    public double getFissionRate(ItemStack pStack) {
        return Isotopes.TH232.getFissionRate();
    }

    @Override
    public double getNeutronAbsorptionRate(ItemStack pStack) {
        return Isotopes.TH232.getNeutronAbsorptionRate();
    }

    @Override
    public float getFissionEnergy(ItemStack pStack) {
        return Isotopes.TH232.getFissionEnergy();
    }

    @Override
    public float getNeutronAbsorptionEnergy(ItemStack pStack) {
        return Isotopes.TH232.getNeutronAbsorptionEnergy();
    }

    public enum Isotopes implements AbstractRadioactiveItem.Isotopes {
        TH232;

        public int getId() {
            return 0;
        }

        @Override
        public double getRadiationVal() {
            return 0.000021;
        }

        @Override
        public double getFissionRate() {
            return 0.01;
        }

        @Override
        public double getNeutronAbsorptionRate() {
            return 0.96;
        }

        @Override
        public float getFissionEnergy() {
            return 20;
        }

        @Override
        public float getNeutronAbsorptionEnergy() {
            return 1942f;
        }

        @Override
        public AbstractRadioactiveItem.Isotopes getPostAbsorptionIsotope() {
            return Uranium.Isotopes.U233;
        }
    }

    public static class Nugget extends Thorium {
        @Override
        public double getRadiation(ItemStack pStack) {
            return super.getRadiation(pStack) / 9;
        }

        @Override
        public float getFissionEnergy(ItemStack pStack) {
            return super.getFissionEnergy(pStack) / 9;
        }

        @Override
        public float getNeutronAbsorptionEnergy(ItemStack pStack) {
            return super.getNeutronAbsorptionEnergy(pStack) / 9;
        }
    }

    public static class CompoundDust extends Thorium implements ICompounds {
        private final String anion;
        public CompoundDust(String pAnion) {
            this.anion = pAnion.toUpperCase();
        }

        public ItemStack getDecayItem() {
            ItemStack decayed = DustUtil.createDustFromIons(IonicParts.Cations.URANIUM.ordinal(), IonicParts.Anions.valueOf(anion).ordinal());
            CompoundTag tag = decayed.getOrCreateTag();
            ListTag list = new ListTag();
            for (int i = 0; i < 4; i++) {
                list.addTag(i, FloatTag.valueOf(0));
            }
            list.addTag(4, FloatTag.valueOf(1));
            tag.put("isotopes", list);
            decayed.setTag(tag);
            return decayed;
        }

        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            IonicParts cation = getCation();
            IonicParts anion = getAnion();
            if (cation != null && anion != null) {
                pTooltipComponents.add(Component.literal(cation.toString() + anion.toString()).withStyle(ChatFormatting.GRAY));
            }
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }

        @Override
        public IonicParts getCation() {
            IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
            int anOxState = Math.abs(anion.getOxidationState());
            return new IonicParts(IonicParts.Cations.THORIUM, anOxState > 0 && 4 % anOxState == 0 ? 1 : anOxState);
        }

        @Override
        public IonicParts getAnion() {
            IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
            int anOxState = Math.abs(anion.getOxidationState());
            return new IonicParts(anion, anOxState > 0 && 4 % anOxState == 0 ? 4 / anOxState : 4);
        }
    }
}

package net.nukollodda.tekora.item.tools;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SmithingTemplates {
    /* Tekora smithing template list
     * titanium - base: steel
     * thorium - base: steel
     * tungsten steel - base: iron
     * vanasteel - base: iron
     */
    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESC_FORMAT = ChatFormatting.BLUE;

    public static final Component APPLIES_TO_IRON = Component.translatable("item.tekora.upgrade_smithing_template_iron.applies_to")
            .withStyle(DESC_FORMAT);

    public static final Component APPLIES_TO_STEEL = Component.translatable("item.tekora.upgrade_smithing_template_steel.applies_to")
            .withStyle(DESC_FORMAT);
    public static final Component APPLIES_TO_ALL_IRON = Component.translatable("item.tekora.upgrade_smithing_template_iron.all_base_desc");
    public static final Component APPLIES_TO_ALL_STEEL = Component.translatable("item.tekora.upgrade_smithing_template_steel.all_base_desc");
    public static final Component APPLIES_TO_TOOLS_STEEL = Component.translatable("item.tekora.upgrade_smithing_template_steel.tools_base_desc");

    public static @NotNull SmithingTemplateItem createTekoraUpgradeTemplate(Component pApplies, Component pBaseTypes, String pName) {
        return new SmithingTemplateItem(
                pApplies,
                Component.translatable("item.tekora." + pName + "_ingot").withStyle(DESC_FORMAT),
                Component.translatable("item.tekora." + pName + "_smithing_template.desc").withStyle(TITLE_FORMAT),
                pBaseTypes,
                Component.translatable("item.tekora." + pName + "_smithing_template.upgrade_material"),
                createUpgradeIconsList(!pBaseTypes.equals(APPLIES_TO_TOOLS_STEEL)),
                List.of(new ResourceLocation("item/empty_slot_ingot")));
    }

    private static List<ResourceLocation> createUpgradeIconsList(boolean pHasArmorVar) {
        List<ResourceLocation> resourceList = new ArrayList<>(List.of(
                EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL));
        if (pHasArmorVar) {
            resourceList.addAll(List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE,
                    EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS));
        }
        return resourceList;
    }
}

package net.nukollodda.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.items.SlotItemHandler;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.block.entity.entities.machines.CentrifugeEntity;
import net.nukollodda.tekora.fluid.TekoraChemicalFluidType;
import net.nukollodda.tekora.menu.types.AbstractTekoraElectricMenu;

public class CentrifugeMenu extends AbstractTekoraElectricMenu {
    public final CentrifugeEntity blockEnt;

    public CentrifugeMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public CentrifugeMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(TekoraMenuTypes.CENTRIFUGE_MENU.get(), inv, data, id, 10);
        this.blockEnt = (CentrifugeEntity) entity;
        this.blockEnt.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 35, 18));
            this.addSlot(new SlotItemHandler(handler, 1, 56, 26));
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    this.addSlot(new SlotItemHandler(handler, i * 4 + j + 2, 100 + (j * 18), 7 + (i * 52)));
                }
            }
        });
        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1); // max progress

        return maxProgress != 0 && progress != 0 ? progress * 26 / maxProgress : 0;
    }

    public int getInputFluidAmount() {
        int amt = blockEnt.getInputFluid().getAmount();
        int cap = blockEnt.getInputFluidCapacity();

        return cap != 0 && amt != 0 ? (int)Math.ceil(amt * 29f / cap) : 0;
    }

    public int getInputFluidColor() {
        FluidType type = blockEnt.getInputFluid().getFluid().getFluidType();
        if (type instanceof TekoraChemicalFluidType chemicalFluid) {
            return chemicalFluid.getTintColor();
        }
        return 0xFFFFFF;
    }

    public ResourceLocation getInputFluidTexture() {
        FluidType type = blockEnt.getInputFluid().getFluid().getFluidType();
        if (type instanceof TekoraChemicalFluidType chemicalFluid) {
            return chemicalFluid.getStillTexture();
        }
        String[] parts = type.getDescriptionId().split("\\.");
        return new ResourceLocation(parts[0], "textures/block/" + parts[parts.length - 1] + "_still.png");
    }

    public int getOutputFluidAmount(int ind) {
        int amt = blockEnt.getOutputFluid(0).getAmount();
        int cap = blockEnt.getOutputFluidCapcity(0);

        return cap != 0 && amt != 0 ? (int)Math.ceil(amt * 25f / cap) : 0;
    }

    public int getOutputFluidColor(int ind) {
        FluidType type = blockEnt.getOutputFluid(ind).getFluid().getFluidType();
        if (type instanceof TekoraChemicalFluidType chemicalFluid) {
            return chemicalFluid.getTintColor();
        }
        return 0xFFFFFF;
    }

    public ResourceLocation getOutputFluidTexture(int ind) {
        FluidType type = blockEnt.getOutputFluid(ind).getFluid().getFluidType();
        if (type instanceof TekoraChemicalFluidType chemicalFluid) {
            return chemicalFluid.getStillTexture();
        }
        String[] parts = type.getDescriptionId().split("\\.");
        return new ResourceLocation(parts[0], parts[parts.length - 1]);
    }

    public int getEnergy() {
        int electricity = this.data.get(2);
        int maxElectricity = this.data.get(3);

        return maxElectricity != 0 && electricity != 0 ? electricity * 48 / maxElectricity : 0;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEnt.getBlockPos()), pPlayer, TekoraBlocks.CENTRIFUGE.get());
    }
}

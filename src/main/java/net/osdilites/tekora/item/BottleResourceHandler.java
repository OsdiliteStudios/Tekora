package net.osdilites.tekora.item;

import java.util.Objects;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.transfer.ItemAccessResourceHandler;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.item.ItemResource;

// TODO FIND ANOTHER BETTER FILE OR FOLDER TO PUT THIS CLASS IN
// BucketResourceHandler.java used as a basis for this
public final class BottleResourceHandler extends ItemAccessResourceHandler<FluidResource> {
    // TODO find a better place for this constant?
    final public static int BOTTLE_VOLUME = 333;
    
    public BottleResourceHandler(ItemAccess itemAccess) {
        super(itemAccess, 1);
    }
    
    @Override
    protected FluidResource getResourceFrom(ItemResource accessResource, int index) {
        if (accessResource.getItem() instanceof PotionItem) {
            ItemStack itemStack = accessResource.toStack();

            // TODO instead, have bottles for dynamically generated tekoraFluids, or disregard this note
            PotionContents potionContents = ((PotionContents)itemStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY)); 
            if (potionContents.is(Potions.WATER)) {
                return FluidResource.of(Fluids.WATER);
            } else {
                return FluidResource.EMPTY;
            }

        } else {
            return FluidResource.EMPTY;
        }
    }

    @Override
    protected int getAmountFrom(ItemResource accessResource, int index) {
        var resource = getResourceFrom(accessResource, index);
        return resource.isEmpty() ? 0 : BOTTLE_VOLUME;
    }

    @Override
    protected ItemResource update(ItemResource accessResource, int index, FluidResource newResource, int newAmount) {
        if (newAmount == 0) {
            return ItemResource.of(Items.GLASS_BOTTLE);
        } else if (newAmount != BOTTLE_VOLUME) {
            return ItemResource.EMPTY;
        } else {
            // var newStack = newResource.toStack(newAmount);
            // return ItemResource.of(newStack.getFluidType().getBucket(newStack));
            // TODO return the bottled fluid as a resource; may need to create or modify helper methods 

            ItemStack potStack = PotionContents.createItemStack(accessResource.getItem(), Potions.WATER);
            return ItemResource.of(potStack);
        }
    }

    @Override
    protected int getCapacity(int index, FluidResource resource) {
        Objects.checkIndex(index, size());
        return BOTTLE_VOLUME;
    }
}

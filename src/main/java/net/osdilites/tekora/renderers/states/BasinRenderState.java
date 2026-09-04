package net.osdilites.tekora.renderers.states;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public class BasinRenderState extends BlockEntityRenderState {
    public Level level;
    public ItemStackRenderState bucketIn;
    public ItemStackRenderState bucketOut;
    public ArrayList<ItemStackRenderState> items;
    // todo include a value for fluids
}

package net.osdilites.tekora.renderers.states;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.level.Level;

public class CrafterRenderState extends BlockEntityRenderState {
    public Level level;
    public double x = 0.5d;
    public double z = 0.5d;
    public final ItemStackRenderState input = new ItemStackRenderState();
    public final ItemStackRenderState output = new ItemStackRenderState();
}

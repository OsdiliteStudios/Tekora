package net.osdilites.tekora.renderers.states;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public class BasinRenderState extends BlockEntityRenderState {
    public Level level;
    public final ItemStackRenderState bucketIn = new ItemStackRenderState();
    public final ItemStackRenderState bucketOut = new ItemStackRenderState();
    public final ArrayList<ItemStackRenderState> items = new ArrayList<>();
    public TextureAtlasSprite fluidTexture;
    public int fluidClr = 0xFF_FFFFFF;
    public float filled = 0.f;
    // todo include a value for fluids

    public BasinRenderState() {
        this.items.ensureCapacity(11);
        for (int i = 0; i < 9; ++i) {
            this.items.add(new ItemStackRenderState());
        }
    }
}

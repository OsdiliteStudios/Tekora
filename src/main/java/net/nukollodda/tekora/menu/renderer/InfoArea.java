package net.nukollodda.tekora.menu.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.HoverEvent;

/*
 * BluSunrise
 * Copyright (c) 2021
 */
public abstract class InfoArea {
    protected final Rect2i area;

    public InfoArea(Rect2i pArea) {
        this.area = pArea;
    }

    public abstract void draw(PoseStack pTransform);
}

package net.nukollodda.tekora.block.models;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ChunkRenderTypeSet;
import net.minecraftforge.client.model.IDynamicBakedModel;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.client.model.geometry.IGeometryBakingContext;
import net.minecraftforge.client.model.pipeline.QuadBakingVertexConsumer;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.block.entity.blocks.connecters.AbstractConnector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static net.nukollodda.tekora.block.entity.blocks.connecters.AbstractConnector.ConnectorType.*;
import static net.nukollodda.tekora.block.models.CablePatterns.SpriteIdx.*;

/** Credit to Mcjty for most of the code in this class
 * */

public class CableBakedModel implements IDynamicBakedModel {
    private final IGeometryBakingContext context;
    private final boolean facade;

    private TextureAtlasSprite spriteConnector;
    private TextureAtlasSprite spriteNoneCable;
    private TextureAtlasSprite spriteNormalCable;
    private TextureAtlasSprite spriteEndCable;
    private TextureAtlasSprite spriteCornerCable;
    private TextureAtlasSprite spriteThreeCable;
    private TextureAtlasSprite spriteCrossCable;
    private TextureAtlasSprite spriteSide;

    static {
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(false, false, false, false), CablePatterns.QuadSetting.of(SPRITE_NONE, 0));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(true, false, false, false), CablePatterns.QuadSetting.of(SPRITE_END, 3));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(false, true, false, false), CablePatterns.QuadSetting.of(SPRITE_END, 0));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(false, false, true, false), CablePatterns.QuadSetting.of(SPRITE_END, 1));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(false, false, false, true), CablePatterns.QuadSetting.of(SPRITE_END, 2));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(true, true, false, false), CablePatterns.QuadSetting.of(SPRITE_CORNER, 0));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(false, true, true, false), CablePatterns.QuadSetting.of(SPRITE_CORNER, 1));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(false, false, true, true), CablePatterns.QuadSetting.of(SPRITE_CORNER, 2));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(true, false, false, true), CablePatterns.QuadSetting.of(SPRITE_CORNER, 3));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(false, true, false, true), CablePatterns.QuadSetting.of(SPRITE_STRAIGHT, 0));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(true, false, true, false), CablePatterns.QuadSetting.of(SPRITE_STRAIGHT, 1));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(true, true, true, false), CablePatterns.QuadSetting.of(SPRITE_THREE, 0));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(false, true, true, true), CablePatterns.QuadSetting.of(SPRITE_THREE, 1));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(true, false, true, true), CablePatterns.QuadSetting.of(SPRITE_THREE, 2));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(true, true, false, true), CablePatterns.QuadSetting.of(SPRITE_THREE, 3));
        CablePatterns.PATTERNS.put(CablePatterns.Pattern.of(true, true, true, true), CablePatterns.QuadSetting.of(SPRITE_CROSS, 0));
    }
    public CableBakedModel(IGeometryBakingContext context, boolean facade) {
        this.context = context;
        this.facade = facade;
    }

    private void initTextures() {
        if (spriteConnector == null) {
            spriteConnector = getTexture("block/cable/connector");
            spriteNormalCable = getTexture("block/cable/normal");
            spriteNoneCable = getTexture("block/cable/none");
            spriteEndCable = getTexture("block/cable/end");
            spriteCornerCable = getTexture("block/cable/corner");
            spriteThreeCable = getTexture("block/cable/three");
            spriteCrossCable = getTexture("block/cable/cross");
            spriteSide = getTexture("block/cable/side");
        }
    }

    private TextureAtlasSprite getTexture(String path) {
        return Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(new ResourceLocation(Tekora.MODID, path));
    }

    @Override
    public @NotNull List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull RandomSource rand, @NotNull ModelData extraData, @Nullable RenderType layer) {
        initTextures();
        List<BakedQuad> quads = new ArrayList<>();
        if (side == null && (layer == null || layer.equals(RenderType.solid()))) {
            AbstractConnector.ConnectorType north, south, west, east, up, down;
            if (state != null) {
                north = state.getValue(AbstractConnector.NORTH);
                south = state.getValue(AbstractConnector.SOUTH);
                west = state.getValue(AbstractConnector.WEST);
                east = state.getValue(AbstractConnector.EAST);
                up = state.getValue(AbstractConnector.UP);
                down = state.getValue(AbstractConnector.DOWN);
            } else {
                if (facade) {
                    quads.add(quad(v(0, 1, 1), v(1, 1, 1), v(1, 1, 0), v(0, 1, 0), spriteSide));
                    quads.add(quad(v(0, 0, 0), v(1, 0, 0), v(1, 0, 1), v(0, 0, 1), spriteSide));
                    quads.add(quad(v(1, 0, 0), v(1, 1, 0), v(1, 1, 1), v(1, 0, 1), spriteSide));
                    quads.add(quad(v(0, 0, 1), v(0, 1, 1), v(0, 1, 0), v(0, 0, 0), spriteSide));
                    quads.add(quad(v(0, 1, 0), v(1, 1, 0), v(1, 0, 0), v(0, 0, 0), spriteSide));
                    quads.add(quad(v(0, 0, 1), v(1, 0, 1), v(1, 1, 1), v(0, 1, 1), spriteSide));
                    return quads;
                }
                north = south = west = east = up = down = AbstractConnector.ConnectorType.NONE;
            }

            TextureAtlasSprite spriteCable = spriteNormalCable;
            Function<CablePatterns.SpriteIdx, TextureAtlasSprite> spriteGetter = this::getSpriteNormal;

            double o = .4;

            if (up == CABLE) {
                quads.add(quad(v(1 - o, 1, o), v(1 - o, 1, 1 - o), v(1 - o, 1 - o, 1 - o), v(1 - o, 1 - o, o), spriteCable));
                quads.add(quad(v(o, 1, 1 - o), v(o, 1, o), v(o, 1 - o, o), v(o, 1 - o, 1 - o), spriteCable));
                quads.add(quad(v(o, 1, o), v(1 - o, 1, o), v(1 - o, 1 - o, o), v(o, 1 - o, o), spriteCable));
                quads.add(quad(v(o, 1 - o, 1 - o), v(1 - o, 1 - o, 1 - o), v(1 - o, 1, 1 - o), v(o, 1, 1 - o), spriteCable));
            } else {
                CablePatterns.QuadSetting pattern = CablePatterns.findPattern(west, south, east, north);
                quads.add(quad(v(o, 1 - o, 1 - o), v(1 - o, 1 - o, 1 - o), v(1 - o, 1 - o, o), v(o, 1 - o, o), spriteGetter.apply(pattern.sprite()), pattern.rotation()));
            }

            if (down == CABLE) {
                quads.add(quad(v(1 - o, o, o), v(1 - o, o, 1 - o), v(1 - o, 0, 1 - o), v(1 - o, 0, o), spriteCable));
                quads.add(quad(v(o, o, 1 - o), v(o, o, o), v(o, 0, o), v(o, 0, 1 - o), spriteCable));
                quads.add(quad(v(o, o, o), v(1 - o, o, o), v(1 - o, 0, o), v(o, 0, o), spriteCable));
                quads.add(quad(v(o, 0, 1 - o), v(1 - o, 0, 1 - o), v(1 - o, o, 1 - o), v(o, o, 1 - o), spriteCable));
            } else {
                CablePatterns.QuadSetting pattern = CablePatterns.findPattern(west, north, east, south);
                quads.add(quad(v(o, o, o), v(1 - o, o, o), v(1 - o, o, 1 - o), v(o, o, 1 - o), spriteGetter.apply(pattern.sprite()), pattern.rotation()));
            }

            if (east == CABLE) {
                quads.add(quad(v(1, 1 - o, 1 - o), v(1, 1 - o, o), v(1 - o, 1 - o, o), v(1 - o, 1 - o, 1 - o), spriteCable));
                quads.add(quad(v(1, o, o), v(1, o, 1 - o), v(1 - o, o, 1 - o), v(1 - o, o, o), spriteCable));
                quads.add(quad(v(1, 1 - o, o), v(1, o, o), v(1 - o, o, o), v(1 - o, 1 - o, o), spriteCable));
                quads.add(quad(v(1, o, 1 - o), v(1, 1 - o, 1 - o), v(1 - o, 1 - o, 1 - o), v(1 - o, o, 1 - o), spriteCable));
            } else {
                CablePatterns.QuadSetting pattern = CablePatterns.findPattern(down, north, up, south);
                quads.add(quad(v(1 - o, o, o), v(1 - o, 1 - o, o), v(1 - o, 1 - o, 1 - o), v(1 - o, o, 1 - o), spriteGetter.apply(pattern.sprite()), pattern.rotation()));
            }

            if (west == CABLE) {
                quads.add(quad(v(o, 1 - o, 1 - o), v(o, 1 - o, o), v(0, 1 - o, o), v(0, 1 - o, 1 - o), spriteCable));
                quads.add(quad(v(o, o, o), v(o, o, 1 - o), v(0, o, 1 - o), v(0, o, o), spriteCable));
                quads.add(quad(v(o, 1 - o, o), v(o, o, o), v(0, o, o), v(0, 1 - o, o), spriteCable));
                quads.add(quad(v(o, o, 1 - o), v(o, 1 - o, 1 - o), v(0, 1 - o, 1 - o), v(0, o, 1 - o), spriteCable));
            } else {
                CablePatterns.QuadSetting pattern = CablePatterns.findPattern(down, south, up, north);
                quads.add(quad(v(o, o, 1 - o), v(o, 1 - o, 1 - o), v(o, 1 - o, o), v(o, o, o), spriteGetter.apply(pattern.sprite()), pattern.rotation()));
            }

            if (north == CABLE) {
                quads.add(quad(v(o, 1 - o, o), v(1 - o, 1 - o, o), v(1 - o, 1 - o, 0), v(o, 1 - o, 0), spriteCable));
                quads.add(quad(v(o, o, 0), v(1 - o, o, 0), v(1 - o, o, o), v(o, o, o), spriteCable));
                quads.add(quad(v(1 - o, o, 0), v(1 - o, 1 - o, 0), v(1 - o, 1 - o, o), v(1 - o, o, o), spriteCable));
                quads.add(quad(v(o, o, o), v(o, 1 - o, o), v(o, 1 - o, 0), v(o, o, 0), spriteCable));
            } else {
                CablePatterns.QuadSetting pattern = CablePatterns.findPattern(west, up, east, down);
                quads.add(quad(v(o, 1 - o, o), v(1 - o, 1 - o, o), v(1 - o, o, o), v(o, o, o), spriteGetter.apply(pattern.sprite()), pattern.rotation()));
            }

            if (south == CABLE) {
                quads.add(quad(v(o, 1 - o, 1), v(1 - o, 1 - o, 1), v(1 - o, 1 - o, 1 - o), v(o, 1 - o, 1 - o), spriteCable));
                quads.add(quad(v(o, o, 1 - o), v(1 - o, o, 1 - o), v(1 - o, o, 1), v(o, o, 1), spriteCable));
                quads.add(quad(v(1 - o, o, 1 - o), v(1 - o, 1 - o, 1 - o), v(1 - o, 1 - o, 1), v(1 - o, o, 1), spriteCable));
                quads.add(quad(v(o, o, 1), v(o, 1 - o, 1), v(o, 1 - o, 1 - o), v(o, o, 1 - o), spriteCable));
            } else {
                CablePatterns.QuadSetting pattern = CablePatterns.findPattern(west, down, east, up);
                quads.add(quad(v(o, o, 1 - o), v(1 - o, o, 1 - o), v(1 - o, 1 - o, 1 - o), v(o, 1 - o, 1 - o), spriteGetter.apply(pattern.sprite()), pattern.rotation()));
            }
        }
        return quads;
    }

    private TextureAtlasSprite getSpriteNormal(CablePatterns.SpriteIdx idx) {
        initTextures();
        return switch (idx) {
            case SPRITE_NONE -> spriteNoneCable;
            case SPRITE_END -> spriteEndCable;
            case SPRITE_STRAIGHT -> spriteNormalCable;
            case SPRITE_CORNER -> spriteCornerCable;
            case SPRITE_THREE -> spriteThreeCable;
            case SPRITE_CROSS -> spriteCrossCable;
        };
    }

    @Override
    public boolean useAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean usesBlockLight() {
        return false;
    }

    @Override
    public boolean isCustomRenderer() {
        return false;
    }

    @Override
    public ChunkRenderTypeSet getRenderTypes(@NotNull BlockState state, @NotNull RandomSource rand, @NotNull ModelData data) {
        return ChunkRenderTypeSet.all();
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return spriteNormalCable == null
                ? Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply((new ResourceLocation("minecraft", "missingno")))
                : spriteNormalCable;
    }

    @Override
    public ItemTransforms getTransforms() {
        return context.getTransforms();
    }

    @Override
    public ItemOverrides getOverrides() {
        return ItemOverrides.EMPTY;
    }


    public static BakedQuad quad(Vec3 v1, Vec3 v2, Vec3 v3, Vec3 v4, TextureAtlasSprite sprite, int rotation) {
        return switch (rotation) {
            case 1 -> quad(v2, v3, v4, v1, sprite);
            case 2 -> quad(v3, v4, v1, v2, sprite);
            case 3 -> quad(v4, v1, v2, v3, sprite);
            default -> quad(v1, v2, v3, v4, sprite);
        };
    }

    public static BakedQuad quad(Vec3 v1, Vec3 v2, Vec3 v3, Vec3 v4, TextureAtlasSprite sprite) {
        Vec3 normal = v3.subtract(v2).cross(v1.subtract(v2)).normalize();

        BakedQuad[] quad = new BakedQuad[1];
        QuadBakingVertexConsumer builder = new QuadBakingVertexConsumer(q -> quad[0] = q);
        builder.setSprite(sprite);
        builder.setDirection(Direction.getNearest(normal.x, normal.y, normal.z));
        putVertex(builder, normal, v1.x, v1.y, v1.z, 0, 0, sprite);
        putVertex(builder, normal, v2.x, v2.y, v2.z, 0, 16, sprite);
        putVertex(builder, normal, v3.x, v3.y, v3.z, 16, 16, sprite);
        putVertex(builder, normal, v4.x, v4.y, v4.z, 16, 0, sprite);
        return quad[0];
    }

    private static void putVertex(VertexConsumer builder, Position normal,
                                  double x, double y, double z, float u, float v,
                                  TextureAtlasSprite sprite) {
        float iu = sprite.getU(u);
        float iv = sprite.getV(v);
        builder.vertex(x, y, z)
                .uv(iu, iv)
                .uv2(0, 0)
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .normal((float) normal.x(), (float) normal.y(), (float) normal.z())
                .endVertex();
    }

    public static Vec3 v(double x, double y, double z) {
        return new Vec3(x, y, z);
    }
}

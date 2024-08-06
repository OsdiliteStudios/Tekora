package net.leng.tekora.block.models;

import net.leng.tekora.block.entity.blocks.connecters.AbstractConnector;

import java.util.HashMap;
import java.util.Map;

/** Code from mcjty's tutorials
 * */

public class CablePatterns {
    static final Map<Pattern, QuadSetting> PATTERNS = new HashMap<>();
    public static QuadSetting findPattern(AbstractConnector.ConnectorType s1, AbstractConnector.ConnectorType s2, AbstractConnector.ConnectorType s3, AbstractConnector.ConnectorType s4) {
        return PATTERNS.get(new Pattern(s1 != AbstractConnector.ConnectorType.NONE, s2 != AbstractConnector.ConnectorType.NONE, s3 != AbstractConnector.ConnectorType.NONE, s4 != AbstractConnector.ConnectorType.NONE));
    }

    public enum SpriteIdx {
        SPRITE_NONE,
        SPRITE_END,
        SPRITE_STRAIGHT,
        SPRITE_CORNER,
        SPRITE_THREE,
        SPRITE_CROSS
    }

    public record QuadSetting(SpriteIdx sprite, int rotation) {

        public static QuadSetting of(SpriteIdx sprite, int rotation) {
            return new QuadSetting(sprite, rotation);
        }
    }

    public record Pattern(boolean s1, boolean s2, boolean s3, boolean s4) {

        public static Pattern of(boolean s1, boolean s2, boolean s3, boolean s4) {
            return new Pattern(s1, s2, s3, s4);
        }
    }
}

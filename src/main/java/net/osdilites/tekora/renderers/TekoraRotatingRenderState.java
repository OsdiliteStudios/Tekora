package net.osdilites.tekora.renderers;

import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.List;

public class TekoraRotatingRenderState extends BlockEntityRenderState {
    public BlockState blockState;
    public int packedLight = 15728880; // todo, change based on light level of environment
    public List<BlockStateModelPart> parts;
    public List<BlockPos> partners;
    private float angle;

    public void setAngle(float angle) {
        this.angle = angle * 180 / (float)Math.PI;
    }

    public float getAngle() {
        return angle;
    }

    public Direction.Axis getAxis() {
        if (this.blockState != null) {
            if (this.blockState.hasProperty(BlockStateProperties.FACING)) {
                return this.blockState.getValue(BlockStateProperties.FACING).getAxis();
            } else if (this.blockState.hasProperty(BlockStateProperties.AXIS)) {
                return this.blockState.getValue(BlockStateProperties.AXIS);
            }
        }

        return Direction.Axis.Y;
    }
}

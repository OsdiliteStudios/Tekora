package net.tekoramods.tekora.block;

import net.minecraft.world.level.block.SimpleWaterloggedBlock;

public interface FluidloggedBlock extends SimpleWaterloggedBlock {
    // should be like waterlogging but compatible with most nonreactive non-metallic tekora fluids
    // second-prop - force inheritance should occur to all classes that implements SimpleWaterloggedBlock
}

package aor.type;

import mindustry.world.blocks.distribution.StackConveyor;


public class LiquidStackConveyor extends StackConveyor {
    public final int timerFlow = timers++;

    public LiquidStackConveyor(String name) {
        super(name);
        hasLiquids = true;

    }
        public class WeighLiquidStackConveyorBuild extends StackConveyor.StackConveyorBuild{
        @Override
        public void updateTile(){
            if(liquids.currentAmount() > 0.0001f && timer(timerFlow, 1)){
                moveLiquidForward(false, liquids.current());
            }
            super.updateTile();
        }
    }
}
package aor.type;

import aor.aorItems;
import arc.math.Mathf;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.meta.StatUnit;

import static aor.aorMod.*;

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
            if(lastItem != null) {
                if (lastItem.hardness == 1) {speed = 0.04f;}
                if (lastItem.hardness == 2) {speed = 0.032f;}
                if (lastItem.hardness == 3) {speed = 0.024f;}
                if (lastItem.hardness == 4) {speed = 0.016f;}
                if (lastItem.hardness == 5) {speed = 0.008f;}
            } else{speed = 1f;}

            super.updateTile();
        }
    }
}
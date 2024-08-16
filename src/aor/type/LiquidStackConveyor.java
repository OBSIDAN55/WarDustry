package aor.type;

import mindustry.world.blocks.distribution.StackConveyor;

public class LiquidStackConveyor extends StackConveyor {
    public LiquidStackConveyor(String name) {
        super(name);
        hasLiquids = true;
    }
    public class LiquidStackConveyorBuild extends StackConveyor.StackConveyorBuild{
        @Override
        public void updateTile(){
            if(liquids.currentAmount() > 0.01f){
                dumpLiquid(liquids.current());
            }
            super.updateTile();
        }
    }
}

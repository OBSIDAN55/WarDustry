package aor.type;

import mindustry.world.blocks.distribution.StackRouter;

public class WeighLiquidStackRouter extends StackRouter {
    public WeighLiquidStackRouter(String name) {
        super(name);
        hasLiquids = true;
    }
    public class WeighLiquidStackRouterBuild extends StackRouterBuild{
        @Override
        public void updateTile(){
            if(liquids.currentAmount() > 0.01f){
                dumpLiquid(liquids.current());
            }
            //if(current != null) {
            //    if (current.hardness == 1) {speed = 0.04f;}
            //    if (current.hardness == 2) {speed = 0.032f;}
            //    if (current.hardness == 3) {speed = 0.024f;}
            //    if (current.hardness == 4) {speed = 0.016f;}
            //    if (current.hardness == 5) {speed = 0.008f;}
            //} else{speed = 1f;}
            super.updateTile();
        }
    }
}

package aor.type;

import mindustry.world.blocks.distribution.StackRouter;

public class LiquidStackRouter extends StackRouter {
    public LiquidStackRouter(String name) {
        super(name);
        hasLiquids = true;
    }
    public class WeighLiquidStackRouterBuild extends StackRouterBuild{
        @Override
        public void updateTile(){
            if(liquids.currentAmount() > 0.01f){
                dumpLiquid(liquids.current());
            }
            super.updateTile();
        }
    }
}

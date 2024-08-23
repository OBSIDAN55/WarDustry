package aor.type;

import mindustry.world.blocks.distribution.Junction;

public class WeighLiquidJunction extends Junction {
    public final int timerFlow = timers++;
    public WeighLiquidJunction(String name) {
        super(name);
        hasLiquids = true;
        hasItems = true;
    }

    public class WeighLiquidJunctionBuild extends JunctionBuild {
        @Override
        public void updateTile() {
            if (liquids.currentAmount() > 0.01f && timer(timerFlow, 1)) {
                dumpLiquid(liquids.current());
                noSleep();
            }else {sleep();}
            super.updateTile();
        }
    }
}


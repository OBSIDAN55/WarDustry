package aor.type;

import mindustry.world.blocks.distribution.Junction;

public class WeighLiquidJunction extends Junction {
   // public final int timerFlow = timers++;
    public WeighLiquidJunction(String name) {
        super(name);
        hasLiquids = true;
        hasItems = true;
        update = true;
    }

    public class WeighLiquidJunctionBuild extends JunctionBuild {
        @Override
        public void updateTile() {
            update = true;
            if (liquids.currentAmount() > 0.0001f) {
                dumpLiquid(liquids.current());
                speed = 0.0001f;
            }else {speed = 40000f;}
            super.updateTile();
        }
    }
}


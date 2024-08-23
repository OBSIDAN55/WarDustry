package aor.type;

import mindustry.content.Liquids;
import mindustry.world.blocks.production.Drill;

public class OilDrill extends Drill {
    public OilDrill(String name){
        super(name);
    }
    public class OilDrillBuild extends DrillBuild {
        @Override
        public void updateTile() {
            if (liquids.get(Liquids.oil) > 0.01f) {
                dumpLiquid(Liquids.oil);
            }
            super.updateTile();
        }

    }
}

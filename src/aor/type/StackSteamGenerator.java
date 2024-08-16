package aor.type;

import mindustry.world.blocks.power.ConsumeGenerator;

public class StackSteamGenerator extends ConsumeGenerator {
    public StackSteamGenerator(String name) {
        super(name);
        hasLiquids = true;
    }
    public class StackSteamGeneratorBuild extends ConsumeGenerator.ConsumeGeneratorBuild{
        @Override
        public void updateTile(){
            if(liquids.currentAmount() > 0.01f){
                dumpLiquid(liquids.current());
            }
            super.updateTile();
        }
    }
}

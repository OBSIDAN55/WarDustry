package aor.type;

import mindustry.content.Fx;
import mindustry.entities.Damage;
import mindustry.world.blocks.production.HeatCrafter;
import mindustry.world.meta.Stat;

public class DamageHeatCrafter extends HeatCrafter{
    public float dmg;
    public DamageHeatCrafter(String name) {
        super(name);
        dmg = 100f;
        heatRequirement = 10f;
        maxEfficiency = 1f;
    }
    public void setStats(){
        super.setStats();
        stats.add(Stat.damage,"overheating = "+ (int)dmg +" damage");
    }
    public class DamageHeatCrafterBuild extends HeatCrafterBuild{
        public void updateTile(){
            if(progress >= 0.9f && heat > (maxEfficiency * heatRequirement + 0.999)){
                if(dmg > health){
                    kill();
                    breakEffect = Fx.blastExplosion;
                }else {
                    Damage.damage(x, y, 1, dmg);
                }
            }
            super.updateTile();
        }
    }
}

package aor.type;

import aor.aorItems;
import aor.audio.Sfx;
import arc.audio.Sound;
import arc.func.Boolf;
import arc.struct.EnumSet;
import mindustry.entities.Damage;
import mindustry.entities.Effect;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.world.blocks.heat.HeatBlock;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.consumers.Consume;
import mindustry.world.meta.*;
import mindustry.content.*;
import mindustry.gen.*;
import static aor.aorMod.*;

import static mindustry.Vars.*;

public class HeatNuclearReactor  extends HeatProducer {

    public int explosionRadius;
    public int explosionDamage;
    public Effect explodeEffect;
    public Sound explodeSound;
    public Sound startSound;

    public float explosionPuddleRange = tilesize * 2f;
    public float explosionPuddleAmount = 100f;
    public float explosionMinWarmup = 0f;

    public float explosionShake, explosionShakeDuration;


    public HeatNuclearReactor(String name) {
        super(name);
        craftTime = 2000f;
        itemCapacity = 10;
        hasItems = true;
        hasLiquids = true;
        rebuildable = false;
        flags = EnumSet.of(BlockFlag.reactor, BlockFlag.generator);
        schematicPriority = -5;



        envEnabled = Env.any;
        explosionShake = 6f;
        explosionShakeDuration = 16f;

        explosionRadius = 19;
        explosionDamage = 1250 * 4;

        explodeEffect = Fx.reactorExplosion;
        explodeSound = Sounds.explosionbig;

        startSound = Sfx.NucStart;
        rotateDraw = false;
        rotate = true;
        canOverdrive = false;
        drawArrow = true;
    }
    @Override
    public void setStats(){
        this.stats.add(Stat.size, "@x@", new Object[]{this.size, this.size});
        this.stats.add(Stat.health, (float)this.health, StatUnit.none);
        if (this.canBeBuilt() && this.requirements.length > 0) {
            this.stats.add(Stat.buildTime, this.buildCost / 60.0F, StatUnit.seconds);
            this.stats.add(Stat.buildCost, StatValues.items(false, this.requirements));
            if (this.hasLiquids) {
                this.stats.add(Stat.liquidCapacity, this.liquidCapacity, StatUnit.liquidUnits);
            }

            if (this.hasItems && this.itemCapacity > 0) {
                this.stats.add(Stat.itemCapacity, (float)this.itemCapacity, StatUnit.items);
            }
            if (this.hasItems && this.itemCapacity > 0 || this.outputItems != null) {
                this.stats.add(Stat.productionTime, this.craftTime / 60.0F, StatUnit.seconds);
            }
            Consume[] var1 = this.consumers;
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Consume c = var1[var3];
                c.display(this.stats);
            }
            if (this.outputLiquids != null) {
                this.stats.add(Stat.output, StatValues.liquids(1.0F, this.outputLiquids));
            }
            this.stats.add(Stat.output, 90, StatUnit.heatUnits);
            this.stats.add(or,"");
            this.stats.add(input2,aorItems.nuclearFuel);
            this.stats.add(output2, 120, StatUnit.heatUnits);

        }
    }
    @Override
    public void setBars(){
        super.setBars();
    }

    public class HeatNuclearReactorBuild extends HeatProducerBuild implements HeatBlock {
        @Override
        public void updateTile() {
            float cooler = liquids.get(Liquids.water);
            if (!items.empty() && cooler == 0) {
                if (heat < 120f) {
                    heat = heat + 0.4f;
                }
            }else if(!items.empty() && cooler > 0){
                if(heat > 91){
                    heat = heat - 0.5f;
                }
            }


            super.updateTile();
        }

        public void onDestroyed() {
            super.onDestroyed();
            Damage.damage(x, y, explosionRadius * tilesize, explosionDamage);
            explodeEffect.at(this);
            explodeSound.at(this);
            Effect.shake(explosionShake, explosionShakeDuration, this);
        }
    }
}

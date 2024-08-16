package aor.type;

import aor.audio.Sfx;
import arc.Core;
import arc.audio.Sound;
import arc.graphics.Color;
import arc.struct.EnumSet;
import mindustry.entities.Damage;
import mindustry.entities.Effect;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.blocks.heat.HeatBlock;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.draw.*;
import mindustry.world.meta.BlockFlag;
import mindustry.world.meta.Env;
import mindustry.content.*;
import mindustry.gen.*;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

import static arc.Core.assets;
import static mindustry.Vars.*;

public class HeatNuclearReactor  extends HeatProducer {

    public int act = 0;
    public int actt = 0;
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
        stats.add(Stat.output, "\uF828 ->");
        super.setStats();
        stats.add(Stat.output, "\uF828 ->");
        stats.add(Stat.output, 90, StatUnit.heatUnits );
    }
    @Override
    public void setBars(){
        super.setBars();
    }

    public class HeatNuclearReactorBuild extends HeatProducerBuild implements HeatBlock {
        @Override
        public void updateTile() {
            if(act == 0 && !items.empty()){
                act = 1;
                startSound.at(this);
            }
            if(items.empty()){
                act = 0;
            }
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

package aor.type;

import arc.Core;
import arc.Events;
import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.util.Eachable;
import arc.util.Nullable;
import arc.util.Strings;
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.units.BuildPlan;
import mindustry.game.EventType;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.type.LiquidStack;
import mindustry.ui.Bar;
import mindustry.world.blocks.heat.HeatConductor;
import mindustry.world.blocks.power.PowerGenerator;
import mindustry.world.consumers.ConsumeItemFilter;
import mindustry.world.consumers.ConsumeLiquidFilter;
import mindustry.world.draw.DrawBlock;
import mindustry.world.draw.DrawDefault;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

public class HeatRedirectorGenerator extends HeatConductor {


    public float itemDuration = 120f;

    public float warmupSpeed = 0.05f;
    public float effectChance = 0.01f;
    public Effect generateEffect = Fx.none, consumeEffect = Fx.none;
    public float generateEffectRange = 3f;

    public @Nullable LiquidStack outputLiquid;
    /** If true, this block explodes when outputLiquid exceeds capacity. */
    public boolean explodeOnFull = false;

    public @Nullable ConsumeItemFilter filterItem;
    public @Nullable ConsumeLiquidFilter filterLiquid;


    public float productionEfficiency;
    public float generateTime;
    public float powerProduction;
    public Stat generationType = Stat.basePowerGeneration;
    public DrawBlock drawer = new DrawDefault();

    public HeatRedirectorGenerator(String name){
        super(name);
        consumesPower = false;
        outputsPower = true;
        powerProduction = 1000f;
        update = true;
        solid = true;
        hasPower = true;
        group = BlockGroup.power;
    }

    @Override
    public void init(){
        filterItem = findConsumer(c -> c instanceof ConsumeItemFilter);
        filterLiquid = findConsumer(c -> c instanceof ConsumeLiquidFilter);

        if(outputLiquid != null){
            outputsLiquid = true;
            hasLiquids = true;
        }

        emitLight = true;
        lightRadius = 65f * size;
        super.init();
    }

    public float getDisplayedPowerProduction(){
        return powerProduction;
    }
    @Override
    public TextureRegion[] icons(){
        return drawer.finalIcons(this);
    }

    @Override
    public void load(){
        super.load();
        drawer.load(this);
    }




    @Override
    public void setStats(){
        super.setStats();
        stats.add(generationType, powerProduction * 60.0f, StatUnit.powerSecond);
    }

    @Override
    public void setBars(){
        super.setBars();

        if(hasPower && outputsPower){
            addBar("power", (HeatRedirectorGeneratorBuild entity) -> new Bar(() ->
                    Core.bundle.format("bar.poweroutput",
                            Strings.fixed(entity.getPowerProduction() * 60 * entity.timeScale(), 1)),
                    () -> Pal.powerBar,
                    () -> entity.productionEfficiency));
        }
    }

    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list){
        drawer.drawPlan(this, plan, list);
    }

    @Override
    public boolean outputsItems(){
        return false;
    }


    public class HeatRedirectorGeneratorBuild extends HeatConductorBuild{

        public float warmup, totalTime, efficiencyMultiplier = 1f;

        public float productionEfficiency;


        @Override
        public void updateEfficiencyMultiplier(){
            if(filterItem != null){
                float m = filterItem.efficiencyMultiplier(this);
                if(m > 0) efficiencyMultiplier = m;
            }else if(filterLiquid != null){
                float m = filterLiquid.efficiencyMultiplier(this);
                if(m > 0) efficiencyMultiplier = m;
            }
        }

        public void updateTile(){
           super.updateTile();

           if (heat!=0){
               efficiency *= heat/10f;
            }
            if(liquids.currentAmount() > 0.01f){
                dumpLiquid(liquids.current());
            }
            boolean valid = efficiency > 0;

            warmup = Mathf.lerpDelta(warmup, valid ? 1f : 0f, warmupSpeed);

            productionEfficiency = efficiency * efficiencyMultiplier;
            totalTime += warmup * Time.delta;

            //randomly produce the effect
            if(valid && Mathf.chanceDelta(effectChance)){
                generateEffect.at(x, y);
            }

            //take in items periodically
            if(hasItems && valid && generateTime <= 0f){
                consume();
                consumeEffect.at(x + Mathf.range(generateEffectRange), y + Mathf.range(generateEffectRange));
                generateTime = 1f;
            }

            if(outputLiquid != null){
                float added = Math.min(productionEfficiency * delta() * outputLiquid.amount, liquidCapacity - liquids.get(outputLiquid.liquid));
                liquids.add(outputLiquid.liquid, added);
                dumpLiquid(outputLiquid.liquid);

                if(explodeOnFull && liquids.get(outputLiquid.liquid) >= liquidCapacity - 0.01f){
                    kill();
                    Events.fire(new EventType.GeneratorPressureExplodeEvent(this));
                }
            }
        }

        @Override
        public boolean consumeTriggerValid(){
            return generateTime > 0;
        }

        @Override
        public float totalProgress(){
            return totalTime;
        }

        @Override
        public void draw(){
            drawer.draw(this);
        }

        @Override
        public float warmup(){
            return warmup;
        }

        @Override
        public void onDestroyed(){
            super.onDestroyed();
        }

        @Override
        public void drawLight(){
            super.drawLight();
            drawer.drawLight(this);
            Drawf.light(x, y, (60f + Mathf.absin(10f, 5f)) * size, Color.orange, 0.5f * warmup);
        }

        @Override
        public float ambientVolume(){
            return Mathf.clamp(productionEfficiency);
        }

        @Override
        public float getPowerProduction(){
            return enabled ? powerProduction * productionEfficiency : 0f;
        }

        @Override
        public byte version(){
            return 1;
        }

        public void write(Writes write){
            super.write(write);
            write.f(productionEfficiency);
            write.f(generateTime);
        }

        public void read(Reads read, byte revision){
            super.read(read, revision);
            productionEfficiency = read.f();
            if(revision >= 1){
                generateTime = read.f();
            }
        }
    }
}
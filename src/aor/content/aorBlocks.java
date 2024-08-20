package aor.content;

import aor.aorLiquids;
import aor.aorItems;
import aor.multicraft.IOEntry;
import aor.type.*;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.struct.Seq;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.RailBulletType;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.ShockMine;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.LiquidTurret;
import mindustry.world.blocks.distribution.StackRouter;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.heat.HeatConductor;
import mindustry.world.blocks.liquid.ArmoredConduit;
import mindustry.world.blocks.liquid.LiquidBridge;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BlockGroup;
import aor.multicraft.MultiCrafter;
import aor.multicraft.Recipe;


import static mindustry.gen.Sounds.flame;
import static mindustry.type.ItemStack.with;

public class aorBlocks {
    public static Block
    //production
    furnace, cokeBattery, blastFurnace, arcFurnace, press, moldingMachine, oilRig, oilPlatform, oilDistiller, oilRefinery, oxidativeReactor, lubricationPlant, baseAssembler,gasCentrifuge,
    //turrets
    flamethrower, miniGun, railGun, rocketLauncher,
    //power
    boiler,steamGenerator, nuclearReactor, heatExchanger, steamTurbine, solarPanel,fuelGenerator,
    ElectricTransmissionLine, substation, accumulator,
    //effect
    antiTankMine,
    //drills
    pneumaticDrill, keroseneDrill, gasolineDrill, dieselDrill, drillingRig,
    //distribution
    oilConveyor, oilRouter, gasolineConveyor, gasolineRouter, energyConveyor, energyRouter, liquidPipe, heatPipe, heatRouter, waterPump, pumpingStation, liquidTank, aboveGroundPipe,
    //cores
    coreCreation, coreDestruction,
    //environment
    boxiteOre, gematiteOre, leadOre, malachiteOre, sphaleriteOre, titaniumOre, wolframiteOre, uraniumOre, rockyGround;

    public static void load(){
        furnace = new MultiCrafter("furnace"){{
            requirements(Category.crafting, with(aorItems.gematiteItem, 50, aorItems.leadItem, 35));
            itemCapacity = 60;
            size = 3;
            resolvedRecipes = Seq.with(
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.gematiteItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.ironIngot, 1
                            );
                        }};
                        craftTime = 30f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.malachiteItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.copperIngot, 1
                            );
                        }};
                        craftTime = 30f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.leadItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.leadIngot, 1
                            );
                        }};
                        craftTime = 30f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.titaniumItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.titaniumIngot, 1
                            );
                        }};
                        craftTime = 30f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.aluminiumItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.aluminiumIngot, 1
                            );
                        }};
                        craftTime = 30f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.sphaleriteItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.zincIngot, 1
                            );
                        }};
                        craftTime = 30f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.wolframiteItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.wolframiteIngot, 1
                            );
                        }};
                        craftTime = 30f;
                    }}
            );
            craftEffect = aorFx.smoke;
        }};
        press = new MultiCrafter("press"){{
            requirements(Category.crafting, with(aorItems.ironIngot, 40, aorItems.leadIngot,30, aorItems.copperIngot,15));
            itemCapacity = 50;
            size = 3;
            resolvedRecipes = Seq.with(
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.gematiteItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.ironIngot, 1
                            );
                        }};
                        craftTime = 60f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.malachiteItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.copperIngot, 1
                            );
                        }};
                        craftTime = 60f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.leadItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.leadIngot, 1
                            );
                        }};
                        craftTime = 60f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.titaniumItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.titaniumIngot, 1
                            );
                        }};
                        craftTime = 60f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.aluminiumItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.aluminiumIngot, 1
                            );
                        }};
                        craftTime = 60f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.sphaleriteItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.zincIngot, 1
                            );
                        }};
                        craftTime = 60f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.wolframiteItem, 1,
                                    Items.coal, 2
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.wolframiteIngot, 1
                            );
                            craftTime = 60f;
                        }};
                    }}
            );
            craftEffect = Fx.pulverizeMedium;
        }};
        moldingMachine = new MultiCrafter("molding-machine"){{
            requirements(Category.crafting, with(aorItems.ironIngot, 100, aorItems.ironPlate, 30, aorItems.copperIngot, 120, aorItems.copperPlate, 20, aorItems.leadIngot, 40, aorItems.leadPlate, 35));
            itemCapacity = 50;
            size = 3;
            resolvedRecipes =Seq.with(
                    new Recipe(){{
                        input = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.ironIngot,1
                            );
                        }};
                        output = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.ironRod,1
                            );
                        }};
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.copperIngot,1
                            );
                        }};
                        output = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.copperWire,1
                            );
                        }};
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.steelItem,1
                            );
                        }};
                        output = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.steelRod,1
                            );
                        }};
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.wolframiteIngot,1
                            );
                        }};
                        output = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.wolframiteRod,1
                            );
                        }};
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.petcoke,1
                            );
                        }};
                        output = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.carbonElectrode,1
                            );
                        }};
                        craftTime = 60f;
                    }}
            );
            craftEffect = Fx.pulverizeMedium;
        }};
        baseAssembler = new MultiCrafter("base-assembler"){{
            requirements(Category.crafting, with(aorItems.ironIngot, 130, aorItems.ironPlate, 70, aorItems.copperIngot, 150, aorItems.copperPlate, 70,
                    aorItems.leadIngot, 70, aorItems.leadPlate, 95));
            itemCapacity = 10;
            size = 3;
            resolvedRecipes =Seq.with(
                    new Recipe(){{
                        input = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.ironPlate,5,
                                    aorItems.copperWire, 6,
                                    aorItems.steelRod, 1
                            );
                        }};
                        output = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.electricMotor,1
                            );
                        }};
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.uranium235, 1,
                                    aorItems.steelPlate,5
                            );
                        }};
                        output = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.nuclearFuel,2
                            );
                        }};
                        craftTime = 60f;
                    }}
            );
            craftEffect = Fx.pulverizeMedium;
        }};
        gasCentrifuge = new Separator("gas-centrifuge"){{
            requirements(Category.crafting, with(aorItems.bitumen, 125, aorItems.steelPlate, 100, aorItems.copperWire, 55, aorItems.wolframiteRod, 35, aorItems.ironRod, 65, aorItems.electricMotor, 20, aorItems.titaniumPlate, 80));
            results = with(
                aorItems.uranium235,1,
                    aorItems.uranium238, 35
            );
            hasLiquids = false;
            hasPower = true;
            craftTime = 135f;
            size = 4;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawPlasma(),
                    new DrawDefault()
            );

            consumePower(11f);
            consumeItem(aorItems.uranium,1);

        }};

        oilRefinery = new GenericCrafter("oilrefinery"){{
            requirements(Category.crafting, with( aorItems.aluminiumIngot, 40, aorItems.aluminiumPlate, 60,aorItems.ironIngot, 100,
                    aorItems.ironPlate, 50, aorItems.leadIngot, 65, aorItems.copperPlate, 40, aorItems.copperIngot, 30));
            size = 4;
            rotate = true;
            hasLiquids = true;
            hasPower = true;
            group = BlockGroup.liquids;
            liquidCapacity = 40;
            consumePower(20f);
            consumeLiquid(mindustry.content.Liquids.oil, 10);
            outputLiquids = LiquidStack.with(aorLiquids.heavyOil, 5f, aorLiquids.tightOil, 5f);
            craftTime = 20;
            updateEffect =Fx.none;
            liquidOutputDirections = new int[]{1,3};
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawLiquidOutputs()
            );
            craftEffect = aorFx.smoke;

        }};
        oilRig = new AttributeCrafter("oil-rig"){{
            requirements(Category.production, with(aorItems.aluminiumIngot, 30, aorItems.aluminiumPlate, 45,aorItems.ironIngot, 70,
                    aorItems.ironPlate, 45, aorItems.leadIngot, 55, aorItems.copperPlate, 30, aorItems.copperIngot, 20));
            size = 3;
            attribute = Attribute.oil;
            baseEfficiency = 0;
            minEfficiency = 1;
            consumePower(3f);
            consumeLiquid(aorLiquids.steam, 10);
            outputLiquid = new LiquidStack(mindustry.content.Liquids.oil, 10);
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(aorLiquids.pressure),
                    new DrawPistons(){{
                        sinMag = 2f;
                        sinScl = 5f;
                        sides = 8;
                        sideOffset = Mathf.PI / 2f;
                    }},
                    new DrawDefault(),
                    new DrawRegion("-rotator"){{
                        spinSprite = true;
                        rotateSpeed = -2;
                    }},
                    new DrawRegion("-top")
            );
        }};
        oilPlatform = new AttributeCrafter("oil-platform"){{
            requirements(Category.liquid, with(aorItems.aluminiumIngot, 120, aorItems.aluminiumPlate, 150,aorItems.ironIngot, 130,
                    aorItems.ironPlate, 250, aorItems.leadIngot, 165, aorItems.copperPlate, 200, aorItems.copperIngot, 150, aorItems.zincIngot, 50, aorItems.zincPlate, 40));
            size = 4;
            attribute = Attribute.get("tar");
            consumePower(3);
            consumeLiquid(aorLiquids.pressure, 10);
            outputLiquid = new LiquidStack(Liquids.oil, 1);
            craftTime = 60;
            floating = true;
            baseEfficiency = 0;
            minEfficiency = 1;
            displayEfficiencyScale = 1;
            displayEfficiency = true;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(aorLiquids.pressure),
                    new DrawPistons(){{
                        sinMag = 2;
                        sinScl = 5;
                        sides = 4;
                        sideOffset = Mathf.PI / 2f;
                    }},
                    new DrawDefault(),
                    new DrawRegion("-rotator"){{
                        spinSprite = true;
                        rotateSpeed = -2;
                    }},
                    new DrawRegion("-top")
            );

        }};
        oilDistiller = new GenericCrafter("oil-distiller"){{
            requirements(Category.crafting, with(aorItems.gematiteItem,1));
            size = 3;
            rotate = true;
            hasLiquids = true;
            hasPower = true;
            group = BlockGroup.liquids;
            liquidCapacity = 40;
            consumePower(20f);
            consumeLiquid(mindustry.content.Liquids.oil, 10);
            outputLiquids = LiquidStack.with(aorLiquids.kerosene, 5f, aorLiquids.gasoline, 6f, aorLiquids.diesel, 5f);
            craftTime = 30;
            updateEffect = aorFx.smoke;
            liquidOutputDirections = new int[]{1,2,3};
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawLiquidOutputs(),
                    new DrawGlowRegion()
            );
        }};
        lubricationPlant = new GenericCrafter("lubrication-plant"){{
            requirements(Category.crafting, with(aorItems.gematiteItem,1));
            size = 2;
            hasLiquids = true;
            hasPower = true;
            group = BlockGroup.liquids;
            liquidCapacity = 40;
            consumePower(20f);
            consumeLiquid(aorLiquids.tightOil, 10);
            outputLiquid = new LiquidStack(aorLiquids.lubricant, 5);
            craftTime = 60;
            updateEffect = Fx.none;
            drawer = new DrawMulti(
                    new DrawGlowRegion("-glow"),
                    new DrawDefault()
            );
        }};
        oxidativeReactor = new GenericCrafter("oxidative-reactor"){{
            requirements(Category.crafting, with(aorItems.gematiteItem,1));
            size = 2;
            hasLiquids = true;
            hasPower = true;
            group = BlockGroup.liquids;
            liquidCapacity = 40;
            consumePower(20f);
            consumeLiquid(aorLiquids.heavyOil, 10);
            outputItem = new ItemStack(aorItems.bitumen,5);
            craftTime = 60;

            updateEffect = aorFx.smoke;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(aorLiquids.heavyOil),
                    new DrawDefault()
            );
        }};
        arcFurnace = new GenericCrafter("arc-furnace"){{
            requirements(Category.crafting, with(aorItems.gematiteItem,1));
                size = 4;
                hasItems = true;
                hasPower = true;
                consumePower(40f);
                itemCapacity = 20;
                consumeItems(with(aorItems.ironIngot, 10, aorItems.carbonElectrode, 2));
                outputItem = new ItemStack(aorItems.steelItem, 6);
                craftTime = 30;
                updateEffect = Fx.none;
                craftEffect = aorFx.arcFurnaceSmoke;
        }};
        blastFurnace = new GenericCrafter("blast-furnace"){{
            requirements(Category.crafting, with(aorItems.gematiteItem,1));
            size = 3;
            hasItems = true;
            consumeItems(with(aorItems.ironIngot, 2, aorItems.petcoke, 1));
            outputItem = new ItemStack(aorItems.steelItem, 1);
            craftTime = 150;
            updateEffect = Fx.none;
            craftEffect = aorFx.smoke;
        }};
        cokeBattery = new GenericCrafter("coke-battery"){{
            requirements(Category.crafting, with(aorItems.gematiteItem,1));
            size = 3;
            hasLiquids = true;
            hasPower = true;
            group = BlockGroup.liquids;
            liquidCapacity = 40;
            craftTime = 60;
            consumeLiquid(aorLiquids.heavyOil, 10);
            outputItem = new ItemStack(aorItems.petcoke,5);
            updateEffect = Fx.none;
            craftEffect = aorFx.smoke;
        }};
        //distribution
        oilConveyor = new WeighLiquidStackConveyor("oil-conveyor"){{
            requirements(Category.distribution, with(aorItems.ironPlate, 5));
            speed = 1;
            itemCapacity = 30;
            liquidCapacity = 20;
            consumeLiquid(mindustry.content.Liquids.oil, 0.2f/60f);
        }};
        oilRouter = new WeighLiquidStackRouter("oil-router"){{
            requirements(Category.distribution, with(aorItems.ironPlate, 10));
            health = 130;
            liquidCapacity = 20;
            consumeLiquid(mindustry.content.Liquids.oil, 0.2f/60f);
            speed = 6f;
            underBullets = true;
            solid = false;
        }};
        gasolineConveyor = new WeighLiquidStackConveyor("gasoline-conveyor"){{
            requirements(Category.distribution, with(aorItems.ironPlate, 5, aorItems.steelPlate, 5 ));
            speed = 0.2f;
            itemCapacity = 20;
            liquidCapacity = 60;
            consumeLiquid(aorLiquids.gasoline, 1.5f/60f);
        }};
        gasolineRouter = new WeighLiquidStackRouter("gasoline-router"){{
            requirements(Category.distribution, with(aorItems.ironPlate, 10, aorItems.steelPlate, 10));
            health = 130;
            liquidCapacity = 20;
            consumeLiquid(aorLiquids.gasoline, 1.5f/60f);
            speed = 6f;
            underBullets = true;
            solid = false;
        }};
        energyConveyor = new WeighStackConveyor("energy-conveyor"){{
            requirements(Category.distribution, with(aorItems.steelPlate, 5, aorItems.electricMotor,5));
            speed = 0.3f;
            itemCapacity = 50;
            outputRouter = false;
            hasPower = true;
            consumesPower = true;
            conductivePower = true;
            underBullets = true;
            baseEfficiency = 0;
            consumePower(3/60f);
        }};
        energyRouter = new StackRouter("energy-router"){{
            requirements(Category.distribution, with(aorItems.steelPlate, 10, aorItems.electricMotor,10));
            health = 130;
            speed = 6f;
            hasPower = true;
            consumesPower = true;
            conductivePower = true;
            baseEfficiency = 1f;
            underBullets = true;
            solid = false;
            consumePower(1);
        }};
        heatPipe = new HeatConductor("heat-pipe"){{
            requirements(Category.power, with(aorItems.copperPlate,25));
            researchCostMultiplier = 10f;
            group = BlockGroup.heat;
            size = 1;
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput(), new DrawHeatInput("-heat"));
            regionRotated1 = 1;
        }};
        heatRouter = new HeatConductor("heat-router"){{
            requirements(Category.power, with(aorItems.copperPlate,30));
            researchCostMultiplier = 10f;
            group = BlockGroup.heat;
            size = 1;
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput(-1, false), new DrawHeatOutput(), new DrawHeatOutput(1, false), new DrawHeatInput("-heat"));
            regionRotated1 = 1;
            splitHeat = true;
        }};
        waterPump = new AttributeCrafter("water-pump"){{
            requirements(Category.liquid, with(aorItems.aluminiumIngot, 120, aorItems.aluminiumPlate, 150,aorItems.ironIngot, 130,
                    aorItems.ironPlate, 250, aorItems.leadIngot, 165, aorItems.copperPlate, 200, aorItems.copperIngot, 150, aorItems.zincIngot, 50, aorItems.zincPlate, 40));
            size = 3;
            attribute = Attribute.get("water");
            outputLiquid = new LiquidStack(Liquids.water, 1);
            craftTime = 60;
            floating = true;
            baseEfficiency = 0;
            minEfficiency = 1;
            displayEfficiencyScale = 1;
            displayEfficiency = true;
        }};
        pumpingStation = new AttributeCrafter("pumping-station"){{
            requirements(Category.liquid, with(aorItems.aluminiumIngot, 120, aorItems.aluminiumPlate, 150,aorItems.ironIngot, 130,
                    aorItems.ironPlate, 250, aorItems.leadIngot, 165, aorItems.copperPlate, 200, aorItems.copperIngot, 150, aorItems.zincIngot, 50, aorItems.zincPlate, 40));
            size = 4;
            attribute = Attribute.get("water");
            outputLiquid = new LiquidStack(Liquids.water, 1);
            craftTime = 20;
            floating = true;
            baseEfficiency = 0;
            minEfficiency = 1;
            displayEfficiencyScale = 1;
            displayEfficiency = true;
        }};
        liquidPipe = new ArmoredConduit("liquid-pipe"){{
            requirements(Category.liquid, with(aorItems.ironPlate, 5, aorItems.leadPlate, 5));
            liquidCapacity = 16f;
            liquidPressure = 1.025f;
            health = 220;
        }};
        liquidTank = new LiquidRouter("liquid-tank"){{
            requirements(Category.liquid, with(aorItems.ironPlate, 500, aorItems.steelPlate,100));
            size = 3;
            solid = true;
            liquidCapacity = 2000f;
            health = 500;
        }};
        aboveGroundPipe = new LiquidBridge("above-ground-pipe"){{
            requirements(Category.liquid, with(aorItems.ironPlate, 10, aorItems.leadPlate, 5));
            fadeIn = moveArrows = false;
            arrowSpacing = 6f;
            range = 6;
            hasPower = false;
        }};
        //drills
        pneumaticDrill = new Drill("pneumatic-drill"){{
            requirements(Category.production, with(aorItems.ironIngot, 20,aorItems.copperPlate, 10));
            drillTime = 280;
            size = 2;
            tier = 4;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;
            consumeLiquid(mindustry.content.Liquids.water, 0.06f).boost();
        }};
        keroseneDrill = new Drill("kerosene-drill"){{
            requirements(Category.production, with(aorItems.ironIngot, 25,aorItems.copperPlate, 15, aorItems.aluminiumIngot, 10, aorItems.leadPlate, 15));
            drillTime = 280;
            size = 3;
            tier = 2;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;
            consumeLiquid(aorLiquids.kerosene, 0.5f / 60f);
            consumeLiquid(mindustry.content.Liquids.water, 3f / 60f).boost();
        }};
        gasolineDrill = new Drill("gasoline-drill"){{
            requirements(Category.production, with(aorItems.ironIngot, 50,aorItems.copperPlate, 30, aorItems.aluminiumIngot, 30, aorItems.leadPlate, 20, aorItems.steelPlate, 60, aorItems.ironRod, 30));
            drillTime = 280;
            size = 4;
            tier = 3;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;
            consumeLiquid(aorLiquids.gasoline, 0.5f / 60f);
            consumeLiquid(mindustry.content.Liquids.water, 3f / 60f).boost();
        }};
        dieselDrill = new Drill("diesel-drill"){{
            requirements(Category.production, with(aorItems.ironIngot, 150,aorItems.copperPlate, 100, aorItems.aluminiumIngot, 100, aorItems.leadPlate, 65, aorItems.steelPlate, 120, aorItems.titaniumPlate, 60, aorItems.ironRod, 50));
            drillTime = 280;
            size = 5;
            tier = 4;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;
            consumeLiquid(aorLiquids.diesel, 0.5f / 60f);
            consumeLiquid(mindustry.content.Liquids.water, 3f / 60f).boost();
        }};
        drillingRig = new WallCrafter("drilling-rig"){{
            requirements(Category.production, with(aorItems.ironIngot, 200,aorItems.copperPlate, 30, aorItems.aluminiumIngot, 30, aorItems.leadPlate, 20));
            consumePower(11 / 60f);
            drillTime = 50f;
            size = 3;
            attribute = Attribute.sand;
            output = Items.sand;
            fogRadius = 2;
            researchCost = with(aorItems.gematiteItem,1);
            ambientSound = Sounds.drill;
            ambientSoundVolume = 0.04f;
        }};
        //effect
        antiTankMine = new ShockMine("anti-tank-mine"){{
            requirements(Category.production, with(aorItems.ironPlate,10, aorItems.petcoke, 20));
            hasShadow = false;
            size = 2;
            health = 260;
            damage = 400;
            tileDamage = 300;
            bullet = new BombBulletType(){{
                speed = 0;
                lifetime = 1;
                hittable = false;
                splashDamage = 200;
                splashDamageRadius = 50;
                damage = 0;
                status = StatusEffects.unmoving;
                statusDuration = 600;
                incendAmount = 2;
                incendChance = 0.8f;
                makeFire = false;
                hitEffect = new ExplosionEffect(){{
                    waveColor = Color.valueOf("00000000");
                    smokeColor = Color.valueOf("808080");
                    sparkColor = Color.valueOf("808080");
                    waveLife = 0;
                    waveStroke = 0;
                    waveRad = 0;
                    waveRadBase = 0;
                    sparkStroke = 3;
                    sparkRad = 60;
                    sparkLen = 7;
                    smokeSize = 15;
                    smokeSizeBase = 2;
                    smokeRad = 60;
                    smokes = 20;
                    sparks = 10;
                    lifetime = 90;
                }};
            }};
        }};
        //environment, ores
        boxiteOre = new OreBlock("boxite-ore"){{
           itemDrop = aorItems.aluminiumItem;
           variants = 1;
           wallOre = false;
           oreDefault = true;
        }};
        gematiteOre = new OreBlock("gematite-ore"){{
            itemDrop = aorItems.gematiteItem;
            variants = 4;
            wallOre = false;
            oreDefault = true;
        }};
        leadOre = new OreBlock("lead-ore"){{
            itemDrop = aorItems.leadItem;
            variants = 4;
            wallOre = false;
            oreDefault = true;
        }};
        malachiteOre = new OreBlock("malachite-ore"){{
            itemDrop = aorItems.malachiteItem;
            variants = 4;
            wallOre = false;
            oreDefault = true;
        }};
        sphaleriteOre = new OreBlock("sphalerite-ore"){{
            itemDrop = aorItems.sphaleriteItem;
            variants = 4;
            wallOre = false;
            oreDefault = true;
        }};
        titaniumOre = new OreBlock("titanium-ore"){{
            itemDrop = aorItems.titaniumItem;
            variants = 4;
            wallOre = false;
            oreDefault = true;
        }};
        wolframiteOre = new OreBlock("wolframite-ore"){{
            itemDrop = aorItems.wolframiteItem;
            variants = 4;
            wallOre = false;
            oreDefault = true;
        }};
        uraniumOre = new OreBlock("uranium-ore"){{
            itemDrop = aorItems.uranium;
            variants = 4;
            wallOre = false;
            oreDefault = true;
        }};
        //power
        nuclearReactor = new HeatNuclearReactor("nuclear-reactor"){{
            requirements(Category.power, with(aorItems.bitumen, 1250, aorItems.steelPlate, 1000, aorItems.copperWire, 565, aorItems.wolframiteRod, 345, aorItems.ironRod, 475, aorItems.electricMotor, 50, aorItems.titaniumPlate, 650));
            size = 8;
            itemCapacity = 10;
            consumeItem(aorItems.nuclearFuel, 1);
            hasLiquids = true;
            consumeLiquid(Liquids.water,4.2f);
            outputLiquid = new LiquidStack(aorLiquids.steam, 4);
            heatOutput = 120f;
            explosionPuddleRange = 7;
            explosionPuddleAmount = 200;
            explosionMinWarmup = 0.5f;
            explosionRadius = 65;
            warmupRate = 0.1f;
            explosionDamage = 30000;
            explosionShake = 4;
            craftTime = 2000f;
            explodeEffect = Fx.massiveExplosion;
            ambientSoundVolume = 1f;
            ignoreLiquidFullness = true;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawHeatOutput(){{
                        heatPulse = 0.3f;
                        heatPulseScl = 10f;
                        glowMult = 1.2f;
                        rotOffset = 0;
                        drawGlow = true;
                    }},
                    new DrawGlowRegion("-glow"){{
                        color = Color.cyan;
                        layer = 110;
                    }});
        }};
        steamGenerator = new StackSteamGenerator("steam-generator"){{
            requirements(Category.power, with(aorItems.gematiteItem,1));
            powerProduction = 800/60f;
            consumeLiquid(aorLiquids.steam, 1f);
            hasLiquids = true;
            liquidCapacity = 150f;
            size = 3;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawRegion("-rotator"){{
                        spinSprite = true;
                        rotateSpeed = -35;
                    }});
            effectChance = 0.4f;
            generateEffect = aorFx.steam;
        }};
         boiler = new GenericCrafter("boiler"){{
             requirements(Category.power, with(aorItems.gematiteItem, 1));
             size = 3;
             hasLiquids = true;
             liquidCapacity = 40;
             itemCapacity = 60;
             consumeItem(Items.coal, 3);
             consumeLiquid(Liquids.water, 120/60f);
             outputLiquid = new LiquidStack(aorLiquids.steam, 1.5f);
             craftTime = 120;
             updateEffect = Fx.none;
         }};
         heatExchanger = new DamageHeatCrafter("heat-exchanger"){{
             requirements(Category.power, with(aorItems.gematiteItem,1));
             health = 1340;
             size = 3;
             rotate = true;
             invertFlip = true;
             heatRequirement = 30f;
             craftTime = 120f;
             liquidCapacity = 40;
             maxEfficiency = 1f;
             dmg = 400f;
             drawer = new DrawMulti(new DrawGlowRegion("-glow"), new DrawDefault(), new DrawHeatInput(),new DrawLiquidOutputs());

             outputLiquids = LiquidStack.with(aorLiquids.steam, 2);
             liquidOutputDirections = new int[]{4};
             regionRotated1 = 3;
             consumeLiquid(Liquids.water, 2f);
             drawArrow = false;
         }};

         steamTurbine = new HeatRedirectorGenerator("steam-turbine"){{
             requirements(Category.power, with(Items.tungsten, 10, Items.graphite, 10));
             researchCostMultiplier = 10f;
             size = 3;
             regionRotated1 = 1;
             powerProduction = 800/60f;
             consumeLiquid(aorLiquids.steam, 1f);
             hasLiquids = true;
             liquidCapacity = 150f;
             size = 3;
             ambientSound = Sounds.smelter;
             ambientSoundVolume = 0.06f;
             drawer = new DrawMulti(
                     new DrawDefault(),
                     new DrawHeatOutput(),
                     new DrawHeatInput("-heat")
                     //new DrawRegion("-rotator"){{
                     //    spinSprite = true;
                     //    rotateSpeed = -35;
                     //}}
             );
             //effectChance = 0.4f;
             //generateEffect = aorFx.steam;
         }};
        //turrets
        flamethrower = new LiquidTurret("flamethrower"){{
            requirements(Category.turret, with(aorItems.gematiteItem,1));
                ammo(
                        aorLiquids.heavyOil, new BulletType(4.5f, 100){{
                            hitSize = 12;
                            pierce = true;
                            pierceBuilding = true;
                            pierceCap = 4;
                            lifetime = 33.333333333f;
                            hitEffect = Fx.none;
                            despawnEffect = Fx.none;
                            hittable = false;
                            keepVelocity = false;
                        }},
                        aorLiquids.tightOil, new BulletType(4.5f, 100){{
                            hitSize = 12;
                            pierce = true;
                            pierceBuilding = true;
                            pierceCap = 4;
                            lifetime = 33.333333333f;
                            hitEffect = Fx.none;
                            despawnEffect = Fx.none;
                            hittable = false;
                            keepVelocity = false;
                        }},
                        aorLiquids.kerosene, new BulletType(4.5f, 100){{
                            hitSize = 12;
                            pierce = true;
                            pierceBuilding = true;
                            pierceCap = 4;
                            lifetime = 33.333333333f;
                            hitEffect = Fx.none;
                            despawnEffect = Fx.none;
                            hittable = false;
                            keepVelocity = false;
                        }},
                        aorLiquids.gasoline, new BulletType(4.5f, 100){{
                            hitSize = 12;
                            pierce = true;
                            pierceBuilding = true;
                            pierceCap = 4;
                            lifetime = 33.333333333f;
                            hitEffect = Fx.none;
                            despawnEffect = Fx.none;
                            hittable = false;
                            keepVelocity = false;
                        }},
                        aorLiquids.diesel, new BulletType(4.5f, 100){{
                            hitSize = 12;
                            pierce = true;
                            pierceBuilding = true;
                            pierceCap = 4;
                            lifetime = 33.333333333f;
                            hitEffect = Fx.none;
                            despawnEffect = Fx.none;
                            hittable = false;
                            keepVelocity = false;
                        }}
                );

                recoil = 0;
                reload = 6;
                coolantMultiplier = 1.5f;
                range = 150;
                shootY = 3;
                size = 2;
                shootCone = 50;
                targetAir = false;
                ammoUseEffect = Fx.none;
                health = 400;
                shootSound = flame;
                shootEffect = new ParticleEffect(){{
                    particles = 20;
                    cone = 6;
                    length = 200;
                    sizeFrom = 4;
                    sizeTo = 1;
                    colorFrom = Color.valueOf("db401c");
                    colorTo = Color.valueOf("ffdd55");
                    lifetime = 100;
                    layer = 120;

                    drawer = new DrawTurret(){{
                        parts.add(new RegionPart("-bottom"){{
                            progress = PartProgress.warmup;
                            mirror = false;
                            under = true;
                            y = 4;
                            moveY = -4;
                        }},
                                new RegionPart("-side-l"){{
                                    progress = PartProgress.warmup;
                                    mirror = false;
                                    under = false;
                                    y = 0;
                                    x = 1.1f;
                                    moveX = -1.6f;
                                    moveY = -1.5f;
                                    moveRot = 15;
                                }},
                                new RegionPart("-side-r"){{
                                    progress = PartProgress.warmup;
                                    mirror = false;
                                    under = false;
                                    y = 0;
                                    x = -1.1f;
                                    moveX = 1.6f;
                                    moveY = -1.5f;
                                    moveRot = -15;
                                }}
                        );
                        }};
                    }};
                }};
        miniGun = new ItemTurret("minigun"){{
            requirements(Category.turret, with(Items.copper, 1));
                size = 2;
                reload = 6;
                recoil = 0.1f;
                range = 400;
                ammo(
                        Items.copper, new BasicBulletType(20f,10f){{
               drag = 0.01f;
               width = 5;
               height = 7;
               lifetime = 20;
               hitSize = 4;
               trailLength = 5;
               trailWidth = 1.7f;
               despawnEffect = Fx.hitBulletColor;
               inaccuracy = 5;
            }},
                        Items.thorium, new BasicBulletType(20f,13f){
                            {
                                drag = 0.01f;
                                width = 5;
                                height = 7;
                                lifetime = 20;
                                hitSize = 4;
                                trailLength = 5;
                                trailWidth = 1.7f;
                                despawnEffect = Fx.hitBulletColor;
                                inaccuracy = 5;
                                status = StatusEffects.melting;
                            }},
                        Items.graphite, new BasicBulletType(23f,15f){
                            {
                                drag = 0.01f;
                                width = 5;
                                height = 7;
                                lifetime = 17.39f;
                                hitSize = 4;
                                trailLength = 5;
                                trailWidth = 1.7f;
                                despawnEffect = Fx.hitBulletColor;
                                inaccuracy = 4;
                                status = StatusEffects.melting;
                            }},
                        Items.silicon, new BasicBulletType(26f,15f){
                            {
                                drag = 0.01f;
                                width = 5;
                                height = 7;
                                lifetime = 15.38f;
                                hitSize = 4;
                                trailLength = 5;
                                trailWidth = 1.7f;
                                reloadMultiplier = 1.5f;
                                despawnEffect = Fx.hitBulletColor;
                                inaccuracy = 2;
                                status = StatusEffects.melting;
                            }}
                        );
        }};
        railGun = new ItemTurret("railgun"){{
            requirements(Category.turret, with(Items.copper, 1));
            ammo(
                    aorItems.steelRod, new RailBulletType(){{
                        shootEffect = Fx.railShoot;
                        length = 500;
                        pointEffectSpace = 60;
                        pierceEffect = Fx.railHit;
                        pointEffect = Fx.railTrail;
                        hitEffect = Fx.massiveExplosion;
                        smokeEffect = Fx.shootBig2;
                        damage = 600;
                        pierceDamageFactor = 0.5f;
                    }},
                    aorItems.wolframiteRod, new RailBulletType(){{
                        shootEffect = Fx.railShoot;
                        length = 500;
                        pointEffectSpace = 60;
                        pierceEffect = Fx.railHit;
                        pointEffect = Fx.railTrail;
                        hitEffect = Fx.massiveExplosion;
                        smokeEffect = Fx.shootBig2;
                        damage = 1500;
                        pierceDamageFactor = 0.5f;
                    }}
            );

        }};
        //rocketLauncher = new ItemTurret("rocket-launcher"){{
        //    requirements(Category.turret, with(Items.copper, 1));
        //    shoot = new ShootPattern(){{
        //       shotDelay = 30;
        //       shots = 5;
        //    }};
        //    ammo(
        //            Items.copper, new BulletType(){{
        //                //доделай блять
        //            }}
        //    );
        //}};
        //multicrafters

        //cores
        coreDestruction = new CoreBlock("coreDestruction"){{
            requirements(Category.production, with(Items.copper, 1));
             alwaysUnlocked = true;
             isFirstTier = true;
             unitType = aorUnits.mig24;
             health = 1100;
             itemCapacity = 4500;
             size = 3;
             unitCapModifier = 15;

        }};
        coreCreation = new CoreBlock("coreCreation"){{
            requirements(Category.production, with(Items.copper, 1));
            unitType = aorUnits.mig24;
            rotate = true;
            health = 3500;
            itemCapacity = 10000;
            size = 4;
            thrusterLength = 8.5f;
            unitCapModifier = 30;
            researchCostMultiplier = 0.07f;
            placeablePlayer = true;
            offset = 10;
        }};
    }
}
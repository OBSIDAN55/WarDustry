package aor.content;

import aor.aorLiquids;
import aor.aorItems;
import aor.multicraft.IOEntry;
import aor.type.*;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.struct.Seq;
import mindustry.content.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.RailBulletType;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.defense.ShockMine;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.LiquidTurret;
import mindustry.world.blocks.distribution.DirectionalUnloader;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.distribution.StackRouter;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.heat.HeatConductor;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.blocks.liquid.ArmoredConduit;
import mindustry.world.blocks.liquid.LiquidBridge;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.units.UnitAssembler;
import mindustry.world.blocks.units.UnitFactory;
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
    furnace, electricFurnace, cokeBattery, blastFurnace, arcFurnace, press, moldingMachine, oilRig, oilPlatform,
    keroseneExtractor,gasolineExtractor,dieselExtractor, oilRefinery, oxidativeReactor,
    lubricationPlant, baseAssembler,gasCentrifuge, electricHeater, macerator,
    //turrets
    flamethrower, miniGun, railGun, rocketLauncher,
    //power
    boiler,steamGenerator, nuclearReactor, heatExchanger, steamTurbine, solarPanel,fuelGenerator,
    electricTransmissionLine, substation, zincBattery,
    //effect
    antiTankMine,
    //drills
    pneumaticDrill, keroseneDrill, gasolineDrill, dieselDrill, drillingRig,
    //distribution
    oilConveyor, oilRouter, oilJunction,gasolineConveyor, gasolineRouter, gasolineJunction, energyConveyor, energyRouter, energyJunction, oilUnloader, oilItemBridge,
    waterPump, pumpingStation, liquidTank, aboveGroundPipe, liquidPipe, liquidRouter,
    heatPipe, heatRouter,
    //cores
    coreCreation, coreDestruction,
    //environment
    boxiteOre, gematiteOre, leadOre, malachiteOre, sphaleriteOre, titaniumOre, wolframiteOre, uraniumOre, rockyGround,
    //walls
    stoneWall, ironWall, ironBitumenWall, steelWall, titaniumWall, titaniumTungstenWall,
    bigStoneWall, bigIronWall, bigIronBitumenWall, bigSteelWall, bigTitaniumWall, bigTitaniumTungstenWall,
    //units
    sovietTankFabricator, sovietTankAssembler,
    engine, t90Turret, t14Turret;

    public static void load(){
        furnace = new MultiCrafter("furnace"){{
            requirements(Category.crafting, with(aorItems.rock, 15));
            itemCapacity = 100;
            size = 3;
            resolvedRecipes = Seq.with(
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.gematiteItem, 1,
                                    Items.coal, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.ironIngot, 1
                            );
                        }};
                        craftTime = 100f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.malachiteItem, 1,
                                    Items.coal, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.copperIngot, 1
                            );
                        }};
                        craftTime = 100f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.leadItem, 1,
                                    Items.coal, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.leadIngot, 1
                            );
                        }};
                        craftTime = 100f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.aluminiumItem, 1,
                                    Items.coal, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.aluminiumIngot, 1
                            );
                        }};
                        craftTime = 100f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.sphaleriteItem, 1,
                                    Items.coal, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.zincIngot, 1
                            );
                        }};
                        craftTime = 120f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.titaniumItem, 1,
                                    Items.coal, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.titaniumIngot, 1
                            );
                        }};
                        craftTime = 150f;
                    }},


                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.wolframiteItem, 1,
                                    Items.coal, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.wolframiteIngot, 1
                            );
                        }};
                        craftTime = 175f;
                    }}
            );
            updateEffect = aorFx.smoke;
        }};
        macerator = new GenericCrafter("macerator"){{
            requirements(Category.crafting, with(Items.copper, 30, Items.lead, 25));
            size = 2;
            outputItem = new ItemStack(Items.sand, 1);
            craftEffect = Fx.pulverize;
            craftTime = 40f;
            updateEffect = Fx.pulverizeSmall;
            hasItems = hasPower = true;
            drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-rotator"){{
                spinSprite = true;
                rotateSpeed = 2f;
            }});
            ambientSound = Sounds.grinding;
            ambientSoundVolume = 0.025f;

            consumeItem(aorItems.rock, 1);
            consumePower(0.50f);
        }};
        press = new MultiCrafter("press"){{
            requirements(Category.crafting, with(aorItems.ironIngot, 15, aorItems.leadIngot,10));
            itemCapacity = 100;
            size = 3;
            resolvedRecipes = Seq.with(
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.rock, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.stoneBlock, 1
                            );
                        }};
                        craftTime = 150f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.ironIngot, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.ironPlate, 2
                            );
                        }};
                        craftTime = 150f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.copperIngot, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.copperPlate, 2
                            );
                        }};
                        craftTime = 150f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.leadIngot, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.leadPlate, 2
                            );
                        }};
                        craftTime = 150f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.aluminiumIngot, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.aluminiumPlate, 2
                            );
                        }};
                        craftTime = 150f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.zincIngot, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.zincPlate, 2
                            );
                        }};
                        craftTime = 150f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.titaniumIngot, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.titaniumPlate, 2
                            );
                        }};
                        craftTime = 250f;
                    }},

                    new Recipe(){{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.steelItem, 1
                            );
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.steelPlate, 2
                            );
                        }};
                        craftTime = 300f;
                    }}
            );
            craftEffect = Fx.pulverizeMedium;
        }};
        moldingMachine = new MultiCrafter("molding-machine"){{
            requirements(Category.crafting, with(aorItems.ironIngot, 40, aorItems.ironPlate, 10, aorItems.copperIngot, 30, aorItems.copperPlate, 20, aorItems.leadIngot, 40, aorItems.leadPlate, 35));
            itemCapacity = 100;
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
                                    aorItems.ironRod,4
                            );
                        }};
                        craftTime = 300f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.copperIngot,1
                            );
                        }};
                        output = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.copperWire,6
                            );
                        }};
                        craftTime = 300f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.steelItem,1
                            );
                        }};
                        output = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.steelRod,3
                            );
                        }};
                        craftTime = 300f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.wolframiteIngot,1
                            );
                        }};
                        output = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.wolframiteRod,2
                            );
                        }};
                        craftTime = 300f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.petcoke,1
                            );
                        }};
                        output = new IOEntry(){{
                            items = ItemStack.with(
                                    aorItems.carbonElectrode,4
                            );
                        }};
                        craftTime = 300f;
                    }}
            );
            craftEffect = Fx.pulverizeMedium;
        }};
        electricFurnace = new MultiCrafter("electric-furnace"){{
            requirements(Category.crafting, with(aorItems.stoneBlock, 25, aorItems.copperWire, 10));
            itemCapacity = 100;
            size = 3;
            resolvedRecipes = Seq.with(
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.gematiteItem, 1
                            );
                            power = 140f/60f;
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.ironIngot, 1
                            );
                        }};
                        craftTime = 50f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.malachiteItem, 1
                            );
                            power = 140f/60f;
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.copperIngot, 1
                            );
                        }};
                        craftTime = 50f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.leadItem, 1
                            );
                            power = 140f/60f;
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.leadIngot, 1
                            );
                        }};
                        craftTime = 50f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.aluminiumItem, 1
                            );
                            power = 140f/60f;
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.aluminiumIngot, 1
                            );
                        }};
                        craftTime = 50f;
                    }},
                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.sphaleriteItem, 1
                            );
                            power = 200f/60f;
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
                                    aorItems.titaniumItem, 1
                            );
                            power = 240f/60f;
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.titaniumIngot, 1
                            );
                        }};
                        craftTime = 75f;
                    }},


                    new Recipe() {{
                        input = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.wolframiteItem, 1
                            );
                            power = 350f/60f;
                        }};
                        output = new IOEntry() {{
                            items = ItemStack.with(
                                    aorItems.wolframiteIngot, 1
                            );
                        }};
                        craftTime = 87.5f;
                    }}
            );
            updateEffect = aorFx.smoke;
        }};
        baseAssembler = new MultiCrafter("base-assembler"){{
            requirements(Category.crafting, with(aorItems.ironIngot, 130, aorItems.ironPlate, 70, aorItems.copperIngot, 150, aorItems.copperPlate, 70,
                    aorItems.leadIngot, 70, aorItems.leadPlate, 95));
            itemCapacity = 40;
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
                        craftTime = 220f;
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
                        craftTime = 260f;
                    }}
            );
            craftEffect = Fx.pulverizeMedium;
        }};
        gasCentrifuge = new Separator("gas-centrifuge"){{
            requirements(Category.crafting, with(aorItems.bitumen, 125, aorItems.steelPlate, 100, aorItems.copperWire, 55, aorItems.wolframiteRod, 35, aorItems.ironRod, 65, aorItems.electricMotor, 20, aorItems.titaniumPlate, 80));
            itemCapacity = 35;
            results = with(
                aorItems.uranium235,1,
                    aorItems.uranium238, 35
            );
            hasLiquids = false;
            hasPower = true;
            craftTime = 120f;
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
            liquidCapacity = 100;
            consumePower(1450/60f);
            consumeLiquid(mindustry.content.Liquids.oil, 30/60f);
            outputLiquids = LiquidStack.with(aorLiquids.heavyOil, 20/60f, aorLiquids.tightOil, 10/60f);
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
            requirements(Category.production, with(aorItems.ironIngot, 70, aorItems.ironPlate, 45, aorItems.leadIngot, 55, aorItems.copperPlate, 30, aorItems.copperIngot, 20));
            size = 3;
            attribute = Attribute.oil;
            baseEfficiency = 0;
            minEfficiency = 1;
            consumeLiquid(aorLiquids.steam, 9/60f);
            outputLiquid = new LiquidStack(mindustry.content.Liquids.oil, 15/60f);
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(aorLiquids.steam),
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
                    aorItems.ironPlate, 250, aorItems.leadIngot, 165, aorItems.zincIngot, 50, aorItems.zincPlate, 40));
            size = 4;
            attribute = Attribute.get("tar");
            consumeLiquid(aorLiquids.steam, 18/60f);
            outputLiquid = new LiquidStack(Liquids.oil, 40/60f);
            craftTime = 60;
            floating = true;
            baseEfficiency = 0;
            minEfficiency = 1;
            displayEfficiencyScale = 1;
            displayEfficiency = true;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(aorLiquids.steam),
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
        electricHeater = new HeatProducer("electric-heater"){{
            requirements(Category.crafting, with(Items.tungsten, 30, Items.oxide, 30));
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput());
            rotateDraw = false;
            size = 2;
            heatOutput = 5f;
            regionRotated1 = 1;
            ambientSound = Sounds.hum;
            itemCapacity = 0;
            consumePower(100f / 60f);
        }};
        keroseneExtractor = new HeatCrafter("kerosene-extractor"){{
            requirements(Category.crafting, with(aorItems.ironIngot, 50, aorItems.ironPlate,30, aorItems.copperPlate, 60, aorItems.leadPlate, 40, aorItems.aluminiumPlate,80));
            size = 2;
            hasLiquids = true;
            consumeLiquid(Liquids.oil, 5/60f);
            consumePower(1);
            heatRequirement = 15;
            maxEfficiency = 1.33f;
            craftTime = 90f;
            outputLiquid = new LiquidStack(aorLiquids.kerosene, 4f/60f);
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawHeatInput()
            );
        }};
        lubricationPlant = new GenericCrafter("lubrication-plant"){{
            requirements(Category.crafting, with(aorItems.gematiteItem,1));
            localizedName = "lubrication-plant UNDER REVIEW FOR REMOVAL";
            size = 2;
            hasLiquids = true;
            hasPower = true;
            group = BlockGroup.liquids;
            liquidCapacity = 40;
            consumePower(450/60f);
            consumeLiquid(aorLiquids.tightOil, 5/60f);
            outputLiquid = new LiquidStack(aorLiquids.lubricant, 6/60f);
            craftTime = 60;
            updateEffect = Fx.none;
            drawer = new DrawMulti(
                    new DrawGlowRegion("-glow"),
                    new DrawDefault()
            );
        }};
        oxidativeReactor = new GenericCrafter("oxidative-reactor"){{
            requirements(Category.crafting, with(aorItems.ironIngot, 50, aorItems.ironPlate,30, aorItems.copperPlate, 60, aorItems.leadPlate, 40, aorItems.aluminiumPlate,80));
            size = 2;
            hasLiquids = true;
            hasPower = true;
            group = BlockGroup.liquids;
            liquidCapacity = 40;
            consumePower(200f/60f);
            consumeLiquid(aorLiquids.heavyOil, 3/60f);
            outputItem = new ItemStack(aorItems.bitumen,1);
            craftTime = 250;

            updateEffect = aorFx.smoke;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(aorLiquids.heavyOil),
                    new DrawDefault()
            );
        }};

        gasolineExtractor = new HeatCrafter("gasoline-extractor"){{
            requirements(Category.crafting, with(aorItems.ironIngot, 50, aorItems.ironPlate,30, aorItems.copperPlate, 60, aorItems.leadPlate, 40, aorItems.aluminiumPlate,80));
            size = 3;
            hasLiquids = true;
            consumeLiquid(aorLiquids.tightOil, 10/60f);
            consumePower(130/60f);
            heatRequirement = 20;
            maxEfficiency = 1.5f;
            craftTime = 120f;
            outputLiquid = new LiquidStack(aorLiquids.kerosene, 9f/60f);
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawHeatInput()
            );
        }};
        dieselExtractor = new HeatCrafter("diesel-extractor"){{
            requirements(Category.crafting, with(aorItems.ironIngot, 50, aorItems.ironPlate,30, aorItems.copperPlate, 60, aorItems.leadPlate, 40, aorItems.aluminiumPlate,80));
            size = 3;
            hasLiquids = true;
            consumeLiquid(aorLiquids.tightOil, 15/60f);
            consumePower(160/60f);
            heatRequirement = 20;
            maxEfficiency = 2f;
            craftTime = 150f;
            outputLiquid = new LiquidStack(aorLiquids.diesel, 10f/60f);
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawHeatInput()
            );
        }};
        cokeBattery = new GenericCrafter("coke-battery"){{
            requirements(Category.crafting, with(aorItems.bitumen,50, aorItems.leadIngot, 70, aorItems.titaniumIngot, 60, aorItems.titaniumPlate, 30, aorItems.ironRod, 40));
            size = 3;
            hasLiquids = true;
            hasPower = true;
            group = BlockGroup.liquids;
            liquidCapacity = 40;
            craftTime = 60;
            consumeLiquid(aorLiquids.heavyOil, 30/60f);
            outputItem = new ItemStack(aorItems.petcoke,6);
            updateEffect = Fx.none;
            craftEffect = aorFx.smoke;
        }};
        blastFurnace = new GenericCrafter("blast-furnace"){{
            requirements(Category.crafting, with(aorItems.bitumen,190, aorItems.leadIngot,150, aorItems.titaniumIngot, 120, aorItems.titaniumPlate, 50, aorItems.ironRod, 70));
            size = 3;
            hasItems = true;
            consumeItems(with(aorItems.ironIngot, 2, aorItems.petcoke, 1));
            outputItem = new ItemStack(aorItems.steelItem, 1);
            craftTime = 30;
            updateEffect = Fx.none;
            craftEffect = aorFx.smoke;
        }};
        arcFurnace = new GenericCrafter("arc-furnace"){{
            requirements(Category.crafting, with(aorItems.bitumen,240,aorItems.steelPlate, 140, aorItems.leadIngot,190, aorItems.titaniumIngot, 170, aorItems.titaniumPlate, 90, aorItems.ironRod, 120));
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
        //distribution
        oilConveyor = new LiquidStackConveyor("oil-conveyor"){{
            requirements(Category.distribution, with(aorItems.ironPlate, 2));
            speed = 25f/60f/10f;
            itemCapacity = 10;
            liquidCapacity = 20;
            consumeLiquid(mindustry.content.Liquids.oil, 0.2f/60f);
        }};
        oilRouter = new LiquidStackRouter("oil-router"){{
            requirements(Category.distribution, with(aorItems.ironPlate, 20));
            health = 130;
            liquidCapacity = 20;
            itemCapacity = 1;
            consumeLiquid(mindustry.content.Liquids.oil, 0.6f/60f);
            speed = 2.4f;
            underBullets = true;
            solid = false;
        }};
        oilJunction = new LiquidItemJunction("oil-junction"){{
            requirements(Category.distribution, with(aorItems.ironPlate, 20));
            capacity = 20;
            health = 30;
            buildCostMultiplier = 6f;
            consumeLiquid(mindustry.content.Liquids.oil, 0.6f/60f);
        }};
        oilItemBridge = new LiquidItemBridge("oil-bridge"){{
            requirements(Category.distribution, with(Items.lead, 6, Items.copper, 6));
            speed = 0.1f;
            fadeIn = moveArrows = false;
            arrowSpacing = 6f;
            range = 4;
            arrowPeriod = 0.9f;
            arrowTimeScl = 2.75f;
            bufferCapacity = 20;
            itemCapacity = 20;
            hasPower = false;
        }};
        oilUnloader = new DirectionalUnloader("unloader"){{
            requirements(Category.effect, with(Items.titanium, 25, Items.silicon, 30));
            speed = 24f/60f;
        }};
        gasolineConveyor = new LiquidStackConveyor("gasoline-conveyor"){{
            requirements(Category.distribution, with(aorItems.ironPlate, 2, aorItems.steelPlate, 2 ));
            speed = 0.05f;
            itemCapacity = 20;
            liquidCapacity = 20;
            consumeLiquid(aorLiquids.gasoline, 0.5f/60f);
        }};
        gasolineRouter = new LiquidStackRouter("gasoline-router"){{
            requirements(Category.distribution, with(aorItems.ironPlate, 20, aorItems.steelPlate, 20));
            health = 130;
            liquidCapacity = 20;
            itemCapacity = 1;
            consumeLiquid(aorLiquids.gasoline, 1.5f/60f);
            speed = 1f;
            underBullets = true;
            solid = false;
        }};
        gasolineJunction = new LiquidItemJunction("gasoline-junction"){{
            requirements(Category.distribution, with(aorItems.ironPlate, 20, aorItems.steelPlate, 20));
            capacity = 50;
            health = 30;
            buildCostMultiplier = 6f;
            consumeLiquid(aorLiquids.gasoline, 0.6f/60f);
        }};
        energyConveyor = new StackConveyor("energy-conveyor"){{
            requirements(Category.distribution, with(aorItems.steelPlate, 2, aorItems.electricMotor,2));
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
            requirements(Category.distribution, with(aorItems.steelPlate, 20, aorItems.electricMotor,20));
            health = 130;
            speed = 6f;
            hasPower = true;
            consumesPower = true;
            conductivePower = true;
            baseEfficiency = 1f;
            underBullets = true;
            solid = false;
            consumePower(9/60f);
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
            requirements(Category.liquid, with(aorItems.aluminiumIngot, 80, aorItems.aluminiumPlate, 50,aorItems.ironIngot, 20,
                    aorItems.ironPlate, 50, aorItems.leadIngot, 15));
            size = 3;
            attribute = Attribute.get("water");
            outputLiquid = new LiquidStack(Liquids.water, 2);
            craftTime = 30;
            floating = true;
            baseEfficiency = 0;
            minEfficiency = 1;
            displayEfficiencyScale = 1;
            displayEfficiency = true;
        }};
        pumpingStation = new AttributeCrafter("pumping-station"){{
            requirements(Category.liquid, with(aorItems.aluminiumIngot, 120, aorItems.aluminiumPlate, 150,aorItems.ironIngot, 130,
                    aorItems.ironPlate, 250, aorItems.leadIngot, 165, aorItems.titaniumPlate, 80,
                    aorItems.titaniumIngot, 140, aorItems.steelPlate, 80, aorItems.steelRod, 40));
            size = 4;
            attribute = Attribute.get("water");
            outputLiquid = new LiquidStack(Liquids.water, 3);
            craftTime = 20;
            consumePower(570/60f);
            floating = true;
            baseEfficiency = 0;
            minEfficiency = 1;
            displayEfficiencyScale = 1;
            displayEfficiency = true;
        }};
        liquidPipe = new ArmoredConduit("liquid-pipe"){{
            requirements(Category.liquid, with(aorItems.ironPlate, 2, aorItems.leadPlate, 2));
            liquidCapacity = 10;
            liquidPressure = 1.025f;
            health = 220;
        }};
        liquidRouter = new LiquidRouter("liquid-router"){{
            requirements(Category.liquid, with(aorItems.ironPlate, 2, aorItems.leadPlate, 2));
            liquidCapacity = 20f;
            liquidPressure = 1.025f;
            health = 50;
            solid = true;
        }};
        liquidTank = new LiquidRouter("liquid-tank"){{
            requirements(Category.liquid, with(aorItems.ironPlate, 300, aorItems.steelPlate,50));
            size = 3;
            solid = true;
            liquidCapacity = 2000f;
            health = 500;
        }};
        aboveGroundPipe = new LiquidBridge("above-ground-pipe"){{
            requirements(Category.liquid, with(aorItems.ironPlate, 10, aorItems.leadPlate, 10));
            fadeIn = moveArrows = false;
            arrowSpacing = 6f;
            range = 6;
            hasPower = false;
        }};
        //drills
        pneumaticDrill = new OilDrill("pneumatic-drill"){{
            requirements(Category.production, with(aorItems.ironIngot, 20,aorItems.copperPlate, 10));
            drillTime = 240;
            size = 2;
            tier = 2;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;
            consumeLiquid(mindustry.content.Liquids.oil, 0.15f/60f);
            consumeLiquid(mindustry.content.Liquids.water, 5f/60f).boost();
        }};
        keroseneDrill = new Drill("kerosene-drill"){{
            requirements(Category.production, with(aorItems.ironIngot, 25,aorItems.copperPlate, 15, aorItems.aluminiumIngot, 10, aorItems.leadPlate, 15));
            drillTime = 200;
            size = 3;
            tier = 3;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;
            consumeLiquid(aorLiquids.kerosene, 0.5f / 60f);
            consumeLiquid(mindustry.content.Liquids.water, 6f / 60f).boost();
            consumePower(30f/60f);
        }};
        gasolineDrill = new Drill("gasoline-drill"){{
            requirements(Category.production, with(aorItems.ironIngot, 50,aorItems.copperPlate, 30, aorItems.aluminiumIngot, 30, aorItems.leadPlate, 20, aorItems.steelPlate, 60, aorItems.ironRod, 30));
            drillTime = 170;
            size = 4;
            tier = 4;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;
            consumeLiquid(aorLiquids.gasoline, 0.5f / 60f);
            consumeLiquid(mindustry.content.Liquids.water, 6f / 60f).boost();
            consumePower(1);
        }};
        dieselDrill = new Drill("diesel-drill"){{
            requirements(Category.production, with(aorItems.ironIngot, 150,aorItems.copperPlate, 100, aorItems.aluminiumIngot, 100, aorItems.leadPlate, 65, aorItems.steelPlate, 120, aorItems.titaniumPlate, 60, aorItems.ironRod, 50));
            drillTime = 145;
            size = 5;
            tier = 5;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;
            consumeLiquid(aorLiquids.diesel, 0.5f / 60f);
            consumeLiquid(mindustry.content.Liquids.water, 6f / 60f).boost();
            consumePower(150f/60f);
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
        rockyGround = new Floor("rocky-ground", 3){{
           attributes.set(Attribute.get("rock"), 1);
        }};
        //power
        boiler = new GenericCrafter("boiler"){{
                    requirements(Category.power, with(aorItems.gematiteItem, 100, aorItems.copperPlate, 50, aorItems.leadIngot, 100));
                    size = 3;
                    hasLiquids = true;
                    liquidCapacity = 80;
                    itemCapacity = 60;
                    consumeItem(Items.coal, 3);
                    consumeLiquid(Liquids.water, 36/60f);
                    outputLiquid = new LiquidStack(aorLiquids.steam, 27f/60f);
                    craftTime = 120;
                    updateEffect = Fx.none;
                }};
        steamGenerator = new StackSteamGenerator("steam-generator"){{
            requirements(Category.power, with(aorItems.ironPlate, 150, aorItems.aluminiumPlate, 75, aorItems.ironRod, 60));
            powerProduction = 800/60f;
            consumeLiquid(aorLiquids.steam, 18/60f);
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
        electricTransmissionLine = new PowerNode("electric-transmission-line") {{
            requirements(Category.power, with(aorItems.ironRod, 4, aorItems.copperWire, 10));
            maxNodes = 2;
            laserRange = 60;
        }};
        substation = new PowerNode("substation"){{
            requirements(Category.power, with(aorItems.ironRod, 6, aorItems.copperWire, 30));
            size = 3;
            maxNodes = 30;
            laserRange = 10;
        }};
        zincBattery = new Battery("zinc-battery"){{
            requirements(Category.power, with(aorItems.ironPlate, 80, aorItems.copperWire, 20, aorItems.zincPlate, 50));
            size = 2;
            consumePowerBuffered(20000f);
            baseExplosiveness = 2f;
        }};
        solarPanel = new SolarGenerator("solar-panel"){{
            requirements(Category.power, with(aorItems.ironPlate, 80, aorItems.copperWire, 20, aorItems.aluminiumPlate, 60, aorItems.ironRod, 30));
           size = 3;
           powerProduction = 160/60f;
        }};
        nuclearReactor = new HeatNuclearReactor("nuclear-reactor"){{
            requirements(Category.power, with(aorItems.bitumen, 1250, aorItems.steelPlate, 1000, aorItems.copperWire, 565, aorItems.wolframiteRod, 345,
                    aorItems.ironRod, 475, aorItems.electricMotor, 50, aorItems.titaniumPlate, 650));
            size = 8;
            itemCapacity = 10;
            liquidCapacity = 200f;
            consumeItem(aorItems.nuclearFuel, 1);
            hasLiquids = true;
            consumeLiquid(Liquids.water,(18*4+2)/60f);
            outputLiquid = new LiquidStack(aorLiquids.steam, 18*4/60f);
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


         heatExchanger = new DamageHeatCrafter("heat-exchanger"){{
             requirements(Category.power, with(aorItems.bitumen, 120, aorItems.steelPlate, 100, aorItems.copperWire, 55, aorItems.wolframiteRod, 35,
                     aorItems.ironRod, 45, aorItems.electricMotor, 10, aorItems.titaniumPlate, 65));
             health = 1340;
             size = 3;
             rotate = true;
             invertFlip = true;
             heatRequirement = 30f;
             craftTime = 120f;
             liquidCapacity = 80;
             maxEfficiency = 1f;
             dmg = 400f;
             drawer = new DrawMulti(new DrawGlowRegion("-glow"), new DrawDefault(), new DrawHeatInput(),new DrawLiquidOutputs());

             outputLiquids = LiquidStack.with(aorLiquids.steam, 36f/60f);
             liquidOutputDirections = new int[]{4};
             regionRotated1 = 3;
             consumeLiquid(Liquids.water, 36f/60f);
             drawArrow = false;
         }};

         steamTurbine = new HeatRedirectorGenerator("steam-turbine"){{
             requirements(Category.power, with(aorItems.bitumen, 150, aorItems.steelPlate, 120, aorItems.copperWire, 95, aorItems.wolframiteRod, 75,
                     aorItems.ironRod, 65, aorItems.electricMotor, 20, aorItems.titaniumPlate, 85));
             researchCostMultiplier = 10f;
             size = 3;
             regionRotated1 = 1;
             powerProduction = 800/60f;
             consumeLiquid(aorLiquids.steam, 36f/60f);
             hasLiquids = true;
             liquidCapacity = 150f;
             size = 3;
             ambientSound = Sounds.smelter;
             ambientSoundVolume = 0.06f;
             drawer = new DrawMulti(
                     new DrawDefault(),
                     new DrawHeatOutput(),
                     new DrawHeatInput("-heat"),
                     new DrawRegion("-rotator"){{
                         spinSprite = true;
                         rotateSpeed = -50;
                     }}
             );
             effectChance = 0.4f;
             generateEffect = aorFx.steam;
         }};
        //turrets
        //todo turrets
        // balance turrets
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
             unitType = aorUnits.mi24;
             health = 1100;
             itemCapacity = 4500;
             size = 3;
             unitCapModifier = 15;

        }};
        coreCreation = new CoreBlock("coreCreation"){{
            requirements(Category.production, with(Items.copper, 1));
            unitType = aorUnits.mi24;
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

        //walls region
        stoneWall = new Wall("stone-wall"){{
            requirements(Category.defense, with(aorItems.rock, 6));
            health = 220;
            armor = 2;
        }};
        bigStoneWall = new Wall("big-stone-wall"){{
            requirements(Category.defense, with(aorItems.rock, 6*4));
            health = 220*4;
            armor = 3;
            size = 2;
        }};
        ironWall = new Wall("iron-wall"){{
            requirements(Category.defense, with(aorItems.ironIngot, 6));
           health = 250;
           armor = 3;
        }};
        bigIronWall = new Wall("big-iron-wall"){{
            requirements(Category.defense, with(aorItems.ironIngot, 6*4));
            health = 250*4;
            armor = 4;
            size = 2;
        }};
        ironBitumenWall = new Wall("iron-bitumen-wall"){{
            requirements(Category.defense, with(aorItems.ironIngot, 6, aorItems.bitumen, 5));
            health = 320;
            armor = 3;
        }};
        bigIronBitumenWall = new Wall("big-iron-bitumen-wall"){{
            requirements(Category.defense, with(aorItems.ironIngot, 6*4, aorItems.bitumen, 5*4));
            health = 320*4;
            armor = 4;
            size = 2;
        }};
        steelWall = new Wall("steel-wall"){{
            requirements(Category.defense, with(aorItems.steelItem, 6));
            health = 360;
            armor = 5;
        }};
        bigSteelWall = new Wall("big-steel-wall"){{
            requirements(Category.defense, with(aorItems.steelItem, 6*4));
            health = 360*4;
            armor = 6;
            size = 2;
        }};
        titaniumWall = new Wall("titanium-wall"){{
            requirements(Category.defense, with(aorItems.titaniumIngot, 6));
            health = 430;
            armor = 4;
        }};
        bigTitaniumWall = new Wall("big-titanium-wall"){{
            requirements(Category.defense, with(aorItems.titaniumIngot, 6*4));
            health = 430*4;
            armor = 5;
            size = 2;
        }};
        titaniumTungstenWall = new Wall("titanium-tungsten-wall"){{
            requirements(Category.defense, with(aorItems.titaniumIngot, 6, aorItems.wolframiteIngot, 5));
            health = 500;
            armor = 6;
        }};
        bigTitaniumTungstenWall = new Wall("big-titanium-tungsten-wall"){{
            requirements(Category.defense, with(aorItems.titaniumIngot, 6*4, aorItems.wolframiteIngot, 5*4));
            health = 500*4;
            armor = 8;
            size = 2;
        }};
        engine = new Wall("engine"){{
            requirements(Category.units, with(Items.copper,1));
            size = 2;
        }};
        t90Turret = new Wall("t-90-turret"){{
            requirements(Category.units, with(Items.copper,1));
            size = 2;
        }};
        t14Turret = new Wall("t-14-turret"){{
            requirements(Category.units, with(Items.copper,1));
            size = 2;
        }};
        //units factory
        sovietTankFabricator = new UnitFactory("soviet-tank-fabricator"){{
            requirements(Category.units, with(Items.silicon, 200, Items.beryllium, 150));
            size = 3;
            configurable = false;
            plans = Seq.with(
            new UnitPlan(aorUnits.bt7, 60f * 55f, with(aorItems.ironPlate, 60, aorItems.ironRod, 20, aorItems.ironIngot, 70)),
            new UnitPlan(aorUnits.btr80, 60f * 70f, with(aorItems.ironPlate, 80, aorItems.ironRod, 50, aorItems.ironIngot, 100)),
            new UnitPlan(aorUnits.t34, 60f * 80f, with(aorItems.ironPlate, 120, aorItems.ironRod, 70, aorItems.ironIngot, 120))
            );
            fogRadius = 3;
            consumePower(2f);
        }};
        sovietTankAssembler = new UnitAssembler("soviet-tank-assembler"){{
            requirements(Category.units, with(Items.thorium, 500, Items.oxide, 150, Items.carbide, 80, Items.silicon, 500));
            size = 5;
            plans.add(
                    new AssemblerUnitPlan(aorUnits.t90, 60f * 100f, PayloadStack.list(aorBlocks.engine, 1, aorBlocks.t90Turret, 1, aorBlocks.bigSteelWall, 20)),
                    new AssemblerUnitPlan(aorUnits.t14, 60f * 120f, PayloadStack.list(aorBlocks.engine, 1, aorBlocks.t14Turret, 1, aorBlocks.bigSteelWall, 35))
            );
            areaSize = 13;
            researchCostMultiplier = 0.4f;

            consumePower(3f);
        }};
    }
}
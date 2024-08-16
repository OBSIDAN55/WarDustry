package aor.content;

import aor.aorItems;
import aor.aorLiquids;
import mindustry.content.Liquids;

import static mindustry.content.TechTree.*;

public class earthTechTree {
    public static void load(){
            Planets.earth.techTree = nodeRoot("earth",aorBlocks.coreDestruction,() -> {
                node(aorUnits.mig24, () -> {
                });
                node(aorBlocks.oilConveyor, () -> {
                    node(aorBlocks.gasolineConveyor, () -> {
                        node(aorBlocks.energyConveyor);
                    });
                    node(aorBlocks.oilRouter, () -> {
                        node(aorBlocks.gasolineRouter, () -> {
                            node(aorBlocks.energyRouter);
                        });
                    });
                });
                node(aorBlocks.furnace, () -> {
                    node(aorBlocks.press, () -> {
                        node(aorBlocks.moldingMachine, () -> {
                            node(aorBlocks.baseAssembler);
                        });
                    });
                });
                node(aorBlocks.cokeBattery, () -> {
                    node(aorBlocks.blastFurnace, () -> {
                        node(aorBlocks.arcFurnace);
                    });
                });
                node(aorBlocks.oilRig, () -> {
                    node(aorBlocks.oilRefinery, () -> {
                        node(aorBlocks.oxidativeReactor, () -> {
                            node(aorBlocks.lubricationPlant, () -> {
                                node(aorBlocks.oilDistiller);
                            });
                        });
                        node(aorBlocks.oilPlatform);
                    });
                });
                node(aorBlocks.coreCreation);
                node(aorBlocks.pneumaticDrill, () -> {
                    node(aorBlocks.keroseneDrill, () -> {
                        node(aorBlocks.gasolineDrill, () -> {
                            node(aorBlocks.dieselDrill);
                        });
                    });
                });
                node(aorBlocks.boiler, () -> {
                    node(aorBlocks.steamGenerator, () -> {
                        node(aorBlocks.heatExchanger, () -> {
                            node(aorBlocks.heatPipe, () -> {
                                node(aorBlocks.heatRouter, () -> {
                                    node(aorBlocks.gasCentrifuge, () -> {
                                        node(aorBlocks.nuclearReactor);
                                    });
                                });
                            });
                        });
                    });
                });
                node(aorUnits.bt7,()->{
                    node(aorUnits.t34,()->{
                        node(aorUnits.btr80,()->{
                            node(aorUnits.t90,()->{
                                node(aorUnits.t14);
                            });
                        });
                    });
                });
                nodeProduce(aorItems.gematiteItem,()-> {
                    nodeProduce(aorItems.ironIngot, () -> {
                        nodeProduce(aorItems.ironPlate, () -> {
                            nodeProduce(aorItems.ironRod, () -> {
                            });
                        });
                    });
                    nodeProduce(aorItems.malachiteItem, () -> {
                        nodeProduce(aorItems.copperIngot, () -> {
                            nodeProduce(aorItems.copperPlate, () -> {
                                nodeProduce(aorItems.copperWire, () -> {
                                });
                            });
                        });
                        nodeProduce(aorItems.leadItem, () -> {
                            nodeProduce(aorItems.leadIngot, () -> {
                                nodeProduce(aorItems.leadPlate, () -> {
                                });
                            });
                            nodeProduce(aorItems.aluminiumItem, () -> {
                                nodeProduce(aorItems.aluminiumIngot, () -> {
                                    nodeProduce(aorItems.aluminiumPlate, () -> {
                                    });
                                });
                                nodeProduce(aorItems.sphaleriteItem, () -> {
                                    nodeProduce(aorItems.zincIngot, () -> {
                                        nodeProduce(aorItems.zincPlate, () -> {
                                        });
                                    });
                                    nodeProduce(aorItems.titaniumItem, () -> {
                                        nodeProduce(aorItems.titaniumIngot, () -> {
                                            nodeProduce(aorItems.titaniumPlate, () -> {
                                            });
                                        });
                                        nodeProduce(aorItems.wolframiteItem, () -> {
                                            nodeProduce(aorItems.wolframiteIngot, () -> {
                                                nodeProduce(aorItems.wolframiteRod, () -> {
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });
                    nodeProduce(aorItems.uranium, () -> {
                        nodeProduce(aorItems.uranium238, () -> {
                            nodeProduce(aorItems.uranium235, () -> {
                                nodeProduce(aorItems.nuclearFuel,()->{});
                            });
                        });
                    });
                    nodeProduce(aorItems.electricMotor, () -> {
                    });
                });
                nodeProduce(aorLiquids.steam,()->{
                    nodeProduce(aorLiquids.pressure,()->{});
                    nodeProduce(Liquids.oil,()->{
                        nodeProduce(aorLiquids.heavyOil,()->{
                            nodeProduce(aorItems.bitumen, () -> {});
                            nodeProduce(aorItems.petcoke, () -> {
                                nodeProduce(aorItems.carbonElectrode, () -> {
                                });
                            });
                        });
                        nodeProduce(aorLiquids.tightOil,()->{
                            nodeProduce(aorLiquids.lubricant,()->{});
                            nodeProduce(aorLiquids.kerosene,()->{
                                nodeProduce(aorLiquids.gasoline,()->{
                                    nodeProduce(aorLiquids.diesel,()->{});
                                });
                            });

                        });
                    });
                });
            });

    }
}


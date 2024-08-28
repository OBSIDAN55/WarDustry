package aor;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;


public class aorItems {
    public static final Seq<Item> huiItems = new Seq<>();
    public static Item

    //items
    gematiteItem,malachiteItem,aluminiumItem,leadItem,steelItem,sphaleriteItem,titaniumItem,wolframiteItem,petcoke,bitumen, uranium, rock,
    //ingots
    ironIngot,copperIngot,aluminiumIngot,leadIngot,zincIngot,titaniumIngot,wolframiteIngot,
    //plates
    ironPlate,copperPlate,aluminiumPlate,leadPlate,steelPlate,zincPlate,titaniumPlate,
    //rods
    ironRod,copperWire,steelRod,carbonElectrode,wolframiteRod,
    //other
    uranium235, uranium238,nuclearFuel,electricMotor, stoneBlock, glass;
    public static void load(){
        //colors
        String gemcol = "831E1E";
        String malcol = "386C1C";
        String alucol = "787884";
        String bitcol = "2E2D2D";
        String copcol = "D99D73";
        String ironcol = "787884";
        String leadcol = "6C6C6C";
        String stecol = "47474B";
        String zincol = "403825";
        String titcol = "282D3E";
        String wolcol = "48372F";
        String rockcol = "957A75";
        String glacol = "B6D6F3";
        rock = new Item("rock", Color.valueOf(rockcol)){{
            cost = 1.3f;
            explosiveness = 0f;
            hardness = 2;
            radioactivity = 0f;
        }};
        stoneBlock = new Item("stone-block", Color.valueOf(rockcol)){{
            cost = 1.3f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        glass = new Item("glass", Color.valueOf(glacol)){{
            cost = 1.3f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        gematiteItem = new Item("gematite-item", Color.valueOf(gemcol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        ironIngot = new Item("iron-ingot", Color.valueOf(ironcol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        ironPlate = new Item("iron-plate", Color.valueOf(ironcol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        ironRod = new Item("iron-rod", Color.valueOf(ironcol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        malachiteItem = new Item("malachite-item", Color.valueOf(malcol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        copperIngot = new Item("copper-ingot", Color.valueOf(copcol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        copperPlate = new Item("copper-plate", Color.valueOf(copcol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        copperWire = new Item("copper-wire", Color.valueOf(copcol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        leadItem = new Item("lead-item", Color.valueOf(leadcol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        leadIngot = new Item("lead-ingot", Color.valueOf(leadcol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        leadPlate = new Item("lead-plate", Color.valueOf(leadcol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        aluminiumItem = new Item("aluminium-item", Color.valueOf(alucol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        aluminiumIngot = new Item("aluminium-ingot", Color.valueOf(alucol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        aluminiumPlate = new Item("aluminium-plate", Color.valueOf(alucol)){{
            cost = 1f;
            explosiveness = 0f;
            hardness = 1;
            radioactivity = 0f;
        }};
        sphaleriteItem = new Item("sphalerite-item", Color.valueOf(zincol)){{
            cost = 2f;
            explosiveness = 0f;
            hardness = 2;
            radioactivity = 0f;
        }};
        zincIngot = new Item("zinc-ingot", Color.valueOf(zincol)){{
            cost = 2f;
            explosiveness = 0f;
            hardness = 2;
            radioactivity = 0f;
        }};
        zincPlate = new Item("zinc-plate", Color.valueOf(zincol)){{
            cost = 2f;
            explosiveness = 0f;
            hardness = 2;
            radioactivity = 0f;
        }};
        titaniumItem = new Item("titanium-item", Color.valueOf(titcol)){{
            cost = 3f;
            explosiveness = 0f;
            hardness = 3;
            radioactivity = 0f;
        }};
        titaniumIngot = new Item("titanium-ingot", Color.valueOf(titcol)){{
            cost = 3f;
            explosiveness = 0f;
            hardness = 3;
            radioactivity = 0f;
        }};
        titaniumPlate = new Item("titanium-plate", Color.valueOf(titcol)){{
            cost = 3f;
            explosiveness = 0f;
            hardness = 3;
            radioactivity = 0f;
        }};
        steelItem = new Item("steel", Color.valueOf(stecol)){{
            cost = 3f;
            explosiveness = 0f;
            hardness = 3;
            radioactivity = 0f;
        }};
        steelPlate = new Item("steel-plate", Color.valueOf(stecol)){{
            cost = 3f;
            explosiveness = 0f;
            hardness = 3;
            radioactivity = 0f;
        }};
        steelRod = new Item("steel-rod", Color.valueOf(stecol)){{
            cost = 3f;
            explosiveness = 0f;
            hardness = 3;
            radioactivity = 0f;
        }};
        wolframiteItem = new Item("wolframite-item", Color.valueOf(wolcol)){{
            cost = 4f;
            explosiveness = 0f;
            hardness = 4;
            radioactivity = 0f;
        }};
        wolframiteIngot = new Item("wolframite-ingot", Color.valueOf(wolcol)){{
            cost = 4f;
            explosiveness = 0f;
            hardness = 4;
            radioactivity = 0f;
        }};
        wolframiteRod = new Item("wolframite-rod", Color.valueOf(wolcol)){{
            cost = 4f;
            explosiveness = 0f;
            hardness = 4;
            radioactivity = 0f;
        }};
        petcoke = new Item("petcoke", Color.valueOf(bitcol)){{
            cost = 2f;
            explosiveness = 0f;
            hardness = 2;
            radioactivity = 0f;
            flammability = 1.4f;
        }};
        carbonElectrode = new Item("carbon-electrode", Color.valueOf(bitcol)){{
            cost = 2f;
            explosiveness = 0f;
            hardness = 2;
            radioactivity = 0f;
        }};
        bitumen = new Item("bitumen", Color.valueOf(bitcol)){{
            cost = 2f;
            explosiveness = 0f;
            hardness = 2;
            radioactivity = 0f;
            flammability = 0.8f;
        }};
        electricMotor = new Item("electric-motor"){{
            cost = 4f;
            explosiveness = 0f;
            hardness = 2;
            radioactivity = 0f;
        }};
        uranium = new Item("uranium"){{
            cost = 5f;
            explosiveness = 0.2f;
            hardness = 5;
            radioactivity = 1.7f;
            charge = 0.3f;
        }};
        uranium235 = new Item("uranium-235"){{
            cost = 5f;
            explosiveness = 0.4f;
            hardness = 5;
            radioactivity = 2.6f;
            charge = 0.7f;
        }};
        uranium238 = new Item("uranium-238"){{
            cost = 5f;
            explosiveness = 0.2f;
            hardness = 5;
            radioactivity = 0.4f;
            charge = 0.25f;
        }};
        nuclearFuel = new Item("nuclear-fuel", Color.valueOf("54D67D")){{
            cost = 5f;
            explosiveness = 0.4f;
            hardness = 5;
            radioactivity = 2.25f;
            charge = 0.45f;
        }};


        huiItems.addAll(ironPlate,copperPlate,aluminiumPlate,leadPlate,steelPlate,zincPlate,titaniumPlate,
                gematiteItem,malachiteItem,aluminiumItem,leadItem,steelItem,sphaleriteItem,titaniumItem,wolframiteItem,petcoke,bitumen,
                ironIngot,copperIngot,aluminiumIngot,leadIngot,zincIngot,titaniumIngot,wolframiteIngot,
                ironRod,copperWire,steelRod,carbonElectrode,wolframiteRod,
                uranium,uranium235,nuclearFuel,electricMotor);
    }

}

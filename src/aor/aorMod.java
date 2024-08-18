package aor;

import aor.audio.Sfx;
import aor.content.*;
import mindustry.content.Blocks;
import mindustry.mod.Mod;

import mindustry.world.meta.Attribute;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatCat;

public class aorMod extends Mod {
    public aorMod(){
    }

    public static final Stat
    itemsMoved1 = new Stat("itemsMoved1", StatCat.items),
    itemsMoved2 = new Stat("itemsMoved2", StatCat.items),
    itemsMoved3 = new Stat("itemsMoved3", StatCat.items),
    itemsMoved4 = new Stat("itemsMoved4", StatCat.items),
    itemsMoved5 = new Stat("itemsMoved5", StatCat.items),
    itemsMoved9 = new Stat("itemsMoved9", StatCat.items),
    itemsMoved6 = new Stat("itemsMoved6", StatCat.items),
    itemsMoved7 = new Stat("itemsMoved7", StatCat.items),
    itemsMoved8 = new Stat("itemsMoved8", StatCat.items),
    itemsMoved10= new Stat("itemsMoved10", StatCat.items);
    @Override
    public void loadContent(){
        Sfx.load();
        Attribute.add("tar");
        Attribute.add("water");

        mindustry.content.Blocks.tar.attributes.set(Attribute.get("tar"), 1);
        Blocks.deepwater.attributes.set(Attribute.get("water"), 1);
        Blocks.water.attributes.set(Attribute.get("water"), 1);
        Blocks.taintedWater.attributes.set(Attribute.get("water"), 1);
        Blocks.deepTaintedWater.attributes.set(Attribute.get("water"), 1);
        Blocks.darksandTaintedWater.attributes.set(Attribute.get("water"), 1);
        Blocks.sandWater.attributes.set(Attribute.get("water"), 1);
        Blocks.darksandWater.attributes.set(Attribute.get("water"), 1);
        aorItems.load();
        aorLiquids.load();
        aorUnits.load();
        aorBlocks.load();
        Planets.load();
        SectorPresets.load();
        earthTechTree.load();
    }
}



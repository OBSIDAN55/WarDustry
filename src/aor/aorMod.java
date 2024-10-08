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
    or = new Stat("or", StatCat.crafting),
    input2 = new Stat("input2",StatCat.crafting),
    output2 = new Stat("output2", StatCat.crafting);
    @Override
    public void loadContent(){
        Sfx.load();
        Attribute.add("tar");
        Attribute.add("water");
        Attribute.add("rock");
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



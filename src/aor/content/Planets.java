package aor.content;

import aor.aorItems;
import mindustry.content.Items;
import mindustry.type.Planet;
import arc.graphics.*;
import mindustry.game.*;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.*;
import mindustry.world.meta.*;

import static aor.aorItems.huiItems;


public class Planets {
    public static Planet
            earth;

    public static void load() {
        earth = new Planet("earth", mindustry.content.Planets.sun, 1.05f, 2) {{
             meshLoader = ()-> new MultiMesh(
                new NoiseMesh(earth,405,6,1f,2,2f,1.1f,1f,Color.valueOf("178735"), Color.red,2,2f,1f,1f),
                new NoiseMesh(earth,5975,6,1f,2,2f,1.1f,1f,Color.valueOf("115c25"), Color.red,2,2f,1f,1f),
                new NoiseMesh(earth,564,6,1f,2,2f,1.1f,1f,Color.valueOf("#439c5b"), Color.red,2,2f,1f,1f)
             );
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 2, 0.15f, 0.14f, 5, Color.white.a(0.75f), 2, 0.42f, 1f, 0.43f),
                new HexSkyMesh(this, 3, 0.6f, 0.15f, 5, Color.white.a(0.75f), 2, 0.42f, 1.2f, 0.45f)
            );
            generator = new SerpuloPlanetGenerator();
            alwaysUnlocked = true;
            landCloudColor = Color.white;
            atmosphereColor = Color.valueOf("0000ff00");
            defaultEnv = Env.scorching | Env.terrestrial;
            startSector = 10;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.1f;
            tidalLock = true;
            orbitSpacing = 2.5f;
            totalRadius += 2.6f;
            lightSrcTo = 0.5f;
            lightDstFrom = 0.2f;
            clearSectorOnLose = false;
            defaultCore = aorBlocks.coreDestruction;
            iconColor = Color.green;
            hiddenItems.addAll(Items.erekirItems).removeAll(huiItems);
            hiddenItems.addAll(Items.serpuloItems).removeAll(huiItems);
            enemyBuildSpeedMultiplier = 0.4f;

            allowLaunchToNumbered = false;
            updateLighting = false;
            ruleSetter = r -> {
                r.waveTeam = Team.green;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.fog = false;
                r.staticFog = false;
                r.lighting = false;
                r.coreDestroyClear = true;
                r.onlyDepositCore = true;
                r.unitAmmo = true;
            };

            unlockedOnLand.add(aorBlocks.coreDestruction);
        }};


    }
}

package aor.content;

import mindustry.type.*;

import static mindustry.content.Planets.*;

public class SectorPresets {
    public static SectorPreset
    startSector;

    public static void load(){
        startSector = new SectorPreset("startSector", Planets.earth, 10){{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 10;
            difficulty = 1;
            overrideLaunchDefaults = true;
            noLighting = true;
            startWaveTimeMultiplier = 3f;
        }};

    }
}

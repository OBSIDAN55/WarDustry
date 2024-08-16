package aor.audio;

import arc.audio.Sound;
import mindustry.Vars;
import arc.Core;
import arc.assets.AssetDescriptor;
import arc.assets.loaders.SoundLoader;
public class Sfx {
    public static Sound
    NucStart = new Sound();

    protected static Sound loadSound(String fileName) {
        String name = "sounds/" + fileName;
        String path = Vars.tree.get(name + ".ogg").exists() ? name + ".ogg" : name + ".mp3";

        Sound sound = new Sound();

        AssetDescriptor<?> desc = Core.assets.load(path, Sound.class, new SoundLoader.SoundParameter(sound));
        desc.errored = Throwable::printStackTrace;

        return sound;
    }
    public static void load() {
        if (Vars.headless) return;
        NucStart = loadSound("NucStart");
    }
}


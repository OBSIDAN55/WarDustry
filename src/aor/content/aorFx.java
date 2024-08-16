package aor.content;

import arc.graphics.Color;
import mindustry.entities.Effect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;

public class aorFx {
    public static final Effect
    smoke = new ParticleEffect(){{
        colorFrom = Color.gray;
        colorTo = Color.valueOf("00000000");
        particles = 2;
        randLength = true;
        baseRotation = 45f;
        cone = 15f;
        length = 500f;
        baseLength = 0f;
        lightScl = 2f;
        lightOpacity = 0.6f;
        layer = 100;
        lifetime = 2000f;
        sizeFrom = 0;
        sizeTo = 10;
        offsetX = 0;
        offsetY = 0;
    }},
    steam = new ParticleEffect(){{
        colorFrom = Color.white;
        colorTo = Color.valueOf("00000000");
        particles = 2;
        randLength = true;
        baseRotation = 45f;
        cone = 15f;
        length = 500f;
        baseLength = 0f;
        lightScl = 2f;
        lightOpacity = 0.6f;
        layer = 100;
        lifetime = 2000f;
        sizeFrom = 0;
        sizeTo = 10;
    }},
    arcFurnaceSmoke = new MultiEffect(
            new ParticleEffect(){{
                colorFrom = Color.gray;
                colorTo = Color.valueOf("00000000");
                particles = 2;
                randLength = true;
                baseRotation = 45f;
                cone = 15f;
                length = 500f;
                baseLength = 0f;
                lightScl = 2f;
                lightOpacity = 0.6f;
                layer = 100;
                lifetime = 2000f;
                sizeFrom = 0;
                sizeTo = 10;
                offsetX = -15;
                offsetY = 0;
            }},
            new ParticleEffect(){{
                colorFrom = Color.gray;
                colorTo = Color.valueOf("00000000");
                particles = 2;
                randLength = true;
                baseRotation = 45f;
                cone = 15f;
                length = 500f;
                baseLength = 0f;
                lightScl = 2f;
                lightOpacity = 0.6f;
                layer = 100;
                lifetime = 2000f;
                sizeFrom = 0;
                sizeTo = 10;
                offsetX = 15;
                offsetY = 0;
            }},
            new ParticleEffect(){{
                colorFrom = Color.gray;
                colorTo = Color.valueOf("00000000");
                particles = 2;
                randLength = true;
                baseRotation = 45f;
                cone = 15f;
                length = 500f;
                baseLength = 0f;
                lightScl = 2f;
                lightOpacity = 0.6f;
                layer = 100;
                lifetime = 2000f;
                sizeFrom = 0;
                sizeTo = 10;
                offsetX = 0;
                offsetY = 15;
            }},
            new ParticleEffect(){{
                colorFrom = Color.gray;
                colorTo = Color.valueOf("00000000");
                particles = 2;
                randLength = true;
                baseRotation = 45f;
                cone = 15f;
                length = 500f;
                baseLength = 0f;
                lightScl = 2f;
                lightOpacity = 0.6f;
                layer = 100;
                lifetime = 2000f;
                sizeFrom = 0;
                sizeTo = 10;
                offsetX = 0;
                offsetY = -15;
            }},
            aorFx.smoke
    );

}

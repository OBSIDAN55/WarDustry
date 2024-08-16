package aor.content;

import aor.entities.HelicopterUnitType;
import aor.entities.entity.CopterUnitEntity;
import aor.type.Rotor;
import arc.func.Prov;
import arc.graphics.Color;
import arc.struct.ObjectIntMap;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.RailBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootPattern;
import mindustry.gen.Entityc;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.unit.TankUnitType;
import arc.struct.ObjectMap.Entry;
import mindustry.gen.*;

import static mindustry.Vars.tilesize;

public class aorUnits {
    public static UnitType
    //soviet unit tree
    bt7, t34, btr80, t90, t14,
    //usa unit tree
    m1CombatCar, m41, m48, mbt70, m1Abrams,
    //TODO new unit tree
    //aviation
    mig29, b32, mig24,
    //coreUnits
    ruined,
    //heli
    helitest;
    // Steal from Unlimited Armament Works which stole from Progressed Material which stole from Endless Rusting which stole from Progressed Materials in the past which stole from BetaMindy
    private static final Entry<Class<? extends Entityc>, Prov<? extends Entityc>>[] types = new Entry[]{
            prov(CopterUnitEntity.class, CopterUnitEntity::new),
    };

    private static final ObjectIntMap<Class<? extends Entityc>> idMap = new ObjectIntMap<>();

    /**
     * Internal function to flatmap {@code Class -> Prov} into an {@link Entry}.
     * @author GlennFolker
     */
    private static <T extends Entityc> Entry<Class<T>, Prov<T>> prov(Class<T> type, Prov<T> prov) {
        Entry<Class<T>, Prov<T>> entry = new Entry<>();
        entry.key = type;
        entry.value = prov;
        return entry;
    }

    /**
     * Setups all entity IDs and maps them into {@link EntityMapping}.
     * <p>
     * Put this inside load()
     * </p>
     * @author GlennFolker
     */
    private static void setupID() {
        for (
                int i = 0,
                j = 0,
                len = EntityMapping.idMap.length;
                i < len;
                i++
        ) {
            if (EntityMapping.idMap[i] == null) {
                idMap.put(types[j].key, i);
                EntityMapping.idMap[i] = types[j].value;
                if (++j >= types.length) break;
            }
        }
    }

    /**
     * Retrieves the class ID for a certain entity type.
     * @author GlennFolker
     */
    public static <T extends Entityc> int classID(Class<T> type) {
        return idMap.get(type, -1);
    }

    public static void load(){
        setupID();
        //soviet unit tree
        bt7 = new TankUnitType("bt-7"){{
            this.constructor= TankUnit::create;
                hitSize = 13.75f;
                treadPullOffset = 5;
                speed = 2.5f;
                rotateSpeed = 1.4f;
                health = 2100;
                armor = 8;
                itemCapacity = 0;
                omniMovement = false;
                range = 560;
                outlineColor = Color.valueOf("000000ff");
                weapons.add(new Weapon(name + "-weapon"){{
                    layerOffset = 0.0001f;
                    outlineColor = Color.valueOf("000000ff");
                    reload = 125;
                    rotate = true;
                    recoil = 0;
                    rotateSpeed = 1.2f;
                    mirror = false;
                    x = 0;
                    y = 4;
                    cooldownTime = 30;
                    top = true;
                    shootSound = Sounds.largeCannon;
                    shootY = 15;
                    bullet = new BasicBulletType(600,20){{
                        pierce = true;
                        pierceCap = 3;
                        drag=  0.01f;
                        smokeEffect = Fx.shootBigSmoke;
                        shootEffect = Fx.shootBigColor;
                        width = 5;
                        height = 7;
                        lifetime = 28;
                        hitSize = 4;
                        trailWidth = 1.7f;
                        trailLength = 5;
                        despawnEffect = Fx.hitBulletColor;
                    }};
                    parts.addAll(
                            new RegionPart("-part"){{
                            progress = PartProgress.recoil;
                            mirror = false;
                            under = true;
                            top = true;
                            y = -2;
                            moveY = -2;
                            outline = false;
                            }}
                    );

                }}
                );



        }};
        t34 = new TankUnitType("t-34"){{
            this.constructor=TankUnit::create;
                hitSize = 18;
                treadPullOffset = 5;
                speed = 1.7f;
                rotateSpeed = 1.2f;
                health = 2100;
                armor = 8;
                itemCapacity = 0;
                omniMovement = false;
                range = 560;
                outlineColor = Color.valueOf("000000ff");
                weapons.add(new Weapon(name + "-weapon"){{
                        layerOffset = 0.0001f;
                        outlineColor = Color.valueOf("000000ff");
                        reload = 240;
                        rotate = true;
                        recoil = 0;
                        rotateSpeed = 1;
                        mirror = false;
                        x = 0;
                        y = 0;
                        cooldownTime = 30;
                        top = true;
                        shootSound = Sounds.largeCannon;
                        shootY = 33;
                        bullet = new BasicBulletType(600,20){{
                            pierce = true;
                            pierceCap = 3;
                            drag=  0.01f;
                            smokeEffect = Fx.shootBigSmoke;
                            shootEffect = Fx.shootBigColor;
                            width = 5;
                            height = 7;
                            lifetime = 28;
                            hitSize = 4;
                            trailWidth = 1.7f;
                            trailLength = 5;
                            despawnEffect = Fx.hitBulletColor;
                        }};
                        parts.addAll(
                                new RegionPart("-part"){{
                                    progress = PartProgress.recoil;
                                    mirror = false;
                                    under = true;
                                    top = true;
                                    y = 2;
                                    moveY = -2;
                                    outline = false;
                                }}
                        );

                    }}
                );
        }};
        btr80 = new TankUnitType("btr-80"){{
            this.constructor=TankUnit::create;
            hitSize = 18;
            treadPullOffset = 5;
            speed = 1.7f;
            rotateSpeed = 1.2f;
            health = 2100;
            armor = 8;
            itemCapacity = 0;
            omniMovement = false;
            range = 560;
            weapons.add(new Weapon(name + "-weapon"){{
                    layerOffset = 0.0001f;
                    outlineColor = Color.valueOf("000000ff");
                    reload = 5;
                    rotate = true;
                    recoil = 0;
                    rotateSpeed = 3;
                    mirror = false;
                    x = 0;
                    y = 6;
                    cooldownTime = 30;
                    top = true;
                    shootSound = Sounds.largeCannon;
                    shootY = 11;
                    bullet = new BasicBulletType(20, 10) {{
                        pierce = true;
                        pierceCap = 3;
                        drag = 0.01f;
                        smokeEffect = Fx.shootBigSmoke;
                        shootEffect = Fx.shootBigColor;
                        width = 5;
                        height = 7;
                        lifetime = 28;
                        hitSize = 4;
                        trailWidth = 1.7f;
                        trailLength = 5;
                        despawnEffect = Fx.hitBulletColor;
                        inaccuracy = 5;
                    }};
                    parts.addAll(
                            new RegionPart("-part") {{
                                progress = PartProgress.recoil;
                                mirror = false;
                                under = true;
                                top = true;
                                y = -5;
                                moveY = -2;
                                outline = false;
                            }}
                    );
            }}
            );
        }};
        t90 = new TankUnitType("t-90"){{
            this.constructor=TankUnit::create;
            hitSize = 18;
            treadPullOffset = 5;
            speed = 1.3f;
            rotateSpeed = 1;
            health = 2100;
            armor = 8;
            itemCapacity = 0;
            omniMovement = false;
            range = 560;
            outlineColor = Color.valueOf("000000ff");
            weapons.add(new Weapon(name + "-weapon"){{
                            layerOffset = 0.0001f;
                            outlineColor = Color.valueOf("000000ff");
                            reload = 400;
                            rotate = true;
                            recoil = 0;
                            rotateSpeed = 0.8f;
                            mirror = false;
                            x = 0;
                            y = 0;
                            cooldownTime = 30;
                            top = true;
                            shootSound = Sounds.largeCannon;
                            shootY = 45;
                            bullet = new BasicBulletType(600,20){{
                                pierce = true;
                                pierceCap = 3;
                                drag=  0.01f;
                                smokeEffect = Fx.shootBigSmoke;
                                shootEffect = Fx.shootBigColor;
                                width = 5;
                                height = 7;
                                lifetime = 28;
                                hitSize = 4;
                                trailWidth = 1.7f;
                                trailLength = 5;
                                despawnEffect = Fx.hitBulletColor;
                            }};
                            parts.addAll(
                                    new RegionPart("-part"){{
                                        progress = PartProgress.recoil;
                                        mirror = false;
                                        under = true;
                                        top = true;
                                        y = 9;
                                        moveY = -5;
                                        outline = false;
                                    }}
                            );

                        }}
            );
        }};
        t14 = new TankUnitType("t-14"){{
                this.constructor=TankUnit::create;
                hitSize = 18;
                treadPullOffset = 5;
                speed = 1.8f;
                rotateSpeed = 1.6f;
                health = 2100;
                armor = 8;
                itemCapacity = 0;
                omniMovement = false;
                range = 700;
                outlineColor = Color.valueOf("000000ff");
                weapons.add(new Weapon(name + "-weapon"){{
                                layerOffset = 0.0001f;
                                outlineColor = Color.valueOf("000000ff");
                                reload = 252;
                                rotate = true;
                                recoil = 0;
                                rotateSpeed = 1.2f;
                                mirror = false;
                                x = 0;
                                y = 0;
                                cooldownTime = 30;
                                top = true;
                                shootSound = Sounds.largeCannon;
                                shootY = 45;
                                bullet = new BasicBulletType(600,20){{
                                    pierce = true;
                                    pierceCap = 3;
                                    drag=  0.01f;
                                    smokeEffect = Fx.shootBigSmoke;
                                    shootEffect = Fx.shootBigColor;
                                    width = 5;
                                    height = 7;
                                    lifetime = 28;
                                    hitSize = 4;
                                    trailWidth = 1.7f;
                                    trailLength = 5;
                                    despawnEffect = Fx.hitBulletColor;
                                }};
                                parts.addAll(
                                        new RegionPart("-part"){{
                                            progress = PartProgress.recoil;
                                            mirror = false;
                                            under = true;
                                            top = true;
                                            y = 20;
                                            moveY = -2;
                                            outline = false;
                                        }}
                                );

                            }}
                );
        }};
        m1CombatCar = new TankUnitType("m1-combat-car"){{
            this.constructor=TankUnit::create;
            hitSize = 18;
            treadPullOffset = 5;
            speed = 1.6f;
            rotateSpeed = 1.2f;
            health = 2100;
            armor = 8;
            itemCapacity = 0;
            omniMovement = false;
            range = 400;
            outlineColor = Color.valueOf("000000ff");
            weapons.addAll(
                    new Weapon(name + "-weapon1"){{
                        layerOffset = 0.0001f;
                        outlineColor = Color.valueOf("000000ff");
                        reload = 7;
                        rotate = false;
                        recoil = 0;
                        mirror = false;
                        x = 0;
                        y = 0;
                        cooldownTime = 30;
                        top = true;
                        shootSound = Sounds.largeCannon;
                        shootY = 2;
                        bullet = new BasicBulletType(600,20){{
                            pierce = true;
                            pierceCap = 3;
                            drag=  0.01f;
                            smokeEffect = Fx.shootBigSmoke;
                            shootEffect = Fx.shootBigColor;
                            width = 5;
                            height = 7;
                            lifetime = 28;
                            hitSize = 4;
                            trailWidth = 1.7f;
                            trailLength = 5;
                            despawnEffect = Fx.hitBulletColor;
                        }};
                        parts.addAll(
                                new RegionPart("-part"){{
                                    progress = PartProgress.recoil;
                                    mirror = false;
                                    under = true;
                                    top = true;
                                    y = 0;
                                    moveY = -2;
                                    outline = false;
                                }}

                        );

                    }},
                    new Weapon(name + "-weapon2"){{
                        layerOffset = 0.0001f;
                        outlineColor = Color.valueOf("000000ff");
                        reload = 100;
                        rotate = true;
                        recoil = 0;
                        rotateSpeed = 1.2f;
                        mirror = false;
                        x = 0;
                        y = 0;
                        cooldownTime = 30;
                        top = true;
                        shootSound = Sounds.largeCannon;
                        shootY = 1.5f;
                        bullet = new BasicBulletType(600,20){{
                            pierce = true;
                            pierceCap = 3;
                            drag=  0.01f;
                            smokeEffect = Fx.shootBigSmoke;
                            shootEffect = Fx.shootBigColor;
                            width = 5;
                            height = 7;
                            lifetime = 28;
                            hitSize = 4;
                            trailWidth = 1.7f;
                            trailLength = 5;
                            despawnEffect = Fx.hitBulletColor;
                        }};
                        parts.addAll(
                                new RegionPart("-part1"){{
                                    progress = PartProgress.recoil;
                                    mirror = false;
                                    under = true;
                                    top = true;
                                    y = 0;
                                    moveY = -2;
                                    outline = false;
                                }}
                        );
                    }},
                    new Weapon(name + "-weapon2"){
                        {
                            layerOffset = 0.0001f;
                            outlineColor = Color.valueOf("000000ff");
                            reload = 9;
                            rotate = true;
                            recoil = 0;
                            rotateSpeed = 1.2f;
                            mirror = false;
                            x = 0;
                            y = 0;
                            cooldownTime = 30;
                            top = true;
                            shootSound = Sounds.largeCannon;
                            shootY = 2;
                            bullet = new BasicBulletType(600, 20) {{
                                pierce = true;
                                pierceCap = 3;
                                drag = 0.01f;
                                smokeEffect = Fx.shootBigSmoke;
                                shootEffect = Fx.shootBigColor;
                                width = 5;
                                height = 7;
                                lifetime = 28;
                                hitSize = 4;
                                trailWidth = 1.7f;
                                trailLength = 5;
                                despawnEffect = Fx.hitBulletColor;
                            }};
                            parts.addAll(
                                    new RegionPart("-part2") {{
                                        progress = PartProgress.recoil;
                                        mirror = false;
                                        under = true;
                                        top = true;
                                        y = 0;
                                        moveY = -2;
                                        outline = false;
                                    }}
                            );
                        }}
            );

        }};
        m41 = new TankUnitType("m41"){{
            this.constructor=TankUnit::create;
            hitSize = 18;
            treadPullOffset = 5;
            speed = 1.4f;
            rotateSpeed = 1.1f;
            health = 2100;
            armor = 8;
            itemCapacity = 0;
            omniMovement = false;
            range = 700;
            outlineColor = Color.valueOf("000000ff");
            weapons.add(new Weapon(name + "-weapon"){{
                            layerOffset = 0.0001f;
                            outlineColor = Color.valueOf("000000ff");
                            reload = 252;
                            rotate = true;
                            recoil = 0;
                            rotateSpeed = 1.2f;
                            mirror = false;
                            x = 0;
                            y = 0;
                            cooldownTime = 30;
                            top = true;
                            shootSound = Sounds.largeCannon;
                            shootY = 45;
                            bullet = new BasicBulletType(600,20){{
                                pierce = true;
                                pierceCap = 3;
                                drag=  0.01f;
                                smokeEffect = Fx.shootBigSmoke;
                                shootEffect = Fx.shootBigColor;
                                width = 5;
                                height = 7;
                                lifetime = 28;
                                hitSize = 4;
                                trailWidth = 1.7f;
                                trailLength = 5;
                                despawnEffect = Fx.hitBulletColor;
                            }};
                            parts.addAll(
                                    new RegionPart("-part"){{
                                        progress = PartProgress.recoil;
                                        mirror = false;
                                        under = true;
                                        top = true;
                                        y = (float) 68 /4;
                                        moveY = -2;
                                        outline = false;
                                    }}
                            );

                        }}
            );
        }};
        m48 = new TankUnitType("m48"){{
            this.constructor=TankUnit::create;
            hitSize = 18;
            treadPullOffset = 5;
            speed = 1.4f;
            rotateSpeed = 1.1f;
            health = 2100;
            armor = 8;
            itemCapacity = 0;
            omniMovement = false;
            range = 700;
            outlineColor = Color.valueOf("000000ff");
            weapons.add(new Weapon(name + "-weapon"){{
                            layerOffset = 0.0001f;
                            outlineColor = Color.valueOf("000000ff");
                            reload = 252;
                            rotate = true;
                            recoil = 0;
                            rotateSpeed = 1.2f;
                            mirror = false;
                            x = 0;
                            y = 0;
                            cooldownTime = 30;
                            top = true;
                            shootSound = Sounds.largeCannon;
                            shootY = 45;
                            bullet = new BasicBulletType(600,20){{
                                pierce = true;
                                pierceCap = 3;
                                drag=  0.01f;
                                smokeEffect = Fx.shootBigSmoke;
                                shootEffect = Fx.shootBigColor;
                                width = 5;
                                height = 7;
                                lifetime = 28;
                                hitSize = 4;
                                trailWidth = 1.7f;
                                trailLength = 5;
                                despawnEffect = Fx.hitBulletColor;
                            }};
                            parts.addAll(
                                    new RegionPart("-part"){{
                                        progress = PartProgress.recoil;
                                        mirror = false;
                                        under = true;
                                        top = true;
                                        y = (float) 29 /4;
                                        moveY = -2;
                                        outline = false;
                                    }}
                            );

                        }}
            );
        }};
        mbt70 = new TankUnitType("mbt-70"){{
            this.constructor=TankUnit::create;
            hitSize = 18;
            treadPullOffset = 5;
            speed = 1.4f;
            rotateSpeed = 1.1f;
            health = 2100;
            armor = 8;
            itemCapacity = 0;
            omniMovement = false;
            range = 700;
            outlineColor = Color.valueOf("000000ff");
            weapons.add(new Weapon(name + "-weapon"){{
                            layerOffset = 0.0001f;
                            outlineColor = Color.valueOf("000000ff");
                            reload = 252;
                            rotate = true;
                            recoil = 0;
                            rotateSpeed = 1.2f;
                            mirror = false;
                            x = 0;
                            y = 0;
                            cooldownTime = 30;
                            top = true;
                            shootSound = Sounds.largeCannon;
                            shootY = 45;
                            bullet = new BasicBulletType(600,20){{
                                pierce = true;
                                pierceCap = 3;
                                drag=  0.01f;
                                smokeEffect = Fx.shootBigSmoke;
                                shootEffect = Fx.shootBigColor;
                                width = 5;
                                height = 7;
                                lifetime = 28;
                                hitSize = 4;
                                trailWidth = 1.7f;
                                trailLength = 5;
                                despawnEffect = Fx.hitBulletColor;
                            }};
                            parts.addAll(
                                    new RegionPart("-part"){{
                                        progress = PartProgress.recoil;
                                        mirror = false;
                                        under = true;
                                        top = true;
                                        y = (float) 62/4;
                                        moveY = -2;
                                        outline = false;
                                    }}
                            );

                        }}
            );
        }};
        m1Abrams = new TankUnitType("m1-abrams"){{
            this.constructor=TankUnit::create;
            hitSize = 18;
            treadPullOffset = 5;
            speed = 1.4f;
            rotateSpeed = 1.1f;
            health = 2100;
            armor = 8;
            itemCapacity = 0;
            omniMovement = false;
            range = 700;
            outlineColor = Color.valueOf("000000ff");
            weapons.add(new Weapon(name + "-weapon"){{
                            layerOffset = 0.0001f;
                            outlineColor = Color.valueOf("000000ff");
                            reload = 252;
                            rotate = true;
                            recoil = 0;
                            rotateSpeed = 1.2f;
                            mirror = false;
                            x = 0;
                            y = 0;
                            cooldownTime = 30;
                            top = true;
                            shootSound = Sounds.largeCannon;
                            shootY = 45;
                            bullet = new BasicBulletType(600,20){{
                                pierce = true;
                                pierceCap = 3;
                                drag=  0.01f;
                                smokeEffect = Fx.shootBigSmoke;
                                shootEffect = Fx.shootBigColor;
                                width = 5;
                                height = 7;
                                lifetime = 28;
                                hitSize = 4;
                                trailWidth = 1.7f;
                                trailLength = 5;
                                despawnEffect = Fx.hitBulletColor;
                            }};
                            parts.addAll(
                                    new RegionPart("-part"){{
                                        progress = PartProgress.recoil;
                                        mirror = false;
                                        under = true;
                                        top = true;
                                        y = (float) 58 /4;
                                        moveY = -2;
                                        outline = false;
                                    }}
                            );

                        }}
            );
        }};
        //chinese unit tree
        mig24 = new HelicopterUnitType("mig-24"){{
            float unitRange = 28 * tilesize;
            health = 450;
            hitSize = 18;

            speed = 2.5f;
            accel = 0.04f;
            drag = 0.016f;
            rotateSpeed = 5.5f;

            circleTarget = true;
            lowAltitude = true;
            faceTarget = flying = true;
            range = unitRange;

            fallSpeed = 0.0015f;
            spinningFallSpeed = 4;
            fallSmokeY = -10f;
            engineSize = 0;

            constructor = CopterUnitEntity::new;

            rotors.add(
                    new Rotor(name + "-blade") {{
                        x = y = 0;
                        rotorSpeed = -30f;
                        bladeCount = 5;
                        rotorTopSizeScl = 0.8f;
                    }}
            );
        }};

    }
}


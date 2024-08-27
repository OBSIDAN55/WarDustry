package aor.content;

import aor.entities.HelicopterUnitType;
import aor.entities.entity.CopterUnitEntity;
import aor.type.Rotor;
import arc.func.Prov;
import arc.graphics.Color;
import arc.math.geom.Rect;
import arc.struct.ObjectIntMap;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.gen.Entityc;
import mindustry.gen.Sounds;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.TankUnitType;
import arc.struct.ObjectMap.Entry;
import mindustry.gen.*;

import static mindustry.Vars.tilesize;

public class aorUnits {
    public static UnitType
    //soviet unit tree
    bt7, t34, t64a, t90, t14,
    //support
    btr80, btr90,
    //naval
    rk183r, tk206m,
    //aviation
    tu160, tu22m,
    //heli
    mi24, mi28n, ka52,

    //usa unit tree
    m1CombatCar, m41, m48, mbt70, m1Abrams,
    //support
    uss1, uss2,
    //naval
    usn1, usn2,
    //aviation
    usa1, usa2,
    //heli
    ush1, ush2, ush3,
    //chinese unit tree
    t59, t80, t99, mbt2000, vt4,
    //support
    cs1, cs2,
    //naval
    cn1, cn2,
    //aviation
    ca1, ca2,
    //heli
    ch1, ch2, ch3,
    //todo naval units 1/9
    //todo air units 0/6
    //todo support units 2/6
    //todo heli units 3/9

    //coreUnits
    ruined;

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
        t64a = new TankUnitType("t-64a"){{
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
                                        y = 75/4;
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
                            shootSound = Sounds.shootSnap;
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
        btr90 = new TankUnitType("btr-90"){{
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
                            y = -16/4f;
                            cooldownTime = 30;
                            top = true;
                            shootSound = Sounds.shootSnap;
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
                                        y = 0;
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
                        shootSound = Sounds.shootSnap;
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
                            shootSound = Sounds.shootSnap;
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
        t59 = new TankUnitType("t-59"){{
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
                            shootY = 50;
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
                                        y = (float) 49 /4;
                                        moveY = -2;
                                        outline = false;
                                    }}
                            );

                        }}
            );
        }};
        t80 = new TankUnitType("t-80"){{
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
                                        y = (float) 59 /4;
                                        moveY = -2;
                                        outline = false;
                                    }}
                            );

                        }}
            );
        }};
        t99 = new TankUnitType("t-99"){{
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
                                        y = (float) 83 /4;
                                        moveY = -2;
                                        outline = false;
                                    }}
                            );

                        }}
            );
        }};
        mbt2000 = new TankUnitType("mbt-2000"){{
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
                                        y = (float) 100 /4;
                                        moveY = -2;
                                        outline = false;
                                    }}
                            );

                        }}
            );
        }};
        vt4 = new TankUnitType("vt-4"){{
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
                                        y = (float) 134 /4;
                                        moveY = -2;
                                        outline = false;
                                    }}
                            );

                        }}
            );
        }};

        //core units

        ruined = new TankUnitType("ruined"){{
            this.constructor = TankUnit::create;
            hitSize = 46f;
            treadPullOffset = 1;
            speed = 2.4f;
            health = 22000;
            armor = 26f;
            rotateSpeed = 1.7f;
            buildSpeed = 0.5f;
            mineTier = 2;
            mineSpeed = 7f;
            mineRange = 27f;
            rotateToBuilding = true;
            omniMovement = false;

            float xo = 231f/2f, yo = 231f/2f;
            treadRects = new Rect[]{new Rect(27 - xo, 152 - yo, 67, 73), new Rect(24 - xo, 51 - 9 - yo, 29, 17), new Rect(59 - xo, 18 - 9 - yo, 39, 19)};
             weapons.add(new Weapon(name+"-weapon"){{
                 outlineColor = Color.valueOf("000000ff");
                 reload = 3;
                 rotate = true;
                 recoil = 0.3f;
                 rotateSpeed = 1.9f;
                 mirror = true;
                 x = -10;
                 y = -3;
                 top = true;
                 shootSound = Sounds.shootSnap;
                 shootY = 8;

                 shoot = new ShootBarrel(){{
                     barrels = new float[]{
                             0f, 1f, 0f,
                             3f, 0f, 0f,
                             -3f, 0f, 0f,
                     };
                 }};
                 bullet = new BasicBulletType(20,600){{
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
             }});

        }};
        mi24 = new HelicopterUnitType("mi-24"){{
            float unitRange = 28 * tilesize;
            health = 450;
            hitSize = 90;

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
        mi28n = new HelicopterUnitType("mi-28n"){{
            float unitRange = 28 * tilesize;
            health = 450;
            hitSize = 90;

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
                        x = 0;
                        y =  98/4;
                        rotorSpeed = -60f;
                        bladeCount = 5;
                        rotorTopSizeScl = 1f;
                    }}
            );
        }};

        ka52 = new HelicopterUnitType("ka-52"){{
            float unitRange = 28 * tilesize;
            health = 450;
            hitSize = 90;

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
                        x = y =  0;
                        rotorSpeed = -50f;
                        bladeCount = 3;
                        rotorTopSizeScl = 1f;
                    }}
            );
        }};



        rk183r = new UnitType("rk-183r"){{
            this.constructor = UnitWaterMove::create;
            health = 450;
            hitSize = 90;

            speed = 2.5f;
            accel = 0.04f;
            drag = 0.016f;
            rotateSpeed = 5.5f;

            weapons.add(new Weapon(name +"-weapon1"){{
                x=0;
                y = 7.5f;
                outlineColor = Color.valueOf("000000ff");
                reload = 3;
                rotate = true;
                recoil = 0.3f;
                rotateSpeed = 1.9f;
                mirror = false;
                top = true;
                shootSound = Sounds.shootSnap;
                shootY = 2;
                bullet = new BasicBulletType(20,60){{
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
            }});
            weapons.add(new Weapon(name +"-weapon2"){{
                x=0;
                y = -12.5f;
                outlineColor = Color.valueOf("000000ff");
                reload = 4;
                rotate = true;
                recoil = 0.3f;
                rotateSpeed = 1.9f;
                mirror = false;
                top = true;
                shootSound = Sounds.shootSnap;
                shootY = 2;
                bullet = new BasicBulletType(20,60){{
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
            }});
        }};
        tk206m = new UnitType("tk-206m"){{
            this.constructor = UnitWaterMove::create;
            health = 450;
            hitSize = 90;

            speed = 2.5f;
            accel = 0.04f;
            drag = 0.016f;
            rotateSpeed = 5.5f;

            weapons.add(new Weapon(name +"-weapon1"){{
                x=0;
                y = 68/4f;
                outlineColor = Color.valueOf("000000ff");
                reload = 3;
                rotate = true;
                rotationLimit = 240f;
                recoil = 0.3f;
                rotateSpeed = 3.4f;
                mirror = false;
                top = true;
                shootSound = Sounds.shootSnap;
                shootY = 2;
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
                bullet = new BasicBulletType(20,60){{
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
            }});
            weapons.add(new Weapon(name +"-weapon2"){{
                x=0;
                y = -86/4f;
                outlineColor = Color.valueOf("000000ff");
                reload = 4;
                rotate = true;
                baseRotation = 180f;
                rotationLimit = 240f;
                recoil = 0.3f;
                rotateSpeed = 3.4f;
                mirror = false;
                top = true;
                shootSound = Sounds.shootSnap;
                shootY = 2;
                parts.addAll(
                        new RegionPart("-part"){{
                            progress = PartProgress.recoil;
                            rotation = 180f;
                            mirror = false;
                            under = true;
                            top = true;
                            y = 0;
                            moveY = -2;
                            outline = false;
                        }}
                );
                bullet = new BasicBulletType(20,60){{
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
            }});
        }};

    }
}


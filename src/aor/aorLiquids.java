package aor;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class aorLiquids {
    public static Liquid
    heavyOil, tightOil,lubricant, pressure, kerosene,gasoline,diesel, steam;
    public static void load(){
        heavyOil = new Liquid("heavyoil", Color.valueOf("4D220E")){{
            heatCapacity = 0.4f;
            viscosity = 0.6f;
            explosiveness = 1.2f;
            flammability = 1.5f;
        }};
        tightOil = new Liquid("tightoil", Color.valueOf("A65E2E")){{
            heatCapacity = 0.4f;
            viscosity = 0.6f;
            explosiveness = 1.2f;
            flammability = 1f;
        }};
        lubricant = new Liquid("lubricant", Color.valueOf("8A73C6FF")){{
            heatCapacity = 0.4f;
            viscosity = 0.6f;
            explosiveness = 1.2f;
            flammability = 1f;
        }};
        pressure = new Liquid("pressure", Color.white){{
            heatCapacity = 0.4f;
            viscosity = 0.6f;
            explosiveness = 1.2f;
            flammability = 1f;
            gas = true;
        }};
        kerosene = new Liquid("kerosene", Color.valueOf("E1E9F0cc")){{
            heatCapacity = 0.4f;
            viscosity = 0.6f;
            explosiveness = 1.2f;
            flammability = 1f;
        }};
        gasoline = new Liquid("gasoline", Color.valueOf("567148cc")){{
            heatCapacity = 0.4f;
            viscosity = 0.6f;
            explosiveness = 1.2f;
            flammability = 1f;
        }};
        diesel = new Liquid("diesel", Color.valueOf("BA914Dcc")){{
            heatCapacity = 0.4f;
            viscosity = 0.6f;
            explosiveness = 1.2f;
            flammability = 1f;
        }};
        steam = new Liquid("steam", Color.white){{
            heatCapacity = 0.4f;
            viscosity = 0.6f;
            explosiveness = 1.2f;
            flammability = 1f;
            gas = true;
        }};
    }
}

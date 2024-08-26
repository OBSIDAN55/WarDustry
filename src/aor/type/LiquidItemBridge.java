package aor.type;

import arc.util.io.Writes;
import arc.util.io.Reads;
import mindustry.content.Liquids;
import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.world.ItemBuffer;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Env;

public class LiquidItemBridge extends ItemBridge {

    public final int timerAccept = timers++;

    public float speed = 40f;
    public int bufferCapacity = 50;


    public LiquidItemBridge(String name) {
        super(name);
        hasPower = false;
        hasItems = true;
        hasLiquids = true;
        outputsLiquid = true;
        canOverdrive = false;
        group = BlockGroup.liquids;
        envEnabled = Env.any;
    }
    public class LiquidItemBridgeBuild extends ItemBridgeBuild{
        ItemBuffer buffer = new ItemBuffer(bufferCapacity);

        @Override
        public void updateTransport(Building other){
            if(buffer.accepts() && items.total() > 0 && liquids.get(Liquids.oil)> 0.0001f){
                buffer.accept(items.take());
            }
            if(warmup >= 0.25f){
                moved |= moveLiquid(other, liquids.current()) > 0.05f;
            }

            Item item = buffer.poll(speed / timeScale);
            if(timer(timerAccept, 4 / timeScale) && item != null && other.acceptItem(this, item)){
                moved = true;
                other.handleItem(this, item);
                buffer.remove();
            }
        }

        @Override
        public void doDump(){
            dump();
            dumpLiquid(liquids.current(), 1f);
        }

        @Override
        public void write(Writes write){
            super.write(write);
            buffer.write(write);
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);
            buffer.read(read);
        }
    }
}

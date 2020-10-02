package bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingPlayer extends Bowling{

    private String name;

    public String getName() {
        return name;
    }

    public BowlingPlayer(String name){
        this.name = name;
    }

    public void pitch(){
        setPitchingCount(getPitchingCount() - 1);
    }
}

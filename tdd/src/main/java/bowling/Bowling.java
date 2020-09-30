package bowling;

import java.util.List;
import java.util.Random;

public class Bowling {

    private int pin;
    private int pitchingCount;
    private int frame;

    public Bowling(){
        this.pin = 10;
        this.pitchingCount = 21;
        this.frame = frameCalc();
    }

    public int getPin(){
        return pin;
    }

    public int getPitchingCount(){
        return pitchingCount;
    }

    public int getFrame(){
        return frame;
    }

    public void pitch(){
        int nowFrame = frameCalc();
        this.pin -= (int)((Math.random()*10000)%10);
        this.pitchingCount -= 1;
        this.frame = pitchingCount / 2;
        if(nowFrame != frameCalc()){
            this.pin = 10;
        }
    }

    private int frameCalc(){
        return this.pitchingCount / 2;
    }

}

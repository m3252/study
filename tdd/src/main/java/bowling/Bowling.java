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

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setPitchingCount(int pitchingCount) {
        if(this.pitchingCount == 0){
            throw new RuntimeException("투구 횟수가 초과되었습니다.");
        }
        int nowFrame = getFrame();
        this.pin -= downPin();
        this.pitchingCount = pitchingCount;
        this.frame = pitchingCount / 2;
        if(nowFrame != getFrame()){
            this.pin =10;
        }
    }

    public void setFrame(int frame) {
        this.frame = frame;
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

    private int frameCalc(){
        return this.pitchingCount / 2;
    }

    public int downPin(){
        return (int)((Math.random()*10000)%10);
    }

}

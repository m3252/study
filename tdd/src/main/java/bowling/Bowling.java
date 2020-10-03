package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bowling extends BowlingScore{

    private int pin;
    private int pitchCount
;
    private int frame;
    private List<Integer> downPins;
    private List<BowlingScore> score;

    public Bowling(){
        this.pin = 10;
        this.pitchCount
 = 21;
        this.frame = 1;
        this.downPins = new ArrayList<>();
    }

    public void setPitchCount(int pitchCount) {
        if(this.pitchCount == 0){
            throw new RuntimeException("투구 횟수가 초과되었습니다.");
        }
        bowlingRule(downPin());
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public int getPin(){
        return pin;
    }

    public int getPitchCount(){
        return pitchCount
;
    }

    public int getFrame(){
        return frame;
    }

    public int downPin(){
        int downPin = (int)((Math.random()*10000) % getPin()+1);
        downPins.add(downPin);
        return downPin;
    }

    public List<Integer> getDownPins(){
        return downPins;
    }

    public int getDownPin(int index){
        return downPins.get(index);
    }

    private void bowlingRule(int downPin){
        int nowFrame = getFrame();
        if(downPin != 10){
            this.pin -= downPin;
            pitchCount -= 1;
            if (pitchCount % 2 != 0 && pitchCount != 21 && pitchCount != 1)
                this.frame ++;
            if (nowFrame != getFrame())
                this.pin = 10;
        }

        // 10프레임 이전 스트라이크
        if(downPin == 10 && frame != 10){
            this.frame ++;
            this.pin = 10;
            pitchCount -= 2;
        }
        // 10프레임 스트라이크
        if(downPin == 10 && frame == 10){
            this.pin = 10;
            pitchCount -= 1;
        }
        // 10프레임 스페어

    }
}

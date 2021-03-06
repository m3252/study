package bowling;

import java.util.ArrayList;
import java.util.List;

/**
 * 최상위 수준의 모듈
 */
public class Bowling{

    private int pin;
    private int pitchCount;
    private int frame;
    private final List<Integer> downPins;

    public Bowling(){
        this.pin = 10;
        this.pitchCount = 21;
        this.frame = 1;
        this.downPins = new ArrayList<>(21);
    }

    public void setPitchCount() {
        if(pitchCount == 0){
            throw new RuntimeException("투구 횟수가 초과되었습니다.");
        }
        pitchCount -= 1;
        int downPin = downPin();
        bowlingRule(downPin);
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
        //int downPin = 10;
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
        pin -= downPin;

        /**
         * 10프레임 이전 스트라이크 X
         */
        if(nowFrame < 10 && downPin != 10){
            if (pitchCount % 2 != 0 && pitchCount != 21)
                frame ++;
            if (nowFrame != getFrame())
                pin = 10;
        }

        /**
         * 10프레임 이전 스트라이크 O
         */
        if(nowFrame < 10 && downPin == 10){
            frame ++;
            pitchCount -= 1;
            pin = 10;
            downPins.add(-1);
        }

        /**
         * 10프레임 이후
         */
        if(nowFrame == 10 && pitchCount == 2 && downPin == 10) {
            pin = 10;
        }
        if(nowFrame == 10 && pitchCount == 1){
            if(getDownPin(18) + getDownPin(19) == 10){
                pin = 10;
            }else if(getDownPin(18) != 10){
                pitchCount -= 1;
                downPins.add(0);
            }
        }
    }
}

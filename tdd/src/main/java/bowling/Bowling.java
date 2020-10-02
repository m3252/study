package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bowling implements BowlingScore{

    private int pin;
    private int pitchingCount;
    private int frame;
    private List<Integer> downPins;
    private int score;

    public Bowling(){
        this.pin = 10;
        this.pitchingCount = 21;
        this.frame = 1;
        this.downPins = new ArrayList<>();
    }

    public void setPitchingCount(int pitchingCount) {
        if(this.pitchingCount == 0){
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

    public int getPitchingCount(){
        return pitchingCount;
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

    @Override
    public int getScore() {
        int score = 0;
        int spare = 0;
        int strike = 0;

        for (int i=0; i<downPins.size(); i++) {
            if((i+1) % 2 == 0){

            }

        }
        return score;
    }

    private void bowlingRule(int downPin){
        int nowFrame = getFrame();
        if(downPin != 10){
            this.pin -= downPin;
            pitchingCount -= 1;
            if (pitchingCount % 2 != 0 && pitchingCount != 21 && pitchingCount != 1)
                this.frame ++;
            if (nowFrame != getFrame())
                this.pin = 10;
        }

        // 10프레임 이전 스트라이크
        if(downPin == 10 && frame != 10){
            this.frame ++;
            this.pin = 10;
            pitchingCount -= 2;
        }

        // 10프레임 스트라이크
        if(downPin == 10 && frame == 10){
            this.pin = 10;
            pitchingCount -= 1;
        }

        // 10프레임 스페어


    }
}

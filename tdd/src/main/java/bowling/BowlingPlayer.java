package bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingPlayer extends Bowling implements BowlingScore{

    private String name;
    private List<Integer> scores;

    public BowlingPlayer(String name) {
        this.name = name;
        scores = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getScores() {
        scoreCalculator(getDownPins());
        return scores;
    }

    public void pitch() {
        setPitchCount();
    }

    public void scoreCalculator(List<Integer> downPins){
        int countByFrame = 0;
        int scoreByFrame = 0;
        int leftScore = 0;
        int rightScore = 0;
        for(int i = 0, n = downPins.size(); i < n; i++){
            countByFrame++;

            if(downPins.get(i) != -1){ //스트라이크 체크
                scoreByFrame += downPins.get(i);
            }

            if(countByFrame == 1 && scoreByFrame == 10){ //스트라이크 체크
                if((i+3) < downPins.size() -1){ // 마지막 투구 체크
                    leftScore =  downPins.get(i+2);
                    rightScore = downPins.get(i+3) == -1 ? 10 : downPins.get(i+3);
                    scoreByFrame += leftScore + rightScore;
                }
                scores.add(scoreByFrame);
                countByFrame = 0;
                scoreByFrame = 0;
                i++;
            }
            else if(countByFrame == 2){
                if(scoreByFrame == 10 && (i+1) != downPins.size() -1){ // 마지막가 아니고 스페어면
                    leftScore = downPins.get(i+1);
                    scoreByFrame += leftScore;
                }
                scores.add(scoreByFrame);
                countByFrame = 0;
                scoreByFrame = 0;
            }
        }
        scores.add(downPins.get(20));
    }

    @Override
    public String toString() {
        return "선수 이름 : " + "'" + name + '\''
                + " 투구 당 쓰러트린 핀{" + getDownPins() + '}'
                + " 점수 = " +
                getScores().stream().mapToInt(Integer::intValue).sum() + '}';
    }
}

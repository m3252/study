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
        int frameScore = 0;
        int frameCheckCount = 0;
        int frameScoreSum = 0;

        for(int i = 0, n = downPins.size(); i < n; i++){
            frameCheckCount++;

            if(downPins.get(i) != -1){
                frameScoreSum += downPins.get(i);
            }

            if(frameCheckCount == 1 && frameScoreSum == 10){
                if(i+3 != downPins.size() -1){
                    frameScoreSum += downPins.get(i+2);
                    frameScoreSum += downPins.get(i+3);
                }
                scores.add(frameScoreSum);
                frameCheckCount = 0;
                frameScoreSum = 0;
            }
            else if(frameCheckCount == 2 && frameScoreSum == 10){
                if(i+1 != downPins.size() -1) {
                    frameScoreSum += downPins.get(i + 1);
                }
                scores.add(frameScoreSum);
                frameCheckCount = 0;
                frameScoreSum = 0;
            }
            else if(frameCheckCount == 2){
                scores.add(frameScoreSum);
                frameCheckCount = 0;
                frameScoreSum = 0;
            }
        }
        scores.add(downPins.get(20));
    }

    @Override
    public String toString() {
        return "Player{" + "'" + name + '\'' + '}'
                + " DownPins{" + getDownPins() + '}'
                + " scores=" +
                getScores().stream().mapToInt(Integer::intValue).sum() + '}';
    }

}

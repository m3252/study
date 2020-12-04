package bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingPlayer extends Bowling implements PrintScore {

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

    public void scoreCalculator(List<Integer> downPins) {
        int countByFrame = 0;
        int scoreByFrame = 0;
        int leftScore = 0;
        int rightScore = 0;
        for (int i = 0, n = downPins.size(); i < n; i++) {
            countByFrame++;

            if (downPins.get(i) != -1) { // 이전 투구가 스트라이크인지 확인
                scoreByFrame += downPins.get(i);
            }

            if (countByFrame == 1 && scoreByFrame == 10) { // 스트라이크 체크
                if ((i + 3) < downPins.size() - 1) { // 마지막 투구 체크
                    leftScore = downPins.get(i + 2);
                    rightScore = downPins.get(i + 3) == -1 ? 10 : downPins.get(i + 3);
                    scoreByFrame += leftScore + rightScore;
                }
                scores.add(scoreByFrame);
                countByFrame = 0;
                scoreByFrame = 0;
                i++;
            } else if (countByFrame == 2) {
                if (scoreByFrame == 10 && (i + 1) < downPins.size() - 1) { // 마지막 투구가 아니고 스페어면
                    leftScore = downPins.get(i + 1);
                    scoreByFrame += leftScore;
                }
                scores.add(scoreByFrame);
                countByFrame = 0;
                scoreByFrame = 0;
            }
        }
        if (downPins.size() > 20) {
            scores.add(downPins.get(20));
        }
    }

    @Override
    public String toString() {
        return "선수 이름 : " + "'" + name + '\''
                + " 투구 당 쓰러트린 핀{" + getDownPins() + '}'
                + " 점수 = " +
                getScores().stream().mapToInt(Integer::intValue).sum() + '}';
    }

    @Override
    public void printScore() {
        int sum = 0;
        StringBuilder print = new StringBuilder("");
        int size = this.scores.size() == 11 ? 10 : this.scores.size();
        for (int i = 0; i < size; i++) {
            sum += this.scores.get(i);
            if(i == 9){
                sum += scores.get(i+1);
            }
            print.append(" | ").append(i + 1).append("Frame : ").append(sum).append(" | ");
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println(print.toString());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }
}

package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingPlayer extends Bowling implements BowlingScore{

    private String name;
    private List<Integer> scores;

    public BowlingPlayer(String name) {
        this.name = name;
        this.scores = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getScores() {
        return scoreCalculator(getDownPins());
    }

    public void pitch() {
        setPitchCount();
    }

    public List<Integer> scoreCalculator(List<Integer> downPins){


        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Player{" + "'" + name + '\'' + '}'
                + " DownPins{" + getDownPins() + '}'
                + " scores=" + scores.toString() + '}';
    }

}

package bowling;

public class BowlingPlayer extends Bowling{

    private String name;

    public String getName() {
        return name;
    }

    public BowlingPlayer(String name){
        this.name = name;
    }

    public void pitch(){
        setPitchCount();
    }
}

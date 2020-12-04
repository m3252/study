package solid.ocp;

/*
    코드를 수정하더라도 잠재적 버그에 안전하다.
    기존 코드를 변경하지 않더라도 새로운 일을 할 수 있다.
*/
public class SuperCoolGuitarWithFlames extends Guitar{

    private String flameColor;


    public SuperCoolGuitarWithFlames(String make, String model, int volume) {
        super(make, model, volume);
    }


    public void setFlameColor(String flameColor) {
        this.flameColor = flameColor;
    }

    public String getFlameColor() {
        return flameColor;
    }

}

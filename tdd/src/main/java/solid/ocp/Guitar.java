package solid.ocp;


// 개방 - 폐쇄 원칙
// 확장에는 열려있고 수정에는 닫혀야 한다.
public class Guitar {

    private String make;
    private String model;
    private int volume;

    public Guitar(String make, String model, int volume) {
        this.make = make;
        this.model = model;
        this.volume = volume;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getVolume() {
        return volume;
    }
}

package solid.lsp;

/*
    시대의 흐름에 따라 더 넓은 의미로 재평가 될 수 있다.
*/
public class ElectricCar implements Car{

    private Engine engine;

    @Override
    public void turnOnEngine() {
        throw new AssertionError("나는 엔진이 없어!");
    }

    @Override
    public void accelerate() {
        engine.powerOn();
    }
}

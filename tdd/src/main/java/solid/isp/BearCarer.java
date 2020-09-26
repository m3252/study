package solid.isp;

/*
    인터페이슬를 분리하여 자신이 필요한 행동만 의존하도록 했다.
    클라이언트가 자신이 이용하지 않는 메서드에 의존하지 않아야 한다.
*/
public class BearCarer implements BearCleaner, BearFeeder{
    @Override
    public void washTheBear() {

    }

    @Override
    public void feedTheBear() {

    }
}

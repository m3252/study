package solid.dip;

/*
* 상위 수준의 모듈은 하위 수준의 모듈에 의존해서는 안 된다. 둘 모두 추상화에 의존해야 한다.
* 추상화는 구체적인 사항에 의존해서는 안 된다. 구체적인 사항은 추상화에 의존해야 한다.
* 추상화에 의존하라!
*
* 변동성이 큰 구체 클래슬부터 파생되지 말 것.
* 변동성이 큰 구체 클래스를 참조하지 말 것.
* 구체 함수를 오버라이드 하지 말 것.
* 구체적이며 변동성이 크다면 절대로 그 이름을 언급하지 말 것.
* */

public class Windows98Machine {

    private final StandardKeyboard keyboard;

    private final Monitor monitor;


    public Windows98Machine(StandardKeyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}

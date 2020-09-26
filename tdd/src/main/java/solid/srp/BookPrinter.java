package solid.srp;

/*
    북 프린터를 북 객체에 넣을 경우 단일 책임 원칙 위반!
    클래스를 분리함으로써 더 좋은 확장성을 얻었다.
*/
public class BookPrinter {

    void printTextToConsole(){

    }

    void printTextToAnotherMedium(String text){

    }
}

package string_calc;

/*양수를 받는 숫자 객체*/
public class Positive {

    private int number;

    public Positive(String number){
        this(Integer.parseInt(number));
    }

    public Positive(int number){
        if(number < 0){
            throw new RuntimeException();
        }
        this.number = number;
    }

    public Positive add(Positive other){
        return new Positive(this.number + other.number);
    }

    public int getNumber(){
        return number;
    }


}

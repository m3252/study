package calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Calculator {

    private int value = 0;
    private List<Integer> historyList;

    Calculator(){ }
    Calculator(int value){
        this.value = value;
        historyList = new ArrayList<>();
    }
    public int getValue(){
        return value;
    }

    public int add(int input){
        this.value += input;
        addHistory(getValue());
        return getValue();
    }

    private void addHistory(int result){
        historyList.add(result);
    }

    public int getHistory(int index){
        if(0 > index || index > historyList.size() -1){
            return -1;
        }
        return Optional.ofNullable(historyList.get(index)).orElse(-1);
    }

    public void clear(){
        historyList.clear();
    }


}

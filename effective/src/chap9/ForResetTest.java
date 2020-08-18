package chap9;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ForResetTest {

    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();
        for(int i=0;  i < 10; i++){
            list.add(i);
        }

        for(int i=0, n = getListSize(list); i<n; i++){
            System.out.println(list.get(i));
        }
    }

    private static int getListSize(List list){
        System.out.println("getListSize ::");
        return list.size();
    }

}

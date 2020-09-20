package string_calc;

public class StringCalculator {

    // 2 들여쓰기를 제거하고 else를 제거한 버전
    public static int splitAndSum(String text){
        if(text == null ||text.isEmpty()){
            return 0;
        }
        String[] values = text.split(",|:");
        return sum(values);
    }

    public static int sum(String[] values){
        int result = 0;
        for(String value : values){
            result += Integer.parseInt(value);
        }
        return result;
    }
}

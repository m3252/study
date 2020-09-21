package string_calc;

public class StringCalculator {

    // 1. 들여쓰기(2depth)를 제거하고 else를 제거
    // 2. 메소드에서 한 가지 일만 하도록 변경, 로컬 변수 제거
    // 3. 컴포즈 패턴 메소드 적용. (1단계 추상화)
    // 4. 음수가 들어오면 RuntimeException, 양수를 받는 숫자 객체 추가
    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text){
        return text == null || text.isEmpty();
    }

    private static String[] split(String text){
        return text.split(",|:");
    }

    private static Positive[] toInts(String[] values) {
        Positive[] positives = new Positive[values.length];
        for (int i = 0; i < values.length; i++) {
            positives[i] = new Positive(values[i]);
        }
        return positives;
    }


    private static int sum(Positive[] numbers) {
        Positive result = new Positive(0);
        for (Positive number : numbers) {
            result = result.add(number);
        }
        return result.getNumber();
    }

}

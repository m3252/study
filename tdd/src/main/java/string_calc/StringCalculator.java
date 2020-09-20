package string_calc;

public class StringCalculator {

    // 1. 들여쓰기(2depth)를 제거하고 else를 제거
    // 2. 메소드에서 한 가지 일만 하도록 변경, 로컬 변수 제거
    // 3. 컴포즈 패턴 메소드 적용. (1단계 추상화)
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

    private static int[] toInts(String[] values) {
        int numbers[] = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

}

package chpa8;

import java.math.BigInteger;
import java.util.Objects;

public class ThrowsExceptionEx {

    public static void main(String[] args){

        sort(null , -1, -1);
//        BigInteger num = BigInteger.valueOf(-1);
//        System.out.println(mod(num));

        String nullChk = "널이 아닌데?";
        nullChk = Objects.requireNonNull(nullChk, "전략");
        System.out.println(nullChk);
    }

    /**
     * 현재 값 mod m 값을 반환한다. 이 메서드는
     * 항상 음이 아닌 BigInteger를 반환한다는 점에서 remainder 메서드와 다르다.
     *
     * @param m 계수(양수여야 한다.)
     * @return 현재 값 mod m
     * @throws ArithmeticException m이 0보다 작거나 같으면 발생한다.
     */
    public static BigInteger mod(BigInteger m) {
        if(m.signum() <= 0){
            throw new ArithmeticException("게수 (m)은 양수여야 한다." + m);
        }
        return m;
    }

    // public 이 아니면 Assert로 검사할 수 있다.
    private static void sort(long[] a, int offset, int length){
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
    }

}

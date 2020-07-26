package chap7;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.TWO;
import static java.math.BigInteger.ONE;

public class Mersenne {

    /*
     * 데이터 소스가 Stream.iterate 거나 중간 연산으로
     * limit 을 쓰면 파이프라인 병렬화로는 성능 개선을 기대할 수 없다.
     *
     * Stream 성능 효율은 ArratList, HashMap, HashSet, ConcurrentHashMap 의 인스턴스거나
     * 배열, int 범위, long 범위일 때 병렬화 효과가 가장 좋다.
     * */
    public static void main(String[] args){
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

    public static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }


}

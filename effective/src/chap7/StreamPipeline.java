package chap7;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class StreamPipeline {

    public static void main(String[] args){

        long s = System.currentTimeMillis();
        System.out.println(pi2(10000000));
        long e = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( e - s )/1000.0 );


    }


    // 소수 계산 스트림 파이프라인 - 병렬화에 적합하다. 19초
    static long pi1(long n){
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    // 소수 계산 스트림 파이프라인 - 병렬화 버전  4초 미르스틴
    static long pi2(long n){
            return LongStream.rangeClosed(2,n)
                    .parallel()
                    .mapToObj(BigInteger::valueOf)
                    .filter(i-> i.isProbablePrime(50))
                    .count();
    }




}

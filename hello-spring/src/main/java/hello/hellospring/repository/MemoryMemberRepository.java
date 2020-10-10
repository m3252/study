package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;



    public void clearStore(){
         store.clear();
    }
}

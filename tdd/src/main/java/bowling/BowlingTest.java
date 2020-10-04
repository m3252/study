package bowling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class BowlingTest {

    @Test
    void 객체가_존재하는지_확인한다(){
        Bowling bowling = new Bowling();
        BowlingPlayer player = new BowlingPlayer("Test");
    }

    @Test
    void 볼링객체의_값을_검증(){
        Bowling bowling = new Bowling();
        assertEquals(bowling.getPin(), 10);
        assertEquals(bowling.getPitchCount(), 21);
        assertTrue(bowling.getFrame() == 1);
    }

    @Test
    void 투구와_프레임_검증(){
        BowlingPlayer bp = new BowlingPlayer("Test");
        assertTrue(bp.getPin() == 10); // 투구전 핀은 10개
        assertTrue(bp.getFrame() == 1); // 프레임은 1로 시작
        assertTrue(bp.getPitchCount() == 21); // 21회로 시작
        bp.pitch(); // 첫 번째 투구
        if(bp.getPin() != 10){
            assertTrue(bp.getPitchCount() == 20);
            assertTrue(bp.getFrame() == 1);
        }else{
            assertTrue(bp.getPitchCount() == 19);
            assertTrue(bp.getFrame() == 2);
        }
    }

    @Test
    void 투구는_총_21(){
        BowlingPlayer bp = new BowlingPlayer("Test");
        RuntimeException e
                = assertThrows(RuntimeException.class, () ->{
            while(bp.getPitchCount() > 0){
                bp.pitch();
            }
            bp.pitch();
        });
        assertThat(e.getMessage()).isEqualTo("투구 횟수가 초과되었습니다.");
    }

    @Test
    void 넘어진_핀_테스트(){
        int sum = 0;
        int count = 0;
        BowlingPlayer player1 = new BowlingPlayer("player1");
        while(player1.getPitchCount() > 0){
            player1.pitch();
        }
        System.out.println(player1.getDownPins());
    }

    @Test
    void 점수테스트(){
        BowlingPlayer player1 = new BowlingPlayer("player1");
        BowlingPlayer player2 = new BowlingPlayer("player2");
        while(player1.getPitchCount() > 0){
            player1.pitch();
        }
        System.out.println(player1.toString());
        System.out.println(player1.getScores());
    }

    @Test
    void 존재하지않는_인덱스일땐(){
        List<Integer> testList = new ArrayList<>();
        RuntimeException e
                = assertThrows(RuntimeException.class, () ->{
            testList.remove(20);
        });
        assertThat(e.getMessage()).isEqualTo("Index: 20, Size: 0");
    }
}

package bowling;

import org.junit.jupiter.api.Test;
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
        assertEquals(bowling.getPitchingCount(), 21);
        assertTrue(bowling.getFrame() == 1);
    }

    @Test
    void 투구와_프레임_검증(){
        BowlingPlayer bp = new BowlingPlayer("Test");
        assertTrue(bp.getPin() == 10); // 투구전 핀은 10개
        assertTrue(bp.getFrame() == 1); // 프레임은 1로 시작
        assertTrue(bp.getPitchingCount() == 21);
        bp.pitch(); // 첫 번째 투구
        assertTrue(bp.getPitchingCount() == 20);
        assertTrue(bp.getFrame() == 1);
        bp.pitch(); // 두 번째 투구
        assertTrue(bp.getPitchingCount() == 19);
        assertTrue(bp.getPin() == 10);
        assertTrue(bp.getFrame() == 2);
        bp.pitch(); // 세 번째 투구
        assertTrue(bp.getFrame() == 2);
    }

    @Test
    void 투구는_총_21(){
        BowlingPlayer bp = new BowlingPlayer("Test");
        BowlingPlayer bp2 = new BowlingPlayer("Test2");
        RuntimeException e
                = assertThrows(RuntimeException.class, () ->{
            for(int i=1; i<=22; i++){
                bp.pitch();
            }
        });
        assertThat(e.getMessage()).isEqualTo("투구 횟수가 초과되었습니다.");
        bp2.pitch();
    }

    @Test
    void 점수쌓기_테스트(){
        int sum = 0;
        int count = 0;
        BowlingPlayer player1 = new BowlingPlayer("player1");
        for(int i=1; i<=21; i++){
            count ++;
            player1.pitch(); //공을 굴리면
            sum += player1.getDownPin(i-1);
            assertThat(sum < 10);
            if(count == 2 && i != 20)
                sum = 0;
        }
    }

    @Test
    void 점수계산기_테스트(){
        BowlingPlayer player1 = new BowlingPlayer("player1");
        player1.getScore();
    }
}

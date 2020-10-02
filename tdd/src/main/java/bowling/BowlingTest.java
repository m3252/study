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
        BowlingScore score = new BowlingScore();
    }

    @Test
    void 볼링객체의_값을_검증(){
        Bowling bowling = new Bowling();
        assertEquals(bowling.getPin(), 10);
        assertEquals(bowling.getPitchingCount(), 21);
        assertTrue(bowling.getFrame() == 10);
    }

    @Test
    void 투구와_프레임_검증(){
        BowlingPlayer bp = new BowlingPlayer("Test");
        assertTrue(bp.getPin() == 10); // 투구전 핀은 10개
        assertTrue(bp.getFrame() == 10); // 프레임은 10으로 시작
        bp.pitch(); // 첫 번째 투구
        System.out.println(bp.getPin()); // 투구후 핀은 모른다.

        assertTrue(bp.getFrame() == 10); // 첫 투구가 끝나도 프레임은 10
        bp.pitch(); // 두 번째 투구
        assertTrue(bp.getFrame() == 9); // 두 번째 투구가 끝나면 프레임은 9
        assertTrue(bp.getPin() == 10); // 새로운 프레임이 시작되면 핀은 초기화
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


}

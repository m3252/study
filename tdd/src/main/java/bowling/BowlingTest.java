package bowling;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BowlingTest {

    @Test
    void 객체가_존재하는지_확인한다(){
        Bowling bowling = new Bowling();
        BowlingPlayer player = new BowlingPlayer();
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
        Bowling bowling = new Bowling();
        assertTrue(bowling.getPin() == 10); // 투구전 핀은 10개
        assertTrue(bowling.getFrame() == 10); // 프레임은 10으로 시작
        bowling.pitch(); // 첫 번째 투구
        System.out.println(bowling.getPin()); // 투구후 핀은 모른다.

        assertTrue(bowling.getFrame() == 10); // 첫 투구가 끝나도 프레임은 10
        bowling.pitch(); // 두 번째 투구
        assertTrue(bowling.getFrame() == 9); // 두 번째 투구가 끝나면 프레임은 9
        assertTrue(bowling.getPin() == 10); // 새로운 프레임이 시작되면 핀은 초기화
    }
}

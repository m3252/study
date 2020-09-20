package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    public void 초기화(){
        calc = new Calculator(20);
    }


    @Test
    public void 계산기_초기값은_0이다(){
        Calculator calc = new Calculator();
        assertEquals(0, calc.getValue());
    }

    @Test
    public void 생성자를_통해서_값을_주입한다(){
        Calculator calc1 = new Calculator(20);
        Calculator calc2 = new Calculator(30);
        assertFalse(calc2.getValue() == 20);
        assertTrue(calc2.getValue() == 30);
        assertTrue(calc1.getValue() == 20);
     }

    @Test
    public void 더하기_함수를_제공한다(){
        Calculator calc = new Calculator(20);
        assertEquals(20, calc.getValue());
        calc.add(10);
        assertEquals(30, calc.getValue());
    }

    @Test
    public void 히스토리를_쌓는다(){
        Calculator calc = new Calculator(20);
        assertEquals(20, calc.getValue());
        calc.add(10);
        assertEquals(calc.getHistory(0), 30);
        calc.add(10);
        assertEquals(calc.getHistory(1), 40);
        calc.add(10);
        assertEquals(calc.getHistory(2), 50);
    }

    @Test
    public void 히스토리를_지운다(){
        calc.add(10);
        assertTrue(calc.getHistory(0) == 30 );
        calc.clear();
        assertTrue(calc.getHistory(0) == -1);
        calc.add(10);
        assertTrue(calc.getHistory(0) != -1);
    }

    @Test
    public void 히스토리를_검증한다(){
        calc.clear();
        calc.add(10);
        calc.add(20);
        calc.add(30);
        assertEquals(calc.getHistory(0), 10);
        assertEquals(calc.getHistory(1),20);
        assertEquals(calc.getHistory(2), 30);
    }
}

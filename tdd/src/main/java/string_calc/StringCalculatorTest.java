package string_calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    public void null_또는_빈값(){
        assertEquals((StringCalculator.splitAndSum(null)), 0);
        assertEquals((StringCalculator.splitAndSum("")),0);
    }

    @Test
    public void 값_하나(){
        assertEquals((StringCalculator.splitAndSum("1")), 1);
    }

    @Test
    public void 쉼표_구분자(){
        assertEquals((StringCalculator.splitAndSum("1,2")), 3);
    }

    @Test
    public void 쉼표_콜론_구분자(){
        assertEquals((StringCalculator.splitAndSum("1,2:3")), 6);
    }

}
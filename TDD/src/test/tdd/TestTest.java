package tdd;

import org.junit.jupiter.api.Test;
import tdd.vo.Dollar;

import static org.junit.jupiter.api.Assertions.*;

class TestTest {

    @Test
    public void testMultiplication(){
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.getAmount());
    }

}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;//import org.junit.jupiter.api.Assertions;

class CalculatorTest {


    @Test
    void checkTwoAddThreeIsFive() {
        Calculator calculator = new Calculator();
        double actualSum = calculator.add(2,3);
        double expectedSum=5;
        assertEquals(expectedSum,actualSum);
    }
}
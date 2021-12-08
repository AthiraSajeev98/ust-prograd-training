import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    Square square;

    @Test
    public void checkAreaIsErrorWhenLengthIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Square(-2));
    }

    @Test
    public void checkAreaIsErrorWhenLengthIsZero() {
        assertThrows(IllegalArgumentException.class, () -> new Square(0));
    }


    @Nested
    class TestArea {

        @Test
        public void checkAreaIsTenWhenLengthIsTwoAndBreadthIsFive() {
            square = new Square(5);
            double actualArea = square.area();
            double expectedArea = 25;
            assertEquals(expectedArea, actualArea);
        }

        @Test
        public void checkAreaIsTenWhenLengthIsTwoPointFiveAndBreadthIsFivePointFive() {
            square = new Square(2.5);
            double actualArea = square.area();
            double expectedArea = 6.25;
            assertEquals(expectedArea, actualArea);
        }

    }

    @Nested
    class TestPerimeter {

        @Test
        public void checkPerimeterIsEightWhenLengthIsTwo() {
            square = new Square(2);
            double actualPerimeter = square.perimeter();
            double expectedPerimeter = 8;
            assertEquals(expectedPerimeter, actualPerimeter);
        }

        @Test
        public void checkPerimeterIsTenWhenLengthIsTwoPointFive() {
            square = new Square(2.5);
            double actualArea = square.perimeter();
            double expectedArea = 10;
            assertEquals(expectedArea, actualArea);
        }
    }

}


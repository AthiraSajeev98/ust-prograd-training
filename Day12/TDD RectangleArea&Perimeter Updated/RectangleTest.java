import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    Rectangle rectangle = new Rectangle(10, 10);
    double defaultExpectedArea = rectangle.area();
    double defaultExpectedPerimeter = rectangle.perimeter();

    @Nested
    class TestingAreaOfReactangle {


        @Test
        public void checkAreaIsHundredWhenDefaultLengthIsTenAndDefaultBreadthIsTen() {
            double actualArea = rectangle.area();
            assertEquals(defaultExpectedArea, actualArea);
        }

        @Test
        public void checkAreaIsTenWhenLengthIsFiveAndBreadthIsTwo() {
            double actualArea = rectangle.area(5, 2);
            double expectedArea = 5 * 2;
            assertEquals(expectedArea, actualArea);
        }


        @Test
        public void checkAreaIsTenPointZeroWhenLengthIsFivePointZeroAndBreadthIsTwoPointZero() {
            double actualArea = rectangle.area(5.0, 2.0);
            double expectedArea = 5.0 * 2.0;
            assertEquals(expectedArea, actualArea);
        }

        @Test
        public void checkPerimeterIsZeroWhenLengthIsFiveAndBreadthIsZero() {
            assertThrows(ArithmeticException.class, () -> rectangle.area(5, 0));
        }

    }

    @Nested
    class TestPerimeterOfReactangle {

        @Test
        public void checkPerimeterIsFourtyWhenDefaultLengthIsTenAndDefaultBreadthIsTen() {
            double actualArea = rectangle.perimeter();
            assertEquals(defaultExpectedPerimeter, actualArea);
        }

        @Test
        public void checkPerimeterIsFourteenWhenLengthIsFiveAndBreadthIsTwo() {
            double actulaPerimeter = rectangle.perimeter(5, 2);
            double expectedPerimeter = 2 * (5 + 2);
            assertEquals(expectedPerimeter, actulaPerimeter);
        }

        @Test
        public void checkPerimeterIsZeroWhenLengthIsFiveAndBreadthIsZero() {
            assertThrows(ArithmeticException.class, () -> rectangle.perimeter(5, 0));
        }

        @Test
        public void checkPerimeterIsFourWhenLengthIsOneAndBreadthIsOne() {
            double actulaPerimeter = rectangle.perimeter(1, 1);//Shift F6
            double expectedPerimeter = 2 * (1 + 1);
            assertEquals(expectedPerimeter, actulaPerimeter);
        }
    }
}
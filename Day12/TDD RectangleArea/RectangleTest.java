import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    Rectangle rectangle = new Rectangle();

    @Nested
    class TestingAreaOfReactangle {
        @Test
        public void checkAreaIsTenWhenLengthIsFiveAndBreadthIsTwo() {
            double actualArea = rectangle.area(5, 2);
            double expectedArea = 5 * 2;
            assertEquals(expectedArea, actualArea);
        }

        @Test
        public void checkAreaIsTenPointFourWhenLengthIsFivePoinTwoAndBreadthIsTwo() {
            double actualArea = rectangle.area(5.2, 2);
            double expectedArea = 5.2 * 2;
            assertEquals(expectedArea, actualArea);
        }

        @Test
        public void checkAreaIsTenPointZeroWhenLengthIsFivePointZeroAndBreadthIsTwoPointZero() {
            double actualArea = rectangle.area(5.0, 2.0);
            double expectedArea = 5.0 * 2.0;
            assertEquals(expectedArea, actualArea);
        }

    }

}
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    Rectangle rectangle;

    @Test
    public void checkAreaIsErrorWhenLengthOrBreadthIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-2, 5));
    }


    @Nested
    class TestArea {

        @Test
        public void checkAreaIsTenWhenLengthIsTwoAndBreadthIsFive() {
            rectangle = new Rectangle(2, 5);
            double actualArea = rectangle.area();
            double expectedArea = 10;
            assertEquals(expectedArea, actualArea);
        }

        @Test
        public void checkAreaIsTenWhenLengthIsTwoPointFiveAndBreadthIsFivePointFive() {
            rectangle = new Rectangle(2.5, 5.5);
            double actualArea = rectangle.area();
            double expectedArea = 13.75;
            assertEquals(expectedArea, actualArea);
        }

    }

    @Nested
    class TestPerimeter {

        @Test
        public void checkPerimeterIsFourteenWhenLengthIsTwoANdBreadthIsFive() {
            rectangle = new Rectangle(2, 5);
            double actualPerimeter = rectangle.perimeter();
            double expectedPerimeter = 14;
            assertEquals(expectedPerimeter, actualPerimeter);
        }

        @Test
        public void checkPerimeterIsTenWhenLengthIsTwoPointFiveAndBreadthIsFivePointFive() {
            rectangle = new Rectangle(2.5, 5.5);
            double actualArea = rectangle.perimeter();
            double expectedArea = 16;
            assertEquals(expectedArea, actualArea);
        }
    }

}

//    using data members for dimensions
//        setting the values of these data members in a parameterised constructor
//        throwing exception for invalid dimension in constructor itself
//        creating new rectangle for each test case
//        Rectangle rectangle = new Rectangle(4,5);

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthConverterTest {
    LengthConverter lengthConverter = new LengthConverter();

    @Nested
    class CentimeterToCentimeterTest {
        @Test
        public void checkIfOneCentimeterEqualToOneCentimeter() {
            double actualMagnitude = lengthConverter.centiToCenti(1);
            double expectedMagnitude = 1;
            assertEquals(expectedMagnitude, actualMagnitude);

        }

        @Test
        public void checkIfOnePointFiveCentimeterEqualToOnePointFiveCentimeter() {
            double actualMagnitude = lengthConverter.centiToCenti(1.5);
            double expectedMagnitude = 1.5;
            assertEquals(expectedMagnitude, actualMagnitude);
        }

    }

    @Nested
    class MeterToCentimeterTest {
        @Test
        public void checkIfOneMeterEqualToHundredCentimeter() {
            double actualMagnitude = lengthConverter.baseToCenti(1);
            double expectedMagnitude = 100;
            assertEquals(expectedMagnitude, actualMagnitude);
        }

        @Test
        public void checkIfOnePointFiveMeterEqualToOneHundredFiftyCentimeter() {
            double actualMagnitude = lengthConverter.baseToCenti(1.5);
            double expectedMagnitude = 150;
            assertEquals(expectedMagnitude, actualMagnitude);
        }


    }

    @Nested
    class CentimeterToKilometerTest {
        @Test
        public void checkIfHundredCentimeterEqualToOneThousandthKilometer() {
            double actualMagnitude = lengthConverter.centiToKilo(100);
            double expectedMagnitude = 0.001;
            assertEquals(expectedMagnitude, actualMagnitude);
        }

        @Test
        public void checkIfOneHundredFiftyCentimeterEqualToFifteenThousandthKilometer() {
            double actualMagnitude = lengthConverter.centiToKilo(150);
            double expectedMagnitude = 0.0015;
            assertEquals(expectedMagnitude, actualMagnitude);
        }

    }

    @Nested
    class AdditionOfMagnitudes {

        @Test
        public void checkIfAdditionOfOneMeterAndHundredCentimeterGivesTwoMeters() {
            double actualMagnitude =1+ lengthConverter.centiToBase(100);
            double expectedMagnitude = 2;
            assertEquals(expectedMagnitude, actualMagnitude);
        }

        @Test
        public void checkIfAdditionOfTwoHundredCentimetersAndOneKilometersGivesOneLakhAndTwoHundredCentimeters() {
            double actualMagnitude = 200+ lengthConverter.kiloToCenti(1);
            double expectedMagnitude = 100200;
            assertEquals(expectedMagnitude, actualMagnitude);

        }
    }

    @Nested
    class SubtractionOfMagnitudes {

        @Test
        public void checkIfSubtractionOfOneMeterAndFiftyCentimeterGivesPointFiveMeters() {
            double actualMagnitude = 1- lengthConverter.centiToBase(50);
            double expectedMagnitude = 0.5;
            assertEquals(expectedMagnitude, actualMagnitude);
        }

        @Test
        public void checkIfSubtractionOfTwoThousandCentimeterAndOneMeterGivesNineteenHundredCentimeters() {
            double actualMagnitude = 2000- lengthConverter.baseToCenti(1);
            double expectedMagnitude = 1900;
            assertEquals(expectedMagnitude, actualMagnitude);
        }
    }

}

//As an architect, I want to able to check if 1 cm is equal to 1 cm.
//As an architect, I want to be able to check if 1 m is equal to 100 cm,
//and 100 cm is equal to 0.001 km.

//As an architect, I want to be able to know that 1 m + 100 cm = 2 m,
// or 200 cm + 1 km = 100200 cm.
//As an architect, I want to be able to know that 1 m - 50 cm = 0.5 m,
// 2000 cm – 1 m = 1900 cm.
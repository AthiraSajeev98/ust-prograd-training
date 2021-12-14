import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProbabilityFinderTest {
    ProbabilityFinder probabilityFinder = new ProbabilityFinder();

    //As a statistician, I want to be able to know that the probability of a heads in a coin toss
    //is equal to the probability of a tails in a coin toss.
    @Nested
    public class ProbabilityOfSingleCoinTossTest {
        @Test
        public void checkIfProbabilityOfOccurringHeadIsEqualToProbabilityOfOccurringTail() {
            double occurringHead = probabilityFinder.probabilityOfTossingASingleCoin("H");
            double occurringTail = probabilityFinder.probabilityOfTossingASingleCoin("T");

            assertEquals(occurringHead, occurringTail);
        }

        @Test
        public void checkExceptionWhenTossingASingleCoin() {
            assertThrows(IllegalArgumentException.class, () -> probabilityFinder.probabilityOfTossingASingleCoin("A"));
        }

    }

    //As a statistician, I want to be able to know the probability of two events occurring together.
    @Nested
    public class ProbabilityOfSingleCoinTossedTwiceTest {
        @Test
        public void checkIfProbabilityOfTwoEventsOccurringTogetherIsEqualToPointTwoFive() {
            double occurringEventTogether = probabilityFinder.probabilityOfTossingASingleCoinTwice("HH");
            assertEquals(.25, occurringEventTogether);
        }

        //As a statistician, I want to be able to know the probability of an event not occurring.

        @Test
        public void checkIfProbabilityOfAnEventNotOccurringIsEqualToPointTwoFive() {
            double occurringEventTogether = 1 - probabilityFinder.probabilityOfTossingASingleCoinTwice("H");
            assertEquals(.25, occurringEventTogether);
        }

        //As a statistician, I want to be able to know the probability of either two events occurring.

        @Test
        public void checkIfProbabilityOfEitherHeadAndTailOrTailAndHeadOccurringIsEqualToPointFive() {
            double occurringEventTogether = probabilityFinder.probabilityOfEitherTwoEventsOccurring();
            assertEquals(0.5, occurringEventTogether);
        }


        @Test
        public void checkExceptionWhenInvalidTossOccurs() {
            assertThrows(IllegalArgumentException.class, () -> probabilityFinder.probabilityOfTossingASingleCoinTwice("AH"));
        }
    }
}
//As a statistician, I want to be able to know that the probability of a heads in a coin toss
//is equal to the probability of a tails in a coin toss.
//As a statistician, I want to be able to know the probability of two events occurring together.
//As a statistician, I want to be able to know the probability of an event not occurring.
//As a statistician, I want to be able to know the probability of either two events occurring.
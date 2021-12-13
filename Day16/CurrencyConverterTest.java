import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {
    CurrencyConverter currencyConverter = new CurrencyConverter();

    @Nested
    public class RupeesToDollarTest {
        @Test
        public void checkIfSeventyFourPointEightFiveRupeesIsEqualToOneDollar() {
            double actualCurrencyValue = currencyConverter.rupeesToDollar(74.85);
            double expectedCurrencyValue = 1;
            assertEquals(expectedCurrencyValue, actualCurrencyValue);
        }
    }

    @Nested
    public class AddMoneyToWalletTest {
        @Test
        public void checkIfAdditionOfFiftyRupeesAndOneDollarIsEqualToOneHundredAndTwentyFourPointEightFiveRupees() {
            currencyConverter.addRupeesToWallet(50);
            currencyConverter.addDollarsToWallet(1);
            assertEquals(124.85, currencyConverter.getWalletBalance("Rs"));


            //System.out.println(currencyConverter.getWalletBalance("Rs"));
        }

        @Test
        public void checkIfAdditionOfSeventyFourPointEightFiveRupeesAndOneDollarAndOneHundredAndFortyNinePointSevenRupeesGivesFourDollars() {
            currencyConverter.addRupeesToWallet(74.85);
            currencyConverter.addDollarsToWallet(1);
            currencyConverter.addRupeesToWallet(149.7);
            assertEquals(4, currencyConverter.getWalletBalance("$"));
            //System.out.println(currencyConverter.getWalletBalance("$"));
        }
    }
    @Nested
    public class WithdrawMoneyFromWalletTest {
        @Test
        public void checkIfWithdrawalOfOneDollarFromOneHundredAndTwentyFourPointEightFiveRupeesGivesFiftyRupees() {
            currencyConverter.addRupeesToWallet(50);
            currencyConverter.addDollarsToWallet(1);
            currencyConverter.withdrawDollarsFromWallet(1);
            assertEquals(50, currencyConverter.getWalletBalance("Rs"));
            //System.out.println(currencyConverter.getWalletBalance("Rs"));
        }

        @Test
        public void checkIfWithdrawalOfOneHundredAndFortyNinePointSevenRupeesFromFourDollarsGivesTwoDollars() {
            currencyConverter.addRupeesToWallet(74.85);
            currencyConverter.addDollarsToWallet(1);
            currencyConverter.addRupeesToWallet(149.7);
            currencyConverter.withdrawRupeesFromWallet(149.7);
            assertEquals(2, currencyConverter.getWalletBalance("$"));
            //System.out.println(currencyConverter.getWalletBalance("$"));
        }


    }


}

//    As a wallet owner, I would like to be able to know that 74.85 rupees is equal to 1 dollar.
//        As a wallet owner I would like to be able to put money into my wallet so that I can take it out later.
//        As a wallet owner, I want to know the total money my wallet has for the preferred currency. When Rs.50 & $1 added to my wallet,
//        Then the sum of money in the wallet is Rs.124.85, (Given preferred currency is Rs.)

//    As a wallet owner, I want to know the total money my wallet has for the preferred currency.
//    When Rs.74.85, $1, Rs.149.7 added to my wallet, Then sum of money in the wallet is $4, (Given preferred currency is $)
//        As a wallet owner I would like to be able to take a specified amount of money out of the wallet.
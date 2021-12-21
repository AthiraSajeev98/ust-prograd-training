
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


class CurrencyConverter {
    final double USDININR = 76.08;
    final double OMRININR = 197.49;
    final double AEDININR = 20.70;
    final double EURININR = 85.63;

    double amount;


    public double rupeesToDollars(double rupees) {
        return rupees / USDININR;
    }

    public double dollarsToRupees(double dollars) {
        return dollars * USDININR;
    }

    public double rupeesToOmaniRiyal(double rupees) {
        return rupees / OMRININR;
    }

    public double omaniRiyalToRupees(double omaniRiyal) {
        return omaniRiyal * OMRININR;
    }

    public double rupeesToUnitedArabEmiratesDirham(double rupees) {
        return rupees / AEDININR;
    }

    public double unitedArabEmiratesDirhamToRupees(double uaeDirham) {
        return uaeDirham * AEDININR;
    }

    public double rupeesToEuro(double rupees) {
        return rupees / EURININR;
    }

    public double euroToRupees(double euro) {
        return euro * EURININR;
    }

    public double round(double value) {
        return (double) Math.round(value * 100) / 100;
    }


    public double getAmount() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the amount to be convert:");
            amount = scanner.nextDouble();
            if (amount <= 0) {
                throw new IllegalArgumentException("The amount cannot be negative or zero");
            }

        } catch (IllegalArgumentException iae) {
            System.out.println("The amount cannot be negative or zero");
        }
        return amount;
    }
}

public class CurrencyConverterApplication {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter currencyConverter = new CurrencyConverter();


        Logger logger = Logger.getLogger("MyLog");
        FileHandler fileHandler;
        fileHandler = new FileHandler("log.txt");
        logger.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.info("Program Started...");


        int exit = 0;
        System.out.println("*#*#*#**#*#*#*WELCOME TO CURRENCY CONVERTER APPLICATION*#*#*#**#*#*#*");
        while (exit < 1) {
            double amount = 0;
            double convertedAmount = 0;
            System.out.println("    USDtoINR -> DollarsToRupees");
            System.out.println("    INRtoUSD -> RupeesToDollars");
            System.out.println("    OMRtoINR -> OmaniRiyalToRupees");
            System.out.println("    INRtoOMR -> RupeesToOmaniRiyal");
            System.out.println("    AEDtoINR -> UnitedArabEmiratesDirhamToRupees");
            System.out.println("    INRtoAED -> RupeesToUnitedArabEmiratesDirham");
            System.out.println("    EURtoINR ->EuroToRupees");
            System.out.println("    INRtoEUR -> RupeesToEuro");
            System.out.println("    exit -> exit loop");
            System.out.println("Enter the desired conversion : ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "USDtoINR":
                    logger.info("User selected Rupees to US Dollar conversion");
                    System.out.println("*********Converting USD to INR*********");
                    amount = currencyConverter.getAmount();
                    logger.info("User entered amount in USD : " + amount);
                    convertedAmount = currencyConverter.round(currencyConverter.dollarsToRupees(amount));
                    System.out.println("Amount converted to INR : " + convertedAmount);
                    System.out.println("*********Conversion Completed*********");
                    logger.info("Amount converted to INR : " + convertedAmount);
                    break;

                case "INRtoUSD":
                    logger.info("User selected Dollar to Rupees conversion");
                    System.out.println("*********Converting INR to USD*********");
                    amount = currencyConverter.getAmount();
                    logger.info("User entered amount in INR : " + amount);
                    convertedAmount = currencyConverter.round(currencyConverter.rupeesToDollars(amount));
                    System.out.println("Amount converted to USD : " + convertedAmount);
                    System.out.println("*********Conversion Completed*********");
                    logger.info("Amount converted to USD : " + convertedAmount);
                    break;

                case "OMRtoINR":
                    logger.info("User selected Omani Rial to Rupees conversion");

                    System.out.println("*********Converting OMR to INR*********");
                    amount = currencyConverter.getAmount();
                    logger.info("User entered amount in OMR: " + amount);
                    convertedAmount = currencyConverter.round(currencyConverter.omaniRiyalToRupees(amount));
                    System.out.println("Amount converted to INR : " + convertedAmount);
                    System.out.println("*********Conversion Completed*********");
                    logger.info("Amount converted to INR : " + convertedAmount);
                    break;

                case "INRtoOMR":
                    logger.info("User selected Rupees to Omani Rial");
                    System.out.println("*********Converting INR to OMR*********");
                    amount = currencyConverter.getAmount();
                    logger.info("User entered amount in INR : " + amount);
                    convertedAmount = currencyConverter.round(currencyConverter.rupeesToOmaniRiyal(amount));
                    System.out.println("Amount converted to OMR : " + convertedAmount);
                    System.out.println("*********Conversion Completed*********");
                    logger.info("User entered amount : " + convertedAmount);
                    break;

                case "AEDtoINR":
                    logger.info("User selected United Arab Emirates Dirham to Rupees");
                    System.out.println("*********Converting AED to INR*********");
                    amount = currencyConverter.getAmount();
                    logger.info("User entered amount in AED : " + amount);
                    convertedAmount = currencyConverter.round(currencyConverter.unitedArabEmiratesDirhamToRupees(amount));
                    System.out.println("Amount converted to INR : " + convertedAmount);
                    System.out.println("*********Conversion Completed*********");
                    logger.info("Amount converted to INR : " + convertedAmount);
                    break;

                case "INRtoAED":
                    logger.info("User selected Rupees to United Arab Emirates Dirham");
                    System.out.println("*********Converting INR to AED*********");
                    amount = currencyConverter.getAmount();
                    logger.info("User entered amount in INR: " + amount);
                    convertedAmount = currencyConverter.round(currencyConverter.rupeesToUnitedArabEmiratesDirham(amount));
                    System.out.println("Amount converted to AED : " + convertedAmount);
                    System.out.println("*********Conversion Completed*********");
                    logger.info("User entered amount : " + convertedAmount);
                    break;

                case "EURtoINR":
                    logger.info("User selected Euro to Rupees");
                    System.out.println("*********Converting EUR to INR*********");
                    amount = currencyConverter.getAmount();
                    logger.info("User entered amount in EUR : " + amount);
                    convertedAmount = currencyConverter.round(currencyConverter.euroToRupees(amount));
                    System.out.println("Amount converted to INR : " + convertedAmount);
                    System.out.println("*********Conversion Completed*********");
                    logger.info("Amount converted to INR : " + convertedAmount);
                    break;

                case "INRtoEUR":
                    logger.info("User selected Rupees to Euro");

                    System.out.println("*********Converting INR to EUR*********");
                    amount = currencyConverter.getAmount();
                    logger.info("User entered amount : " + amount);
                    convertedAmount = currencyConverter.round(currencyConverter.rupeesToEuro(amount));
                    System.out.println("Amount converted to EUR : " + convertedAmount);
                    System.out.println("*********Conversion Completed*********");
                    logger.info("User entered amount : " + convertedAmount);
                    break;

                case "exit":
                    exit++;
                    break;

                default:
                    System.out.println("Please Enter A Valid Input");

            }
        }
        System.out.println("THANKYOU VISIT AGAIN....!");
        logger.info("Program Stopped...");
    }
}


//Make a console based currency converter application with suppport for atleast 5 currencies.
//Requirements:
//1. Must be a menu driven program.
//2. All currencies to be displayed correct upto 2 decimal places.
//3. Each interaction of the user with the program must be logged in a log.txt file
//`log.txt` example contents -
//Program started.
//User selected INR
//User selected USD
//User entered amount 1400
//Program stopped.
//4. Add exception handling for when user enters invalid amount or chooses invalid option



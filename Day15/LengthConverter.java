public class LengthConverter extends MagnitudeConverter{
//base = magnitudeInMeter or magnitudeInGram

    public double centimeterToCentimeter(double magnitudeInCentimeter) {

        return magnitudeInCentimeter;
    }

    public double meterToCentimeter(double magnitudeInmeter) {

        return magnitudeInmeter * 100;

    }

    public double centimeterToMeter(double magnitudeInCentimeter) {

        return magnitudeInCentimeter / 100;
    }


    public double kilometerToCentimeter(double magnitudeInKilometer) {

        return magnitudeInKilometer * 100000;
    }

    public double centimeterToKilometer(double magnitudeInCentimeter ) {

        return magnitudeInCentimeter / 100000;
    }

}

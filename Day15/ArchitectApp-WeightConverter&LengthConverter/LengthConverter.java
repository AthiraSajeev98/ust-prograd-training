public class LengthConverter {
//base = magnitudeInMeter or magnitudeInGram

    public double centiToCenti(double magnitudeInCentimeterOrCentigram) {

        return magnitudeInCentimeterOrCentigram;
    }

    public double baseToCenti(double magnitudeInMeterOrGram) {

        return magnitudeInMeterOrGram * 100;

    }

    public double centiToBase(double magnitudeInCenti) {

        return magnitudeInCenti / 100;
    }

    public double baseToBase(double magnitudeInBase) {
        return magnitudeInBase;
    }

    public double baseToKilo(double magnitudeInBase) {
        return magnitudeInBase/1000;
    }

    public double kiloToBase (double magnitudeInKilo) {
        return magnitudeInKilo*1000;
    }

    public double kiloToCenti(double magnitudeInKilometerOrKilogram) {

        return magnitudeInKilometerOrKilogram * 100000;
    }

    public double centiToKilo(double magnitudeInCentimeterOrCentigram) {

        return magnitudeInCentimeterOrCentigram / 100000;
    }


}

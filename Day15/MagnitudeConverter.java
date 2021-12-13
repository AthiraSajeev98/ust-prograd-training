 abstract class MagnitudeConverter {
    double gramOrMeterToGramOrMeter(double magnitudeInGramOrMeter) {
        return magnitudeInGramOrMeter;
    }

    double gramOrMeterToKilogramOrKilometer(double magnitudeInGramOrMeter) {
        return magnitudeInGramOrMeter / 1000;
    }

    double KilogramOrKilometerToGramOrMeter(double magnitudeInKilogramOrKilometer) {
        return magnitudeInKilogramOrKilometer * 1000;
    }
}

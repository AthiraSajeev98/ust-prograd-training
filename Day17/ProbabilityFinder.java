public class ProbabilityFinder {
    String[] singleCoinToss = {"H", "T"};
    String[] singleCoinTossTwice = {"HT", "HH", "TT", "TH"};


    public double probabilityOfTossingASingleCoin(String event) {
        if (event.equals("T") || event.equals("H")) {
            double count = 0;
            for (int i = 0; i < singleCoinToss.length; i++) {
                if (singleCoinToss[i].contains(event)) {
                    count++;
                }
            }
            return count / (singleCoinToss.length);
        } else {
            throw new IllegalArgumentException("Invalid toss");
        }
    }

    public double probabilityOfTossingASingleCoinTwice(String event) {
        double count = 0;
        if (event.equals("HH") || event.equals("HT") || event.equals("TH") || event.equals("TT") || event.equals("T") || event.equals("H")) {

            for (int i = 0; i < singleCoinTossTwice.length; i++) {
                if (singleCoinTossTwice[i].contains(event)) {
                    count++;
                }
            }
            return count / singleCoinTossTwice.length;
        } else {
            throw new IllegalArgumentException("Invalid toss");
        }

    }

    public double probabilityOfEitherTwoEventsOccurring() {
        double count = 0;
        for (int i = 0; i < singleCoinTossTwice.length; i++) {
            if (singleCoinTossTwice[i].contains("H") && singleCoinTossTwice[i].contains("T")) {
                count++;
            }

        }
        return count / singleCoinTossTwice.length;
    }
}
public class TransitCalculator {
    int numberOfDays;
    int numberOfRides;
  
    String[] typeOfRide = {"pay-per-ride", "7-day", "30-day"};
    double[] priceOfRide = {2.75, 33, 127};
  
    public TransitCalculator(int days, int rides) {
        numberOfDays = days;
        numberOfRides = rides;

    }

    public double unlimited7Price() {
        double sevenDayPurchases = Math.ceil(numberOfDays / 7);
        double total7DayCost = sevenDayPurchases * priceOfRide[1];

        return total7DayCost / numberOfRides;
    }

    public double getRidePrices() {
        double pprRide = priceOfRide[0];
        double unlimited7Price = unlimited7Price();
        double unlimited30Price = priceOfRide[2] / numberOfRides;

        double allPrices[] = {pprRide, unlimited7Price, unlimited30Price};

        return allPrices;
    }
  
    public String getBestFare() {

        double[] ridePrices = getRidePrices();
        int winningIndex = 0;

        for(int i = 0; i < ridePrices.length; i++) {

            if (ridePrices[i] < ridePrices[winningIndex]) {
                winningIndex = i;
            }
        }

        return "The best option for you is to get " + typeOfRide[winningIndex] + "type of Ride for $" + ridePrices[winningIndex] + " per ride";
    }

    public static void main(String[] args) {
        int myRides = 12;
        int myDays = 5;

        TransitCalculator transitCalc = new TransitCalculator(myRides, myDays);
        
        System.out.println(transitCalc.getBestFare());
    }
  }
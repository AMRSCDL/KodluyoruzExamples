import java.util.Date;
class TravelInsurance extends Insurance {
    private int numberOfTravelers;

    public TravelInsurance(String name, double price, Date startDate, Date endDate, int numberOfTravelers) {
        super(name, price, startDate, endDate);
        this.numberOfTravelers = numberOfTravelers;
    }

    @Override
    public double calculate() {
        double basePrice = getPrice();
        double travelerFactor = numberOfTravelers <= 2 ? 1.0 : 1.2;
        return basePrice * travelerFactor;
    }
}

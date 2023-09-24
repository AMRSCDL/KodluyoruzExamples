import java.util.Date;
public class CarInsurance extends Insurance {
     private int carValue;

    public CarInsurance(String name, double price, Date startDate, Date endDate, int carValue) {
        super(name, price, startDate, endDate);
        this.carValue = carValue;
    }

    @Override
    public double calculate() {
        double basePrice = getPrice();
        double carValueFactor = carValue / 10000.0;
        return basePrice + (basePrice * carValueFactor);
    }
}

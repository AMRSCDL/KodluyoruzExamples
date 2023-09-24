import java.util.Date;

public class HealthInsurance extends Insurance {
    private int age;

    public HealthInsurance(String name, double price, Date startDate, Date endDate, int age) {
        super(name, price, startDate, endDate);
        this.age = age;
    }

    @Override
    public double calculate() {
        double basePrice = getPrice();
        double ageFactor = age < 30 ? 0.9 : 1.1;
        return basePrice * ageFactor;
    }
}

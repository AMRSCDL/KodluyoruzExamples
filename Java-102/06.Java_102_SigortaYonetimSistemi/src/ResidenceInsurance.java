import java.util.Date;

class ResidenceInsurance extends Insurance {
    private double propertyValue;

    public ResidenceInsurance(String name, double price, Date startDate, Date endDate, double propertyValue) {
        super(name, price, startDate, endDate);
        this.propertyValue = propertyValue;
    }

    @Override
    public double calculate() {
        double basePrice = getPrice();
        double propertyValueFactor = propertyValue / 100000.0;
        return basePrice + (basePrice * propertyValueFactor);
    }
}

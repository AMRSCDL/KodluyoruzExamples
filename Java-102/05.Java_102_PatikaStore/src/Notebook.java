public class Notebook extends PatikaStore{
    private int id;
    private double unitPrice;
    private double discountRate;
    private int stockQuantity;
    private String productName;
    private Brands brand;
    private int ram;
    private String storage;
    private double screenSize;

    public Notebook(double unitPrice, double discountRate, int stockQuantity, String productName, Brands brand, int ram, String storage, double screenSize) {
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stockQuantity = stockQuantity;
        this.productName = productName;
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
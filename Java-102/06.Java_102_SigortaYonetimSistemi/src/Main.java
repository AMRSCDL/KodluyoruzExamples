import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Bireysel kullanıcı oluşturma
        Address homeAddress = new HomeAddress("123 Main St", "City", "State", "12345");
        ArrayList<Address> user1Addresses = new ArrayList<>();
        user1Addresses.add(homeAddress);
        User user1 = new User("John", "Doe", "john.doe@email.com", "password", "Engineer", 30, user1Addresses);

        // Kurumsal kullanıcı oluşturma
        Address businessAddress = new BusinessAddress("456 Business Rd", "Business City", "Business State", "54321");
        ArrayList<Address> user2Addresses = new ArrayList<>();
        user2Addresses.add(businessAddress);
        User user2 = new User("Jane", "Smith", "jane.smith@email.com", "password1", "Manager", 25, user2Addresses);

        // Bireysel ve kurumsal hesaplar oluşturma
        Account individualAccount = new Individual(user1);
        Account enterpriseAccount = new Enterprise(user2);

        // Sigortaları oluşturma
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + 365 * 24 * 60 * 60 * 1000); // 1 yıl sonrası
        Insurance healthInsurance = new HealthInsurance("Sağlık Sigortası", 500.0, startDate, endDate, 35);
        Insurance carInsurance = new CarInsurance("Oto Sigortası", 800.0, startDate, endDate, 15000);
        Insurance residenceInsurance = new ResidenceInsurance("Konut Sigortası", 1000.0, startDate, endDate, 200000);
        Insurance travelInsurance = new TravelInsurance("Seyahat Sigortası", 300.0, startDate, endDate, 2);

        // Sigortaları hesaplama ve eklemeleri
        double healthInsurancePrice = healthInsurance.calculate();
        double carInsurancePrice = carInsurance.calculate();
        double residenceInsurancePrice = residenceInsurance.calculate();
        double travelInsurancePrice = travelInsurance.calculate();

        individualAccount.addInsurance(healthInsurance);
        individualAccount.addInsurance(carInsurance);
        enterpriseAccount.addInsurance(residenceInsurance);
        enterpriseAccount.addInsurance(travelInsurance);

        // Hesapları yöneten AccountManager oluşturma
        AccountManager accountManager = new AccountManager();
        AccountManager accountManager2 = new AccountManager();
        accountManager.addAccount(individualAccount);
        accountManager2.addAccount(enterpriseAccount);

        // John kullanıcısı için giriş yapma
        try {
            Account loggedInAccount = accountManager.login("john.doe@email.com", "password");
            if (loggedInAccount != null) {
                loggedInAccount.showUserInfo();
            } else {
                System.out.println("John Giriş başarısız.");
            }
        } catch (InvalidAuthenticationException e) {
            System.out.println("John Giriş başarısız: " + e.getMessage());
        }

        System.out.println("----------------------------------------------------");
        // Jane kullanıcısı için giriş yapma
        try {
            Account loggedInAccount2 = accountManager2.login("jane.smith@email.com", "password1");
            if (loggedInAccount2 != null) {
                loggedInAccount2.showUserInfo();
            } else {
                System.out.println("Jane Giriş başarısız.");
            }
        } catch (InvalidAuthenticationException e) {
            System.out.println("Jane Giriş başarısız: " + e.getMessage());
        }

    }
}

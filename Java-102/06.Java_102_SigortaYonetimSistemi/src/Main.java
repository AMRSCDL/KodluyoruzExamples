import java.util.*;

public class Main {
    public static void main(String[] args) {
        Address homeAddress = new HomeAddress();
        Address businessAddress = new BusinessAddress();

        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(homeAddress);
        addresses.add(businessAddress);
        User user = new User("Ahmet", "Emir", "deneme@deneme.com", "password", "IT", 23, addresses);

        Account individualAccount = new Individual(user);
        Account enterpriseAccount = new Enterprise(user);

        AccountManager accountManager = new AccountManager();
        accountManager.addAccount(individualAccount);
        accountManager.addAccount(enterpriseAccount);

        Account loggedInAccount = accountManager.login("yanlış@mail.com", "password");
        if (loggedInAccount != null) {
            System.out.println("Giriş başarılı.");
            loggedInAccount.showUserInfo();
        } else {
            System.out.println("Giriş başarısız. Mail ya da şifre hatalı!");
        }
    }
}

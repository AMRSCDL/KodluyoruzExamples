import java.util.*;


public abstract class Account implements Comparable<Account> {
    private AuthenticationStatus loginStatus;
    private User user;
    private ArrayList<Insurance> insurances;

    public Account(User user) {
        this.user = user;
        this.loginStatus = AuthenticationStatus.FAIL;
        this.insurances = new ArrayList<>();
    }

    public abstract void addInsurance(Insurance insurance);

    public AuthenticationStatus loginUser(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            loginStatus = AuthenticationStatus.SUCCESS;
        } else {
            throw new InvalidAuthenticationException("Geçersiz kimlik bilgileri.");
        }
        return loginStatus;
    }

    public void addAddress(Address address) {
        user.getAddresses().add(address);
    }

    public void removeAddress(Address address) {
        user.getAddresses().remove(address);
    }

    public abstract void showUserInfo();

    @Override
    public int compareTo(Account o) {

        return 0;
    }

    public AuthenticationStatus getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(AuthenticationStatus loginStatus) {
        this.loginStatus = loginStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }
}

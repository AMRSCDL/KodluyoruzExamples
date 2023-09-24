public class Enterprise extends Account {
    public Enterprise(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        this.getInsurances().add(insurance);
    }

    @Override
    public void showUserInfo() {
        System.out.println("Kurumsal Kullanıcı Bilgileri:");
        System.out.println("Ad: " + getUser().getFirstName());
        System.out.println("Soyad: " + getUser().getLastName());
        System.out.println("E-posta: " + getUser().getEmail());
        System.out.println("Meslek: " + getUser().getOccupation());
        System.out.println("Yaş: " + getUser().getAge());

        System.out.println("Adresler:");
        for (Address address : getUser().getAddresses()) {
            System.out.println("- " + address.toString());
        }

        System.out.println("Sigortalar:");
        for (Insurance insurance : getInsurances()) {
            System.out.println("- " + insurance.getName());
        }
    }
}

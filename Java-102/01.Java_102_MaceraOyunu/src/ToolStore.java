import java.util.Scanner;

public class ToolStore extends NormalLoc {
    private Scanner input;

    public ToolStore(Player player) {
        super(player, "Eşya Dükkanı");
        this.input = new Scanner(System.in);
    }

    @Override
    public boolean onLocation() {
        System.out.println("-------------------Eşya Dükkanına Hoşgeldiniz-------------------");
        System.out.println("1-Silahlar \n2-Zırhlar\n3-Çıkış Yap");

        int selectCase;
        boolean isTrue = false;

        while (!isTrue) {
            System.out.print("Seçiminiz: ");
            try {
                selectCase = Integer.parseInt(input.next());

                if (selectCase < 1 || selectCase > 3) {
                    System.out.println("Lütfen 1 ile 3 arasında bir rakam girin.");
                } else {
                    switch (selectCase) {
                        case 1:
                            printWeapon();
                            buyWeapon();
                            isTrue = true;
                            break;
                        case 2:
                            printArmour();
                            buyArmour();
                            isTrue = true;
                            break;
                        case 3:
                            System.out.println("Bir daha bekleriz !");
                            this.getPlayer().selectLoc();
                            isTrue = true;
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Lütfen sayısal bir değer girin!");
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("----------------------------Silahlar----------------------------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + ", Hasar: " + w.getDamage() + ", Tutar: " + w.getPrice());
        }
        System.out.println("0 - Geri dön");
    }

    public void buyWeapon() {
        int selectWeaponID;
        boolean isTrue = false;

        while (!isTrue) {
            System.out.print("Seçiminiz: ");
            try {
                selectWeaponID = Integer.parseInt(input.next());
                if (selectWeaponID == 0) {
                    onLocation();
                    break;
                }
                Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);

                if (selectedWeapon == null || selectedWeapon.getPrice() > getPlayer().getMoney()) {
                    System.out.println("Geçersiz bir seçim yaptınız veya paranız yetersiz!");
                } else {
                    System.out.println(selectedWeapon.getName() + " Silahını satın aldınız.");
                    int balance = getPlayer().getMoney() - selectedWeapon.getPrice();
                    getPlayer().setMoney(balance);
                    System.out.println("Kalan bakiyeniz: " + getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
                getPlayer().printInfo();
            } catch (NumberFormatException e) {
                System.out.println("Lütfen sayısal bir değer girin!");
            }
        }
    }

    public void printArmour() {
        System.out.println("----------------------------Zırhlar-----------------------------");
        for (Armour a : Armour.armours()) {
            System.out.println(a.getId() + " - " + a.getName() + ", Engelleme: " + a.getBlock() + ", Tutar: " + a.getPrice());
        }
        System.out.println("0 - Geri dön");
    }

    public void buyArmour() {
        int selectArmourID;
        boolean isTrue = false;

        while (!isTrue) {
            System.out.print("Seçiminiz: ");
            try {
                selectArmourID = Integer.parseInt(input.next());
                if (selectArmourID == 0) {
                    onLocation();
                    break;
                }
                Armour selectedArmour = Armour.getArmourObjById(selectArmourID);

                if (selectedArmour == null || selectedArmour.getPrice() > getPlayer().getMoney()) {
                    System.out.println("Geçersiz bir seçim yaptınız veya paranız yetersiz!");
                } else {
                    System.out.println(selectedArmour.getName() + " Zırhını satın aldınız.");
                    int balance = getPlayer().getMoney() - selectedArmour.getPrice();
                    getPlayer().setMoney(balance);
                    System.out.println("Kalan bakiyeniz: " + getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmour(selectedArmour);
                }
                getPlayer().printInfo();
            } catch (NumberFormatException e) {
                System.out.println("Lütfen sayısal bir değer girin!");
            }
        }
    }
}

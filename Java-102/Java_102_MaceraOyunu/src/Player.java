import java.util.Scanner;

public class Player {
    private int damage;
    private int healthy;
    private int orihinalHealth;
    private int money;
    private String charName;
    private String name;
    private String locName;
    private Inventory inventory;


    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory= new Inventory();
    }
    public void selectChar() {
        boolean isTrue = true;
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("----------------------------------------------------------------");
        int id = 1;
        for (GameChar gameChar : charList) {
            System.out.println((id++) + "-" + gameChar.getName() + ", Hasar: " + gameChar.getDamage() + ", Sağlık: " + gameChar.getHealth() + ", Para: " + gameChar.getMoney());
        }
        System.out.println("----------------------------------------------------------------");
        Scanner input = new Scanner(System.in);

        while (isTrue) {
            System.out.println("Başlamak için bir karakter seçiniz:");
            try {
                int selectChar = Integer.parseInt(input.nextLine());

                if (selectChar < 1 || selectChar > 3) {
                    System.out.println("Geçersiz giriş yaptınız! Tekrar deneyin.");
                } else {
                    switch (selectChar) {
                        case 1:
                            initPlayer(new Samurai());
                            isTrue = false;
                            break;
                        case 2:
                            initPlayer(new Archer());
                            isTrue = false;
                            break;
                        case 3:
                            initPlayer(new Knight());
                            isTrue = false;
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Lütfen sadece rakamları kullanın!");
            }
        }
    }
    public String getLocName() {
        return this.locName;
    }
    public void setLocName(String locName) {
        this.locName = locName;
    }
    public void selectLoc(){
        boolean isTrue = true;
        Location[] locList ={new SafeHouse(this), new ToolStore(this), new Cave(this),new Forest(this), new River(this),new Coal(this) ,new ExitGame(this)};
        System.out.println();
        printInfo();
        System.out.println("###########################-BÖLGELER-###########################");
        int id = 1;
        for (Location location : locList) {
            System.out.println((id++) + "-" + location.getName());
        }
        System.out.println("----------------------------------------------------------------");
        Scanner input2 = new Scanner(System.in);
        Location location = null;

        while (isTrue) {
            System.out.println("Gitmek istediğiniz alanı seçiniz:");
            try {
                int selectLoc = Integer.parseInt(input2.nextLine());

                if (selectLoc < 1 || selectLoc > 7) {
                    System.out.println("Geçersiz giriş yaptınız! Tekrar deneyin.");
                } else {
                    switch (selectLoc) { 
                        case 1:
                            location=(new SafeHouse(this));
                            isTrue = false;
                            break;
                        case 2:
                            location=(new ToolStore(this));
                            isTrue = false;
                            break;
                        case 3:
                            location=(new Cave(this));
                            isTrue = false;
                            break;
                        case 4:
                            location=(new Forest(this));
                            isTrue = false;
                            break;
                        case 5:
                            location = (new River(this));
                            isTrue = false;
                            break;
                        case 6:
                            location = (new Coal(this));
                            isTrue = false;
                            break;
                        case 7:
                            location = (new ExitGame(this));
                            isTrue = false;
                            break;
                    }
                    if (!location.onLocation()){
                        System.out.println("Game Over");
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Lütfen sadece rakamları kullanın!");
            }
        }
        input.close();
    }
    public void initLoc(Location location){
        this.setLocName(location.getName());
    }
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealthy(gameChar.getHealth());
        this.setOrihinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }
    public void printInfo(){
        System.out.println("Silahınız: "+this.getInventory().getWeapon().getName()+" Hasarınız: " + getTotalDamage() + ", Sağlık: " + getHealthy() + ", Para: " + getMoney()+", Zırhınız: "+this.getInventory().getArmour().getName()+", Bloklama: "+this.getInventory().getArmour().getBlock());

    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return this.damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getHealthy() {
        return this.healthy;
    }
    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getOrihinalHealth() {
        return orihinalHealth;
    }

    public void setOrihinalHealth(int orihinalHealth) {
        this.orihinalHealth = orihinalHealth;
    }

    public int getMoney() {
        return this.money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public String getCharName() {
        return this.charName;
    }
    public void setCharName(String charName) {
        this.charName = charName;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}

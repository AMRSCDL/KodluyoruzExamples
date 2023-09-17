import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private Award award;
    private int maxObstacle;
    private boolean isWon;


    public BattleLoc(Player player, String name, Obstacle obstacle, Award award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.isWon = false;
    }

    @Override
    public boolean onLocation() {
        int obsNum = this.randomObstacleNum();
        System.out.println("Şu an buradasınız: " + this.getName());

        if (this.isWon()) {
            System.out.println(this.getName() + " bölgesi zaten kazanıldı. Başka bir yere gitmelisiniz.");
            return true;
        }

        System.out.println("Dikkatli ol! Burada: " + obsNum + " tane " + this.getObstacle().getName() + " yaşıyor.");
        System.out.print("<S>avaş ya da <K>aç: ");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNum)) {
            System.out.println(this.getName() + " tüm düşmanları yendiniz !");
            this.setWon(true);
            return true;
        }
        if (this.getPlayer().getHealthy() <= 0) {
            System.out.println("Öldünüz !");
            return false;
        }
        return true;
    }


    public boolean combat(int obsNum) {
        Random random = new Random();

        for (int i = 1; i <= obsNum; i++) {
            this.getObstacle().setHealth(this.obstacle.getOriginalHealth());
            playerStats();
            obstacleStats(i);

            boolean playerFirst = random.nextBoolean();

            while (this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealth() > 0) {
                if (playerFirst) {
                    System.out.println("<V>ur veya <K>aç");
                    String selectCombat = input.nextLine().toUpperCase();
                    if (selectCombat.equals("V")) {
                        playerAttack();
                        if (this.getObstacle().getHealth() > 0) {
                            obstacleAttack();
                        }
                    } else {
                        return false;
                    }
                } else {
                    obstacleAttack();
                    if (this.getPlayer().getHealthy() > 0) {
                        System.out.println("<V>ur veya <K>aç");
                        String selectCombat = input.nextLine().toUpperCase();
                        if (selectCombat.equals("V")) {
                            playerAttack();
                        } else {
                            return false;
                        }
                    }
                }
            }

            if (this.getPlayer().getHealthy() <= 0) {
                System.out.println("Öldünüz !");
                return false;
            }

            if (i == obsNum) {
                System.out.print(this.getAward().getName() + " ödülünü kazandınız !");
                System.out.println("\n" + this.getObstacle().getAward() + " para kazandınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
                this.setWon(true);
            }
        }
        return true;
    }


    public void playerAttack() {
        System.out.print("\nSiz Vurdunuz");
        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());

        if (this.getObstacle().getHealth() < 0) {
            this.getObstacle().setHealth(0);
        }

        afterHit();
    }

    public void obstacleAttack() {
        System.out.println("\n"+obstacle.getName()+" size vurdu");
        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmour().getBlock();
        if (obstacleDamage < 0) {
            obstacleDamage = 0;
        }
        this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);

        if (this.getPlayer().getHealthy() < 0) {
            this.getPlayer().setHealthy(0);
        }

        afterHit();
    }


    public void afterHit() {
        System.out.println("\nCanınız: " + this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealth() + "\n");
    }

    public void playerStats() {
        System.out.println("\nOyuncu değerleri");
        System.out.println("---------------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealthy());
        System.out.println("Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasarınız: " + this.getPlayer().getTotalDamage());
        System.out.println("Zırhınız: " + this.getPlayer().getInventory().getArmour().getName());
        System.out.println("Blocklama: " + this.getPlayer().getInventory().getArmour().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney() + "\n");
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " değerleri");
        System.out.println("---------------------------");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasarı: " + this.getObstacle().getDamage());
        System.out.println("Ödülü: " + this.getObstacle().getAward());
    }

    public int randomObstacleNum() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }
}

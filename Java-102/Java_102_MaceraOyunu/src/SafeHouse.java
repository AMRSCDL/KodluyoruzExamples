public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player,"Güvenli Ev");
    }
    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz !");
        System.out.println("Önceki canınız: "+this.getPlayer().getHealthy());
        getPlayer().setHealthy(this.getPlayer().getOrihinalHealth());
        System.out.println("Canınız yenilendi mevcut canınız: "+this.getPlayer().getHealthy());
        getPlayer().selectLoc();
        return false;
    }
}

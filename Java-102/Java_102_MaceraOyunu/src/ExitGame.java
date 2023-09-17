public class ExitGame extends NormalLoc{
    public ExitGame(Player player) {
        super(player, "Çıkış Yap");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Hoşçakalın!!");
        return true;
    }
}

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), new Award("Food (Yemek)"),3);
    }

    @Override
    public boolean isWon() {
        return super.isWon();
    }
}

public class River extends BattleLoc {
    public River(Player player) {
        super(player, "Nehir", new Bear(), new Award("Water (Su)"),2);
    }

    @Override
    public boolean isWon() {
        return super.isWon();
    }
}

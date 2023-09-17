public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player, "Orman", new Vampire(),new Award("Firewood (Odun)"),3);
    }

    @Override
    public boolean isWon() {
        return super.isWon();
    }
}

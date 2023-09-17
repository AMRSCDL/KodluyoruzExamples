import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz!");
        System.out.print("Lütfen adınzı giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Hoşgeldiniz ! ");
        player.selectChar();
        player.selectLoc();
    }
}

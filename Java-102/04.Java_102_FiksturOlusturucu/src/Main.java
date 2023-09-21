import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> takim = new ArrayList<>();
        takim.add("Fenerbahçe");
        takim.add("Beşiktaş");
        takim.add("Galatasaray");
        takim.add("Eskişehirspor");
        takim.add("Manisaspor");
        takim.add("Trabzonspor");

        if (takim.size()% 2 !=0){
            takim.add("Bay");
        }

        System.out.println("Takımlar\n");
        Iterator<String> itr = takim.iterator();
        int id = 0;
        while (itr.hasNext()){
            System.out.println(++id +"-"+itr.next());
        }
        System.out.println("-------------------------------");

        Fixture fixture = new Fixture(takim);
        List<List<String>> fixtures = fixture.generateFixtures();

        int week = 1;
        for (List<String> weekFixtures : fixtures) {
            System.out.println("\nHafta " + week + " Maçları:\n");
            for (String match : weekFixtures) {
                System.out.println(match);
            }
            week++;
        }
    }
}
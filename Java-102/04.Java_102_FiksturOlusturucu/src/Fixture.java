import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Fixture {
    private List<String> takim;

    public Fixture(List<String> takim) {
        this.takim = takim;
    }

    public  List<List<String>> generateFixtures() {
        List<List<String>> fixtures = new ArrayList<>();
        int numWeeks = takim.size() - 1;

        for (int week = 0; week < numWeeks; week++) {
            List<String> weekFixtures = new ArrayList<>();
            for (int i = 0; i < takim.size() / 2; i++) {
                String homeTeam = takim.get(i);
                String awayTeam = takim.get(takim.size() - 1 - i);

                weekFixtures.add(homeTeam + " vs " + awayTeam);
            }

            Collections.rotate(takim.subList(1, takim.size()), 1);

            fixtures.add(weekFixtures);
        }

        return fixtures;
    }
}

import java.util.ArrayList;
import java.util.List;

class Islem implements Runnable {
    private List<Integer> parca;
    private String isim;
    private ArrayList<Integer> tekListe;
    private ArrayList<Integer> ciftListe;

    public Islem(List<Integer> parca, String isim, ArrayList<Integer> tekListe, ArrayList<Integer> ciftListe) {
        this.parca = parca;
        this.isim = isim;
        this.tekListe = tekListe;
        this.ciftListe = ciftListe;
    }

    @Override
    public void run() {
        for (Integer sayi : parca) {
            if (sayi%2==0){
                ciftListe.add(sayi);
            }else {
                tekListe.add(sayi);
            }
        }
    }
}
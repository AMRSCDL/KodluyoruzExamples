import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Book> bookAd = new TreeSet<>();

        bookAd.add(new Book("BKitap", 250, "B Yazar", 1903));
        bookAd.add(new Book("ZKitap", 600, "Z Yazar", 2020));
        bookAd.add(new Book("CKitap", 350, "C Yazar", 2015));
        bookAd.add(new Book("AKitap", 400, "A Yazar", 2010));
        bookAd.add(new Book("YKitap", 450, "Y Yazar", 2005));

        System.out.println("Kitaplar İsme Göre Sıralı:");
        for (Book kitap : bookAd) {
            System.out.println(kitap.getKitapIsmi());
        }

        Set<Book> bookSayfa = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book kitap1, Book kitap2) {
                return Integer.compare(kitap1.getSayfaSayisi(), kitap2.getSayfaSayisi());
            }
        });

        bookSayfa.addAll(bookAd);

        System.out.println("\nKitaplar Sayfa Sayısına Göre Sıralı:");
        for (Book kitap : bookSayfa) {
            System.out.println(kitap.getKitapIsmi()+" Sayfa sayısı: "+kitap.getSayfaSayisi());
        }
    }
}
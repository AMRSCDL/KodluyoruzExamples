import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main{
    public static void main(String[] args) {
        ArrayList <Book> kitaplar = new ArrayList<>();
        kitaplar.add(new Book("a Book",58,"A Writer",2000));
        kitaplar.add(new Book("b Book",150,"B Writer",2001));
        kitaplar.add(new Book("c Book",346,"C Writer",2002));
        kitaplar.add(new Book("d Book",897,"D Writer",2003));
        kitaplar.add(new Book("e Book",26,"E Writer",2004));
        kitaplar.add(new Book("f Book",45,"F Writer",2005));
        kitaplar.add(new Book("g Book",875,"G Writer",2006));
        kitaplar.add(new Book("h Book",87,"H Writer",2007));
        kitaplar.add(new Book("j Book",980,"J Writer",2008));
        kitaplar.add(new Book("k Book",76,"K Writer",2009));

        Map<String,String> map= kitaplar.stream().collect(Collectors.toMap(Book::getName,Book::getWriter));

        System.out.println("----------------------------------");
        System.out.println("Kitap ve Yazar listesi");
        System.out.println("----------------------------------");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("----------------------------------");
        System.out.println("Sayfa Sayısı 100'den Fazla Olan Kitaplar");
        System.out.println("----------------------------------");
        List<Book> filtrelenmisKitaplar = kitaplar.stream()
                .filter(kitap -> kitap.getPageNum() > 100)
                .toList();

        filtrelenmisKitaplar.forEach(kitap -> System.out.println(kitap.getName() + "Sayfa sayısı: "+kitap.getPageNum()));
        System.out.println("----------------------------------");

    }
}
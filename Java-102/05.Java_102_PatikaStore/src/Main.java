import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatikaStore patikaStore = new PatikaStore();

        while (true) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    notebookIslemleri(patikaStore, scanner);
                    break;
                case 2:
                    cepTelefonuIslemleri(patikaStore, scanner);
                    break;
                case 3:
                    markalariListele(patikaStore);
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
            }
        }
    }

    private static void markalariListele(PatikaStore patikaStore) {
        System.out.println("Markalarımız");
        System.out.println("--------------");
        List<String> sortedBrands = patikaStore.getMarkalar().stream()
                .map(Brands::getName)
                .sorted()
                .collect(Collectors.toList());
        sortedBrands.forEach(System.out::println);
    }

    private static void notebookIslemleri(PatikaStore patikaStore, Scanner scanner) {
        while (true) {
            System.out.println("Notebook İşlemleri");
            System.out.println("1 - Notebook Listesi");
            System.out.println("2 - Notebook Ekle");
            System.out.println("3 - Notebook Sil");
            System.out.println("0 - Geri");
            System.out.print("Tercihiniz : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    patikaStore.listNotebooks();
                    break;
                case 2:
                    patikaStore.addNotebook(scanner);
                    break;
                case 3:
                    patikaStore.listNotebooks();
                    System.out.print("Silmek istediğiniz notebook'un ID'sini girin: ");
                    int notebookId = scanner.nextInt();
                    patikaStore.removeNotebook(notebookId);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
            }
        }
    }

    private static void cepTelefonuIslemleri(PatikaStore patikaStore, Scanner scanner) {
        while (true) {
            System.out.println("Cep Telefonu İşlemleri");
            System.out.println("1 - Cep Telefonu Listesi");
            System.out.println("2 - Cep Telefonu Ekle");
            System.out.println("3 - Cep Telefonu Sil");
            System.out.println("0 - Geri");
            System.out.print("Tercihiniz : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    patikaStore.listPhones();
                    break;
                case 2:
                    patikaStore.addPhone(scanner);
                    break;
                case 3:
                    patikaStore.listPhones();
                    System.out.print("Silmek istediğiniz cep telefonunun ID'sini girin: ");
                    int phoneId = scanner.nextInt();
                    patikaStore.removePhone(phoneId);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
            }
        }
    }
}

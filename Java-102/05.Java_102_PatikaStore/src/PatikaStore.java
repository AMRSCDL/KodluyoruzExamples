import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PatikaStore {
    private static int IdCounterNoteBook = 1;
    private static int IdCounterPhone = 1;
    private List<Phone> phones = new ArrayList<>();
    private List<Notebook> notebooks = new ArrayList<>();
    private List<Brands> markalar = new ArrayList<>();

    public PatikaStore() {
        markalar.add(new Brands(1, "Samsung"));
        markalar.add(new Brands(2, "Lenovo"));
        markalar.add(new Brands(3, "Apple"));
        markalar.add(new Brands(4, "Huawei"));
        markalar.add(new Brands(5, "Casper"));
        markalar.add(new Brands(6, "Asus"));
        markalar.add(new Brands(7, "HP"));
        markalar.add(new Brands(8, "Xiaomi"));
        markalar.add(new Brands(9, "Monster"));
    }

    public List<Brands> getMarkalar() {
        return markalar;
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public void removePhone(int id) {
        phones.removeIf(item -> item.getId() == id);
    }

    public List<Phone> filterPhonesByBrand(String brandName) {
        return phones.stream()
                .filter(item -> item.getBrand().getName().equalsIgnoreCase(brandName))
                .collect(Collectors.toList());
    }

    public void addNotebook(Notebook notebook) {
        notebooks.add(notebook);
    }

    public void removeNotebook(int id) {
        notebooks.removeIf(item -> item.getId() == id);
    }

    public List<Notebook> filterNotebooksByBrand(String brandName) {
        return notebooks.stream()
                .filter(item -> item.getBrand().getName().equalsIgnoreCase(brandName))
                .collect(Collectors.toList());
    }

    public void listPhones() {
        System.out.println("Cep Telefonu Listesi");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-30s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

        for (Phone phone : phones) {
            System.out.printf("| %-2d | %-30s | %-10.2f | %-10s | %-10s | %-10.1f | %-10d | %-10d | %-10d | %-10s |%n",
                    phone.getId(), phone.getProductName(), phone.getUnitPrice(), phone.getBrand().getName(),
                    phone.getMemory(), phone.getScreenSize(), (int) phone.getCamera(), (int) phone.getBatteryPower(),
                    phone.getRam(), phone.getColor());
        }


        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void listNotebooks() {
        System.out.println("Notebook Listesi");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-30s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Ram");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        for (Notebook notebook : notebooks) {
            System.out.printf("| %-2d | %-30s | %-10.2f | %-10s | %-10s | %-10.1f | %-10d |%n",
                    notebook.getId(), notebook.getProductName(), notebook.getUnitPrice(),
                    notebook.getBrand().getName(), notebook.getStorage(), notebook.getScreenSize(),
                    notebook.getRam());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
    }


    public void addNotebook(Scanner scanner) {
        System.out.print("Ürün Adı: ");
        scanner.nextLine();
        String productName = scanner.nextLine();
        System.out.print("Birim Fiyat: ");
        double unitPrice = scanner.nextDouble();
        System.out.print("İndirim Oranı: ");
        double discountRate = scanner.nextDouble();
        System.out.print("Stok Miktarı: ");
        int stockQuantity = scanner.nextInt();

        Brands selectedBrand = null;
        while (selectedBrand == null) {
            System.out.println("Lütfen bir marka seçin:");
            for (Brands brand : markalar) {
                System.out.println(brand.getId() + " - " + brand.getName());
            }
            int brandId = scanner.nextInt();
            selectedBrand = markalar.stream()
                    .filter(brand -> brand.getId() == brandId)
                    .findFirst()
                    .orElse(null);
            if (selectedBrand == null) {
                System.out.println("Geçersiz marka seçtiniz. Lütfen tekrar deneyin.");
            }
        }

        System.out.print("RAM: ");
        int ram = scanner.nextInt();
        System.out.print("Depolama: ");
        String storage = scanner.next();
        System.out.print("Ekran Boyutu (inç cinsinden): ");
        double screenSize = scanner.nextDouble();

        Notebook newNotebook = new Notebook(unitPrice, discountRate, stockQuantity, productName, selectedBrand, ram, storage, screenSize);
        newNotebook.setId(IdCounterNoteBook);
        IdCounterNoteBook++;
        notebooks.add(newNotebook);

        System.out.println("Notebook başarıyla eklendi.");
    }

    public void addPhone(Scanner scanner) {
        System.out.print("Ürün Adı: ");
        scanner.nextLine();
        String productName = scanner.nextLine();
        System.out.print("Birim Fiyat: ");
        double unitPrice = scanner.nextDouble();
        System.out.print("İndirim Oranı: ");
        double discountRate = scanner.nextDouble();
        System.out.print("Stok Miktarı: ");
        int stockQuantity = scanner.nextInt();

        Brands selectedBrand = null;
        while (selectedBrand == null) {
            System.out.println("Lütfen bir marka seçin:");
            for (Brands brand : markalar) {
                System.out.println(brand.getId() + " - " + brand.getName());
            }
            int brandId = scanner.nextInt();
            selectedBrand = markalar.stream()
                    .filter(brand -> brand.getId() == brandId)
                    .findFirst()
                    .orElse(null);
            if (selectedBrand == null) {
                System.out.println("Geçersiz marka seçtiniz. Lütfen tekrar deneyin.");
            }
        }

        System.out.print("Hafıza (örn: 128 GB, 64 GB): ");
        int memory = scanner.nextInt();
        System.out.print("Ekran Boyutu (inç cinsinden): ");
        double screenSize = scanner.nextDouble();
        System.out.print("Kamera (megapixel cinsinden): ");
        int camera = scanner.nextInt();
        System.out.print("Pil kapasitesini mA cinsinden giriniz: ");
        int batteryPower = scanner.nextInt();
        System.out.print("Ram: ");
        int ram = scanner.nextInt();
        System.out.print("Renk: ");
        scanner.nextLine();
        String color = scanner.nextLine();

        Phone newPhone = new Phone(unitPrice, discountRate, stockQuantity, productName, selectedBrand, memory, screenSize, camera, batteryPower, ram, color);
        newPhone.setId(IdCounterPhone);
        IdCounterPhone++;
        phones.add(newPhone);

        System.out.println("Cep telefonu başarıyla eklendi.");
    }
}

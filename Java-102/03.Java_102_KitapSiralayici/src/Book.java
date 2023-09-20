class Book implements Comparable<Book> {
    private String kitapIsmi;
    private int sayfaSayisi;
    private String yazarIsmi;
    private int yayinTarihi;

    public Book(String kitapIsmi, int sayfaSayisi, String yazarIsmi, int yayinTarihi) {
        this.kitapIsmi = kitapIsmi;
        this.sayfaSayisi = sayfaSayisi;
        this.yazarIsmi = yazarIsmi;
        this.yayinTarihi = yayinTarihi;
    }

    public String getKitapIsmi() {
        return kitapIsmi;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public String getYazarIsmi() {
        return yazarIsmi;
    }

    public int getYayinTarihi() {
        return yayinTarihi;
    }

    @Override
    public int compareTo(Book other) {
        return this.kitapIsmi.compareTo(other.kitapIsmi);
    }

}
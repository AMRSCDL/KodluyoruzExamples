public class Main {
    public static void main(String[] args) {
        Fighter marc = new Fighter("Marc" , 100 , 100);
        Fighter alex = new Fighter("Alex" , 100 , 100);
        Ring r = new Ring(marc,alex , 90 , 100);
        r.run();
    }
}

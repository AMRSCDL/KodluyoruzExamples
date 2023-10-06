import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList sayilar = new ArrayList();
        for (int i = 1; i < 10001; i++) {
            sayilar.add(i);
        }
        int parca = sayilar.size() / 4;

        List<Integer> a = sayilar.subList(0, parca -1);
        List<Integer> b = sayilar.subList(parca -1, 2 * parca -1);
        List<Integer> c = sayilar.subList(2 * parca -1, 3 * parca -1);
        List<Integer> d = sayilar.subList(3 * parca -1, 4 * parca);

        ArrayList<Integer> cift = new ArrayList<>();
        ArrayList<Integer> tek = new ArrayList<>();

        Thread threadA = new Thread(new Islem(a,"A",tek, cift));
        Thread threadB = new Thread(new Islem(b,"B",tek, cift));
        Thread threadC = new Thread(new Islem(c,"C",tek, cift));
        Thread threadD = new Thread(new Islem(d,"D",tek, cift));

        // burada yazdığım join sayesinde threadler üst üste binmiyor A işini hallettikten sonra sıra B ye geliyor ve bu şekilde ilerliyor
        try {
            threadA.start();
            threadA.join();
            threadB.start();
            threadB.join();
            threadC.start();
            threadC.join();
            threadD.start();

            threadD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(cift);
    }
}

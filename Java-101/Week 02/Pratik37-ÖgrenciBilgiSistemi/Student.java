public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    Course matSoz;
    Course fizikSoz;
    Course kimyaSoz;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya,Course matSoz,Course fizikSoz,Course kimyaSoz) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        this.matSoz=matSoz;
        this.fizikSoz=fizikSoz;
        this.kimyaSoz=kimyaSoz;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya, int matSoz, int fizikSoz, int kimyaSoz) {

        if ((mat >= 0 && mat <= 100) && (matSoz >= 0 && matSoz <= 100)) {
            this.mat.note = mat;
            this.matSoz.sozNot = matSoz;
        }

        if ((fizik >= 0 && fizik <= 100) && (fizikSoz >= 0 && fizikSoz <= 100)) {
            this.fizik.note = fizik;
            this.fizikSoz.sozNot = fizikSoz;
        }

        if ((kimya >= 0 && kimya <= 100) && (kimyaSoz >= 0 && kimyaSoz <= 100)) {
            this.kimya.note = kimya;
            this.kimyaSoz.sozNot = kimyaSoz;
        }

    }

    public void isPass() {
        if ((this.mat.note == 0 && this.matSoz.sozNot == 0) || (this.fizik.note == 0 && this.fizikSoz.sozNot == 0) || (this.kimya.note == 0 && this.kimyaSoz.sozNot == 0)) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = (((this.fizik.note*0.80)+(this.fizikSoz.sozNot*0.20)) + ((this.kimya.note*0.80)+(this.kimyaSoz.sozNot*0.20)) + ((this.mat.note*0.80)+(this.matSoz.sozNot*0.20))) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("==================================================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
        System.out.println("Matematik Sözlüsü : " + this.matSoz.sozNot);
        System.out.println("Fizik Sözlüsü : " + this.fizikSoz.sozNot);
        System.out.println("Kimya Sözlüsü : " + this.kimyaSoz.sozNot);
    }

}
public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        if (this.salary >= 0 && this.salary <= 1000) {
            return 0;
        } else if (this.salary > 1000) {
            return this.salary * 0.03;
        }
        return 0;
    }

    public double bonus() {
        if (workHours > 40) {
            int totalBonus = 0;
            for (int i = 1; i <= workHours - 40; i++) {
                totalBonus += 30;
            }
            return totalBonus;
        } else {
            System.out.println("Bonus eklenmedi, haftalık çalışma saati 40 saatten az");
            return 0;
        }
    }

    public double raiseSalary() {
        int thisYear = 2021;
        int totalYear = thisYear - this.hireYear;
        double maasArtis = 0;

        if (totalYear < 10) {
            maasArtis = this.salary * 0.05;
        } else if (totalYear >= 10 && totalYear < 20) {
            maasArtis = this.salary * 0.10;
        } else if (totalYear >= 20) {
            maasArtis = this.salary * 0.15;
        }
        return maasArtis;
    }


    public String  toString(){
        double vAndB=(-tax()+bonus()+this.salary);
        double totalMaas=(-tax()+bonus()+raiseSalary()+this.salary);
        System.out.println("Adı: "+this.name);
        System.out.println("Maaşı: "+this.salary);
        System.out.println("Çalışma Saati: "+workHours);
        System.out.println("Başlangıç Yılı: "+hireYear);
        System.out.println("Vergi: "+tax());
        System.out.println("Bonus: "+bonus());
        System.out.println("Maaş Artışı: "+raiseSalary());
        System.out.println("Vergi ve Bonuslarla Birlikte Maaş: "+vAndB);
        System.out.println("Toplam Maaş: "+totalMaas);
        return null;
    }
}

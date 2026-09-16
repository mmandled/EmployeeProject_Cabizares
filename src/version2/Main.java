package version2;

public class Main {
    public static void main(String[] args) {
        Name name1 = new Name("Emmanuel", "Baguio", "Cabizares");
        MyDate birthDate1 = new MyDate(14, 9, 2005);
        MyDate dateHired1 = new MyDate(15, 6, 2023);

        HourlyEmployee emp = new HourlyEmployee(101, name1, dateHired1, birthDate1, 45.0f, 300.0);

        System.out.println(emp);
    }
}
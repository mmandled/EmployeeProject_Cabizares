package version3;

import java.time.LocalDate;

public class CommissionEmployee {
    private int empID;
    private Name name;
    private MyDate dateHired;
    private MyDate birthDate;
    private double totalSale;

    public CommissionEmployee() {
        empID = 0;
        name = new Name();
        dateHired = new MyDate();
        birthDate = new MyDate();
        totalSale = 0;
    }

    public CommissionEmployee(int empID, Name name, MyDate dateHired, MyDate birthDate, double totalSale) {
        this.empID = empID;
        this.name = name;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
        this.totalSale = totalSale;
    }

    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }

    public Name getName() { return name; }
    public void setName(Name name) { this.name = name; }

    public MyDate getDateHired() { return dateHired; }
    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired; }

    public MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate; }

    public double getTotalSale() { return totalSale; }
    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) this.totalSale = totalSale;
    }

    public double computeSalary() {
        double commissionRate;
        if (totalSale < 50000) commissionRate = 0.05;
        else if (totalSale < 100000) commissionRate = 0.10;
        else if (totalSale < 500000) commissionRate = 0.15;
        else commissionRate = 0.20;

        double salary = totalSale * commissionRate;
        if (birthDate != null && birthDate.getMonth() == LocalDate.now().getMonthValue()) {
            salary += 5000;
        }
        return salary;
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, Hired: %s, Birth: %s, Total Sale: P%.2f, Total Salary: P%.2f]",
                empID, name, dateHired, birthDate, totalSale, computeSalary());
    }
}
package version3;

import java.time.LocalDate;

public class BasePlusCommissionEmployee {
    private int empID;
    private Name name;
    private MyDate dateHired;
    private MyDate birthDate;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        empID = 0;
        name = new Name();
        dateHired = new MyDate();
        birthDate = new MyDate();
        totalSale = 0;
        baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name name, MyDate dateHired, MyDate birthDate, double totalSale, double baseSalary) {
        this.empID = empID;
        this.name = name;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
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

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) this.baseSalary = baseSalary;
    }

    public double computeSalary() {
        double commissionRate;
        if (totalSale < 50000) commissionRate = 0.05;
        else if (totalSale < 100000) commissionRate = 0.10;
        else if (totalSale < 500000) commissionRate = 0.15;
        else commissionRate = 0.20;

        double total = baseSalary + (totalSale * commissionRate);
        if (birthDate != null && birthDate.getMonth() == LocalDate.now().getMonthValue()) {
            total += 5000;
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Hired: %s, Birth: %s, Sales: P%.2f, Base: P%.2f, Total Salary: P%.2f]",
                empID, name, dateHired, birthDate, totalSale, baseSalary, computeSalary());
    }
}
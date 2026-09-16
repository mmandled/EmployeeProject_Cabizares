package version3;

import java.time.LocalDate;

public class HourlyEmployee {
    private int empID;
    private Name name;
    private MyDate dateHired;
    private MyDate birthDate;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        empID = 0;
        name = new Name();
        dateHired = new MyDate();
        birthDate = new MyDate();
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name name, MyDate dateHired, MyDate birthDate, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.name = name;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }

    public Name getName() { return name; }
    public void setName(Name name) { this.name = name; }

    public MyDate getDateHired() { return dateHired; }
    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired; }

    public MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate; }

    public float getTotalHoursWorked() { return totalHoursWorked; }
    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) this.ratePerHour = ratePerHour;
    }

    public double computeSalary() {
        double baseSalary;
        if (totalHoursWorked <= 40) {
            baseSalary = totalHoursWorked * ratePerHour;
        } else {
            double regularPay = 40 * ratePerHour;
            double overtimeHours = totalHoursWorked - 40;
            double overtimePay = overtimeHours * (ratePerHour * 1.5);
            baseSalary = regularPay + overtimePay;
        }

        if (birthDate != null && birthDate.getMonth() == LocalDate.now().getMonthValue()) {
            baseSalary += 5000;
        }
        return baseSalary;
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, Hired: %s, Birth: %s, Hours: %.2f, Rate: P%.2f, Total Salary: P%.2f]",
                empID, name, dateHired, birthDate, totalHoursWorked, ratePerHour, computeSalary());
    }
}
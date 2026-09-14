package version2;
import java.time.LocalDate;

public class PieceWorkerEmployee {
    private int empID;
    private Name name;
    private MyDate dateHired;
    private MyDate birthDate;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        empID = 0;
        name = new Name();
        dateHired = new MyDate();
        birthDate = new MyDate();
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name name, MyDate dateHired, MyDate birthDate, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.name = name;
        this.dateHired = dateHired;
        this.birthDate = birthDate;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }

    public Name getName() { return name; }
    public void setName(Name name) { this.name = name; }

    public MyDate getDateHired() { return dateHired; }
    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired; }

    public MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate; }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) this.ratePerPiece = ratePerPiece;
    }

    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;
        int completeHundreds = totalPiecesFinished / 100;
        double bonusPay = completeHundreds * (10 * ratePerPiece);
        double total = basePay + bonusPay;

        if (birthDate != null && birthDate.getMonth() == LocalDate.now().getMonthValue()) {
            total += 5000;
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Hired: %s, Birth: %s, Pieces: %d, Rate: P%.2f, Total Salary: P%.2f]",
                empID, name, dateHired, birthDate, totalPiecesFinished, ratePerPiece, computeSalary());
    }
}
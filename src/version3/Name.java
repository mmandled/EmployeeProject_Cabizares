package version3;

public class Name {
    private String fname;
    private String mname;
    private String lname;

    public Name() {
        this.fname = "N/A";
        this.mname = "N/A";
        this.lname = "N/A";
    }

    public Name(String fname, String mname, String lname) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
    }

    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }

    public String getMname() { return mname; }
    public void setMname(String mname) { this.mname = mname; }

    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }

    @Override
    public String toString() {
        return fname + " " + (mname != null && !mname.isEmpty() ? mname.charAt(0) + ". " : "") + lname;
    }
}
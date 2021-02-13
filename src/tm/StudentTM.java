package tm;

public class StudentTM {
    private String regisID;
    private String couName;
    private String stuID;
    private String stuName;
    private String stuAddress;
    private String stuContact;
    private String stuDOB;
    private String stuGender;

    public StudentTM() {
    }

    public StudentTM(String regisID, String couName, String stuID, String stuName, String stuAddress, String stuContact, String stuDOB, String stuGender) {
        this.regisID = regisID;
        this.couName = couName;
        this.stuID = stuID;
        this.stuName = stuName;
        this.stuAddress = stuAddress;
        this.stuContact = stuContact;
        this.stuDOB = stuDOB;
        this.stuGender = stuGender;
    }

    public String getRegisID() {
        return regisID;
    }

    public void setRegisID(String regisID) {
        this.regisID = regisID;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public String getStuContact() {
        return stuContact;
    }

    public void setStuContact(String stuContact) {
        this.stuContact = stuContact;
    }

    public String getStuDOB() {
        return stuDOB;
    }

    public void setStuDOB(String stuDOB) {
        this.stuDOB = stuDOB;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "regisID='" + regisID + '\'' +
                ", couName='" + couName + '\'' +
                ", stuID='" + stuID + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuAddress='" + stuAddress + '\'' +
                ", stuContact='" + stuContact + '\'' +
                ", stuDOB='" + stuDOB + '\'' +
                ", stuGender='" + stuGender + '\'' +
                '}';
    }
}

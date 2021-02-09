package tm;


public class CourseTM {
    private String coId;
    private String coName;
    private String coDuration;
    private double coFee;

    public CourseTM() {
    }

    public CourseTM(String coId, String coName, String coDuration, double coFee) {
        this.coId = coId;
        this.coName = coName;
        this.coDuration = coDuration;
        this.coFee = coFee;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public String getCoDuration() {
        return coDuration;
    }

    public void setCoDuration(String coDuration) {
        this.coDuration = coDuration;
    }

    public double getCoFee() {
        return coFee;
    }

    public void setCoFee(double coFee) {
        this.coFee = coFee;
    }

    @Override
    public String toString() {
        return "CourseTM{" +
                "coId='" + coId + '\'' +
                ", coName='" + coName + '\'' +
                ", coDuration='" + coDuration + '\'' +
                ", coFee=" + coFee +
                '}';
    }
}

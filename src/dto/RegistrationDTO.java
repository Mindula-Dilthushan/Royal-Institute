package dto;

public class RegistrationDTO {

    private String regId;
    private String regDate;
    private double regFee;
    private StudentDTO studentDTO;
    private CourseDTO courseDTO;

    public RegistrationDTO(String regId, String regDate, double regFee) {
    }

    public RegistrationDTO(String regId, String regDate, double regFee, StudentDTO studentDTO, CourseDTO courseDTO) {
        this.regId = regId;
        this.regDate = regDate;
        this.regFee = regFee;
        this.studentDTO = studentDTO;
        this.courseDTO = courseDTO;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "regId=" + regId +
                ", regDate='" + regDate + '\'' +
                ", regFee=" + regFee +
                ", studentDTO=" + studentDTO +
                ", courseDTO=" + courseDTO +
                '}';
    }
}

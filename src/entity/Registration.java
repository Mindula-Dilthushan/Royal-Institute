package entity;

import dto.CourseDTO;
import dto.StudentDTO;
import javax.persistence.*;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String regId;
    private String regDate;
    private double regFee;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "stId" , referencedColumnName = "studentId" , nullable = false)
    private Student student;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cId" , referencedColumnName = "courseId" , nullable = false)
    private Course course;

    public Registration(String regId, String regDate, double regFee, StudentDTO studentDTO, CourseDTO courseDTO) {
    }

    public Registration(String regId, String regDate, double regFee, Student student, Course course) {
        this.regId = regId;
        this.regDate = regDate;
        this.regFee = regFee;
        this.student = student;
        this.course = course;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regId=" + regId +
                ", regDate='" + regDate + '\'' +
                ", regFee=" + regFee +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}

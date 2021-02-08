package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    private String courseId;
    private String courseName;
    private String duration;
    private double courseFee;

//    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
//    private List<Registration> registrationList = new ArrayList();

    public Course(){
    }

    public Course(String courseId, String courseName, String duration, double courseFee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.courseFee = courseFee;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

//    public List<Registration> getRegistrationList() {
//        return registrationList;
//    }
//
//    public void setRegistrationList(List<Registration> registrationList) {
//        this.registrationList = registrationList;
//    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                ", courseFee=" + courseFee +
//                ", registrationList=" + registrationList +
                '}';
    }
}

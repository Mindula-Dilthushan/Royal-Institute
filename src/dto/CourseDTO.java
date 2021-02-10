package dto;

public class CourseDTO {
    private String courseId;
    private String courseName;
    private String duration;
    private double courseFee;

    public CourseDTO() {
    }

    public CourseDTO(String courseId, String courseName, String duration, double courseFee) {
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

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                ", courseFee=" + courseFee +
                '}';
    }
}


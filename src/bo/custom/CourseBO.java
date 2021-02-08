package bo.custom;

import bo.SuperBO;
import dto.CourseDTO;

public interface CourseBO extends SuperBO {
    boolean saveCourse(CourseDTO courseDTO)throws Exception;
}

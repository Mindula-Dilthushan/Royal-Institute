package bo.custom;

import bo.SuperBO;
import dto.CourseDTO;

import java.util.List;

public interface CourseBO extends SuperBO {
    boolean saveCourse(CourseDTO courseDTO)throws Exception;
    List<CourseDTO>getAll()throws Exception;
}

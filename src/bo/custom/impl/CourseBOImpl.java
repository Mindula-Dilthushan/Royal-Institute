package bo.custom.impl;

import bo.custom.CourseBO;
import dao.DAOFactory;
import dao.custom.CourseDAO;
import dto.CourseDTO;
import entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    private CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getSuperDAO(DAOFactory.DAOType.COURSE);

    @Override
    public boolean saveCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.save(
                new Course(
                        courseDTO.getCourseId(),
                        courseDTO.getCourseName(),
                        courseDTO.getDuration(),
                        courseDTO.getCourseFee()
                )
        );
    }

    @Override
    public List<CourseDTO> getAll() throws Exception {
        List<CourseDTO> courseDTOList = new ArrayList<>();
        List<Course> courseList = courseDAO.getAll();
        for (Course course : courseList){
            courseDTOList.add(
                    new CourseDTO(
                            course.getCourseId(),
                            course.getCourseName(),
                            course.getDuration(),
                            course.getCourseFee()
                    )
            );
        }
        return courseDTOList;
    }
}

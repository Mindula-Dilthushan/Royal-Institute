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
    public boolean updateCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.update(
                new Course(
                        courseDTO.getCourseId(),
                        courseDTO.getCourseName(),
                        courseDTO.getDuration(),
                        courseDTO.getCourseFee()
                )
        );
    }
    @Override
    public boolean deleteCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.delete(
                new Course(
                        courseDTO.getCourseId(),
                        courseDTO.getCourseName(),
                        courseDTO.getDuration(),
                        courseDTO.getCourseFee()
                )
        );
    }
    @Override
    public CourseDTO searchCourse(CourseDTO courseDTO) throws Exception {
          return courseDTOs(courseDAO.search(courses(courseDTO)));
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
    private CourseDTO courseDTOs(Course course){
        return new CourseDTO(
                course.getCourseId(),
                course.getCourseName(),
                course.getDuration(),
                course.getCourseFee()
        );
    }
    private Course courses(CourseDTO courseDTO){
        return new Course(
                courseDTO.getCourseId(),
                courseDTO.getCourseName(),
                courseDTO.getDuration(),
                courseDTO.getCourseFee()
        );
    }
}

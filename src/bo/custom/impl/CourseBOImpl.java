package bo.custom.impl;

import bo.custom.CourseBO;
import dao.DAOFactory;
import dao.custom.CourseDAO;
import dto.CourseDTO;
import entity.Course;

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
}

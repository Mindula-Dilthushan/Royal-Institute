package bo.custom.impl;

import bo.custom.RegistrationBO;
import dao.DAOFactory;
import dao.custom.RegistrationDAO;
import dto.CourseDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import entity.Course;
import entity.Registration;
import entity.Student;
import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {

    private RegistrationDAO registrationDAO = (RegistrationDAO) DAOFactory.getDaoFactory().getSuperDAO(DAOFactory.DAOType.REGISTRATION);

    @Override
    public boolean saveReg(RegistrationDTO registrationDTO) throws Exception {
        return registrationDAO.save(
                new Registration(
                        registrationDTO.getRegId(),
                        registrationDTO.getRegDate(),
                        registrationDTO.getRegFee(),
                        registrationDTO.getStudentDTO(),
                        registrationDTO.getCourseDTO()
                )
        );
    }

    @Override
    public boolean updateReg(RegistrationDTO registrationDTO) throws Exception {
        return registrationDAO.update(
                new Registration(
                        registrationDTO.getRegId(),
                        registrationDTO.getRegDate(),
                        registrationDTO.getRegFee(),
                        registrationDTO.getStudentDTO(),
                        registrationDTO.getCourseDTO()
                )
        );
    }

    @Override
    public boolean deleteReg(RegistrationDTO registrationDTO) throws Exception {
        return registrationDAO.delete(
                new Registration(
                        registrationDTO.getRegId(),
                        registrationDTO.getRegDate(),
                        registrationDTO.getRegFee(),
                        registrationDTO.getStudentDTO(),
                        registrationDTO.getCourseDTO()
                )
        );
    }

    @Override
    public RegistrationDTO searchReg(RegistrationDTO registrationDTO) throws Exception {
        return null;
    }

    @Override
    public List<RegistrationDTO> getAllReg(RegistrationDTO registrationDTO) throws Exception {
        List<RegistrationDTO> registrationDTOList = new ArrayList<>();
        List<Registration> registrationList = registrationDAO.getAll();
            for (Registration registration : registrationList){
                registrationDTOList.add(
                        new RegistrationDTO(
                                registration.getRegId(),
                                registration.getRegDate(),
                                registration.getRegFee(),
                                registrationDTO.getStudentDTO(),
                                registrationDTO.getCourseDTO()
                        )
                );
            }
        return null;
    }

    @Override
    public List<RegistrationDTO> getAllRegistration(String studentId) throws Exception {
       List<RegistrationDTO> registrationDTOList = new ArrayList<>();
       List<Registration> registrationList = registrationDAO.getAllRegistration(studentId);
       for (Registration registration : registrationList){
           registrationDTOList.add(getAllRegis(registration));
       }
       return registrationDTOList;
    }
    private RegistrationDTO getAllRegis(Registration registration){
        return new RegistrationDTO(
                registration.getRegId(),
                registration.getRegDate(),
                registration.getRegFee(),
                getAllStud(registration.getStudent()),
                getAllCou(registration.getCourse())
        );
    }
    private StudentDTO getAllStud(Student student){
        return new StudentDTO(
                student.getStudentId(),
                student.getStudentName(),
                student.getStudentAddress(),
                student.getStudentContact(),
                student.getStudentDOB(),
                student.getStudentGender()
        );
    }
    private CourseDTO getAllCou(Course course){
        return new CourseDTO(
                course.getCourseId(),
                course.getCourseName(),
                course.getDuration(),
                course.getCourseFee()
        );
    }
}

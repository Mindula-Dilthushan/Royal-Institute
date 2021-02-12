package bo.custom.impl;

import bo.custom.AddRegistrationBO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import entity.Course;
import entity.Registration;
import entity.Student;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddRegistrationBOImpl implements AddRegistrationBO {

    private SessionFactory sessionFactory;

    public AddRegistrationBOImpl(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean addRegistration(StudentDTO studentDTO, List<RegistrationDTO> registrationDTOList) throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {

            Student student =  new Student(
                    studentDTO.getStudentId(),
                    studentDTO.getStudentName(),
                    studentDTO.getStudentAddress(),
                    studentDTO.getStudentContact(),
                    studentDTO.getStudentDOB(),
                    studentDTO.getStudentGender()
            );

            List<Registration> registrationList = new ArrayList<>();

            for (RegistrationDTO registrationDTO : registrationDTOList){
                registrationList.add(
                        new Registration(
                                registrationDTO.getRegId(),
                                registrationDTO.getRegDate(),
                                registrationDTO.getRegFee(),
                                registrationDTO.getStudentDTO(),
                                registrationDTO.getCourseDTO()
                        )
                );
            }

            for (Registration reg : registrationList){
                student.getRegistrationList().add(reg);
            }
            for (Registration regis : registrationList){
                regis.setStudent(student);
            }
            for (Registration registration : registrationList){
                Serializable addReg = session.save(registration);

                if (addReg == null){
                    session.getTransaction().rollback();
                    return false;
                }
            }
        }catch (Exception e){
        }
        return false;
    }
}
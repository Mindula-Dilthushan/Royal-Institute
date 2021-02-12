package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    private StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getSuperDAO(DAOFactory.DAOType.STUDENT);

    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.save(
                new Student(
                        studentDTO.getStudentId(),
                        studentDTO.getStudentName(),
                        studentDTO.getStudentAddress(),
                        studentDTO.getStudentContact(),
                        studentDTO.getStudentDOB(),
                        studentDTO.getStudentGender()
                )
        );
    }
    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(
                new Student(
                        studentDTO.getStudentId(),
                        studentDTO.getStudentName(),
                        studentDTO.getStudentAddress(),
                        studentDTO.getStudentContact(),
                        studentDTO.getStudentDOB(),
                        studentDTO.getStudentGender()
                )
        );
    }

    @Override
    public boolean deleteStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.delete(
                new Student(
                        studentDTO.getStudentId(),
                        studentDTO.getStudentName(),
                        studentDTO.getStudentAddress(),
                        studentDTO.getStudentContact(),
                        studentDTO.getStudentDOB(),
                        studentDTO.getStudentGender()
                )
        );
    }

    @Override
    public StudentDTO searchStudent(StudentDTO studentDTO) throws Exception {
       return searchingStudentDTOs(studentDAO.search(searchingStudent(studentDTO)));
    }

    @Override
    public List<StudentDTO> getAllStudent() throws Exception {
        return null;
    }

    private Student searchingStudent(StudentDTO studentDTO) {
        return new Student(
                studentDTO.getStudentId(),
                studentDTO.getStudentName(),
                studentDTO.getStudentAddress(),
                studentDTO.getStudentContact(),
                studentDTO.getStudentDOB(),
                studentDTO.getStudentGender()
        );
    }

    private StudentDTO searchingStudentDTOs(Student student) {
        return new StudentDTO(
                student.getStudentId(),
                student.getStudentName(),
                student.getStudentAddress(),
                student.getStudentContact(),
                student.getStudentDOB(),
                student.getStudentGender()
        );
    }
}

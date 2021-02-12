package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import java.util.List;

public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO studentDTO)throws Exception;
    boolean updateStudent(StudentDTO studentDTO)throws Exception;
    boolean deleteStudent(StudentDTO studentDTO)throws Exception;
    StudentDTO searchStudent(StudentDTO studentDTO)throws Exception;
    List<StudentDTO> getAllStudent()throws Exception;
}

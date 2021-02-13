package dao.custom;

import dao.CrudDAO;
import entity.Registration;
import java.util.List;

public interface RegistrationDAO extends CrudDAO<Registration, String> {
    List<Registration> getAllRegistration(String studentID)throws Exception;
}

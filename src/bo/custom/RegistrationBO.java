package bo.custom;

import bo.SuperBO;
import dto.RegistrationDTO;
import java.util.List;

public interface RegistrationBO extends SuperBO {
    boolean saveReg(RegistrationDTO registrationDTO)throws Exception;
    boolean updateReg(RegistrationDTO registrationDTO)throws Exception;
    boolean deleteReg(RegistrationDTO registrationDTO)throws Exception;
    RegistrationDTO searchReg(RegistrationDTO registrationDTO)throws Exception;
    List<RegistrationDTO> getAllReg(RegistrationDTO registrationDTO)throws Exception;
    List<RegistrationDTO> getAllRegistration(String studentId)throws Exception;
}

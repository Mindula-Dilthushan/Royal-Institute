package bo.custom.impl;

import bo.custom.RegistrationBO;
import dao.DAOFactory;
import dao.custom.RegistrationDAO;
import dto.RegistrationDTO;
import entity.Registration;
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
}

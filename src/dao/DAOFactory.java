package dao;

import dao.custom.impl.CourseDAOImpl;
import dao.custom.impl.RegistrationDAOImpl;
import dao.custom.impl.StudentDAOImpl;

public class DAOFactory {

    public enum DAOType{
        COURSE,STUDENT,REGISTRATION
    }

    private static DAOFactory daoFactory;

    private DAOFactory(){
    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory !=null) ?
                daoFactory : (daoFactory = new DAOFactory());
    }

    public SuperDAO getSuperDAO(DAOType daoType){
        switch (daoType){
            case COURSE:
                return new CourseDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            case REGISTRATION:
                return new RegistrationDAOImpl();
            default:
                return null;
        }
    }

}

package dao;

import dao.custom.impl.CourseDAOImpl;

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
            default:
                return null;
        }
    }

}

package bo;

import bo.custom.impl.AddRegistrationBOImpl;
import bo.custom.impl.CourseBOImpl;
import bo.custom.impl.RegistrationBOImpl;
import bo.custom.impl.StudentBOImpl;

public class BOFactory {

    public enum BOType{
        COURSE,STUDENT,REGISTRATION,ADDREGISTRATION
    }

    private static BOFactory boFactory;

    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory !=null)
                ? boFactory : (boFactory=new BOFactory());
    }
    public SuperBO getSuperBO(BOType boType){
        switch (boType){
            case COURSE:
                return new CourseBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case REGISTRATION:
                return new RegistrationBOImpl();
            case ADDREGISTRATION:
                return new AddRegistrationBOImpl();
            default:
                return null;
        }
    }
}

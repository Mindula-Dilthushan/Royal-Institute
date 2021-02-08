package bo;

import bo.custom.impl.CourseBOImpl;

public class BOFactory {

    public enum BOType{
        COURSE
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
            default:
                return null;
        }
    }
}

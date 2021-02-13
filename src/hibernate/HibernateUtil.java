package hibernate;

import entity.Course;
import entity.Registration;
import entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().loadProperties("hibernate/application.properties").build();

        Metadata metadata = new MetadataSources(standardServiceRegistry)
                            .addAnnotatedClass(Student.class)
                            .addAnnotatedClass(Registration.class)
                            .addAnnotatedClass(Course.class)
                            .getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}

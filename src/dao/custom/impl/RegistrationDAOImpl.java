package dao.custom.impl;

import dao.custom.RegistrationDAO;
import entity.Registration;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.Serializable;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {

    private SessionFactory sessionFactory;

    public RegistrationDAOImpl(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean save(Registration entity) throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Serializable saveReg = session.save(entity);
        session.getTransaction().commit();
        return saveReg != null;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public boolean delete(Registration entity) throws Exception {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public Registration search(Registration entity) throws Exception {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Registration registration = session.find(Registration.class, entity.getRegId());
            session.getTransaction().commit();
            return registration;
        }catch (Exception e){
        }
        return null;
    }

    @Override
    public List<Registration> getAll() throws Exception {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Registration> registrationList = session.createNativeQuery("SELECT * FROM registration",Registration.class).list();
            session.getTransaction().commit();
            return registrationList;
        }catch (Exception e){
        }
        return null;
    }
}

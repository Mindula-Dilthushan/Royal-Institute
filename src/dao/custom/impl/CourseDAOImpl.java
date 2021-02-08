package dao.custom.impl;

import dao.custom.CourseDAO;
import entity.Course;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.Serializable;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    private SessionFactory sessionFactory;

    public CourseDAOImpl(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean save(Course entity) throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Serializable save = session.save(entity);
        session.getTransaction().commit();
        return save !=null;
    }

    @Override
    public boolean update(Course entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Course entity) throws Exception {
        return false;
    }

    @Override
    public Course search(Course entity) throws Exception {
        return null;
    }

    @Override
    public List<Course> getAll() throws Exception {
        return null;
    }
}
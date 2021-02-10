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
    public boolean delete(Course entity) throws Exception {
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
    public Course search(Course entity) throws Exception {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.find(Course.class, entity.getCourseId());
            session.getTransaction().commit();
            return course;
        }catch (Exception e){
        }
        return null;
    }
    @Override
    public List<Course> getAll() throws Exception {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Course> courseList = session.createNativeQuery("SELECT * FROM course",Course.class).list();
            session.getTransaction().commit();
            return courseList;
        }catch (Exception e){
        }
        return null;
    }
}

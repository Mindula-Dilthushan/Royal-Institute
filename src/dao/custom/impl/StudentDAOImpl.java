package dao.custom.impl;

import dao.CrudDAO;
import entity.Student;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.Serializable;
import java.util.List;

public class StudentDAOImpl implements CrudDAO<Student,String> {

    private SessionFactory sessionFactory;

    public StudentDAOImpl(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean save(Student entity) throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Serializable saveStudent = session.save(entity);
        session.getTransaction().commit();
        return saveStudent !=null;
    }

    @Override
    public boolean update(Student entity) throws Exception {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            return true;
        }catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean delete(Student entity) throws Exception {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction();
            return true;
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public Student search(Student entity) throws Exception {
       try {
           Session session = sessionFactory.openSession();
           session.beginTransaction();
           Student student = session.find(Student.class, entity.getStudentId());
           return student;
       }catch (Exception e) {
       }
       return null;
    }

    @Override
    public List<Student> getAll() throws Exception {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Student> studentList = session.createNativeQuery("SELECT * FROM student",Student.class).list();
            session.getTransaction().commit();
            return studentList;
        }catch (Exception e){
        }
        return null;
    }
}

package org.example.tphopital.repository;

import jakarta.persistence.EntityNotFoundException;
import org.example.tphopital.exception.NotFountException;
import org.example.tphopital.model.Patient;
import org.example.tphopital.model.User;
import org.hibernate.Transaction;

import java.util.List;

public class UserRepository extends BaseRepository<User> {

    public UserRepository() {
        super();
    }

    @Override
    public User add(User entity) {
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return entity;
    }

    @Override
    public User finfById(int id) {
        User user = null;

        try {
            session = sessionFactory.openSession();
            user = session.get(User.class,id);
            if (user == null){
                throw new NotFountException("User non trouvé");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = null;
        try {
            session = sessionFactory.openSession();
            users = session.createQuery("from User", User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }


    @Override
    public User update(User entity) {
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return entity;
    }

    @Override
    public boolean delete(User entity) {
        Transaction transaction = null;
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
            result = true;
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return result;
    }

    public User findByEmail(String email){
        User user = null;
        try {
            session = sessionFactory.openSession();
            user = (User) session.createQuery("from User where email = :email")
                    .setParameter("email",email)
                    .uniqueResult();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return user;
    }

}

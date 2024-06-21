package org.example.tphopital.repository;

import org.example.tphopital.exception.NotFountException;
import org.example.tphopital.model.Patient;
import org.hibernate.Transaction;

import java.util.List;

public class PatientRepository extends BaseRepository<Patient> {

    public PatientRepository() {
        super();
    }

    @Override
    public Patient add(Patient entity) {
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            System.out.println("Patient ajouté avec succès : " + entity);
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Échec de l'ajout du patient : " + e.getMessage());
        } finally {
            session.close();
        }
        return entity;
    }

    @Override
    public Patient finfById(int id) {
        Patient patient = null;

        try {
            session = sessionFactory.openSession();
            patient = session.get(Patient.class,id);
            if (patient == null){
                throw new NotFountException("Patient non trouvé");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = null;
        try {
            session = sessionFactory.openSession();
            patients = session.createQuery("from Patient", Patient.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return patients;
    }


    @Override
    public Patient update(Patient entity) {
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
    public boolean delete(Patient entity) {
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
}

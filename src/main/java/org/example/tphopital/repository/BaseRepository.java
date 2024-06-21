package org.example.tphopital.repository;

import org.example.tphopital.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public abstract class BaseRepository <T>{
    protected StandardServiceRegistry registry;

    protected SessionFactory sessionFactory;

    protected Session session;

    public BaseRepository(){
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public abstract T add(T entity);

    public abstract  T finfById(int id);


    public abstract List<T> findAll();

    public abstract T update(T entity);

    public abstract boolean delete(T entity);

}

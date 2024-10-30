package com.youcode.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public abstract class BaseDAO<E ,ID> implements BaseDAOIntf<E ,ID> {

    private final Class<E> entityClass;
    private final SessionFactory sessionFactory;

    public BaseDAO(Class<E> entityClass, SessionFactory sessionFactory) {
        this.entityClass = entityClass;
        this.sessionFactory = sessionFactory;
    }

    protected Session openSession() {
        return sessionFactory.openSession();
    }

    @Override
    public E save(E entity) {
        E e = null ;
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            e = session.merge(entity);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Transaction rolled back due to: " + ex.getMessage());
            }
            ex.printStackTrace();
        }
        return e;
    }


    @Override
    public void update(E entity) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<E> findAll() {
        try (Session session = openSession()) {
            return session.createQuery("FROM " + entityClass.getName(), entityClass).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<E> findById(ID id) {
        try (Session session = openSession()) {
            return Optional.ofNullable(session.get(entityClass, id));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void delete(E entity) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.remove(session.contains(entity) ? entity : session.merge(entity));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(ID id) {
        Optional<E> entity = findById(id);
        entity.ifPresent(this::delete);
    }
}
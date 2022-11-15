package org.enterprise.persistence;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 * A generic DAO somewhat inspired by http://rodrigouchoa.wordpress.com
 * @author pwaite
 * <T> is used to allow us to specify the type that is needed at the time.
 */
public class GenericDao<T> {
    // Variable for class of whatever type we are working with.
    private Class<T> type;

    // Logging
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Constructor
     * Instantiate a new Generic Dao
     * @param type the entity type, for example, User.
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Returns an open session from the SessionFactory
     */
    private static Session getSession() {
        // Gets session factory from provider and opens it.
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    // METHODS FOR THE VARIOUS CRUD CALLS.
    /**
     * Insert an entity
     * CREATE.r.u.d
     * @param entity  Entity to be inserted
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Gets all entities.
     * c.READ.u.d
     * @return All entities
     */
    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();

        session.close();
        return list;
    }

    /**
     * Gets an entity by id
     * c.READ.u.d
     * @param id Entity id to search by
     * @return an entity
     */
    public <T>T getById(int id) {
        // <T>T is the generic all encompassing type.
        // Session object for using the session provider.
        Session session = getSession();

        // entity is generic variable for whatever we get and Cast it (T)
        T entity = (T)session.get(type, id);

        session.close();
        return entity;
    }

    /**
     * Gets entities by one of its properties
     * c.READ.u.d
     * @param propertyName Given property
     * @param value Given value of referenced property
     * @return list
     */
    public List<T> getByPropertyEqual(String propertyName, Object value) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);

        query.select(root).where(builder.equal(root.get(propertyName),value));
        return session.createQuery(query).getResultList();
    }

    /**
     * Gets entities by a property
     * c.READ.u.d
     * @param propertyName Given property name
     * @param value Given value of referenced property
     * @return list
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        value = "%" + value + "%";
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);

        query.select(root).where(builder.like(root.get(propertyName), value));
        return session.createQuery(query).getResultList();
    }

    /**
     * Update an entity
     * c.r.UPDATE.d
     * @param entity  Entity to be updated
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Delete an entity
     * c.r.u.DELETE
     * @param entity Entity to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(entity);
        transaction.commit();
        session.close();
    }
}

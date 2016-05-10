package persistence;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the default MySQL Hibernate DAO for tables in this application. It contains all generic CRUD functionality
 * that the application requires.
 * Created by biwerm on 4/24/16.
 */
public class AbstractDAO<T> {
    private Class<T> type;
    private final Logger log = Logger.getLogger(this.getClass());
    public AbstractDAO(Class<T> type) {
        this.type = type;
    }

    /**
     * This method will take in the set class for the instance of the DAO and add it to the database based on hibernate
     * configurations for the entity.
     * @param object - Entity Class
     * @return int - ID of object that was created
     */
    public int create(T object) {
        Transaction tx = null;
        Integer id = null;
        Session session = getSession();
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(object);
            tx.commit();
            log.debug("Created " + object.getClass().getName() + " with id " +
                    "of: " + id);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return id;
    }

    /**
     * This method will retrieve an instance of the object based on the input primary key and the hibernate setup
     * configurations for the current class instance of the DAO.
     * @param id - Primary Key integer for class.
     * @return T - A class that is of the type of the current instance of DAO
     */
    public T get(int id) {
        return (T) getSession().get(type, id);
    }

    /**
     * This method will retrieve all instances of the current set class type based on hibernate configurations.
     * @return List<T> - A list that contains the type of the current instance of DAO
     */
    public List<T> getAll() {
        return (ArrayList<T>)getSession().createCriteria(type).list();
    }

    /**
     * This method will update the object that is sent as input to the method based on its entity types hibernate
     * configurations.
     * @param object - Object that has a type of the current instances class type.
     */
    public void update(T object) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(object);
            tx.commit();
            log.debug("Updated " + object.getClass().getName() + ": " + object);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    /**
     * This method will update the object that is sent as input to the method based on its entity types hibernate
     * configurations.
     * @param object - Object that has a type of the current instances class type.
     */
    public void delete(T object) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(object);
            tx.commit();
            log.debug("Deleted " + object.getClass().getName() + ": " + object);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    /**
     * This method provide the session for the database actions that take place in this class.
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }
}
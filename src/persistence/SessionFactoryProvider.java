package persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * This class will hold the session factory for database calls for this application.
 */
public class SessionFactoryProvider {
    private static SessionFactory sessionFactory;

    /**
     * This will create a instance of the session factory.
     */
    public static void createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()). buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * This will retrieve a instance of the session factory.
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            createSessionFactory();
        }
        return sessionFactory;
    }
}

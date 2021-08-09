package be.bxlformation.demojpa;

import be.bxlformation.demojpa.entities.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DemoJPA {

    private static SessionFactory buildSessionFactory() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        return config.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        System.out.println("DEMO JPA HIBERNATE");
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

            session.beginTransaction();
            // TRANSACTION SQL
            Section newSection = new Section(1400L, "JPA Hibernate", 10);

            session.save(newSection);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                System.out.println("--- ROLLBACK de la TRANSACTION ---");
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

}

package db;


import db.dto.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBConfig {
    private static final String hibernate_show_sql = "false";
    private static final String hibernate_hbm2ddl_auto = "create";

    private final SessionFactory sessionFactory;

    public DBConfig() {
        Configuration configuration = getPostgresqlConnection();
        sessionFactory = createSessionFactory(configuration);
    }

    private Configuration getH2Configuration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UserDTO.class);
        configuration.addAnnotatedClass(ItemDTO.class);
        configuration.addAnnotatedClass(BucketDTO.class);
        configuration.addAnnotatedClass(AvailableItemsDTO.class);
        configuration.addAnnotatedClass(CategoryItemDTO.class);
        configuration.addAnnotatedClass(OrderDTO.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:./h2db");
        configuration.setProperty("hibernate.connection.username", "user");
        configuration.setProperty("hibernate.connection.password", "user");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        return configuration;
    }

    public static Configuration getPostgresqlConnection() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UserDTO.class);
        configuration.addAnnotatedClass(ItemDTO.class);
        configuration.addAnnotatedClass(BucketDTO.class);
        configuration.addAnnotatedClass(AvailableItemsDTO.class);
        configuration.addAnnotatedClass(CategoryItemDTO.class);
        configuration.addAnnotatedClass(OrderDTO.class);


        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/shoptest");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "123456");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        return configuration;

    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String url = "jdbc:mysql://localhost:3306/store";
    private static final String userName = "root";
    private static final String passWord = "Killer83";

    static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(url, userName, passWord);
                System.out.println("Соединение созданно");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка соединения");
        }
        return connection;
    }
    static SessionFactory sessionFactory = null;
    static Configuration configuration;
    static Properties properties;

    public static SessionFactory getSessionFactory() {

        try {
            if (sessionFactory == null) {
                configuration = new Configuration();
                properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                properties.put(Environment.URL, url);
                properties.put(Environment.USER, userName);
                properties.put(Environment.PASS, passWord);
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                //properties.put(Environment.SHOW_SQL, "true");
                //properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                System.out.println("Соединение созданно");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка соединения");
        }
        return sessionFactory;
    }
}

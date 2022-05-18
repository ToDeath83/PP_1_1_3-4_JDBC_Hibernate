package jm.task.core.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import org.hibernate.cfg.Environment;

import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();
        userDao.saveUser("Вася1", "Пупкин1", (byte) 1);
        userDao.saveUser("Вася2", "Пупкин2", (byte) 2);
        userDao.saveUser("Вася3", "Пупкин3", (byte) 3);
        userDao.saveUser("Вася4", "Пупкин4", (byte) 4);

        List<User> list = userDao.getAllUsers();
        for (User user: list) {
            System.out.println(user);
        }

        userDao.removeUserById(2);

        userDao.cleanUsersTable();
        userDao.dropUsersTable();

//        Configuration configuration = new Configuration();
//        Properties properties = new Properties();
//        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
//        properties.put(Environment.URL,"jdbc:mysql://localhost:3306/store");
//        properties.put(Environment.USER,"root");
//        properties.put(Environment.PASS,"Killer83");
//
//        configuration.setProperties(properties);
//        configuration.addAnnotatedClass(User.class);
//
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties()).build();
//
//        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        System.out.println("Соединение созданно");
//
//
//
//        sessionFactory.close();


//        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(User.class).buildSessionFactory();
//        Session session= null;
//
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        User user = new User("Вася", "Пупкин", (byte)1);
////        System.out.println(user);
////        session.save(user);
////        System.out.println(user);
////        session.getTransaction().commit();
//
//        sessionFactory.close();

    }
}

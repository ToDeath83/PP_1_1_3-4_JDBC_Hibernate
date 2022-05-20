package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoHibernateImpl();

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
    }
}

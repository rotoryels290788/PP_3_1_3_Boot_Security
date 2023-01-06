package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;
import java.util.List;



public interface UserDao {
    void saveUser(User user);

    List<User> getList();

    User getUser(Integer id);

    void deleteUser(Integer id);

    void editUser(User user);

    User getEmail(String email);

}
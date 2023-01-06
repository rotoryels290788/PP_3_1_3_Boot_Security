package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;
import java.util.List;


@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Override
    @Transactional
    public void editUser(User user) {
        userDao.editUser(user);
    }



    @Override
    @Transactional
    public List<User> getList() {
        return userDao.getList();
    }

    @Override
    @Transactional
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);

    }

    @Override
    @Transactional
    public User getEmail(String email) {
        return userDao.getEmail(email);
    }



}




package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;
 @Component
public class UserDetailsServiceImp implements UserDetailsService {

     private final UserDao userDao;

     @Autowired
     public UserDetailsServiceImp(UserDao userDao) {
         this.userDao = userDao;
     }

     @Override
     @Transactional
     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         User user = userDao.getEmail(email);
         if (user == null) {
             throw new UsernameNotFoundException(String.format("Email is '%s' not found", email));
         }

         return new org.springframework.security.core.userdetails.User(user.getEmail(),
                 user.getPassword(),
                 user.getAuthorities());


     }

 }
package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Roles;

import java.util.List;


public interface RolesDao {
    void roleSave(Roles user);

    Roles convert(String id);
    void editRole(Roles role);


    List<Roles> getRole();




}
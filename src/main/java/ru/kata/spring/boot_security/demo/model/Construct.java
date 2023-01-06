package ru.kata.spring.boot_security.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.service.RolesService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Component
public class Construct {
    private UserService userService;
    private RolesService rolesService;


    @Autowired
    public Construct(UserService userService, RolesService rolesService) {

        this.userService = userService;
        this.rolesService = rolesService;
    }


    @PostConstruct
    public void createTable() {

        Roles admin = new Roles("ROLE_ADMIN");
        Roles rolUser = new Roles("ROLE_USER");
        rolesService.roleSave(admin);
        rolesService.roleSave(rolUser);

        List<Roles> role = new ArrayList<>();
        role.add(admin);
        List<Roles> role2 = new ArrayList<>();
        role2.add(rolUser);
        List<Roles> role3 = new ArrayList<>();
        role3.add(admin);
        role3.add(rolUser);


        User user = new User("Dmitry", "IT", "dima@.ru",
                "$2a$12$Zh32gBJNOju413rFHBAIQOipCotpra0RWB4rTkakXGNzOyER3t2.m", role3); //pass 1

        User user2 = new User("Ivan", "Manager", "Iva@.ru",
                "$2a$12$t9O9HkMzFQZvpG2lKpIp7uN0i/wPc4q08Ybk9xfMUdCF8Bfi.YvZe", role2);    //pass 2

        User user3 = new User("Aleksey", "IT", "Aleks@.ru",
                "$2a$12$01VwevanPWzUp7sY2Tz6t.TpVcLARMeYBP1ZhGvbXJbKrjD8nbLqS", role);   //pass 3

        User user4 = new User("Nikolay","Nik@.ru","$2a$12$NhBFNwws9AhagzjpBs.cMOIXEC5SBUgtibEhrpiMXQiDSllg/cP9y"); //pass 4

        userService.saveUser(user);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);
    }
}

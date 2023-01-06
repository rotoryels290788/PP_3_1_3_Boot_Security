package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Roles;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RolesService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RolesService rolesService;
    @Autowired
    public AdminController(PasswordEncoder passwordEncoder, UserService userService, RolesService rolesService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.rolesService = rolesService;
    }
    @GetMapping
    public String getUser(Model model) {
        model.addAttribute("userList", userService.getList());
        return "admin";
    }

    @GetMapping("/newUserAdmin")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);

        List<Roles> roles = rolesService.getRole();
        model.addAttribute("roleList", roles);

        return "newUsers";
    }

    @PostMapping("/newUserAdmin")
    public String saveNewUser(
            @ModelAttribute("newUser") User user
    ) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/admin";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("editUser", userService.getUser(id));
        model.addAttribute("roleList",rolesService.getRole());
        return "editUsers";
    }

    @PatchMapping("/{id}")
    public String userSaveEdit(@PathVariable("id") Integer id, @ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.editUser(user);
        return "redirect:/admin";
    }

}
package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RolesDao;
import ru.kata.spring.boot_security.demo.model.Roles;

import java.util.List;

@Service
public class RolesServiceImp implements RolesService {

    private final RolesDao rolesDao;
    @Autowired
    public RolesServiceImp(RolesDao rolesDao) {
        this.rolesDao = rolesDao;
    }


    @Override
    @Transactional
    public void roleSave(Roles role) {
    rolesDao.roleSave(role);

    }
    @Override
    public Roles convert(String id) {
       return rolesDao.convert(id);
    }



    @Override
    public void editRole(Roles role) {
         rolesDao.editRole(role);
    }

    @Override
    @Transactional
    public List<Roles> getRole() {
        return rolesDao.getRole();
    }


}

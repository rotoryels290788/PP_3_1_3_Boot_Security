package ru.kata.spring.boot_security.demo.dao;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Roles;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class RolesDaoImp implements RolesDao,Converter<String,Roles> {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void roleSave(Roles role) {
       entityManager.persist(role);

    }
    @Override
    public List<Roles> getRole() {
        return entityManager.createQuery("select r from Roles r", Roles.class).getResultList();
    }


    @Override
    public Roles convert(String id) {
        Roles role = new Roles();
        role.setId(Integer.valueOf(id));
        return role;
    }

    @Override
    public void editRole(Roles role) {
        entityManager.merge(role);
    }


}

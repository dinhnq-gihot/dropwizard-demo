package com.example.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.example.entity.UserEntity;

import io.dropwizard.hibernate.AbstractDAO;

public class UserDAO extends AbstractDAO<UserEntity> {
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public UserEntity findById(Long id) {
        return get(id);
    }

    public UserEntity create(UserEntity user) {
        return persist(user);
    }

    public List<UserEntity> findAll() {
        return list(namedTypedQuery("com.example.entity.UserEntity.findAll"));
    }
}

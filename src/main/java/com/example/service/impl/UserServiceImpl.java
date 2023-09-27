package com.example.service.impl;

import com.example.db.UserDAO;
import com.example.entity.UserEntity;
import com.example.service.IUserService;

public class UserServiceImpl implements IUserService {
    private final UserDAO dao;

    public UserServiceImpl(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public UserEntity getUserById(Long id) {
        return dao.findById(id);
    }

    @Override
    public UserEntity createUser(UserEntity entity) {
        return dao.create(entity);
    }
}

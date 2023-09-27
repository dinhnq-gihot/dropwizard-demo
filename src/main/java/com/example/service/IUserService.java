package com.example.service;

import com.example.entity.UserEntity;

public interface IUserService {
    public UserEntity getUserById(Long id);
    public UserEntity createUser(UserEntity entity);
}

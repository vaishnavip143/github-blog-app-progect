package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.payloads.UserDto;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    User registerNewUser(User user);
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

    void deleteUser(Integer id);
    @Transactional
    User updateUser(Integer id, User User);

    ;



}

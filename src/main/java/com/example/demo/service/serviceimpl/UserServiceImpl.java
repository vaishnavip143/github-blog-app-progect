package com.example.demo.service.serviceimpl;

import com.example.demo.payloads.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto user) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        return List.of();
    }

    @Override
    public void deleteUser(Integer userId) {

    }
}

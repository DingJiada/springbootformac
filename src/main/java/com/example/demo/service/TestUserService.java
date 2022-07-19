package com.example.demo.service;

import com.example.demo.dto.TestUserDTO;
import com.example.demo.entity.TestUser;

import java.util.List;

public interface TestUserService {

    List<TestUser> getUser();

    Integer addUser(TestUserDTO testUserDTO);

    void delUserByName(String name);
}

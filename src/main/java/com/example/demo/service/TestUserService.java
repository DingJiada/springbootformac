package com.example.demo.service;

import com.example.demo.entity.TestUser;

import java.util.List;

public interface TestUserService {

    List<TestUser> getUser();

    void addUser(TestUser user);

    void delUserByName(String name);
}

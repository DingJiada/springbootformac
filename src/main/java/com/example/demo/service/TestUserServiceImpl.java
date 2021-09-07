package com.example.demo.service;

import com.example.demo.dao.TestUserDao;
import com.example.demo.entity.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestUserServiceImpl implements TestUserService {

    @Resource
    private TestUserDao testUserDao;

    @Override
    public List<TestUser> getUser() {
       return testUserDao.getUser();
    }

    @Override
    public void addUser(TestUser user) {
        testUserDao.addUser(user);
    }

    @Override
    public void delUserByName(String name) {
        testUserDao.delUserByName(name);
    }
}

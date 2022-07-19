package com.example.demo.service;

import com.example.demo.dao.TestUserDao;
import com.example.demo.dto.TestUserDTO;
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
    public Integer addUser(TestUserDTO testUserDTO) {
        TestUser user = new TestUser();
        user.setName(testUserDTO.getName());
        user.setAge(testUserDTO.getAge());
        user.setPwd(testUserDTO.getPwd());
        user.setMoney(testUserDTO.getMoney());
        user.setRemake(testUserDTO.getRemake());
       return testUserDao.addUser(user);
    }

    @Override
    public void delUserByName(String name) {
        testUserDao.delUserByName(name);
    }
}

package com.example.demo.controller;

import com.example.demo.dto.TestUserDTO;
import com.example.demo.entity.TestUser;
import com.example.demo.service.TestUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HomeController {

    @Resource
    private TestUserService testUserService;

    @RequestMapping("/getUsers")
    public List<TestUser> helloWorld() {
        return testUserService.getUser();
    }

    @RequestMapping("/streamUsers")
    public List<TestUser> streamList() {
        List<TestUser> users = testUserService.getUser();

        return users.stream().peek(o -> {
            o.setId(-1);//隐藏id
        }).collect(Collectors.toList());

    }

    @RequestMapping("/home")
    public String home() {
        return "Hello world";
    }

    @Transactional
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody TestUserDTO testUserDTO) {
        try {

            System.out.println("user.name  = " + testUserDTO.getName());

            Integer result = testUserService.addUser(testUserDTO);
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    @RequestMapping("/delUser/{user.name}")
    public void delUserByName(@PathVariable("user.name") String name) {
        try {

            System.out.println("user.name  = " + name);

            testUserService.delUserByName(name);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }
}

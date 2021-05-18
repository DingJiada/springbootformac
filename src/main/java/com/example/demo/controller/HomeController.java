package com.example.demo.controller;

import com.example.demo.entity.TestUser;
import com.example.demo.service.TestUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
public class HomeController {

    @Resource
    private TestUserService testUserService;

    @RequestMapping("/getUsers")
    public List<TestUser> helloWorld() {
        return testUserService.getUser();
    }

    @RequestMapping("/home")
    public String home() {
        return "Hello world";
    }

    @Transactional
    @RequestMapping("/addUser/{user.name}/{user.age}/{user.pwd}/{user.money}/{user.remake}")
    public void addUser(@PathVariable("user.name") String name,
                       @PathVariable("user.age") Integer age,
                       @PathVariable("user.pwd") String pwd,
                       @PathVariable("user.money") Double money,
                       @PathVariable("user.remake") String remake
                      ) {
        try {

            System.out.println("user.name  = " + name);

            TestUser user = new TestUser();
            user.setName(name);
            user.setAge(age);
            user.setPwd(pwd);
            user.setMoney(money);
            user.setRemake(remake);

            testUserService.addUser(user);

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

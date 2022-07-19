package com.example.demo.dao;

import com.example.demo.entity.TestUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestUserDao {

    @Select("select * from test_user")
    List<TestUser> getUser();

    @Insert({
            "insert into test_user(name,pwd,age,money,remake) " +
            "values(#{name},#{pwd},#{age},#{money},#{remake});"
    })
    Integer addUser(TestUser user);

    @Update({
            "update test_user set "
    })
    Integer changeUser(Integer id);

    @Delete({
          "delete from test_user where id = #{id}"
    })
    Integer delUser(Integer id);

    @Delete({
            "delete from test_user where name = #{name}"
    })
    Integer delUserByName(String name);
}

package org.mirom.examples.dao.impl;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.mirom.examples.dao.UserDAO;
import org.mirom.examples.mappers.UserMapper;
import org.mirom.examples.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOImpl implements UserDAO {
    private DataSource dataSource;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private UserMapper userMapper;

    public List<User> readUsers() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from USER");
        System.out.println("We've obtained collection");
        System.out.println(list);
        List<User> userList = userMapper.getUsers(list);
        return userList;
    }


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

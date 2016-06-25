package org.mirom.examples.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mirom.examples.model.User;

public class UserMapper implements org.springframework.jdbc.core.RowMapper<User>{


    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("ID"));
        user.setName(resultSet.getString("NAME"));
        return user;
    }

    public List<User> getUsers(List<Map<String, Object>> list) {
        List<User> userList = new ArrayList<User>();
        for (Map<String, Object> map : list) {
            User user = new User();
            user.setId((Integer) map.get("ID"));
            user.setName((String) map.get("Name"));
            userList.add(user);
        }
        return userList;
    }

}

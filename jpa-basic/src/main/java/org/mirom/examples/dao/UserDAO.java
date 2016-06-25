package org.mirom.examples.dao;

import java.util.List;
import javax.sql.DataSource;

import org.mirom.examples.mappers.UserMapper;
import org.mirom.examples.model.User;

/**
 * Created by mirom on 6/25/16.
 */
public interface UserDAO {
    void setUserMapper(UserMapper userMapper);

    List<User> readUsers();

    void setDataSource(DataSource dataSource);
}

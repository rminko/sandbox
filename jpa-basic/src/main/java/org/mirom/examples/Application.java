package org.mirom.examples;

import java.util.List;

import org.mirom.examples.dao.UserDAO;
import org.mirom.examples.dao.impl.UserDAOImpl;
import org.mirom.examples.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        EmbeddedDatabase db = builder.setType(H2).addScript("create-db.sql").addScript("insert-data.sql").build();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserDAO runner = (UserDAOImpl) applicationContext.getBean("UserDAO");
        List<User> userList = runner.readUsers();
        System.out.println(userList.size());
    }
}

package pl.arturzgodka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.arturzgodka.databaseutils.UserDao;
import pl.arturzgodka.datamodel.User;

@SpringBootApplication
public class Diablo3CompediumApplication {

    public static void main(String[] args) {
        SpringApplication.run(Diablo3CompediumApplication.class, args);

        User user1 = new User();
        UserDao userDao = new UserDao();

        userDao.saveUser(user1);

    }

}

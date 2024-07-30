package pl.arturzgodka.databaseutils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserSessionFactoryTest {
    public static SessionFactory getCustomUserSessionFactoryTest(int port) { //domyslny port 5432
        Configuration config = new Configuration();
        config.configure("static/hibernate.cfg.xml");
        config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:" + port + "/postgres?loggerLevel=OFF"); //po porcie podac nazwe bazy danych. Jesli taka baza nie istnieje to wyrzuca blad.
        return config.buildSessionFactory();
    }
}

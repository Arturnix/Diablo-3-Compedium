package pl.arturzgodka.databaseutils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserSessionFactory { //klasa zawiera narzedzia do komunikacji z baza danych
    public static SessionFactory getCustomUserSessionFactory() {
        Configuration config = new Configuration();
        config.configure("static/hibernate.cfg.xml"); //plik w ktorym konfiguruje hibernate
        return config.buildSessionFactory();
    }

    //dodac metode z konfiguracja tylko do testow - docker
    //lub stworzyc klase, ktora bedzie tworzyc ta klase tylko w czesci testowej i hibernate config file bedzie tylko w tej czesci testowej, oddzielony od czesci prod.
    //session factory zrobic w katalogu testowym

}

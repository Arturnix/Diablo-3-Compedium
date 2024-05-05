package pl.arturzgodka.databaseutils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.arturzgodka.datamodel.CharacterDataModel;
import pl.arturzgodka.datamodel.UserDataModel;

public class CharacterDao {

    private final SessionFactory sessionFactory = UserSessionFactory.getCustomUserSessionFactory();
    public void saveCharacter(CharacterDataModel characterDataModel) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.merge(characterDataModel);
        t.commit();
        session.close();
    }
}

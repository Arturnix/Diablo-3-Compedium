package pl.arturzgodka.databaseutils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.arturzgodka.datamodel.CharacterDataModel;
import pl.arturzgodka.datamodel.FollowerDataModel;

import java.util.List;

public class FollowerDao {

    private static final SessionFactory sessionFactory = UserSessionFactory.getCustomUserSessionFactory();

    public static void saveFollower(FollowerDataModel followerDataModel) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.merge(followerDataModel);
        t.commit();
        session.close();
    }
}

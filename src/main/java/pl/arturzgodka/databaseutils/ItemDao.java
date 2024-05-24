package pl.arturzgodka.databaseutils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.arturzgodka.datamodel.ItemDataModel;

public class ItemDao {

    private static final SessionFactory sessionFactory = UserSessionFactory.getCustomUserSessionFactory();

    public static void saveItem(ItemDataModel itemDataModel) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.merge(itemDataModel);
        t.commit();
        session.close();
    }
}

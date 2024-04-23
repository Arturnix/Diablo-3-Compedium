package pl.arturzgodka.databaseutils;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.arturzgodka.datamodel.User;

public class UserDao {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //lib spring zawarta w security
    private final SessionFactory sessionFactory = UserSessionFactory.getCustomUserSessionFactory(); //zasob statyczny

    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        user.setPassword(passwordEncoder.encode(user.getPassword())); //aby nie trzymac hasel jako plain text w bazie danych.
        session.merge(user);
        t.commit();
        session.close();
    }

    public void deleteUser(User user) { //instancja zalogowanego uzytkownika aby tylko on sam mogl wykonac operacje usuniecia konta, na ktore jest zalogowany.
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(user);
        transaction.commit();
        session.close();
    }

    public void deleteUser(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> userQuery = cb.createQuery(User.class);
        Root<User> root = userQuery.from(User.class);
        userQuery.select(root).where(cb.equal(root.get("id"), id));
        session.remove(session.createQuery(userQuery).getSingleResult());
        transaction.commit();
        session.close();
    }

    private boolean userExists(User user) {
        return findUserByEmail(user.getEmail()) != null;
    }

    public User findUserByEmail(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder(); //klasa ktora przechwuje kryteria do query
        CriteriaQuery<User> userQuery = cb.createQuery(User.class);
        Root<User> root = userQuery.from(User.class);
        userQuery.select(root).where(cb.equal(root.get("email"), email)); //tworze query. Tlumaczenie sql na jazyk javowy
        User user = session.createQuery(userQuery).getSingleResultOrNull(); //tworze tymczasowego usera aby moc go w razie potrzeby degubowac.
        return user;
    }

    public void changeUserBattleTag(String email, String battleTag) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User u = findUserByEmail(email);
        u.setBattleTag(battleTag);
        session.merge(u);
        transaction.commit();
        session.close();
    }
}

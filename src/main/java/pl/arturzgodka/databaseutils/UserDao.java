package pl.arturzgodka.databaseutils;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.arturzgodka.datamodel.CharacterDataModel;
import pl.arturzgodka.datamodel.UserDataModel;

public class UserDao {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //lib spring zawarta w security
    private final SessionFactory sessionFactory = UserSessionFactory.getCustomUserSessionFactory(); //zasob statyczny

    public void saveUser(UserDataModel userDataModel) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        userDataModel.setPassword(passwordEncoder.encode(userDataModel.getPassword())); //aby nie trzymac hasel jako plain text w bazie danych.
        session.merge(userDataModel);
        t.commit();
        session.close();
    }

    public void deleteUser(UserDataModel userDataModel) { //instancja zalogowanego uzytkownika aby tylko on sam mogl wykonac operacje usuniecia konta, na ktore jest zalogowany.
        if(findUserByEmail(userDataModel.getEmail()) != null) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(userDataModel);
            transaction.commit();
            session.close();
        } else {
            System.out.println("User not found!");
        }
    }

    public UserDataModel findUserByEmail(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder(); //klasa ktora przechwuje kryteria do query
        CriteriaQuery<UserDataModel> userQuery = cb.createQuery(UserDataModel.class);
        Root<UserDataModel> root = userQuery.from(UserDataModel.class);
        userQuery.select(root).where(cb.equal(root.get("email"), email)); //tworze query. Tlumaczenie sql na jazyk javowy
        return session.createQuery(userQuery).getSingleResultOrNull();
    }

    public void changeUserBattleTag(String email, String battleTag) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserDataModel u = findUserByEmail(email);
        u.setBattleTag(battleTag);
        session.merge(u);
        transaction.commit();
        session.close();
    }
}

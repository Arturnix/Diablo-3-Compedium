package pl.arturzgodka.databaseutils;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.arturzgodka.datamodel.*;

import java.util.HashMap;
import java.util.List;

public class CharacterDao {

    private final SessionFactory sessionFactory = UserSessionFactory.getCustomUserSessionFactory();
    public void saveCharacter(CharacterDataModel characterDataModel) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        /*List<ItemDataModel> items = characterDataModel.getItems();
        for(ItemDataModel item : items) {
            item.setCharacterDataModel(characterDataModel);
        }*/
        session.merge(characterDataModel);
        t.commit();
        session.close();
    }

    public void deleteCharacter(CharacterDataModel characterDataModel) {
        if(findCharacterById(characterDataModel.getId()) != null) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(characterDataModel);
            transaction.commit();
            session.close();
        } else {
            System.out.println("Character not found!");
        }
    }

    public CharacterDataModel findCharacterById(int id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CharacterDataModel> userQuery = cb.createQuery(CharacterDataModel.class);
        Root<CharacterDataModel> root = userQuery.from(CharacterDataModel.class);
        userQuery.select(root).where(cb.equal(root.get("id"), id));
        return session.createQuery(userQuery).getSingleResultOrNull();
    }

    public void changeCharacterLevel(int id, int level) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CharacterDataModel ch = findCharacterById(id);
        ch.setLevel(level);
        session.merge(ch);
        transaction.commit();
        session.close();
    }

    public void changeCharacterParagonLevel(int id, int paragonlevel) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CharacterDataModel ch = findCharacterById(id);
        ch.setParagonLevel(paragonlevel);
        session.merge(ch);
        transaction.commit();
        session.close();
    }

    public void changeCharacterSeasonal(int id, boolean seasonal) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CharacterDataModel ch = findCharacterById(id);
        ch.setSeasonal(seasonal);
        session.merge(ch);
        transaction.commit();
        session.close();
    }

    public void changeCharacterDead(int id, boolean dead) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CharacterDataModel ch = findCharacterById(id);
        if(ch.isHardcore()) {
            ch.setDead(dead);
            session.merge(ch);
            transaction.commit();
            session.close();
        }
    }

    public void changeCharacterKills(int id, HashMap<String, Integer> kills) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CharacterDataModel ch = findCharacterById(id);
        ch.setKills(kills);
        session.merge(ch);
        transaction.commit();
        session.close();
    }

    public void changeCharacterSkills(int id, List<SkillDataModel> skills) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CharacterDataModel ch = findCharacterById(id);
        ch.setSkills(skills);
        session.merge(ch);
        transaction.commit();
        session.close();
    }

    public void changeCharacterItems(int id, List<ItemDataModel> items) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CharacterDataModel ch = findCharacterById(id);
        ch.setItems(items);
        session.merge(ch);
        transaction.commit();
        session.close();
    }

    public void changeCharacterFollowers(int id, List<FollowerDataModel> followers) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CharacterDataModel ch = findCharacterById(id);
        ch.setFollowers(followers);
        session.merge(ch);
        transaction.commit();
        session.close();
    }

    public void changeCharacterStats(int id, HashMap<String, Integer> stats) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CharacterDataModel ch = findCharacterById(id);
        ch.setStats(stats);
        session.merge(ch);
        transaction.commit();
        session.close();
    }

}

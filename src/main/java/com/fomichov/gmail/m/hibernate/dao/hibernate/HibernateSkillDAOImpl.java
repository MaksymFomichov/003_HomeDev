package com.fomichov.gmail.m.hibernate.dao.hibernate;

import com.fomichov.gmail.m.hibernate.dao.SkillDAO;
import com.fomichov.gmail.m.hibernate.model.Skill;
import com.fomichov.gmail.m.hibernate.work.ShowTableInConsole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class HibernateSkillDAOImpl implements SkillDAO {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void save(Skill skill) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(skill);
        transaction.commit();
        session.close();
        try {
            ShowTableInConsole.showTableSkills();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Skill skill) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(skill);
        transaction.commit();
        session.close();
        try {
            ShowTableInConsole.showTableSkills();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Skill getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Skill skill = session.get(Skill.class, id);
        session.close();
        return skill;
    }

    public void remove(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Skill skill = session.get(Skill.class, id);
        session.delete(skill);
        transaction.commit();
        session.close();
        try {
            ShowTableInConsole.showTableSkills();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Skill> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Skill ORDER BY id ASC");
        List<Skill> result = query.list();
        session.close();
        return result;
    }
}

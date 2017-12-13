package com.fomichov.gmail.m.hibernate.dao.hibernate;

import com.fomichov.gmail.m.hibernate.dao.DeveloperDAO;
import com.fomichov.gmail.m.hibernate.model.Developer;
import com.fomichov.gmail.m.hibernate.work.ShowTableInConsole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class HibernateDeveloperDAOImpl implements DeveloperDAO{

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void save(Developer developer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(developer);
        transaction.commit();
        session.close();
        try {
            ShowTableInConsole.showTableDevelopers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Developer developer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(developer);
        transaction.commit();
        session.close();
        try {
            ShowTableInConsole.showTableDevelopers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Developer getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Developer developer = session.get(Developer.class, id);
        session.close();
        return developer;
    }

    public void remove(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class, id);
        session.delete(developer);
        transaction.commit();
        session.close();
        try {
            ShowTableInConsole.showTableDevelopers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Developer> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Developer ORDER BY id ASC");
        List<Developer> result = query.list();
        session.close();
        return result;
    }
}

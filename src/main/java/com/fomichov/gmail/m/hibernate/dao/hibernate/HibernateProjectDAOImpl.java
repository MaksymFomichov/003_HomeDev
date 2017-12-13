package com.fomichov.gmail.m.hibernate.dao.hibernate;

import com.fomichov.gmail.m.hibernate.dao.ProjectDAO;
import com.fomichov.gmail.m.hibernate.model.Project;
import com.fomichov.gmail.m.hibernate.work.ShowTablesInConsole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class HibernateProjectDAOImpl implements ProjectDAO {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void save(Project project) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(project);
        transaction.commit();
        session.close();
        try {
            ShowTablesInConsole.showTableProjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Project project) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(project);
        transaction.commit();
        session.close();
        try {
            ShowTablesInConsole.showTableProjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Project getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Project project = session.get(Project.class, id);
        session.close();
        return project;
    }

    public void remove(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Project project = session.get(Project.class, id);
        session.delete(project);
        transaction.commit();
        session.close();
        try {
            ShowTablesInConsole.showTableProjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Project> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Project ORDER BY id ASC");
        List<Project> result = query.list();
        session.close();
        return result;
    }
}

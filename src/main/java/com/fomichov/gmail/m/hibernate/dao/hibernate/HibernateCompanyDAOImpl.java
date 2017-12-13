package com.fomichov.gmail.m.hibernate.dao.hibernate;

import com.fomichov.gmail.m.hibernate.dao.CompanyDAO;
import com.fomichov.gmail.m.hibernate.model.Company;
import com.fomichov.gmail.m.hibernate.work.ShowTablesInConsole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class HibernateCompanyDAOImpl implements CompanyDAO {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void save(Company company) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(company);
        transaction.commit();
        session.close();
        try {
            ShowTablesInConsole.showTableCompanies();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Company company) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(company);
        transaction.commit();
        session.close();
        try {
            ShowTablesInConsole.showTableCompanies();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Company getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Company company = session.get(Company.class, id);
        session.close();
        return company;
    }

    public void remove(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Company company = session.get(Company.class, id);
        session.delete(company);
        transaction.commit();
        session.close();
        try {
            ShowTablesInConsole.showTableCompanies();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Company> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Company ORDER BY id ASC");
        List<Company> result = query.list();
        session.close();
        return result;
    }
}

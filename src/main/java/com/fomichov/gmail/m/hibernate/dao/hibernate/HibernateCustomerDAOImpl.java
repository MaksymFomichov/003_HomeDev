package com.fomichov.gmail.m.hibernate.dao.hibernate;

import com.fomichov.gmail.m.hibernate.dao.CustomerDAO;
import com.fomichov.gmail.m.hibernate.model.Customer;
import com.fomichov.gmail.m.hibernate.work.ShowTableInConsole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class HibernateCustomerDAOImpl implements CustomerDAO {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void save(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
        try {
            ShowTableInConsole.showTableCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
        try {
            ShowTableInConsole.showTableCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    public void remove(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        transaction.commit();
        session.close();
        try {
            ShowTableInConsole.showTableCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Customer ORDER BY id ASC");
        List<Customer> result = query.list();
        session.close();
        return result;
    }
}

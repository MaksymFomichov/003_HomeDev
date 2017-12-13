package com.fomichov.gmail.m.hibernate.work;

import com.fomichov.gmail.m.hibernate.dao.hibernate.*;
import com.fomichov.gmail.m.hibernate.model.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

class CreateDataInTable {

    // создаем разработчика
    void createDeveloper() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Developer developer = new Developer();
        System.out.println("Введите имя разработчика:");
        String name = scanner.nextLine();
        System.out.println("Введите зарплату разработчика:");
        BigDecimal salary = scanner.nextBigDecimal();
        developer.setName(name);
        developer.setSalary(salary);
        new HibernateDeveloperDAOImpl().save(developer);
    }

    // создаем компанию
    void createCompany() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Company company = new Company();
        System.out.println("Введите имя компании:");
        String name = scanner.nextLine();
        company.setCompany(name);
        new HibernateCompanyDAOImpl().save(company);
    }

    // создаем заказчика
    void createCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Введите имя клиента:");
        String name = scanner.nextLine();
        customer.setCustomer(name);
        new HibernateCustomerDAOImpl().save(customer);
    }

    // создаем проект
    void createProject() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Project project = new Project();
        System.out.println("Введите название проекта:");
        String name = scanner.nextLine();
        System.out.println("Введите стоимость проекта:");
        BigDecimal cost = scanner.nextBigDecimal();
        project.setProject(name);
        project.setCost(cost);
        new HibernateProjectDAOImpl().save(project);
    }

    // создаем навык
    void createSkill() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Skill skill = new Skill();
        System.out.println("Введите навык:");
        String name = scanner.nextLine();
        skill.setSkill(name);
        new HibernateSkillDAOImpl().save(skill);
    }
}

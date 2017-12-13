package com.fomichov.gmail.m.hibernate.work;

import com.fomichov.gmail.m.hibernate.dao.hibernate.*;
import com.fomichov.gmail.m.hibernate.model.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

class MenuUpdateDataInTable {
    void updateDeveloper() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id разработчика для обновления данных:");
        long choice = scanner.nextLong();
        scanner.nextLine();
        Developer developer = new HibernateDeveloperDAOImpl().getById(choice);
        System.out.println("Введите новое имя разработчика, текущее имя " + developer.getName());
        String name = scanner.nextLine();
        System.out.println("Введите новую зарплату разработчика, текущая зарплата " + developer.getSalary());
        BigDecimal salary = scanner.nextBigDecimal();
        developer.setName(name);
        developer.setSalary(salary);
        new HibernateDeveloperDAOImpl().update(developer);
    }

    void updateCompany() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id компании для обновления данных:");
        long choice = scanner.nextLong();
        scanner.nextLine();
        Company company = new HibernateCompanyDAOImpl().getById(choice);
        System.out.println("Введите новое название компании, текущее имя " + company.getCompany());
        String companyName = scanner.nextLine();
        company.setCompany(companyName);
        new HibernateCompanyDAOImpl().update(company);
    }

    void updateCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id заказчика для обновления данных:");
        long choice = scanner.nextLong();
        scanner.nextLine();
        Customer customer = new HibernateCustomerDAOImpl().getById(choice);
        System.out.println("Введите новое имя заказчика, текущее имя " + customer.getCustomer());
        String customerName = scanner.nextLine();
        customer.setCustomer(customerName);
        new HibernateCustomerDAOImpl().update(customer);
    }

    void updateProject() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id проекта для обновления данных:");
        long choice = scanner.nextLong();
        scanner.nextLine();
        Project project = new HibernateProjectDAOImpl().getById(choice);
        System.out.println("Введите новое имя проекта, текущее имя " + project.getProject());
        String name = scanner.nextLine();
        System.out.println("Введите новую стоимость проекта, текущая стоимость " + project.getCost());
        BigDecimal cost = scanner.nextBigDecimal();
        project.setProject(name);
        project.setCost(cost);
        new HibernateProjectDAOImpl().update(project);
    }

    void updateSkill() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id навыка для обновления данных:");
        long choice = scanner.nextLong();
        scanner.nextLine();
        Skill skill = new HibernateSkillDAOImpl().getById(choice);
        System.out.println("Введите новый навык, текущий навык " + skill.getSkill());
        String skillName = scanner.nextLine();
        skill.setSkill(skillName);
        new HibernateSkillDAOImpl().update(skill);
    }
}

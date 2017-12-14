package com.fomichov.gmail.m.hibernate.work;

import com.fomichov.gmail.m.hibernate.dao.hibernate.*;
import com.fomichov.gmail.m.hibernate.model.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

class UpdateDataInTable {

    // обновляем данные по разработчику
    void updateDeveloper(List<Long> listId) throws SQLException {
        System.out.println("Введите id разработчика для обновления данных:");
        long choice = MyUtils.checkId(listId);
        Developer developer = new HibernateDeveloperDAOImpl().getById(choice);
        System.out.println("Введите новое имя разработчика, текущее имя " + developer.getName());
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Введите новую зарплату разработчика, текущая зарплата " + developer.getSalary());
        BigDecimal salary = MyUtils.checkBigDecimal();
        developer.setName(name);
        developer.setSalary(salary);
        new HibernateDeveloperDAOImpl().update(developer);
    }

    // обновляем данные по компании
    void updateCompany(List<Long> listId) throws SQLException {
        System.out.println("Введите id компании для обновления данных:");
        long choice = MyUtils.checkId(listId);
        Company company = new HibernateCompanyDAOImpl().getById(choice);
        System.out.println("Введите новое название компании, текущее имя " + company.getCompany());
        Scanner scanner = new Scanner(System.in);
        String companyName = scanner.nextLine();
        company.setCompany(companyName);
        new HibernateCompanyDAOImpl().update(company);
    }

    // обновляем данные по заказчику
    void updateCustomer(List<Long> listId) throws SQLException {
        System.out.println("Введите id заказчика для обновления данных:");
        long choice = MyUtils.checkId(listId);
        Customer customer = new HibernateCustomerDAOImpl().getById(choice);
        System.out.println("Введите новое имя заказчика, текущее имя " + customer.getCustomer());
        Scanner scanner = new Scanner(System.in);
        String customerName = scanner.nextLine();
        customer.setCustomer(customerName);
        new HibernateCustomerDAOImpl().update(customer);
    }

    // обновляем данные по проекту
    void updateProject(List<Long> listId) throws SQLException {
        System.out.println("Введите id проекта для обновления данных:");
        long choice = MyUtils.checkId(listId);
        Project project = new HibernateProjectDAOImpl().getById(choice);
        System.out.println("Введите новое имя проекта, текущее имя " + project.getProject());
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Введите новую стоимость проекта, текущая стоимость " + project.getCost());
        BigDecimal cost = MyUtils.checkBigDecimal();
        project.setProject(name);
        project.setCost(cost);
        new HibernateProjectDAOImpl().update(project);
    }

    // обновляем данные по навыку
    void updateSkill(List<Long> listId) throws SQLException {
        System.out.println("Введите id навыка для обновления данных:");
        long choice = MyUtils.checkId(listId);
        Skill skill = new HibernateSkillDAOImpl().getById(choice);
        System.out.println("Введите новый навык, текущий навык " + skill.getSkill());
        Scanner scanner = new Scanner(System.in);
        String skillName = scanner.nextLine();
        skill.setSkill(skillName);
        new HibernateSkillDAOImpl().update(skill);
    }
}

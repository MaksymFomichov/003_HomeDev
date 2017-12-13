package com.fomichov.gmail.m.hibernate.work;


import com.fomichov.gmail.m.hibernate.dao.hibernate.HibernateCompanyDAOImpl;
import com.fomichov.gmail.m.hibernate.dao.hibernate.HibernateCustomerDAOImpl;
import com.fomichov.gmail.m.hibernate.dao.hibernate.HibernateDeveloperDAOImpl;
import com.fomichov.gmail.m.hibernate.model.Company;
import com.fomichov.gmail.m.hibernate.model.Customer;
import com.fomichov.gmail.m.hibernate.model.Developer;

import java.sql.SQLException;
import java.util.Scanner;

class ExpandedShowList {

    // получаем id разработчика и показываем таблицу навыков в зависимости от выбора пользователя
    void choiceDeveloperToShowListSkills(Boolean addSkill, Boolean deleteSkill) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id разработчика:");
        Long idDeveloper = scanner.nextLong();
        Developer developer = new HibernateDeveloperDAOImpl().getById(idDeveloper);
        if (!addSkill) {
            ShowTableInConsole.showTableDevelopersSkills(developer, deleteSkill); // выводим таблицу навыков выбранного разработчика
        } else {
            ShowTableInConsole.showTableSkillsButNoChoiceDeveloper(idDeveloper); // выводим таблицу навыков без навыков выбранного разработчика
        }
    }

    // получаем id разработчика и показываем таблицу проектов в зависимости от выбора пользователя
    void choiceDeveloperToShowListProjects(Boolean addProject, Boolean deleteProject) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id разработчика:");
        Long idDeveloper = scanner.nextLong();
        Developer developer = new HibernateDeveloperDAOImpl().getById(idDeveloper);
        if (!addProject) {
            ShowTableInConsole.showTableDeveloperProjects(developer, deleteProject);
        } else {
            ShowTableInConsole.showTableProjectsButNoChoiceDeveloper(idDeveloper);
        }
    }

    // получаем id компании и показываем таблицу проектов в зависимости от выбора пользователя
    void choiceCompanyFromShowListProjects(Boolean addProject, Boolean deleteProject) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id компании:");
        Long idCompany = scanner.nextLong();
        Company company = new HibernateCompanyDAOImpl().getById(idCompany);
        if (!addProject) {
            ShowTableInConsole.showTableCompanyProjects(company, deleteProject);
        } else {
            ShowTableInConsole.showTableProjectsButNoChoiceCompany(idCompany);
        }
    }

    // получаем id зазазчика и показываем таблицу проектов в зависимости от выбора пользователя
    void choiceCustomerFromShowListProjects(Boolean addProject, Boolean deleteProject) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id заказчика:");
        Long idCustomer = scanner.nextLong();
        Customer customer = new HibernateCustomerDAOImpl().getById(idCustomer);
        if (!addProject) {
            ShowTableInConsole.showTableCustomerProjects(customer, deleteProject);
        } else {
            ShowTableInConsole.showTableProjectsButNoChoiceCustomer(idCustomer);
        }
    }
}

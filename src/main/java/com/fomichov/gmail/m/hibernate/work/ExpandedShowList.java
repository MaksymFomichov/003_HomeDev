package com.fomichov.gmail.m.hibernate.work;


import com.fomichov.gmail.m.hibernate.dao.hibernate.HibernateDeveloperDAOImpl;
import com.fomichov.gmail.m.hibernate.model.Developer;

import java.sql.SQLException;
import java.util.Scanner;

class ExpandedShowList {

    // выбираем id разработчика для которого будет показываться определенный список навыков
    void choiceDeveloperToShowListSkills(Boolean addSkill, Boolean deleteSkill) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id разработчика:");
        Long idDeveloper = scanner.nextLong();
        Developer developer = new HibernateDeveloperDAOImpl().getById(idDeveloper);
        if (!addSkill) {
            ShowTablesInConsole.showTableDevelopersSkills(developer, deleteSkill); // выводим в консоль таблицу навыков выбранного разработчика
        } else {
            ShowTablesInConsole.showTableSkillsButNoChoiceDeveloper(idDeveloper);
        }
    }

    // выбираем id разработчика для которого будет показываться определенный список проектов
    void choiceDeveloperToShowListProjects(Boolean addProject, Boolean deleteProject) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id разработчика:");
        Long idDeveloper = scanner.nextLong();
        Developer developer = new HibernateDeveloperDAOImpl().getById(idDeveloper);
        if (!addProject) {
            ShowTablesInConsole.showTableDevelopersProjects(developer, deleteProject); // выводим в консоль таблицу проектов выбранного разработчика
        } else {
            ShowTablesInConsole.showTableProjectsButNoChoiceDeveloper(idDeveloper);
        }
    }
//
//    // выбираем id компании для которой будут показаны проекты
//    void choiceCompanyFromShowListProjects() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("\nВведите id компании:");
//        Long idCompany = scanner.nextLong();
//        Company company = new JdbcCompanyDAOImpl().getById(idCompany);
//        ShowTablesInConsole.showTableCompanyProjects(company);
//    }
//
//    // выбираем id заказчика для которой будут показаны проекты
//    void choiceCustomerFromShowListProjects() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("\nВведите id заказчика:");
//        Long idCustomer = scanner.nextLong();
//        Customer customer = new JdbcCustomerDAOImpl().getById(idCustomer);
//        ShowTablesInConsole.showTableCustomerProjects(customer);
//    }
}

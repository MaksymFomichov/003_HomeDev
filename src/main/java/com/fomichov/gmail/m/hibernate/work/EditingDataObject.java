package com.fomichov.gmail.m.hibernate.work;

import com.fomichov.gmail.m.hibernate.dao.hibernate.*;
import com.fomichov.gmail.m.hibernate.model.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

class EditingDataObject {

    // добавляем навык разработчику
    static void addSkillToDeveloper(Long developerId) throws SQLException {
        System.out.println("\nВыберите id навыка для добавления его к разработчику или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        long skillId = scanner.nextLong();
        Developer developer;
        if (skillId == 0) {
            Menu.developerExpandedMenuEdit();
        } else {
            developer = new HibernateDeveloperDAOImpl().getById(developerId); // получаем разработчика для добавление ему навыка
            Skill skill = new HibernateSkillDAOImpl().getById(skillId); // получаем сам навык
            List<Skill> skills = developer.getSkillList(); // получаем все навыки разработчика
            skills.add(skill); // добавляем в список навыков новый навык
            developer.setSkillList(skills); // обновляем список разработчику
            new HibernateDeveloperDAOImpl().update(developer);  // обновляем данные в базе данных
        }
    }

    // добавляем проект разработчику
    static void addProjectToDeveloper(Long developerId) throws SQLException {
        System.out.println("\nВыберите id проекта для добавления его к разработчику или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        long projectId = scanner.nextLong();
        Developer developer;
        if (projectId == 0) {
            Menu.developerExpandedMenuEdit();
        } else {
            developer = new HibernateDeveloperDAOImpl().getById(developerId);
            Project project = new HibernateProjectDAOImpl().getById(projectId);
            List<Project> projects = developer.getProjectList();
            projects.add(project);
            developer.setProjectList(projects);
            new HibernateDeveloperDAOImpl().update(developer);
        }
    }

    // добавляем проект компании
    static void addProjectToCompany(Long companyId) throws SQLException {
        System.out.println("\nВыберите id проекта для добавления его к компании или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        long projectId = scanner.nextLong();
        Company company;
        if (projectId == 0) {
            Menu.companyExpandedMenuEdit();
        } else {
            company = new HibernateCompanyDAOImpl().getById(companyId);
            Project project = new HibernateProjectDAOImpl().getById(projectId);
            List<Project> projects = company.getProjectList();
            projects.add(project);
            company.setProjectList(projects);
            new HibernateCompanyDAOImpl().update(company);
        }
    }

    // добавляем проект заказчику
    static void addProjectToCustomer(Long customerId) throws SQLException {
        System.out.println("\nВыберите id проекта для добавления его к заказчику или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        long projectId = scanner.nextLong();
        Customer customer;
        if (projectId == 0) {
            Menu.companyExpandedMenuEdit();
        } else {
            customer = new HibernateCustomerDAOImpl().getById(customerId);
            Project project = new HibernateProjectDAOImpl().getById(projectId);
            List<Project> projects = customer.getProjectList();
            projects.add(project);
            customer.setProjectList(projects);
            new HibernateCustomerDAOImpl().update(customer);
        }
    }

    // удаляем навык у разработчика
    static void deleteSkillFromDeveloper(Long developerId) throws SQLException {
        System.out.println("\nВыберите id навыка для удаления его у разработчика или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        long skillId = scanner.nextLong();
        Developer developer;
        if (skillId == 0) {
            Menu.developerExpandedMenuEdit();
        } else {
            developer = new HibernateDeveloperDAOImpl().getById(developerId); // получаем разработчика для добавление ему навыка
            Skill skill = new HibernateSkillDAOImpl().getById(skillId); // получаем сам навык
            List<Skill> skills = developer.getSkillList(); // получаем все навыки разработчика

            for (int i = 0; i < skills.size(); i++) {
                if (skill.getId().equals(skills.get(i).getId())) {
                    skills.remove(i);
                    break;
                }
            }

            developer.setSkillList(skills); // обновляем список разработчику
            new HibernateDeveloperDAOImpl().update(developer);  // обновляем данные в базе данных
        }
    }

    // удаляем проект у разработчика
    static void deleteProjectFromDeveloper(Long developerId) throws SQLException {
        System.out.println("\nВыберите id проекта для удаления его у разработчика или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        long projectId = scanner.nextLong();
        Developer developer;
        if (projectId == 0) {
            Menu.developerExpandedMenuEdit();
        } else {
            developer = new HibernateDeveloperDAOImpl().getById(developerId);
            Project project = new HibernateProjectDAOImpl().getById(projectId);
            List<Project> projects = developer.getProjectList();

            for (int i = 0; i < projects.size(); i++) {
                if (project.getId().equals(projects.get(i).getId())) {
                    projects.remove(i);
                    break;
                }
            }

            developer.setProjectList(projects);
            new HibernateDeveloperDAOImpl().update(developer);
        }
    }

    // удаляем проект у компании
    static void deleteProjectFromCompany(Long companyId) throws SQLException {
        System.out.println("\nВыберите id проекта для удаления его у компании или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        long projectId = scanner.nextLong();
        Company company;
        if (projectId == 0) {
            Menu.companyExpandedMenuEdit();
        } else {
            company = new HibernateCompanyDAOImpl().getById(companyId);
            Project project = new HibernateProjectDAOImpl().getById(projectId);
            List<Project> projects = company.getProjectList();

            for (int i = 0; i < projects.size(); i++) {
                if (project.getId().equals(projects.get(i).getId())) {
                    projects.remove(i);
                    break;
                }
            }

            company.setProjectList(projects);
            new HibernateCompanyDAOImpl().update(company);
        }
    }

    // удаляем проект у заказчика
    static void deleteProjectFromCustomer(Long customerId) throws SQLException {
        System.out.println("\nВыберите id проекта для удаления его у заказчика или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        long projectId = scanner.nextLong();
        Customer customer;
        if (projectId == 0) {
            Menu.companyExpandedMenuEdit();
        } else {
            customer = new HibernateCustomerDAOImpl().getById(customerId);
            Project project = new HibernateProjectDAOImpl().getById(projectId);
            List<Project> projects = customer.getProjectList();

            for (int i = 0; i < projects.size(); i++) {
                if (project.getId().equals(projects.get(i).getId())) {
                    projects.remove(i);
                    break;
                }
            }

            customer.setProjectList(projects);
            new HibernateCustomerDAOImpl().update(customer);
        }
    }
}

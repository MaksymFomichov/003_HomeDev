package com.fomichov.gmail.m.hibernate.work;

import com.fomichov.gmail.m.hibernate.dao.*;
import com.fomichov.gmail.m.hibernate.dao.hibernate.*;
import com.fomichov.gmail.m.hibernate.model.*;

import java.sql.SQLException;
import java.util.List;

public class ShowTableInConsole {

    // полные таблицы базы

    // выводим в консоль таблицу Developer
    public static void showTableDevelopers() throws SQLException {
        DeveloperDAO developerDAO = new HibernateDeveloperDAOImpl();
        List<Developer> developerList = developerDAO.getAll();
        System.out.println("\nтаблица - \"developers\"");
        System.out.format("%s%10s%10s", "id", "name", "salary");
        System.out.println("\n----------------------");
        for (Developer value : developerList) {
            System.out.format("%d%10s%10s", value.getId(), value.getName(), value.getSalary());
            System.out.println();
        }
        Menu.workConsoleMenu("developers");
    }

    // выводим в консоль таблицу Skills
    public static void showTableSkills() throws SQLException {
        SkillDAO skillDAO = new HibernateSkillDAOImpl();
        List<Skill> skillList = skillDAO.getAll();
        System.out.println("\nтаблица - \"skills\"");
        System.out.format("%s%15s", "id", "skill");
        System.out.println("\n-------------------");
        for (Skill value : skillList) {
            System.out.format("%d%15s", value.getId(), value.getSkill());
            System.out.println();
        }
        Menu.workConsoleMenu("skills");
    }

    // выводим в консоль таблицу Companies
    public static void showTableCompanies() throws SQLException {
        CompanyDAO companyDAO = new HibernateCompanyDAOImpl();
        List<Company> companyList = companyDAO.getAll();
        System.out.println("\nтаблица - \"companies\"");
        System.out.format("%s%10s", "id", "company");
        System.out.println("\n--------------");
        for (Company value : companyList) {
            System.out.format("%d%10s", value.getId(), value.getCompany());
            System.out.println();
        }
        Menu.workConsoleMenu("companies");
    }

    // выводим в консоль таблицу Customers
    public static void showTableCustomers() throws SQLException {
        CustomerDAO customerDAO = new HibernateCustomerDAOImpl();
        List<Customer> customerList = customerDAO.getAll();
        System.out.println("\nтаблица - \"customers\"");
        System.out.format("%s%15s", "id", "customer");
        System.out.println("\n--------------");
        for (Customer value : customerList) {
            System.out.format("%d%15s", value.getId(), value.getCustomer());
            System.out.println();
        }
        Menu.workConsoleMenu("customers");
    }

    // выводим в консоль таблицу Projects
    public static void showTableProjects() throws SQLException {
        ProjectDAO projectDAO = new HibernateProjectDAOImpl();
        List<Project> projectList = projectDAO.getAll();
        System.out.println("\nтаблица - \"projects\"");
        System.out.format("%s%10s%15s", "id", "cost", "project");
        System.out.println("\n----------------------------");
        for (Project value : projectList) {
            System.out.format("%d%10s%15s", value.getId(), value.getCost(), value.getProject());
            System.out.println();
        }
        Menu.workConsoleMenu("projects");
    }


    // таблицы по запросам

    // выводим все навыки выбранного разработчика
    public static void showTableDevelopersSkills(Developer developer, Boolean deleteSkill) throws SQLException {
        System.out.println("\nнавыки разработчика - " + "\"" + developer.getName() + "\"");
        System.out.format("%s%10s", "id", "skill");
        System.out.println("\n-----------------");
        if (developer.getSkillList().isEmpty()) {
            System.out.println("У разработчика нет навыков");
        } else {
            for (Skill value : developer.getSkillList()) {
                System.out.format("%d%10s", value.getId(), value.getSkill());
                System.out.println();
            }
        }
        if (!deleteSkill) {
            Menu.developerExpandedMenuEdit();
        } else {
            EditingDataObject.deleteSkillFromDeveloper(developer.getId());
        }
    }

    // выводим все проекты выбранного разработчика
    static void showTableDeveloperProjects(Developer developer, Boolean deleteProject) throws SQLException {
        System.out.println("\nпроекты разработчика - " + "\"" + developer.getName() + "\"");
        System.out.format("%s%10s", "id", "project");
        System.out.println("\n-----------------");
        if (developer.getProjectList().isEmpty()) {
            System.out.println("У разработчика нет проектов");
        } else {
            for (Project value : developer.getProjectList()) {
                System.out.format("%d%10s", value.getId(), value.getProject());
                System.out.println();
            }
        }
        if (!deleteProject) {
            Menu.developerExpandedMenuEdit();
        } else {
            EditingDataObject.deleteProjectFromDeveloper(developer.getId());
        }
    }

    // выводим все проекты выбранной компании
    static void showTableCompanyProjects(Company company, Boolean deleteProject) throws SQLException {
        System.out.println("\nпроекты компании - " + "\"" + company.getCompany() + "\"");
        System.out.format("%s%10s", "id", "projects");
        System.out.println("\n-----------------");
        if (company.getProjectList().isEmpty()) {
            System.out.println("У компании нет проектов");
        } else {
            for (Project value : company.getProjectList()) {
                System.out.format("%d%10s", value.getId(), value.getProject());
                System.out.println();
            }
        }
        if (!deleteProject) {
            Menu.companyExpandedMenuEdit();
        } else {
            EditingDataObject.deleteProjectFromCompany(company.getId());
        }
    }

    // выводим все проекты выбранного заказчика
    static void showTableCustomerProjects(Customer customer, Boolean deleteProject) throws SQLException {
        System.out.println("\nпроекты заказчика - " + "\"" + customer.getCustomer() + "\"");
        System.out.format("%s%10s", "id", "projects");
        System.out.println("\n-----------------");
        if (customer.getProjectList().isEmpty()) {
            System.out.println("У заказчика нет проектов");
        } else {
            for (Project value : customer.getProjectList()) {
                System.out.format("%d%10s", value.getId(), value.getProject());
                System.out.println();
            }
        }
        if (!deleteProject) {
            Menu.customerExpandedMenuEdit();
        } else {
            EditingDataObject.deleteProjectFromCustomer(customer.getId());
        }
    }


    // таблицы с сложными запросами и внутренеей обработкой

    // выводим все навыки за исключением навыков выбранного разработчика
    static void showTableSkillsButNoChoiceDeveloper(Long developerId) throws SQLException {
        List<Skill> skillList = new HibernateSkillDAOImpl().getAll();
        List<Skill> developerSkillList = new HibernateDeveloperDAOImpl().getById(developerId).getSkillList();

        System.out.println("\nтаблица - \"skills\"");
        System.out.format("%s%15s", "id", "skill");
        System.out.println("\n-------------------");

        // чистим лист навыков от повторов с навыками разработчика
        for (int i = 0; i < developerSkillList.size(); i++) {
            for (int j = 0; j < skillList.size(); j++) {
                if (developerSkillList.get(i).getSkill().equals(skillList.get(j).getSkill())) {
                    skillList.remove(j);
                    break;
                }
            }
        }

        // выводим лист без повторов навыков которые есть у разработчика
        for (Skill value : skillList) {
            System.out.format("%d%15s", value.getId(), value.getSkill());
            System.out.println();
        }

        EditingDataObject.addSkillToDeveloper(developerId);
    }

    // выводим все проекты за исключением проектов выбранного разработчика
    static void showTableProjectsButNoChoiceDeveloper(Long developerId) throws SQLException {
        List<Project> projectList = new HibernateProjectDAOImpl().getAll();
        List<Project> developerProjectList = new HibernateDeveloperDAOImpl().getById(developerId).getProjectList();

        System.out.println("\nтаблица - \"projects\"");
        System.out.format("%s%15s", "id", "project");
        System.out.println("\n-------------------");

        // чистим лист проектов от повторов с проектами разработчика
        for (int i = 0; i < developerProjectList.size(); i++) {
            for (int j = 0; j < projectList.size(); j++) {
                if (developerProjectList.get(i).getProject().equals(projectList.get(j).getProject())) {
                    projectList.remove(j);
                    break;
                }
            }
        }

        // выводим лист без повторов проектов которые есть у разработчика
        for (Project value : projectList) {
            System.out.format("%d%15s", value.getId(), value.getProject());
            System.out.println();
        }

        EditingDataObject.addProjectToDeveloper(developerId);
    }

    // выводим все проекты за исключением проектов выбранной компании
    static void showTableProjectsButNoChoiceCompany(Long companyId) throws SQLException {
        List<Project> projectList = new HibernateProjectDAOImpl().getAll();
        List<Project> companyProjectList = new HibernateCompanyDAOImpl().getById(companyId).getProjectList();

        System.out.println("\nтаблица - \"projects\"");
        System.out.format("%s%15s", "id", "project");
        System.out.println("\n-------------------");

        // чистим лист проектов от повторов с проектами разработчика
        for (int i = 0; i < companyProjectList.size(); i++) {
            for (int j = 0; j < projectList.size(); j++) {
                if (companyProjectList.get(i).getProject().equals(projectList.get(j).getProject())) {
                    projectList.remove(j);
                    break;
                }
            }
        }

        // выводим лист без повторов проектов которые есть у разработчика
        for (Project value : projectList) {
            System.out.format("%d%15s", value.getId(), value.getProject());
            System.out.println();
        }

        EditingDataObject.addProjectToCompany(companyId);
    }

    // выводим все проекты за исключением проектов выбранного заказчика
    static void showTableProjectsButNoChoiceCustomer(Long customerId) throws SQLException {
        List<Project> projectList = new HibernateProjectDAOImpl().getAll();
        List<Project> customerProjectList = new HibernateCustomerDAOImpl().getById(customerId).getProjectList();

        System.out.println("\nтаблица - \"projects\"");
        System.out.format("%s%15s", "id", "project");
        System.out.println("\n-------------------");

        // чистим лист проектов от повторов с проектами разработчика
        for (int i = 0; i < customerProjectList.size(); i++) {
            for (int j = 0; j < projectList.size(); j++) {
                if (customerProjectList.get(i).getProject().equals(projectList.get(j).getProject())) {
                    projectList.remove(j);
                    break;
                }
            }
        }

        // выводим лист без повторов проектов которые есть у заказчика
        for (Project value : projectList) {
            System.out.format("%d%15s", value.getId(), value.getProject());
            System.out.println();
        }

        EditingDataObject.addProjectToCustomer(customerId);
    }
}

package com.fomichov.gmail.m.hibernate.work;

import java.sql.SQLException;
import java.util.List;

public class Menu {

    // стартовое меню
    public static void startConsoleMenu() throws SQLException {
        String[] listTable = {"developers", "skills", "companies", "customers", "projects"};
        System.out.println("\nВведите номер таблицы для работы с ней или 0 для выхода");
        for (int i = 0; i < listTable.length; i++) {
            System.out.println((i + 1) + " - " + listTable[i]);
        }
        int listChoice [] = {1, 2, 3, 4, 5 , 0};
        int choice = MyUtils.checkChoice(listChoice);
        switch (choice) {
            case 1:
                ShowTableInConsole.showTableDevelopers();
                break;
            case 2:
                ShowTableInConsole.showTableSkills();
                break;
            case 3:
                ShowTableInConsole.showTableCompanies();
                break;
            case 4:
                ShowTableInConsole.showTableCustomers();
                break;
            case 5:
                ShowTableInConsole.showTableProjects();
                break;
            case 0:
                System.exit(0);
        }
    }

    // меню работы с основными таблицами
    static void workConsoleMenu(String nameTable, List<Long> listId) throws SQLException {
        System.out.println("\nВыберите, что вы хотите сделать с данными или 0 для возрата в предыдущее меню");
        System.out.println("1 - создать\n2 - изменить\n3 - удалить");
        int listChoice [] = {1, 2, 3, 0};
        if (nameTable.equals("developers") || nameTable.equals("companies") || nameTable.equals("customers")) {
            System.out.println("4 - расширенное редактирование");
            listChoice = new int[]{1, 2, 3, 4, 0};
        }
        int choice = MyUtils.checkChoice(listChoice);
        switch (choice) {
            case 1:
                if (nameTable.equals("developers")) {
                    new CreateDataInTable().createDeveloper();
                } else if (nameTable.equals("companies")) {
                    new CreateDataInTable().createCompany();
                } else if (nameTable.equals("customers")) {
                    new CreateDataInTable().createCustomer();
                } else if (nameTable.equals("projects")) {
                    new CreateDataInTable().createProject();
                } else if (nameTable.equals("skills")) {
                    new CreateDataInTable().createSkill();
                }
                break;
            case 2:
                if (nameTable.equals("developers")) {
                    new UpdateDataInTable().updateDeveloper(listId);
                } else if (nameTable.equals("companies")) {
                    new UpdateDataInTable().updateCompany(listId);
                } else if (nameTable.equals("customers")) {
                    new UpdateDataInTable().updateCustomer(listId);
                } else if (nameTable.equals("projects")) {
                    new UpdateDataInTable().updateProject(listId);
                } else if (nameTable.equals("skills")) {
                    new UpdateDataInTable().updateSkill(listId);
                }
                break;
            case 3:
                if (nameTable.equals("developers")) {
                    new DeleteDataInTable().deleteDeveloper(listId);
                } else if (nameTable.equals("companies")) {
                    new DeleteDataInTable().deleteCompany(listId);
                } else if (nameTable.equals("customers")) {
                    new DeleteDataInTable().deleteCustomer(listId);
                } else if (nameTable.equals("projects")) {
                    new DeleteDataInTable().deleteProject(listId);
                } else if (nameTable.equals("skills")) {
                    new DeleteDataInTable().deleteSkill(listId);
                }
                break;
            case 4:
                if (nameTable.equals("developers")) {
                    developerExpandedMenuEdit();
                } else if (nameTable.equals("companies")) {
                    companyExpandedMenuEdit();
                } else if (nameTable.equals("customers")) {
                    customerExpandedMenuEdit();
                }
                break;
            case 0:
                startConsoleMenu();
        }
    }

    // меню работы с дополнительными возможностями редактирования для разработчиков
    static void developerExpandedMenuEdit() throws SQLException {
        System.out.println("\nВыберите, что вы хотите сделать или 0 для возрата в предыдущее меню");
        System.out.println("1 - просмотр навыков разрабочика\n2 - добавление навыка разработчику\n3 - удаления навыка у разработчика\n4 - просмотр проектов разработчика\n5 - добавления проекта разработчику\n6 - удаление проекта у разработчика");
        int listChoice [] = {1, 2, 3, 4, 5, 6, 0};
        int choice = MyUtils.checkChoice(listChoice);
        switch (choice) {
            case 1:
                new ExpandedShowList().choiceDeveloperToShowListSkills(false, false);
                break;
            case 2:
                new ExpandedShowList().choiceDeveloperToShowListSkills(true, false);
                break;
            case 3:
                new ExpandedShowList().choiceDeveloperToShowListSkills(false, true);
                break;
            case 4:
                new ExpandedShowList().choiceDeveloperToShowListProjects(false, false);
            break;
            case 5:
                new ExpandedShowList().choiceDeveloperToShowListProjects(true, false);
                break;
            case 6:
                new ExpandedShowList().choiceDeveloperToShowListProjects(false, true);
                break;
            case 0:
                ShowTableInConsole.showTableDevelopers();
        }
    }

    // меню работы с дополнительными возможностями редактирования для компании
    static void companyExpandedMenuEdit() throws SQLException {
        System.out.println("\nВыберите, что вы хотите сделать или 0 для возрата в предыдущее меню");
        System.out.println("1 - просмотр проектов компании\n2 - добавление проекта компании\n3 - удаления проекта компании");
        int listChoice [] = {1, 2, 3, 0};
        int choice = MyUtils.checkChoice(listChoice);
        switch (choice) {
            case 1:
                new ExpandedShowList().choiceCompanyFromShowListProjects(false, false);
                break;
            case 2:
                new ExpandedShowList().choiceCompanyFromShowListProjects(true, false);
                break;
            case 3:
                new ExpandedShowList().choiceCompanyFromShowListProjects(false, true);
                break;
            case 0:
                ShowTableInConsole.showTableCompanies();
        }
    }

    // меню работы с дополнительными возможностями редактирования для заказчика
    static void customerExpandedMenuEdit() throws SQLException {
        System.out.println("\nВыберите, что вы хотите сделать или 0 для возрата в предыдущее меню");
        System.out.println("1 - просмотр проектов заказчика\n2 - добавление проекта заказчику\n3 - удаления проекта у заказчика");
        int listChoice [] = {1, 2, 3, 0};
        int choice = MyUtils.checkChoice(listChoice);
        switch (choice) {
            case 1:
                new ExpandedShowList().choiceCustomerFromShowListProjects(false, false);
                break;
            case 2:
                new ExpandedShowList().choiceCustomerFromShowListProjects(true, false);
                break;
            case 3:
                new ExpandedShowList().choiceCustomerFromShowListProjects(false, true);
                break;
            case 0:
                ShowTableInConsole.showTableCustomers();
        }
    }
}

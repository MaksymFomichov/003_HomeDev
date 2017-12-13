package com.fomichov.gmail.m.hibernate.work;

import com.fomichov.gmail.m.hibernate.dao.hibernate.*;

import java.sql.SQLException;
import java.util.Scanner;

class MenuDeleteDataInTable {
    void deleteDeveloper() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id разработчика для удаления:");
        long choice = scanner.nextLong();
        new HibernateDeveloperDAOImpl().remove(choice);
    }

    void deleteCompany() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id компании для удаления:");
        long choice = scanner.nextLong();
        new HibernateCompanyDAOImpl().remove(choice);
    }

    void deleteCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id клиента для удаления:");
        long choice = scanner.nextLong();
        new HibernateCustomerDAOImpl().remove(choice);
    }

    void deleteProject() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id проекта для удаления:");
        long choice = scanner.nextLong();
        new HibernateProjectDAOImpl().remove(choice);
    }

    void deleteSkill() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id навыка для удаления:");
        long choice = scanner.nextLong();
        new HibernateSkillDAOImpl().remove(choice);
    }
}

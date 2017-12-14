package com.fomichov.gmail.m.hibernate.work;

import com.fomichov.gmail.m.hibernate.dao.hibernate.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

class DeleteDataInTable {

    // удаляем разработчика
    void deleteDeveloper(List<Long> listId) throws SQLException {
        System.out.println("Введите id разработчика для удаления:");
        long choice = MyUtils.checkId(listId);
        new HibernateDeveloperDAOImpl().remove(choice);
    }

    // удаляем компанию
    void deleteCompany(List<Long> listId) throws SQLException {
        System.out.println("Введите id компании для удаления:");
        long choice = MyUtils.checkId(listId);
        new HibernateCompanyDAOImpl().remove(choice);
    }

    // удаляем заказчика
    void deleteCustomer(List<Long> listId) throws SQLException {
        System.out.println("Введите id клиента для удаления:");
        long choice = MyUtils.checkId(listId);
        new HibernateCustomerDAOImpl().remove(choice);
    }

    // удаляем проект
    void deleteProject(List<Long> listId) throws SQLException {
        System.out.println("Введите id проекта для удаления:");
        long choice = MyUtils.checkId(listId);
        new HibernateProjectDAOImpl().remove(choice);
    }

    // удаляем навык
    void deleteSkill(List<Long> listId) throws SQLException {
        System.out.println("Введите id навыка для удаления:");
        long choice = MyUtils.checkId(listId);
        new HibernateSkillDAOImpl().remove(choice);
    }
}

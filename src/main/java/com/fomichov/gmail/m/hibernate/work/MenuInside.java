package com.fomichov.gmail.m.hibernate.work;

import com.fomichov.gmail.m.hibernate.dao.hibernate.HibernateDeveloperDAOImpl;
import com.fomichov.gmail.m.hibernate.dao.hibernate.HibernateProjectDAOImpl;
import com.fomichov.gmail.m.hibernate.dao.hibernate.HibernateSkillDAOImpl;
import com.fomichov.gmail.m.hibernate.model.Developer;
import com.fomichov.gmail.m.hibernate.model.Project;
import com.fomichov.gmail.m.hibernate.model.Skill;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

class MenuInside {

    // меню работы с дополнительными возможностями редактирования для разработчиков
    static void choiceAddSkillFromDeveloper(Long developerId) throws SQLException {
        System.out.println("\nВыберите id навыка для добавления его к разработчику или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        long skillId = scanner.nextLong();
        Developer developer = null;
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

    static void choiceDeleteSkillFromDeveloper(Long developerId) throws SQLException {
        System.out.println("\nВыберите id навыка для удаления его у разработчика или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        long skillId = scanner.nextLong();
        Developer developer = null;
        if (skillId == 0) {
            Menu.developerExpandedMenuEdit();
        } else {
            developer = new HibernateDeveloperDAOImpl().getById(developerId); // получаем разработчика для добавление ему навыка
            Skill skill = new HibernateSkillDAOImpl().getById(skillId); // получаем сам навык
            System.out.println(skill);
            List<Skill> skills = developer.getSkillList(); // получаем все навыки разработчика
            System.out.println(skills);
            skills.remove(skill); // удаляем из списка навыков выбранный навык - почемуто н работатет
            System.out.println(skills);
            developer.setSkillList(skills); // обновляем список разработчику
            new HibernateDeveloperDAOImpl().update(developer);  // обновляем данные в базе данных
        }
    }

    // меню работы с дополнительными возможностями редактирования для разработчиков
    static void choiceAddProjectFromDeveloper(Long developerId) throws SQLException {
        System.out.println("\nВыберите id проекта для добавления его к разработчику или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        long projectId = scanner.nextLong();
        Developer developer = null;
        if (projectId == 0) {
            Menu.developerExpandedMenuEdit();
        } else {
            developer = new HibernateDeveloperDAOImpl().getById(developerId); // получаем разработчика для добавление ему проекта
            Project project = new HibernateProjectDAOImpl().getById(projectId); // получаем сам проект
            List<Project> projects = developer.getProjectList(); // получаем все проекты разработчика
            projects.add(project); // добавляем в список проектов новый проект
            developer.setProjectList(projects); // обновляем список разработчику
            new HibernateDeveloperDAOImpl().update(developer);  // обновляем данные в базе данных
        }
    }

    static void choiceDeleteProjectFromDeveloper(Long developerId) throws SQLException {
        System.out.println("\nВыберите id проекта для удаления его у разработчика или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        long projectId = scanner.nextLong();
        Developer developer = null;
        if (projectId == 0) {
            Menu.developerExpandedMenuEdit();
        } else {
            developer = new HibernateDeveloperDAOImpl().getById(developerId); // получаем разработчика для добавление ему проекта
            Project project = new HibernateProjectDAOImpl().getById(projectId); // получаем сам проект
            System.out.println(project);
            List<Project> projects = developer.getProjectList(); // получаем все проекты разработчика
            System.out.println(projects);
            projects.remove(project); // удаляем из списка проектов выбранный проект - почемуто н работатет
            System.out.println(projects);
            developer.setProjectList(projects); // обновляем список разработчику
            new HibernateDeveloperDAOImpl().update(developer);  // обновляем данные в базе данных
        }
    }
}

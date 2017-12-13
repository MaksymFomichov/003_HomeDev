package com.fomichov.gmail.m;


import com.fomichov.gmail.m.hibernate.dao.DeveloperDAO;
import com.fomichov.gmail.m.hibernate.dao.hibernate.HibernateDeveloperDAOImpl;
import com.fomichov.gmail.m.hibernate.model.Developer;
import com.fomichov.gmail.m.hibernate.work.Menu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Menu.startConsoleMenu();
    }
}

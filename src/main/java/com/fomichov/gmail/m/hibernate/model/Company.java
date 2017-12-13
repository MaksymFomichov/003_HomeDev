package com.fomichov.gmail.m.hibernate.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company")
    private String company;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Project.class, cascade = {CascadeType.MERGE})
    @JoinTable(name = "companies_projects", joinColumns = @JoinColumn(name = "companies_id"), inverseJoinColumns = @JoinColumn(name = "projects_id"))
    private List<Project> projectList;

    public Company() {
    }

    public Company(Long id, String company, List<Project> projectList) {
        this.id = id;
        this.company = company;
        this.projectList = projectList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}

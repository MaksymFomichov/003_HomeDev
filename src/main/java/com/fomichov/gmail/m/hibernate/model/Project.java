package com.fomichov.gmail.m.hibernate.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "project")
    private String project;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "projectList", targetEntity = Developer.class)
    private List<Developer> developerList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "projectList", targetEntity = Company.class)
    private List<Company> companyList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "projectList", targetEntity = Customer.class)
    private List<Customer> customerList;

    public Project() {
    }

    public Project(Long id, BigDecimal cost, String project, List<Developer> developerList, List<Company> companyList, List<Customer> customerList) {
        this.id = id;
        this.cost = cost;
        this.project = project;
        this.developerList = developerList;
        this.companyList = companyList;
        this.customerList = customerList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public List<Developer> getDeveloperList() {
        return developerList;
    }

    public void setDeveloperList(List<Developer> developerList) {
        this.developerList = developerList;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}

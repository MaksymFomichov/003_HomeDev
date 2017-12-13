package com.fomichov.gmail.m.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer")
    private String customer;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Project.class, cascade = {CascadeType.MERGE})
    @JoinTable(name = "customers_projects", joinColumns = @JoinColumn(name = "customers_id"), inverseJoinColumns = @JoinColumn(name = "projects_id"))
    private List<Project> projectList;

    public Customer() {
    }

    public Customer(Long id, String customer, List<Project> projectList) {
        this.id = id;
        this.customer = customer;
        this.projectList = projectList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}

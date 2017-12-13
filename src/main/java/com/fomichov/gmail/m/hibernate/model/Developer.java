package com.fomichov.gmail.m.hibernate.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Skill.class, cascade = {CascadeType.MERGE})
    @JoinTable(name = "developers_skills", joinColumns = @JoinColumn(name = "developers_id"), inverseJoinColumns = @JoinColumn(name = "skills_id"))
    private List<Skill> skillList;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Project.class, cascade = {CascadeType.MERGE})
    @JoinTable(name = "developers_projects", joinColumns = @JoinColumn(name = "developers_id"), inverseJoinColumns = @JoinColumn(name = "projects_id"))
    private List<Project> projectList;

    public Developer() {
    }

    public Developer(Long id, String name, BigDecimal salary, List<Skill> skillList, List<Project> projectList) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.skillList = skillList;
        this.projectList = projectList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}

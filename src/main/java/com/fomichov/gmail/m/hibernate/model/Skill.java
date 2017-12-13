package com.fomichov.gmail.m.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skill")
    private String skill;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "skillList", targetEntity = Developer.class)
    private List<Developer> developerList;

    public Skill() {
    }

    public Skill(Long id, String skill, List<Developer> developerList) {
        this.id = id;
        this.skill = skill;
        this.developerList = developerList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public List<Developer> getDeveloperList() {
        return developerList;
    }

    public void setDeveloperList(List<Developer> developerList) {
        this.developerList = developerList;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                ", developerList=" + developerList +
                '}';
    }
}

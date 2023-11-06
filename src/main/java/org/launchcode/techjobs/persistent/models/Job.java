package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

@Entity
public class Job extends AbstractEntity{



    @ManyToOne
    private Employer employer;

    private String skills;


    public Job() {
    }

    public Job(Employer employer, String skills) {
        this.employer = employer;
        this.skills = skills;
    }


    // Getters and setters.

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

}

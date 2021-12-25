package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.InfectionStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@Table( name = "instructors" ) should not be used anymore (inheritance is single-tabled now)
@DiscriminatorValue("instructor")
@Getter
@Setter
public class Instructor extends User
{
    /*
    @OneToMany
    private List<Course> coursesGiven;
    */
    private String department;
    private String office;

    public Instructor(int universityID, String name, String password, String email, String hesCode, InfectionStatus infectionStatus, boolean isFullyVaccinated, String department, String office) {
        super(universityID, name, password, email, hesCode, infectionStatus, isFullyVaccinated);
        this.department = department;
        this.office = office;
    }

    public Instructor() {

    }

    public Instructor(int universityID, String email, String password) {
        super(universityID, email, password);
    }
}

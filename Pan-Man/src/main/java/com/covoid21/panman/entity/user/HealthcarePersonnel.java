package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.InfectionStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "healthcare_personnel")
@Getter
@Setter
public class HealthcarePersonnel extends User {
    private String department;
    private String office;
    private String title;

    public HealthcarePersonnel(
            int universityID,
            String userName,
            String password,
            String email,
            String hesCode,
            InfectionStatus infectionStatus,
            boolean isFullyVaccinated,
            String department,
            String office,
            String title
    ) {
        super(universityID,userName,password,email,hesCode,infectionStatus,isFullyVaccinated);
        this.department = department;
        this.office = office;
        this.title = title;
    }

    public HealthcarePersonnel() {
        super();
    }
}

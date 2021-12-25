package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.InfectionStatus;
import com.covoid21.panman.entity.appointment.HealthAppointment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@PrimaryKeyJoinColumn(name = "user_id")
//@Table(name = "healthcare_personnel")
@DiscriminatorValue("healthcare")
@Getter
@Setter
public class HealthcarePersonnel extends User {
    private String department;
    private String office;
    private String title;
    /*
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "id")
    private List<HealthAppointment> healthAppointments;
    */
    public HealthcarePersonnel(
            //int universityID,
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
        //this.healthAppointments = new ArrayList<HealthAppointment>();
    }

    public HealthcarePersonnel() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + " " + department;
    }
}

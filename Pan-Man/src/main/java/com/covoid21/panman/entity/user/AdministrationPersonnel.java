package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.InfectionStatus;
import com.covoid21.panman.entity.Notification;
import com.covoid21.panman.entity.TestEntry;
import com.covoid21.panman.entity.VaccinationEntry;
import com.covoid21.panman.entity.appointment.Appointment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Set;

@Entity
@DiscriminatorValue("administration")
@Getter
@Setter
public class AdministrationPersonnel extends User
{
    private String office;
    private String title;
    private String department;

    public AdministrationPersonnel(Long id, int universityID, String name, String password, String email, String hesCode, InfectionStatus infectionStatus, boolean isFullyVaccinated, Set<User> closeContacts, Set<Appointment> appointments, Set<Notification> notifications, Set<User> temporaryCloseContacts, Set<VaccinationEntry> vaccinationsEntries, Set<TestEntry> testEntries, boolean isEnabled, String office, String title, String department) {
        super(id, universityID, name, password, email, hesCode, infectionStatus, isFullyVaccinated, closeContacts, appointments, notifications, temporaryCloseContacts, vaccinationsEntries, testEntries, isEnabled);
        this.office = office;
        this.title = title;
        this.department = department;
    }

    public AdministrationPersonnel(int universityID, String name, String password, String email, String hesCode, InfectionStatus infectionStatus, boolean isFullyVaccinated, String office, String title, String department) {
        super(universityID, name, password, email, hesCode, infectionStatus, isFullyVaccinated);
        this.office = office;
        this.title = title;
        this.department = department;
    }

    public AdministrationPersonnel() {

    }

    public AdministrationPersonnel(int universityID, String email, String password) {
        super(universityID, email, password);
    }
}

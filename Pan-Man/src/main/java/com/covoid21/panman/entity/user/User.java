package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.InfectionStatus;
import com.covoid21.panman.entity.Notification;
import com.covoid21.panman.entity.TestEntry;
import com.covoid21.panman.entity.VaccinationEntry;
import com.covoid21.panman.entity.appointment.Appointment;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Not;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@Getter
@Setter
public abstract class User
{
    @Id
    @GeneratedValue
    private Long id;
    
    private int universityID;
    
    private String userName;
    private String password;
    private String email;
    private String hesCode;
    private InfectionStatus infectionStatus;
    private boolean isFullyVaccinated;
    
    @ManyToMany
    @JoinColumn(name = "closecontacts_id")
    private List<User> closeContacts;

    @OneToMany(mappedBy = "user") // TODO ?
    @JoinColumn(name = "appointments_id") // TODO ?
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "user")
    @JoinColumn(name = "notifications_id")
    private List<Notification> notifications;
    
    @ManyToMany
    private List<User> temporaryCloseContacts;
    
    @OneToMany
    private List<VaccinationEntry> vaccinationsEntries;
    
    @OneToMany
    private List<TestEntry> testEntries;

    public User(
            int universityID,
            String userName,
            String password,
            String email,
            String hesCode,
            InfectionStatus infectionStatus,
            boolean isFullyVaccinated
    ) {
        this.universityID = universityID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.hesCode = hesCode;
        this.infectionStatus = infectionStatus;
        this.isFullyVaccinated = isFullyVaccinated;
        this.closeContacts = new ArrayList<User>();
        this.appointments = new ArrayList<Appointment>();
        this.notifications = new ArrayList<Notification>();
        this.temporaryCloseContacts = new ArrayList<User>();
        this.vaccinationsEntries = new ArrayList<VaccinationEntry>();
        this.testEntries = new ArrayList<TestEntry>();
    }

    public User() {

    }
}

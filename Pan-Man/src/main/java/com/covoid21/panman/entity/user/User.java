package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.InfectionStatus;
import com.covoid21.panman.entity.Notification;
import com.covoid21.panman.entity.TestEntry;
import com.covoid21.panman.entity.VaccinationEntry;
import com.covoid21.panman.entity.appointment.Appointment;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type",
        discriminatorType = DiscriminatorType.STRING)
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User
{
    private boolean isEnabled;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id = 0L;

    @Column(unique = true, nullable = false, updatable = false)
    private int universityID; // acts as a secondary key

    @Column(nullable = false)
    private String name;

    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String hesCode;

    @Enumerated
    private InfectionStatus infectionStatus;

    private boolean isFullyVaccinated;

    //@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @OneToMany
    private Set<User> closeContacts;

    @OneToMany // TODO ?
    private Set<Appointment> appointments;

    //@OneToMany(mappedBy = "user")
    //@JoinColumn(name = "notifications_id")
    @OneToMany
    private Set<Notification> notifications;

    @OneToMany
    private Set<User> temporaryCloseContacts;

    @OneToMany
    @Column(nullable = true)
    private Set<VaccinationEntry> vaccinationsEntries;
    
    @OneToMany
    @Column(nullable = true)
    private Set<TestEntry> testEntries;

    @Autowired
    public User(Long id, int universityID, String name, String password, String email, String hesCode, InfectionStatus infectionStatus, boolean isFullyVaccinated, Set<User> closeContacts, Set<Appointment> appointments, Set<Notification> notifications, Set<User> temporaryCloseContacts, Set<VaccinationEntry> vaccinationsEntries, Set<TestEntry> testEntries, boolean isEnabled) {
        this.id = id;
        this.universityID = universityID;
        this.name = name;
        this.password = password;
        this.email = email;
        this.hesCode = hesCode;
        this.infectionStatus = infectionStatus;
        this.isFullyVaccinated = isFullyVaccinated;
        this.closeContacts = closeContacts;
        this.appointments = appointments;
        this.notifications = notifications;
        this.temporaryCloseContacts = temporaryCloseContacts;
        this.vaccinationsEntries = vaccinationsEntries;
        this.testEntries = testEntries;
        this.isEnabled = isEnabled;
    }

    public User(
            int universityID,
            String name,
            String password,
            String email,
            String hesCode,
            InfectionStatus infectionStatus,
            boolean isFullyVaccinated
    ) {
        this.universityID = universityID;
        this.name = name;
        this.password = password;
        this.email = email;
        this.hesCode = hesCode;
        this.infectionStatus = infectionStatus;
        this.isFullyVaccinated = isFullyVaccinated;
        this.closeContacts = new HashSet<User>();
        this.appointments = new HashSet<Appointment>();
        this.notifications = new HashSet<Notification>();
        this.temporaryCloseContacts = new HashSet<User>();
        this.vaccinationsEntries = new HashSet<VaccinationEntry>();
        this.testEntries = new HashSet<TestEntry>();
    }

    public User() {

    }

    public User(int universityID, String email, String password) {
        this.universityID = universityID;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "" + id + " " + id;
    }

    // @Override <- why does this get underlined???
    public boolean equals(User other) {
        return this.universityID == other.universityID;
    }
}

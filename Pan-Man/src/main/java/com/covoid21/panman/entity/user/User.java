package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.InfectionStatus;
import com.covoid21.panman.entity.TestEntry;
import com.covoid21.panman.entity.VaccinationEntry;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type",
        discriminatorType = DiscriminatorType.STRING)
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public abstract class User
{
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id; // university id

    /*
    @Column(unique = true, nullable = false, updatable = false)
    private int universityID;
    */

    @Column(unique = true, nullable = false)
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
    private Set<User> closeContacts = new HashSet<User>();
    /*
    @OneToMany(mappedBy = "user") // TODO ?
    //@JoinColumn(name = "appointments_id") // TODO ?
    private List<Appointment> appointments = new ArrayList<Appointment>();

    @OneToMany(mappedBy = "user")
    //@JoinColumn(name = "notifications_id")
    private List<Notification> notifications = new ArrayList<Notification>();
    */
    //@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @OneToMany
    private Set<User> temporaryCloseContacts;

    @OneToMany
    @Column(nullable = true)
    private List<VaccinationEntry> vaccinationsEntries;
    
    @OneToMany
    @Column(nullable = true)
    private List<TestEntry> testEntries;

    public User(
            Long universityID,
            String name,
            String password,
            String email,
            String hesCode,
            InfectionStatus infectionStatus,
            boolean isFullyVaccinated
    ) {
        this.id = universityID;
        //this.universityID = universityID;
        this.name = name;
        this.password = password;
        this.email = email;
        this.hesCode = hesCode;
        this.infectionStatus = infectionStatus;
        this.isFullyVaccinated = isFullyVaccinated;
        this.closeContacts = new HashSet<User>();
        //this.appointments = new ArrayList<Appointment>();
        //this.notifications = new ArrayList<Notification>();
        this.temporaryCloseContacts = new HashSet<User>();
        this.vaccinationsEntries = new ArrayList<VaccinationEntry>();
        this.testEntries = new ArrayList<TestEntry>();
    }

    public User() {
    }

    @Override
    public String toString() {
        return "" + id + " " + id;
    }
}

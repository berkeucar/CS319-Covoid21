package com.covoid21.panman.entity.user;

import com.amazonaws.services.identitymanagement.model.UserDetail;
import com.covoid21.panman.entity.InfectionStatus;
import com.covoid21.panman.entity.TestEntry;
import com.covoid21.panman.entity.VaccinationEntry;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@Getter
@Setter
public abstract class User implements UserDetails {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    
    private int universityID;

    private String userName;
    private String password;
    private String email;
    private String hesCode;
    private InfectionStatus infectionStatus;
    private boolean isFullyVaccinated;
    
    @ElementCollection
    private List<Integer> closeContactsID;
    @ElementCollection
    private List<Integer> appointmentsID;
    @ElementCollection
    private List<Integer> notificationsID;
    @ElementCollection
    private List<Integer> temporaryCloseContactsID;
    
    @OneToMany
    private List<VaccinationEntry> vaccinationsEntries;
    
    @OneToMany
    private List<TestEntry> testEntries;

    public User(int universityID, String userName, String password, String email, String hesCode, InfectionStatus infectionStatus, boolean isFullyVaccinated, List<Integer> closeContactsID, List<Integer> appointmentsID, List<Integer> notificationsID, List<Integer> temporaryCloseContactsID, List<VaccinationEntry> vaccinationsEntries, List<TestEntry> testEntries) {
        this.universityID = universityID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.hesCode = hesCode;
        this.infectionStatus = infectionStatus;
        this.isFullyVaccinated = isFullyVaccinated;
        this.closeContactsID = closeContactsID;
        this.appointmentsID = appointmentsID;
        this.notificationsID = notificationsID;
        this.temporaryCloseContactsID = temporaryCloseContactsID;
        this.vaccinationsEntries = vaccinationsEntries;
        this.testEntries = testEntries;
    }

    public User() {
        super();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.InfectionStatus;
import com.covoid21.panman.entity.TestEntry;
import com.covoid21.panman.entity.VaccinationEntry;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table( name = "users" )
@Getter
@Setter
public abstract class User
{
    @Id
    @GeneratedValue
    private int id;
    
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
}

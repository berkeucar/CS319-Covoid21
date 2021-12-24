package com.covoid21.panman.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "policies")
@Getter
@Setter
public class Policy
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = 0L;

    @Version
    private Long version;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated
    private Set<VaccinationType> acceptedVaccines;

    @Column(columnDefinition = "text")
    private String vaccinationInfo;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated
    private Set<TestType> acceptedTests;

    @Column(columnDefinition = "text")
    private String testInfo;

    @Column(columnDefinition = "text")
    private String quarantineInfo;

    private LocalTime openingHour;

    private LocalTime closingHour;

    @Autowired
    public Policy(Long id, Long version, String title, String description, Set<VaccinationType> acceptedVaccines, String vaccinationInfo, Set<TestType> acceptedTests, String testInfo, String quarantineInfo, LocalTime openingHour, LocalTime closingHour) {
        this.id = id;
        this.version = version;
        this.title = title;
        this.description = description;
        this.acceptedVaccines = acceptedVaccines;
        this.vaccinationInfo = vaccinationInfo;
        this.acceptedTests = acceptedTests;
        this.testInfo = testInfo;
        this.quarantineInfo = quarantineInfo;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    public Policy(
            String title,
            String description,
            String vaccinationInfo,
            String testInfo,
            String quarantineInfo,
            LocalTime openingHour,
            LocalTime closingHour
    )
    {
        this.title = title;
        this.description = description;
        this.vaccinationInfo = vaccinationInfo;
        this.testInfo = testInfo;
        this.quarantineInfo = quarantineInfo;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    public Policy() {

    }

    public String toString() {
        return "Policy " + id + " " + title;
    }

    public boolean equals(Policy other) {
        return id.equals(other.id);
    }
}

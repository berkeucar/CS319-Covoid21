package com.covoid21.panman.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "policies")
@Getter
@Setter
public class Policy
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    private String title;
    private String description;

    @ElementCollection
    private List<VaccinationType> acceptedVaccines = new ArrayList<VaccinationType>();
    private String vaccinationInfo;

    @ElementCollection
    private List<TestType> acceptedTests = new ArrayList<TestType>();
    private String testInfo;
    private String quarantineInfo;
    private LocalTime openingHour;
    private LocalTime closingHour;

    protected Policy() {}
    public Policy(String description, String vaccinationInfo, String testInfo, String quarantineInfo, LocalTime openingHour, LocalTime closingHour)
    {
        this.description = description;
        this.vaccinationInfo = vaccinationInfo;
        this.testInfo = testInfo;
        this.quarantineInfo = quarantineInfo;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }
}

package com.covoid21.panman.entity;

import java.time.LocalTime;
import java.util.ArrayList;


public class Policy {
    private final int id;
    private String description;
    private ArrayList<VaccinationType> acceptedVaccines = new ArrayList<VaccinationType>();
    private String vaccinationInfo;
    private ArrayList<TestType> acceptedTests = new ArrayList<TestType>();
    private String testInfo;
    private String quarantineInfo;
    private LocalTime[] workingHours = new LocalTime[2];

    public Policy(int id, String description, String vaccinationInfo, String testInfo, String quarantineInfo, LocalTime openingHour, LocalTime closingHour) {
        this.id = id;
        this.description = description;
        this.vaccinationInfo = vaccinationInfo;
        this.testInfo = testInfo;
        this.quarantineInfo = quarantineInfo;
        this.workingHours[0] = openingHour;
        this.workingHours[1] = closingHour;
    }
}

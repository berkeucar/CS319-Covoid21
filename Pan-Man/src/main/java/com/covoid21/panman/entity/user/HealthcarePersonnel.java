package com.covoid21.panman.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "healthcare_personnel")
@Getter
@Setter
public class HealthcarePersonnel extends User{
    private String department;
    private String office;
    private String title;
}

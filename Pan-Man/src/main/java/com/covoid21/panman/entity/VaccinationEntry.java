package com.covoid21.panman.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VaccinationEntry
{
    @Id
    @Autowired
    private int id;
    private VaccinationType vaccinationType;
    private String location;
}

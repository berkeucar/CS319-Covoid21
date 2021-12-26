package com.covoid21.panman.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class VaccinationEntry
{
    @Id
    @Autowired
    private Long id;

    private VaccinationType vaccinationType;
    private String location;
}

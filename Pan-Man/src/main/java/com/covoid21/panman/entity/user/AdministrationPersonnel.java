package com.covoid21.panman.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administration_personnel")
@Getter
@Setter
public class AdministrationPersonnel extends User{
    private String office;
    private String title;
    private String department;
}

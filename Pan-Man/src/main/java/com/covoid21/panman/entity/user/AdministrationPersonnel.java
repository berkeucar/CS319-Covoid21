package com.covoid21.panman.entity.user;

import javax.persistence.Entity;

@Entity
public class AdministrationPersonnel extends User
{
    private String office;
    private String title;
    private String department;
}

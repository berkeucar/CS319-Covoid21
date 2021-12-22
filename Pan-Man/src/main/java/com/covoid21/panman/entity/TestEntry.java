package com.covoid21.panman.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TestEntry
{
    @Id
    @Autowired
    private int id;
    private TestType testType;
    private Date date;
    private boolean isPositive;
}

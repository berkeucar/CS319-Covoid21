package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.Course;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends User {
    @ManyToMany
    private List<Course> coursesTaken;

    private Date entryDate;
    private String department;
    private String dormRoom;
}

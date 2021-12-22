package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.Course;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Instructor extends User
{
    @OneToMany
    private List<Course> coursesGiven;
    private String department;
    private String office;
}

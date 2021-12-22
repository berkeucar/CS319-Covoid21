package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.Course;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
public class Instructor extends User {
    @OneToMany
    private List<Course> coursesGiven;

    private String department;
    private String office;
}

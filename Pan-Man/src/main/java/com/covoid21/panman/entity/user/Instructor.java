package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.Course;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
//@Table( name = "instructors" ) should not be used anymore (inheritance is single-tabled now)
@DiscriminatorValue("instructor")
@Getter
@Setter
public class Instructor extends User
{
    @OneToMany
    private List<Course> coursesGiven;
    
    private String department;
    private String office;
}

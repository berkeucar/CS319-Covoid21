package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.Course;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "students" )
@Getter
@Setter
public class Student extends User
{
    @ManyToMany
    private List<Course> coursesTaken;
    
    private Date entryDate;
    private String department;
    private String dormRoom;
    
    public Student() {}
}

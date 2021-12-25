package com.covoid21.panman.entity.user;

import com.covoid21.panman.entity.Course;
import com.covoid21.panman.entity.InfectionStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
//@Table(name = "students")
@DiscriminatorValue("student")
@Getter
@Setter
public class Student extends User
{
    @ManyToMany
    private List<Course> coursesTaken;
    
    private Date entryDate;
    private String department;
    private String dormRoom;

    public Student(
            int universityID,
            String userName,
            String password,
            String email,
            String hesCode,
            InfectionStatus infectionStatus,
            boolean isFullyVaccinated,
            Date entryDate,
            String department,
            String dormRoom
    ) {
        super(universityID, userName, password, email, hesCode, infectionStatus, isFullyVaccinated);
        this.entryDate = entryDate;
        this.department = department;
        this.dormRoom = dormRoom;
        this.coursesTaken = new ArrayList<Course>();
    }

    public Student() {
        super();
    }

    public Student(int universityID, String email, String password) {
        super(universityID, email, password);
    }

    public String toString() {
        return "Student" + super.toString();
    }
}

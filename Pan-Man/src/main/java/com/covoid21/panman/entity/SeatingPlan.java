package com.covoid21.panman.entity;

<<<<<<< HEAD
import com.covoid21.panman.database.service.SeatingPlanService;
import com.covoid21.panman.entity.user.Student;
=======
>>>>>>> frontend
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.*;

@Entity
@Table(name = "seatingplans")
=======
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seating-plans")
>>>>>>> frontend
@Getter
@Setter
public class SeatingPlan {
    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = 0L;

    private String code;
    private int section;

    @OneToMany
    private Set<StudentCloseSeats> seating;

    @ManyToMany
    private Set<Student> studentsNearInstructor;

    public SeatingPlan() {
        this.seating = new HashSet<StudentCloseSeats>();
    }

    public SeatingPlan(String code, int section, Set<Student> students) {
        this.code = code;
        this.section = section;
        this.seating = new HashSet<StudentCloseSeats>();
        for (Student student : students) {
            seating.add(new StudentCloseSeats(code, section, student));
        }
        this.studentsNearInstructor = new HashSet<Student>();
    }

    public StudentCloseSeats getStudentCloseSeats(Student student) {
        for (StudentCloseSeats s : seating) {
            if (s.getStudent().getUniversityID() == student.getUniversityID()) {
                System.out.println(student.getUniversityID()); // TODO remove
                return s;
            }
        }
        return null;
    }

    public void setCloseSeats(Student s1, Student s2) {
        getStudentCloseSeats(s1).getCloseStudents().add(s2);
        getStudentCloseSeats(s2).getCloseStudents().add(s1);
=======
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    private int studentCount; // adjacency matrix for student

    @OneToMany
    private List<Seating> seatingPlan = new ArrayList<Seating>();

    @ElementCollection
    private List<Integer> studentsNearInstructor = new ArrayList<Integer>();

    protected SeatingPlan() {

    }

    public SeatingPlan(int studentCount) {
        this.studentCount = studentCount;
>>>>>>> frontend
    }


}

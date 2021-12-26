package com.covoid21.panman.entity;

import com.covoid21.panman.entity.user.Instructor;
import com.covoid21.panman.entity.user.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String code;
    private int section;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Student> students;
    
    @ManyToOne
    private Instructor instructor;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Student> assistants;
    
    private int quota;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    private Set<StudentCloseSeats> seatingPlan;

    @OneToMany
    private Set<Student> studentsNearInstructor;

    private double coordinateX;
    private double coordinateY;
    
    private boolean isFaceToFace;
    
    protected Course() {}

    public Course(
            String code,
            int section,
            Set<Student> students,
            Instructor instructor,
            Set<Student> assistants,
            int quota,
            double coordinateX,
            double coordinateY,
            boolean isFaceToFace
    ) {
        this.code = code;
        this.section = section;
        this.students = students;
        this.instructor = instructor;
        this.assistants = assistants;
        this.quota = quota;
        //this.seatingPlan = new SeatingPlan(code, section, students);
        this.seatingPlan = new HashSet<StudentCloseSeats>();
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.isFaceToFace = isFaceToFace;
    }

    public StudentCloseSeats getStudentCloseSeats(Student s) {
        for (StudentCloseSeats seats : seatingPlan) {
            if (seats.getStudent().getUniversityID() == s.getUniversityID()) {
                return seats;
            }
        }
        return null;
    }

    /*
    public StudentCloseSeats getStudentCloseSeats(Student student) {
        return seatingPlan.getStudentCloseSeats(student);
    }

    public void setCloseSeats(Student s1, Student s2) {
        seatingPlan.setCloseSeats(s1, s2);
    }

    public void addStudent(Student student) {
        students.add(student);
        seatingPlan.getSeating().add(new StudentCloseSeats(code, section, student));
    }
     */
}

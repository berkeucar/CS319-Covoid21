package com.covoid21.panman.entity;

import com.covoid21.panman.entity.user.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "studentcloseseats")
@Getter
@Setter
public class StudentCloseSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = 0L;

    private String code;
    private int section;

    @ManyToOne
    private Student student;

    @OneToMany
    private Set<Student> closeStudents;

    public StudentCloseSeats() {}

    public StudentCloseSeats(String code, int section, Student student) {
        this.code = code;
        this.section = section;
        this.student = student;
        this.closeStudents = new HashSet<Student>();
    }
}

package com.covoid21.panman.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seating-plans")
@Getter
@Setter
public class SeatingPlan {
    @Id
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
    }


}

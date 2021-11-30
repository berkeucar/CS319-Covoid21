package com.covoid21.panman.entity;

import java.util.ArrayList;

public class SeatingPlan {
    private int studentCount; // adjacency matrix for student
    private int[][] seating;
    private ArrayList<Integer> studentsNearInstructor = new ArrayList<Integer>();

    public SeatingPlan(int studentCount) {
        this.studentCount = studentCount;
        this.seating = new int[studentCount][studentCount];
    }
}

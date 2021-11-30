package com.covoid21.panman.entity;

import java.util.ArrayList;

public class Course {
    private final int id;
    private String code;
    private int section;
    private ArrayList<Integer> studentsID = new ArrayList<Integer>();
    private int instructorID;
    private ArrayList<Integer> assistantsID = new ArrayList<Integer>();
    private int quota;
    private int seatingPlanID;
    private double[] coordinate;
    private boolean isFaceToFace;

    public Course(int id, String code, int section, int instructorID, int quota, int seatingPlanID, double[] coordinate, boolean isFaceToFace) {
        this.id = id;
        this.code = code;
        this.section = section;
        this.instructorID = instructorID;
        this.quota = quota;
        this.seatingPlanID = seatingPlanID;
        this.coordinate = coordinate;
        this.isFaceToFace = isFaceToFace;
    }
}

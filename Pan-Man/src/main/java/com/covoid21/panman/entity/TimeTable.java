package com.covoid21.panman.entity;

import java.time.LocalTime;
import java.util.ArrayList;

public class TimeTable {
    int id;
    boolean[] daysOpen;
    int timeSlotMinute;
    LocalTime[][] openingAndClosingTime;
    ArrayList<ArrayList<Integer>> appointmentsID;

    public TimeTable(int id, boolean[] daysOpen, int timeSlotMinute, LocalTime[][] openingAndClosingTime, ArrayList<ArrayList<Integer>> appointmentsID) {
        this.id = id;
        this.daysOpen = daysOpen;
        this.timeSlotMinute = timeSlotMinute;
        this.openingAndClosingTime = openingAndClosingTime;
        this.appointmentsID = appointmentsID;
    }
}

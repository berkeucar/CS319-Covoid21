package com.covoid21.panman.entity;

import java.time.LocalTime;
import java.util.ArrayList;

public class TimeTable
{
    private int id;
    private boolean[] daysOpen = new boolean[7];
    private int timeSlotMinute;
    private LocalTime[][] openingAndClosingTime = new LocalTime[7][2];
    private ArrayList<ArrayList<Integer>> appointmentsID = new ArrayList<ArrayList<Integer>>();
    
    public TimeTable(int id, boolean[] daysOpen, int timeSlotMinute, LocalTime[][] openingAndClosingTime, ArrayList<ArrayList<Integer>> appointmentsID)
    {
        this.id = id;
        this.daysOpen = daysOpen;
        this.timeSlotMinute = timeSlotMinute;
        this.openingAndClosingTime = openingAndClosingTime;
        this.appointmentsID = appointmentsID;
    }
}

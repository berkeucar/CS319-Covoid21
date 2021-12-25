package com.covoid21.panman.manager;

import com.covoid21.panman.manager.AppointmentBehavior;

import java.time.LocalTime;

public class AppointmentManager {
    private AppointmentBehavior appointmentBehavior;

    public AppointmentManager(AppointmentBehavior appointmentBehavior) {
        this.appointmentBehavior = appointmentBehavior;
    }

    public void DisplayForm() {
        appointmentBehavior.displayForm();
    }

    public void makeAppointment(int buttonID) {

    }

    public void showTimeTable(String type) {
        appointmentBehavior.showTimeTable(type);
    }

    public void setWorkingHours(String dept, LocalTime open, LocalTime close) {
        appointmentBehavior.setWorkingHours(dept, open, close);
    }

    public void setWorkingDays(String facility, boolean[] days) {
        appointmentBehavior.setWorkingDays(facility, days);
    }

    public void setHealthCenterTimeSlotSize(String dept, LocalTime sessionTime) {

    }

    public void setFacilityTimeSlotSize(String facility, LocalTime sessionTime) {

    }

    public void processTestResult() {

    }

    public void redirectToPaymentForTest() {

    }
}

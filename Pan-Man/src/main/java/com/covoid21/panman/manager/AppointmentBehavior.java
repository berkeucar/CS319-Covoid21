package com.covoid21.panman.manager;

import java.time.LocalTime;

public interface AppointmentBehavior {
    void displayForm();
    void showTimeTable(String type);
    void setWorkingHours(String facility, LocalTime open, LocalTime close);
    void setWorkingDays(String facility, boolean[] days);
    void showAppointmentScreen();
}

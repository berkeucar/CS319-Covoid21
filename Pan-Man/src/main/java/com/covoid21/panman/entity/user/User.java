package com.covoid21.panman.entity.user;
import com.covoid21.panman.entity.InfectionStatus;
import com.covoid21.panman.entity.TestEntry;
import com.covoid21.panman.entity.VaccinationEntry;

import java.util.ArrayList;

public abstract class User {
    private int id;
    private String userName;
    private String password;
    private String email;
    private String hesCode;
    private InfectionStatus infectionStatus;
    private boolean fullyVaccinated;
    private ArrayList<Integer> closeContactsID;
    private ArrayList<Integer> appointmentsID;
    private ArrayList<Integer> notificationsID;
    private ArrayList<Integer> temporaryCloseContactsID;
    private ArrayList<VaccinationEntry> vaccinationsEntries;
    private ArrayList<TestEntry> testEntries;
}

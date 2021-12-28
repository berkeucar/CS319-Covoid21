package com.covoid21.panman.database;

import com.covoid21.panman.database.service.*;
import com.covoid21.panman.entity.*;
import com.covoid21.panman.entity.appointment.FacilityAppointment;
import com.covoid21.panman.entity.appointment.HealthAppointment;
import com.covoid21.panman.entity.appointment.TestAppointment;
import com.covoid21.panman.entity.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

/**
 * Singleton class
 */
public class DatabaseManager {
    private static DatabaseManager instance;

    // services
    @Autowired
    private AnnouncementService announcementService;

    private NotificationService notificationService;
    private PolicyService policyService;
    private AdministrationPersonnelService administrationPersonnelService;
    private HealthcarePersonnelService healthcarePersonnelService;
    private InstructorService instructorService;
    @Autowired
    private StudentService studentService;
    private FacilityAppointmentService facilityAppointmentService;
    private HealthAppointmentService healthAppointmentService;
    private TestAppointmentService testAppointmentService;
    private CourseService courseService;
    //private SeatingPlanService seatingPlanService;
    private StudentCloseSeatsService studentCloseSeatsService;


    private DatabaseManager() {
        System.out.println("DatabaseManager() constructed");
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    /**
     * Unique getter for students
     * @param universityID
     * @return
     */
    public Student getStudent(int universityID) {
        return studentService.findByUniversityID(universityID);
    }

    /**
     * Unique getter for instructors
     * @param universityID
     * @return
     */
    public Instructor getInstructor(int universityID) {
        return instructorService.findByUniversityID(universityID);
    }

    /**
     * Unique getter for healthcare personnels
     * @param universityID
     * @return
     */
    public HealthcarePersonnel getHealthcarePersonnel(int universityID) {
        return healthcarePersonnelService.findByUniversityID(universityID);
    }

    /**
     * Unique getter for administration personnels
     * @param universityID
     * @return
     */
    public AdministrationPersonnel getAdministrationPersonnel(int universityID) {
        return administrationPersonnelService.findByUniversityID(universityID);
    }

    /**
     * Unique getter for notifications
     * @param receiver
     * @param date
     * @return
     */
    public Notification getNotification(User receiver, Date date) {
        return notificationService.findByReceiverAndDate(receiver, date);
    }


    /**
     * Unique getter for announcements
     * @param date
     * @return
     */
    public Announcement getAnnouncement(Date date) {
        return announcementService.findByDate(date);
    }

    /**
     * Unique getter for courses
     * @return
     */
    public Course getCourse() {
        return null;
    }

    /**
     * Unique getter for facility appointments
     * @param universityID
     * @param date
     * @return
     */
    public FacilityAppointment getFacilityAppointment(int universityID, Date date) {
        return facilityAppointmentService.findByHostUserUniversityIDAndDate(universityID, date);
    }

    /**
     * Unique getter for health appointments
     * @param universityID
     * @param date
     * @return
     */
    public HealthAppointment getHealthAppointment(int universityID, Date date) {
        return healthAppointmentService.findByHostUserUniversityIDAndDate(universityID, date);
    }

    /**
     * Unique getter for test appointments
     * @param universityID
     * @param date
     * @return
     */
    public TestAppointment getTestAppointment(int universityID, Date date) {
        return testAppointmentService.findByHostUserUniversityIDAndDate(universityID, date);
    }


    /**
     * Unique getter for policies
     * @param title
     * @return
     */
    public Policy getPolicy(String title) {
        return policyService.findByTitle(title);
    }


    /**
     * Unique getter for seating plan
     * @param code
     * @param section
     * @return

    public SeatingPlan getSeatingPlan(String code, int section) {
        return seatingPlanService.findByCodeAndSection(code, section);
    }
    */

    /**
     * Unique getter for student close seats
     * @param code
     * @param section
     * @return
     */

    public StudentCloseSeats getStudentCloseSeats(String code, int section) {
        return studentCloseSeatsService.findByCodeAndSection(code, section);
    }

    /**
     * Setter classes for different services and their entities
     * @param entity
     */
    public void setStudent(Student entity) {
        try {
            studentService.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: Student entity not found.");
        }
    }

    public void setInstructor(Instructor entity) {
        try {
            instructorService.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: Instructor entity not found.");
        }
    }

    public void setHealthCarePersonnel(HealthcarePersonnel entity) {
        try {
            healthcarePersonnelService.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: HealthcarePersonnel entity not found.");
        }
    }

    public void setAdministrationPersonnel(AdministrationPersonnel entity) {
        try {
            administrationPersonnelService.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: AdministrationPersonnel entity not found.");
        }
    }

    public void setNotification(Notification entity) {
        try {
            notificationService.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: Notification entity not found.");
        }
    }


    public void setAnnouncement(Announcement entity) {
        try {
            announcementService.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: Announcement entity not found.");
        }
    }

    public void setCourse() {
        // TODO:
    }

    public void setFacilityAppointment(FacilityAppointment entity) {
        try {
            facilityAppointmentService.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: Announcement entity not found.");
        }
    }

    public void setHealthAppointment(HealthAppointment entity) {
        try {
            healthAppointmentService.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: HealthAppointment entity not found.");
        }
    }

    public void setTestAppointment(TestAppointment entity) {
        try {
            testAppointmentService.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: TestAppointment entity not found.");
        }
    }

    public void setPolicy(Policy entity) {
        try {
            policyService.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: Policy entity not found.");
        }
    }

    /**
    public void setSeatingPlan(SeatingPlan entity) {
        try {
            seatingPlanService.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: SeatingPlan entity not found.");
        }
    }
     */

    public void setStudentCloseSeats(StudentCloseSeats entity) {
        try {
            studentCloseSeatsService.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println("Error: StudentsCloseSeats entity not found.");
        }
    }



}

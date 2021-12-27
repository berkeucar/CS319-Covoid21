package com.covoid21.panman;

import com.covoid21.panman.database.service.*;
import com.covoid21.panman.entity.Course;
import com.covoid21.panman.entity.user.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityExistsException;
import java.util.HashSet;

@SpringBootApplication
@EnableJpaRepositories( {"com.covoid21.panman.database.repository", "com.covoid21.panman.registration"} )
@EntityScan( {"com.covoid21.panman.entity", "com.covoid21.panman.registration" } )
public class PanmanApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(PanmanApplication.class, args);
    }
    
    @Bean
    CommandLineRunner commandLineRunner(
            //RegistrationService rs,
            HealthcarePersonnelService hps,
            StudentService ss,
            HealthAppointmentService has,
            TestAppointmentService tas,
            FacilityAppointmentService fas,
            PolicyService ps,
            AnnouncementService as,
            NotificationService ns,
            StudentCloseSeatsService scss,
            //SeatingPlanService sps,
            CourseService cs,
            InstructorService is
    )
    {
        return args ->
        {
            /*
            // policy
            Policy policy = new Policy(
                    "Bilkent Policies",
                    "This paragraph contains some random information about Bilkent policies",
                    "Köpekler ve aşısızlar giremez",
                    "Diagnovir moruq, bi de aşı olmayayım dersen 60 lira kilitleriz",
                    "Final haftasında korona kaparsanız FZ",
                    LocalTime.of(9, 0, 0),
                    LocalTime.of(18, 30, 0)
            );

            try {
                ps.save(policy);
            } catch (EntityExistsException e) {
                System.out.println("policy already exists");
            }

            // student/user
            Student student = new Student(
                    21902222,
                    "Berke Uçar",
                    "sirke",
                    "berke.ucar@ug.bilkent.edu.tr",
                    "berkeninhesi",
                    InfectionStatus.HEALTHY,
                    true,
                    new Date(1019, 8, 30),
                    "Computer Science",
                    "82-842"
            );

            try {
                ss.save(student);
            } catch (EntityExistsException e) {
                System.out.println("student already exists");
            }

            student = new Student(
                    21901815,
                    "Kutay Demiray",
                    "123",
                    "kutay.demiray@ug.bilkent.edu.tr",
                    "kutayinhesi",
                    InfectionStatus.HEALTHY,
                    true,
                    new Date(1019, 8, 30),
                    "Computer Science",
                    "82-736"
            );

            try {
                ss.save(student);
            } catch (EntityExistsException e) {
                System.out.println("student already exists");
            }
            student = new Student(
                    21900000,
                    "Yağız Yaşar",
                    "123",
                    "yy@ug.bilkent.edu.tr",
                    "yagizinhesi",
                    InfectionStatus.HEALTHY,
                    true,
                    new Date(1019, 8, 30),
                    "Computer Science",
                    "82-736"
            );
            try {
                ss.save(student);
            } catch (EntityExistsException e) {
                System.out.println("student already exists");
            }

            Instructor instructor = new Instructor(
                    152535,
                    "Eray Tüzün",
                    "erayt",
                    "tuzun@bilkent.edu.tr",
                    "erayhocaninheskodu",
                    InfectionStatus.HEALTHY,
                    true,
                    "Computer Science",
                    "EA-420"
            );

            try {
                is.save(instructor);
            } catch (EntityExistsException e) {
                System.out.println("instructor already exists");
            }

            // policy
            policy = ps.findByTitle("Bilkent Policies");
            System.out.println(policy);
            policy.getAcceptedTests().add(TestType.DIAGNOVIR);
            policy.getAcceptedVaccines().add(VaccinationType.BIONTECH);
            policy.setDescription("değişik description");
            ps.update(policy);
            policy = ps.findByTitle("Bilkent Policies");
            System.out.println(policy);

            student = ss.findByUniversityID(21901815);
            System.out.println(student);
            student.setInfectionStatus(InfectionStatus.CONTACTED);
            student.setEntryDate(new Date(119, 8, 29));
            ss.update(student);
            student = ss.findByUniversityID(21902222);
            student.setEntryDate(new Date(119, 8, 30));
            ss.update(student);
            System.out.println(ss.findByEmail("kutay.demiray@ug.bilkent.edu.tr"));

            // appointments
            TestAppointment appointment = new TestAppointment(
                    new Date(121, 12, 27, 13, 0, 0),
                    ss.findByUniversityID(21901815),
                    "Diagnovir test appointment",
                    TestType.DIAGNOVIR
            );

            try {
                tas.save(appointment);
            } catch (EntityExistsException e) {
                System.out.println("test appointment already exists");
            }

            appointment = tas.findByHostUserUniversityIDAndDate(
                    21901815,
                    new Date(121, 12, 27, 13, 0, 0));
            appointment.setTestType(TestType.PCR);
            tas.update(appointment);

            FacilityAppointment facilityAppointment = new FacilityAppointment(
                    new Date(121, 12, 27, 13, 0, 0), ss.findByUniversityID(21901815)
                    , "Gym Appointment", "gym"
            );

            try {
                fas.save(facilityAppointment);
            } catch (EntityExistsException e) {
                System.out.println("Facility appointment already exists");
            }
            ;

            HealthcarePersonnel healthcarePersonnel = new HealthcarePersonnel(
                    1234, "orthoDoc", "password", "orthodoc@gmail.com",
                    "0192341812", InfectionStatus.HEALTHY, true,
                    "ortho", "HC-103", "head doc"
            );

            try {
                hps.save(healthcarePersonnel);
            } catch (EntityExistsException e) {
                System.out.println("Healthcare personnel already exists");
            }
            ;

            HealthAppointment healthAppointment = new HealthAppointment(
                    new Date(121, 12, 27, 13, 0, 0),
                    ss.findByUniversityID(21901815),
                    "Orthopedics Appointment, Broken Fibia",
                    "Orthopedics",
                    hps.findByUniversityID(1234)
            );

            try {
                has.save(healthAppointment);
            } catch (EntityExistsException e) {
                System.out.println("Health appointment already exists");
            }
            ;

            // announcement
            Announcement announcement = new Announcement(
                    "Umarım 2022 daha güzel geçer",
                    new Date(121, 12, 31),
                    ss.findByUniversityID(21901815)
            );

            try {
                as.save(announcement);
            } catch (EntityExistsException e) {
                System.out.println("announcement already exists");
            }

            announcement = as.findByDate(new Date(121, 12, 31));
            announcement.setMessage("Mutlu yıllar falan");
            as.update(announcement);

            // notification
            Date date = new Date(121, 12, 26, 13, 52);
            Notification notification = new Notification(
                    date,
                    NotificationType.CONTACT_INFECTION_ALERT,
                    ss.findByUniversityID(21901815),
                    "oda arkadaşın hastalanmış kib aeo"
            );

            try {
                ns.save(notification);
            } catch (EntityExistsException e) {
                System.out.println("notification already exists");
            }

            notification = ns.findByReceiverAndDate(ss.findByUniversityID(21901815), date);
            notification.setMessage("oda arkadaşın hastalanmış ama yeniden");
            ns.update(notification);
            */
            // course
            Course course = new Course(
                    "CS319",
                    3,
                    new HashSet<Student>(),
                    is.findByUniversityID(12),
                    new HashSet<Student>(),
                    60,
                    13.315,
                    36.363153,
                    true
            );

            try {
                course = cs.save(course);
                System.out.println("saved course");
            } catch (EntityExistsException e) {
                course = cs.update(course);
                System.out.println("updated course");
            }

            Student s1 = ss.findByUniversityID(21901815);
            Student s2 = ss.findByUniversityID(21902238);
            course = cs.addNewStudent(course, s1);
            course = cs.addNewStudent(course, s2);
            course = cs.addNeighbors(course, s1, s2);

            try {
                course = cs.save(course);
                System.out.println("saved course");
            } catch (EntityExistsException e) {
                course = cs.update(course);
                System.out.println("updated course");
            }
            System.out.println("over");
        };
    }
}

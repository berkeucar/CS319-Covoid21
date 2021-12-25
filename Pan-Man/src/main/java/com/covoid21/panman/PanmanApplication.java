package com.covoid21.panman;

import com.covoid21.panman.database.service.*;
import com.covoid21.panman.entity.*;

import com.covoid21.panman.entity.appointment.TestAppointment;
import com.covoid21.panman.entity.user.Student;
import com.covoid21.panman.entity.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityExistsException;
import java.time.LocalTime;
import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories( "com.covoid21.panman.database.repository" )
@EntityScan( "com.covoid21.panman.entity" )
public class PanmanApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(PanmanApplication.class, args);
    }
    
    @Bean
    CommandLineRunner commandLineRunner(
            //HealthcarePersonnelService hps,
            StudentService ss,
            //HealthAppointmentService has,
            TestAppointmentService tas,
            //FacilityAppointmentService fas,
            PolicyService ps,
            AnnouncementService as
    )
    {
        return args ->
        {
            // policy
            Policy policy = new Policy(
                    "Bilkent Policies",
                    "This paragraph contains some random information about Bilkent policies",
                    "Köpekler ve aşısızlar giremez",
                    "Diagnovir moruq, bi de aşı olmayayım dersen 60 lira kilitleriz",
                    "Final haftasında korona kaparsanız FZ",
                    LocalTime.of(9,0, 0),
                    LocalTime.of(18,30, 0)
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

            // appointment
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
                    new Date(121, 12, 27, 13, 0 ,0));
            appointment.setDate(new Date(121, 12, 28, 9, 0, 0));
            tas.update(appointment);

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
        };
    }
}

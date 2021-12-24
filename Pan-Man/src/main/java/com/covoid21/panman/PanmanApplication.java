package com.covoid21.panman;

import com.covoid21.panman.database.service.*;
import com.covoid21.panman.entity.*;

import com.covoid21.panman.entity.user.Student;
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
            //TestAppointmentService tas,
            //FacilityAppointmentService fas,
            PolicyService ps
    )
    {
        return args ->
        {
            Policy policy = new Policy(
                    "Bilkent Policies",
                    "This paragraph contains some random information about Bilkent policies",
                    "Köpekler ve aşısızlar giremez",
                    "Diagnovir moruq, bi de aşı olmayayım dersen 60 lira kilitleriz",
                    "Final haftasında korona kaparsanız FZ",
                    LocalTime.of(9,0, 0),
                    LocalTime.of(18,30, 0)
            );

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
                ps.save(policy);
            } catch (EntityExistsException e) {
                System.out.println("policy already exists");
            }

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
            ss.update(student);
            System.out.println(ss.findByEmail("kutay.demiray@ug.bilkent.edu.tr"));
        };
    }
}

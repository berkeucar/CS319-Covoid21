package com.covoid21.panman;

import com.covoid21.panman.database.repository.HealthAppointmentRepository;
import com.covoid21.panman.database.service.*;
import com.covoid21.panman.entity.Announcement;
import com.covoid21.panman.entity.InfectionStatus;
import com.covoid21.panman.entity.Notification;
import com.covoid21.panman.entity.NotificationType;
import com.covoid21.panman.entity.appointment.FacilityAppointment;
import com.covoid21.panman.entity.appointment.HealthAppointment;
import com.covoid21.panman.entity.user.HealthcarePersonnel;
import com.covoid21.panman.entity.user.Student;
import com.covoid21.panman.entity.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
            HealthcarePersonnelService hps,
            StudentService ss,
            HealthAppointmentService has,
            TestAppointmentService tas,
            FacilityAppointmentService fas
    )
    {
        return args ->
        {
            /*
            Announcement announcement = new Announcement("deneme", new Date(), 123);
            Notification notification = new Notification(new Date(),
                    NotificationType.CONTACT_INFECTION_ALERT,
                    1327L,
                    "Your contact is infected birader"
                    );
            as.add(announcement);

            System.out.println(announcement);
            announcement = as.find(2L);
            System.out.println(announcement);
            */

            HealthcarePersonnel personnel = new HealthcarePersonnel(
                    21902238L,
                    "sirkeeverywhere",
                    "123",
                    "berkebjkucar@gmail.com",
                    "3162",
                    InfectionStatus.HEALTHY,
                    true,
                    "Beyin Hastalıkları",
                    "sağlık merkezi z31",
                    "Uzman Dr."
            );
            System.out.println(personnel);
            if (hps.find(21902238L) == null)
                hps.save(personnel);

            personnel = hps.find(21902238L);
            System.out.println(personnel);
            HealthAppointment health = new HealthAppointment(
                    new Date(),
                    personnel,
                    "sirke uçar sağlık hizmetleri",
                    personnel.getDepartment(),
                    personnel
                    );
            has.save(health);
            HealthAppointment appointment = has.find(119L);
            System.out.println(appointment);

            Student kutay = new Student(
                21901815L,
                    "balbaros",
                    "biggesteraytfan",
                    "bal@baros.com",
                    "AS12-DAS1-FAZA-M3AZ",
                    InfectionStatus.HEALTHY,
                    true,
                    new Date(2019, 8, 29),
                    "CS",
                    "82 736 olcak inş"
            );

            Student deneme = ss.find(21901815L);
            System.out.println(deneme);

            if (ss.find(21901815L) == null)
                ss.save(kutay);

            System.out.println(ss.find(21901815L));

            FacilityAppointment facilityAppointment = new FacilityAppointment(
                    new Date(),
                    kutay,
                    "agalarla kütüp",
                    "Main Library"
            );
            facilityAppointment.getParticipants().add(personnel);
            fas.save(facilityAppointment);

            List<FacilityAppointment> appointments = fas.findByParticipantsContaining(kutay);
            System.out.println(appointments.get(0));
            //ns.add(notification);

            //List<Announcement> list = new ArrayList<Announcement>(as.findBySenderID(123L));
        };
    }
}

package com.covoid21.panman;

import com.covoid21.panman.database.repository.HealthAppointmentRepository;
import com.covoid21.panman.database.service.*;
import com.covoid21.panman.entity.Announcement;
import com.covoid21.panman.entity.Notification;
import com.covoid21.panman.entity.NotificationType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
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
    CommandLineRunner commandLineRunner(HealthAppointmentService hs,
                                        TestAppointmentService ts,
                                        FacilityAppointmentService fs
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



            //ns.add(notification);

            //List<Announcement> list = new ArrayList<Announcement>(as.findBySenderID(123L));
        };
    }
}

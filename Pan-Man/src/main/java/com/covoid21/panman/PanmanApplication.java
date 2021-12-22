package com.covoid21.panman;

import com.covoid21.panman.database.repository.AnnouncementRepository;
import com.covoid21.panman.database.service.AnnouncementService;
import com.covoid21.panman.entity.Announcement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@SpringBootApplication
//@ComponentScan("com.covoid21.panman")
@EnableJpaRepositories("com.covoid21.panman.database.repository")
@EntityScan("com.covoid21.panman.entity")
public class PanmanApplication {

    //private static final Logger log = LoggerFactory.getLogger(PanmanApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PanmanApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AnnouncementService as) {
        return args -> {
            Announcement announcement = new Announcement("deneme", new Date(), 123);
            //announcement.setId(1L);
            as.add(announcement);
            System.out.println(announcement);
            announcement = as.find(2L);
            System.out.println(announcement);
        };
    }

}

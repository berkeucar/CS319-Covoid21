package com.covoid21.panman;

import com.covoid21.panman.database.repository.AnnouncementRepository;
import com.covoid21.panman.entity.Announcement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PanmanApplication {

    //private static final Logger log = LoggerFactory.getLogger(PanmanApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PanmanApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AnnouncementRepository announcementRepository) {
        return args -> {
            Announcement announcement = new Announcement("deneme", new Date(), 123);
            System.out.println(announcement);
            System.out.println(announcementRepository.save(announcement));
        };
    }

}

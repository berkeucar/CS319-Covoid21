package com.covoid21.panman.registration.token.service;

import com.covoid21.panman.database.service.AdministrationPersonnelService;
import com.covoid21.panman.database.service.HealthcarePersonnelService;
import com.covoid21.panman.database.service.InstructorService;
import com.covoid21.panman.database.service.StudentService;
import com.covoid21.panman.entity.user.*;
import com.covoid21.panman.registration.token.entity.ConfirmationToken;
import com.covoid21.panman.registration.token.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="confirmation_token_type",
//        discriminatorType = DiscriminatorType.STRING)
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final StudentService student;
    private final InstructorService instructor;
    private final HealthcarePersonnelService healthcare;
    private final AdministrationPersonnelService administration;

    /**
     *
     * @param confirmationToken
    */
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        String type = confirmationToken.getUserType();
        System.out.println(confirmationToken.getUserType());
        int id = confirmationToken.getUniversityID();
        System.out.println(student.findByUserUniversityID(id) != null);
        if (student.findByUserUniversityID(id) != null) {
            Student entity = student.findByUserUniversityID(id);
            try {
                student.update(entity);
            } catch (EntityNotFoundException e) {
                System.out.println("Error in registration request.");
                student.save(entity);
            }
        }
        else if (instructor.findByUserUniversityID(id) != null) {
            Instructor entity = instructor.findByUserUniversityID(id);
            try {
                instructor.update(entity);
            } catch (EntityNotFoundException e) {
                System.out.println("Error in registration request.");
                instructor.save(entity);
            }
        }
        else if (healthcare.findByUserUniversityID(id) != null) {
            HealthcarePersonnel entity = healthcare.findByUserUniversityID(id);
            try {
                healthcare.update(entity);
            } catch (EntityNotFoundException e) {
                System.out.println("Error in registration request.");
                healthcare.save(entity);
            }
        }
        else if (administration.findByUserUniversityID(id) != null) {
            AdministrationPersonnel entity = administration.findByUserUniversityID(id);
            try {
                administration.update(entity);
            } catch (EntityNotFoundException e) {
                System.out.println("Error in registration request.");
                administration.save(entity);
            }
        }
        else {
            System.out.println("Error in registration request.");
        }


        confirmationTokenRepository.save(confirmationToken);
    }

    /**
     *
     * @param token
     * @return
    */
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    /**
     *
     * @param token
     * @return
    */
    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
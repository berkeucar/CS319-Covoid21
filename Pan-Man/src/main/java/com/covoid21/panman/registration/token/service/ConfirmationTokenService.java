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
        User user = confirmationToken.getUser();
        if (user instanceof Student) {
            try {
                student.save((Student) user);
            } catch (EntityExistsException e) {
                System.out.println("Error in registration request.");
            }
        }
        else if (user instanceof Instructor) {
            try {
                instructor.save((Instructor) user);
            } catch (EntityExistsException e) {
                System.out.println("Error in registration request.");
            }
        }
        else if (user instanceof HealthcarePersonnel) {
            try {
                healthcare.save((HealthcarePersonnel) user);
            } catch (EntityExistsException e) {
                System.out.println("Error in registration request.");
            }
        }
        else if (user instanceof AdministrationPersonnel) {
            try {
                administration.save((AdministrationPersonnel) user);
            } catch (EntityExistsException e) {
                System.out.println("Error in registration request.");
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
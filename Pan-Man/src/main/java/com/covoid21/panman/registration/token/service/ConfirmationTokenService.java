package com.covoid21.panman.registration.token.service;

import com.covoid21.panman.entity.user.AdministrationPersonnel;
import com.covoid21.panman.entity.user.HealthcarePersonnel;
import com.covoid21.panman.entity.user.Instructor;
import com.covoid21.panman.entity.user.Student;
import com.covoid21.panman.registration.token.entity.ConfirmationToken;
import com.covoid21.panman.registration.token.entity.StudentConfirmationToken;
import com.covoid21.panman.registration.token.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="confirmation_token_type",
        discriminatorType = DiscriminatorType.STRING)
public class ConfirmationTokenService {
    //@Autowired
    private final ConfirmationTokenRepository confirmationTokenRepository;

    /**
     *
     * @param confirmationToken
    */
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {

        if (confirmationToken.getUser() instanceof Student) {
            try {
                studentService.save((Student) confirmationToken.getUser());
            } catch (EntityExistsException e) {
                studentService.update((Student) confirmationToken.getUser());
            }
        }
        else if (confirmationToken.getUser() instanceof Instructor) {
            try {
                instructorService.save((Instructor) confirmationToken.getUser());
            } catch (EntityExistsException e) {
                instructorService.update((Instructor) confirmationToken.getUser());
            }
        }
        else if (confirmationToken.getUser() instanceof HealthcarePersonnel) {
            try {
                healthcarePersonnelService.save((HealthcarePersonnel) confirmationToken.getUser());
            } catch (EntityExistsException e) {
                healthcarePersonnelService.update((HealthcarePersonnel) confirmationToken.getUser());
            }
        }
        else if (confirmationToken.getUser() instanceof AdministrationPersonnel) {
            try {
                administrationPersonnelService.save((AdministrationPersonnel) confirmationToken.getUser());
            } catch (EntityExistsException e) {
                administrationPersonnelService.update((AdministrationPersonnel) confirmationToken.getUser());
            }
        }


        confirmationTokenRepository.save(confirmationToken);
    }

    /**
     *
     * @param token
     * @return
    */
    public Optional<StudentConfirmationToken> getToken(String token) {
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
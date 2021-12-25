package com.covoid21.panman.registration.token.service;

import com.covoid21.panman.database.service.AdministrationPersonnelService;
import com.covoid21.panman.database.service.HealthcarePersonnelService;
import com.covoid21.panman.database.service.InstructorService;
import com.covoid21.panman.database.service.StudentService;
import com.covoid21.panman.entity.user.*;
import com.covoid21.panman.registration.token.entity.StudentConfirmationToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;
/*
@Service
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="confirmation_token_type",
        discriminatorType = DiscriminatorType.STRING)
public class ConfirmationTokenServiceBase<T extends User> {
    //@Autowired
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final StudentService studentService;
    private final InstructorService instructorService;
    private final HealthcarePersonnelService healthcarePersonnelService;
    private final AdministrationPersonnelService administrationPersonnelService;

    /**
     *
     * @param confirmationToken

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

    public Optional<StudentConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    /**
     *
     * @param token
     * @return

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
*/
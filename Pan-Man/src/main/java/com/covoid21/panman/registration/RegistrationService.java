package com.covoid21.panman.registration;

import com.covoid21.panman.database.service.UserService;
import com.covoid21.panman.email.EmailSender;
import com.covoid21.panman.entity.user.User;
import com.covoid21.panman.registration.token.ConfirmationToken;
import com.covoid21.panman.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService appUserService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("E-mail is not valid.");
        }

        String token = appUserService.signUpUser(
                new User(
                        request.getUserName(),
                        request.getEmail(),
                        request.getPassword(),
                        request.
                        )
        );

        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
        emailSender.send(
                request.getEmail(), link);

        return token;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("Token is not found."));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("E-mail is already confirmed.");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Token is expired.");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }
}
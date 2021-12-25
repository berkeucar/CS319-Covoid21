package com.covoid21.panman.registration.token.service;

import com.covoid21.panman.database.service.*;
import com.covoid21.panman.entity.user.*;
import com.covoid21.panman.registration.token.entity.ConfirmationTokenBase;
import com.covoid21.panman.registration.token.repository.ConfirmationTokenRepositoryBase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="confirmation_token_type",
        discriminatorType = DiscriminatorType.STRING)
public class ConfirmationTokenServiceBase<T extends User> {
    //@Autowired
    private final ConfirmationTokenRepositoryBase confirmationTokenRepositoryBase;
    private final UserServiceBase userServiceBase;

    /**
     *
     * @param confirmationToken
     */
    public void saveConfirmationToken(ConfirmationTokenBase confirmationToken) {

        try {
            userServiceBase.save(confirmationToken.getUser());
        } catch (EntityExistsException e) {
            userServiceBase.update(confirmationToken.getUser());
        }



        confirmationTokenRepositoryBase.save(confirmationToken);
    }

    /**
     *
     * @param token
     * @return
     */
    public Optional<ConfirmationTokenBase> getToken(String token) {
        return confirmationTokenRepositoryBase.findByToken(token);
    }

    /**
     *
     * @param token
     * @return
     */
    public int setConfirmedAt(String token) {
        return confirmationTokenRepositoryBase.updateConfirmedAt(token, LocalDateTime.now());
    }
}

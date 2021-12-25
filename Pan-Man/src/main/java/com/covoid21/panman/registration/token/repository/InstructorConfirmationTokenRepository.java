package com.covoid21.panman.registration.token.repository;

import com.covoid21.panman.registration.token.entity.InstructorConfirmationToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface InstructorConfirmationTokenRepository extends ConfirmationTokenRepositoryBase<InstructorConfirmationToken> {
    @Override
    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationTokenBase c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token, LocalDateTime confirmedAt);
}

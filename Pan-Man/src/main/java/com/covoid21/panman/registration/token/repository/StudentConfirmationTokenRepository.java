package com.covoid21.panman.registration.token.repository;

import com.covoid21.panman.entity.user.Student;
import com.covoid21.panman.registration.token.entity.ConfirmationTokenBase;
import com.covoid21.panman.registration.token.entity.StudentConfirmationToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
@Transactional(readOnly = true)
public interface StudentConfirmationTokenRepository extends ConfirmationTokenRepositoryBase<StudentConfirmationToken> {
    @Override
    @Transactional
    @Modifying
    @Query("UPDATE StudentConfirmationToken c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token, LocalDateTime confirmedAt);
}

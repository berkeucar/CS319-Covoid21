package com.covoid21.panman.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ConfirmationTokenRepositoryBase<T extends ConfirmationTokenBase> extends JpaRepository<T, Long> {

    Optional<T> findByToken(String token);
    
    /*
    @Transactional  
    @Modifying
    @Query("UPDATE ConfirmationTokenBase c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
     */
    int updateConfirmedAt(String token, LocalDateTime confirmedAt);
}

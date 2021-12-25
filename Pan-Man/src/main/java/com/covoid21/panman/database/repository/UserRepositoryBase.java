package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositoryBase<T extends User> extends CrudRepository<T, Long> {
    Optional<T> findByUniversityID(int universityID);
    boolean existsByUniversityID(int universityID);
    Optional<T> findByEmail(String email);
    List<T> findByName(String name);
    Optional<T> findByHesCode(String hesCode);
    List<T> findByCloseContactsContaining(User contact);
    List<T> findByTemporaryCloseContactsContaining(User contact);

    @Query("SELECT u FROM User u WHERE user_type = ?1 AND universityid = ?2")
    Optional<T> findByUserTypeAndUniversityID(String userType, int id);

    @Query("SELECT u FROM User u WHERE user_type = ?1")
    List<T> findByUserType(String userType);
    // TODO maybe add more queries later

    @Transactional
    @Modifying
    @Query("UPDATE User user SET user.isEnabled = TRUE WHERE user.email = ?1")
    int enableUser(String email);
}

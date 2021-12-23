package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositoryBase<T extends User> extends CrudRepository<T, Long> {
    //Optional<T> findByUniversityID(int universityID);
    Optional<T> findByEmail(String email);
    Optional<T> findByName(String name);
    Optional<T> findByHesCode(String hesCode);
    List<T> findByCloseContactsContaining(User contact);
    List<T> findByTemporaryCloseContactsContaining(User contact);
    // TODO maybe add more queries later, if needed
}

package com.covoid21.panman.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBase<T> extends CrudRepository<T, Long> {

}

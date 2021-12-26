package com.covoid21.panman.database.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Base service class for most entities
 * Provides most CRUD operations.
 */
public abstract class ServiceBase<T>
{
    protected CrudRepository<T, Long> baseRepo;

    public ServiceBase(CrudRepository<T, Long> repo) {
        this.baseRepo = repo;
    }

    public abstract T save(T entity) throws EntityExistsException;

    public abstract T update(T entity) throws EntityNotFoundException;

    public T delete(Long id)
    {
        Optional<T> entity = baseRepo.findById(id);
        
        if (!entity.isPresent())
        {
            throw new EntityNotFoundException(); // TODO make a proper error
        }
        
        baseRepo.deleteById(id);
        return entity.get();
    }
    
    public T get(Long id)
    {
        return baseRepo.findById(id).orElse(null);
    }
    
    public T find(Long id)
    {
        return baseRepo.findById(id).orElse(null);
    }
    
    public List<T> findAll()
    {
        List<T> list = new ArrayList<T>();
        baseRepo.findAll().forEach(list::add);
        return list;
    }
    
    public List<T> getAll()
    {
        List<T> list = new ArrayList<T>();
        baseRepo.findAll().forEach(list::add);
        return list;
    }
}

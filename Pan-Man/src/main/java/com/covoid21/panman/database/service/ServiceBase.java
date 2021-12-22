package com.covoid21.panman.database.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Base service class for most entities
 * Provides most CRUD operations.
 */
@Service
public abstract class ServiceBase<T>
{
    protected CrudRepository<T, Long> baseRepo;
    
    public ServiceBase() {}
    
    public T add(T entity)
    {
        return baseRepo.save(entity);
    }
    
    public T delete(Long id)
    {
        T entity = baseRepo.findById(id).orElse(null);
        
        if (entity == null)
        {
            throw new RuntimeException(); // TODO make a proper error
        }
        
        baseRepo.deleteById(id);
        return entity;
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
package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.ServiceBase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/api" )
public abstract class ControllerBase<T>
{
    protected ServiceBase<T> service;
    
    public T save(@RequestBody T entity)
    {
        return service.save(entity);
    }
    
    public T delete(@PathVariable Long id)
    {
        return service.delete(id);
    }
    
    public T get(@PathVariable Long id)
    { // TODO böyle mi emin değilim parametre annotationları
        return service.findById(id);
    }
    
    public  List<T> getAll()
    {
        return service.findAll();
    }
    
}

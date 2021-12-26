package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.ServiceBase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 * @param <T>
 */
@RestController
@RequestMapping( "/api" )
public abstract class ControllerBase<T>
{
    protected ServiceBase<T> controller;
    
    public T save(@RequestBody T entity)
    {
        return service.save(entity);
    }
    
    public T delete(@PathVariable Long id)
    {
        return controller.delete(id);
    }
    
    public T get(@PathVariable Long id)
    { 
        return service.findById(id);
    }
    
    public  List<T> getAll()
    {
        return controller.findAll();
    }
    
}

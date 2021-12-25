package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.ServiceBase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api" )
public abstract class ControllerBase<T>
{
    protected ServiceBase<T> controller;
    
    public T save(@RequestBody T entity)
    {
<<<<<<< HEAD
        return service.save(entity);
=======
        return controller.add(entity);
>>>>>>> frontend
    }
    
    public T delete(@PathVariable Long id)
    {
        return controller.delete(id);
    }
    
    public T get(@PathVariable Long id)
    { // TODO böyle mi emin değilim parametre annotationları
<<<<<<< HEAD
        return service.findById(id);
=======
        return controller.find(id);
>>>>>>> frontend
    }
    
    public List<T> getAll()
    {
        return controller.findAll();
    }
    
}

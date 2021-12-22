package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.ServiceBase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api" )
public abstract class ControllerBase<T>
{
    protected ServiceBase<T> controller;
    
    public T add(@RequestBody T entity)
    {
        return controller.add(entity);
    }
    
    public T delete(@PathVariable Long id)
    {
        return controller.delete(id);
    }
    
    public T get(@PathVariable Long id)
    { // TODO böyle mi emin değilim parametre annotationları
        return controller.find(id);
    }
    
    public List<T> getAll()
    {
        return controller.findAll();
    }
    
}

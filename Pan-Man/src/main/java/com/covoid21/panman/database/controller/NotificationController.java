package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.ServiceBase;
import com.covoid21.panman.entity.Notification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController extends ControllerBase<Notification>
{
    NotificationController(ServiceBase<Notification> controller)
    {
        this.controller = controller;
    }
    
    @Override
    @PostMapping( "/notifications" )
<<<<<<< HEAD
    public Notification save(@RequestBody Notification entity) {
        return super.save(entity);
=======
    public Notification add(@RequestBody Notification entity)
    {
        return controller.add(entity);
>>>>>>> frontend
    }
    
    @Override
    @DeleteMapping( "/notifications/{id}" )
    public Notification delete(@PathVariable Long id)
    {
        return controller.delete(id);
    }
    
    @Override
    @GetMapping( "/notifications{id}" )
    public Notification get(@PathVariable Long id)
    {
        return controller.get(id);
    }
    
    @Override
    @GetMapping( "/notifications" )
    public List<Notification> getAll()
    {
        return controller.getAll();
    }
}

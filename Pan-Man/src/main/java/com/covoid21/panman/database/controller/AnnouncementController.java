package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.ServiceBase;
import com.covoid21.panman.entity.Announcement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnnouncementController extends ControllerBase<Announcement>
{
    AnnouncementController(ServiceBase<Announcement> controller)
    {
        this.controller = controller;
    }
    
    @Override
    @PostMapping( "/announcements" )
    public Announcement save(@RequestBody Announcement entity)
    {
        return super.save(entity);
    }
    
    @Override
    @DeleteMapping( "/announcements/{id}" )
    public Announcement delete(@PathVariable Long id)
    {
        return controller.delete(id);
    }
    
    @Override
    @GetMapping( "/announcements/{id}" )
    public Announcement get(@PathVariable Long id)
    {
        return controller.get(id);
    }
    
    @Override
    @GetMapping( "/announcements" )
    public List<Announcement> getAll()
    {
        return controller.getAll();
    }
}

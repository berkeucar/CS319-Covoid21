package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.ServiceBase;
import com.covoid21.panman.entity.Announcement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/announcement")
public class AnnouncementController extends ControllerBase<Announcement>
{
<<<<<<< HEAD
    @Autowired
    private AnnouncementService announcementService;
=======
    AnnouncementController(ServiceBase<Announcement> controller)
    {
        this.controller = controller;
    }
>>>>>>> frontend
    
    @Override
    @PostMapping( "/announcements" )
    public Announcement save(@RequestBody Announcement entity)
    {
<<<<<<< HEAD
        return super.save(entity);
=======
        return controller.add(entity);
>>>>>>> frontend
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

package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.AnnouncementService;
import com.covoid21.panman.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ResponseBody
@RequestMapping(value = "/announcements")
public class AnnouncementController extends ControllerBase<Announcement>
{
    @Autowired
    private AnnouncementService announcementService;
    
    @Override
    @PostMapping
    public Announcement save(@RequestBody Announcement entity) {
        return announcementService.save(entity);
    }
    
    @Override
    @DeleteMapping( "/{id}" )
    public Announcement delete(@PathVariable Long id) {
        return announcementService.delete(id);
    }
    
    @Override
    @GetMapping( "/{id}" )
    public Announcement get(@PathVariable Long id) {
        return announcementService.findById(id);
    }
    
    @Override
    @GetMapping
    public List<Announcement> getAll() {
        return announcementService.findAll();
    }

    /*
    @PostMapping("/announcements")
    public Announcement add(@RequestBody Announcement announcement) {
        return service.add(announcement);
    }

    @DeleteMapping("/announcements/{id}")
    public Announcement delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping
    public List<Announcement> getAllAnnouncements() {
        System.out.println("AnnouncementController.getAllAnnouncements()");
        return service.getAllAnnouncements();
    }
    */
    
}

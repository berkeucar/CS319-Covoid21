package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.AnnouncementService;
import com.covoid21.panman.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/announcements")
public class AnnouncementController extends ControllerBase<Announcement> {

    private AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
        this.service = announcementService;
    }

    @Override
    @PostMapping("/announcements")
    public Announcement add(Announcement entity) {
        return super.add(entity);
    }

    @Override
    @DeleteMapping("/announcements/{id}")
    public Announcement delete(Long id) {
        return super.delete(id);
    }

    @Override
    @GetMapping("/announcements/{id}")
    public Announcement get(Long id) {
        return super.get(id);
    }

    @Override
    @GetMapping("/announcements")
    public List<Announcement> getAll() {
        return super.getAll();
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

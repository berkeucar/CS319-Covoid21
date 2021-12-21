package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.AnnouncementService;
import com.covoid21.panman.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/announcements")
public class AnnouncementController {
    @Autowired
    AnnouncementService service;

    @PostMapping("/add")
    public Announcement add(@RequestBody Announcement announcement) {
        return service.add(announcement);
    }

    @GetMapping
    public List<Announcement> getAllAnnouncements() {
        System.out.println("AnnouncementController.getAllAnnouncements()");
        return service.getAllAnnouncements();
    }


}

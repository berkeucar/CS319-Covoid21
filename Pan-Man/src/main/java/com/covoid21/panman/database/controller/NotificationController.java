package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.NotificationService;
import com.covoid21.panman.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController extends ControllerBase<Notification> {
    @Autowired
    private NotificationService notificationService;

    @Override
    @PostMapping( "/notifications" )
    public Notification add(@RequestBody Notification entity) {
        return super.add(entity);
    }

    @Override
    @DeleteMapping( "/notifications/{id}" )
    public Notification delete(@PathVariable Long id) {
        return super.delete(id);
    }

    @Override
    @GetMapping( "/notifications{id}" )
    public Notification get(@PathVariable Long id) {
        return super.get(id);
    }

    @Override
    @GetMapping( "/notifications" )
    public List<Notification> getAll() {
        return super.getAll();
    }
}

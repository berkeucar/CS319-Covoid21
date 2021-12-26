package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.NotificationService;
import com.covoid21.panman.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Notification RestController API class, includes save(...),
 * delete(...), get(...), getAll() methods
 */
@RestController
@ResponseBody
@RequestMapping("/notifications")
public class NotificationController extends ControllerBase<Notification> {
    @Autowired
    private NotificationService notificationService;

    @Override
    @PostMapping
    public Notification save(@RequestBody Notification entity) {
        return notificationService.save(entity);
    }

    @Override
    @DeleteMapping( "/{id}" )
    public Notification delete(@PathVariable Long id) {
        return notificationService.delete(id);
    }

    @Override
    @GetMapping( "/{id}" )
    public Notification get(@PathVariable Long id) {
        return notificationService.findById(id);
    }

    @Override
    @GetMapping
    public List<Notification> getAll() {
        return notificationService.findAll();
    }
}

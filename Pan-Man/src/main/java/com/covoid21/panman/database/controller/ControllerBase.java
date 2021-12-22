package com.covoid21.panman.database.controller;

import com.covoid21.panman.database.service.AnnouncementService;
import com.covoid21.panman.database.service.ServiceBase;
import com.covoid21.panman.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

@RestController
public abstract class ControllerBase<T> {
    protected ServiceBase<T> service;

    public T add(@RequestBody T entity) {
        return service.add(entity);
    }

    public T delete(@PathVariable Long id) {
        return service.delete(id);
    }

    public T get(@PathVariable Long id) { // TODO böyle mi emin değilim parametre annotationları
        return service.find(id);
    }

    public List<T> getAll() {
        return service.findAll();
    }

}

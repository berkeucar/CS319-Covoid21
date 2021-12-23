package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.AnnouncementRepository;
import com.covoid21.panman.database.repository.AppointmentRepositoryBase;
import com.covoid21.panman.entity.appointment.Appointment;
import com.covoid21.panman.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public abstract class AppointmentServiceBase<T extends Appointment> extends ServiceBase<T> {
    private AppointmentRepositoryBase<T> appointmentRepo;

    @Autowired
    public AppointmentServiceBase(AppointmentRepositoryBase<T> repo)
    {
        super(repo);
        this.appointmentRepo = repo;
    }

    public List<T> findByDateBefore(Date date) {
        return appointmentRepo.findByDateBefore(date);
    }

    public List<T> findByHostUser(User host) {
        return appointmentRepo.findByHostUser(host);
    }

}

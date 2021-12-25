package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.AnnouncementRepository;
import com.covoid21.panman.database.repository.AppointmentRepositoryBase;
import com.covoid21.panman.entity.Policy;
import com.covoid21.panman.entity.appointment.Appointment;
import com.covoid21.panman.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public abstract class AppointmentServiceBase<T extends Appointment> extends ServiceBase<T> {
    private AppointmentRepositoryBase<T> appointmentRepo;

    @Autowired
    public AppointmentServiceBase(AppointmentRepositoryBase<T> repo)
    {
        super(repo);
        this.appointmentRepo = repo;
    }

    @Override
    public T save(T entity) {
        if (appointmentRepo.existsById(entity.getId())) {
            throw new EntityExistsException();
        }
        return appointmentRepo.save(entity);
    }

    @Override
    public T update(T entity) {
        Optional<T> tmp = appointmentRepo.findById(entity.getId());

        if (tmp.isPresent() || appointmentRepo.existsByHostUser(entity.getHostUser())) {
            return appointmentRepo.save(entity);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    /**
     * This method finds an announcement from a given host user's ID and a Date
     * The query should return a single appointment
     * because one host cannot be in two different appointments at the same time
     * @param universityID
     * @param date
     * @return Found appointment (or null, if not found)
     */
    public T findByHostUserUniversityIDAndDate(int universityID, Date date) {
        return appointmentRepo.findByHostUserUniversityIDAndDate(universityID, date).get();
    }

    public List<T> findByDateBefore(Date date) {
        return appointmentRepo.findByDateBefore(date);
    }

    public List<T> findByHostUser(User host) {
        return appointmentRepo.findByHostUser(host);
    }

}

package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.appointment.Appointment;
import com.covoid21.panman.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepositoryBase<T extends Appointment> extends CrudRepository<T, Long> {
    List<T> findByDateBefore(Date date);
    List<T> findByHostUser(User host);
}

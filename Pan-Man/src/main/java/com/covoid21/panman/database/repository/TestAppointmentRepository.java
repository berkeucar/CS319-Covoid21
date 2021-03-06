package com.covoid21.panman.database.repository;

import com.covoid21.panman.entity.TestType;
import com.covoid21.panman.entity.appointment.TestAppointment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestAppointmentRepository extends AppointmentRepositoryBase<TestAppointment> {
    List<TestAppointment> findByTestType(TestType type);
}

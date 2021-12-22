package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.AppointmentRepositoryBase;
import com.covoid21.panman.database.repository.TestAppointmentRepository;
import com.covoid21.panman.entity.TestType;
import com.covoid21.panman.entity.appointment.TestAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestAppointmentService extends AppointmentServiceBase<TestAppointment> {
    private TestAppointmentRepository testAppointmentRepository;

    @Autowired
    public TestAppointmentService(TestAppointmentRepository repo) {
        super(repo);
        this.testAppointmentRepository = repo;
    }

    public List<TestAppointment> findByTestType(TestType type) {
        return testAppointmentRepository.findByTestType(type);
    }
}

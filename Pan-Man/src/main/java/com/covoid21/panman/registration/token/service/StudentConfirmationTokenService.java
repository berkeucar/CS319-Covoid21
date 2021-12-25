package com.covoid21.panman.registration.token.service;

import com.covoid21.panman.database.service.UserServiceBase;
import com.covoid21.panman.entity.user.Student;
import com.covoid21.panman.registration.token.repository.ConfirmationTokenRepositoryBase;

public class StudentConfirmationTokenService extends ConfirmationTokenServiceBase<Student> {

    public StudentConfirmationTokenService(ConfirmationTokenRepositoryBase confirmationTokenRepositoryBase, UserServiceBase userServiceBase) {
        super(confirmationTokenRepositoryBase, userServiceBase);
    }
}

package com.covoid21.panman.registration.token.entity;

import com.covoid21.panman.entity.user.Student;
import com.covoid21.panman.registration.token.entity.ConfirmationTokenBase;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("student_confirmation_token")
public class StudentConfirmationToken extends ConfirmationTokenBase<Student> {

}

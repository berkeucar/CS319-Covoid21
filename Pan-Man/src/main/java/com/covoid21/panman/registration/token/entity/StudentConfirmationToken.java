package com.covoid21.panman.registration.token.entity;

import com.covoid21.panman.entity.user.Student;

import javax.persistence.DiscriminatorValue;
import java.time.LocalDateTime;

@DiscriminatorValue("student_confirmation_token")
public class StudentConfirmationToken extends ConfirmationTokenBase<Student> {
    public StudentConfirmationToken() {
        super();
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getToken() {
        return super.getToken();
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    public LocalDateTime getExpiresAt() {
        return super.getExpiresAt();
    }

    @Override
    public LocalDateTime getConfirmedAt() {
        return super.getConfirmedAt();
    }

    @Override
    public Student getUser() {
        return super.getUser();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public void setToken(String token) {
        super.setToken(token);
    }

    @Override
    public void setCreatedAt(LocalDateTime createdAt) {
        super.setCreatedAt(createdAt);
    }

    @Override
    public void setExpiresAt(LocalDateTime expiresAt) {
        super.setExpiresAt(expiresAt);
    }

    @Override
    public void setConfirmedAt(LocalDateTime confirmedAt) {
        super.setConfirmedAt(confirmedAt);
    }

    @Override
    public void setUser(Student student) {
        super.setUser(student);
    }

    public StudentConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, Student user) {
        super(token, createdAt, expiresAt, user);
    }
}

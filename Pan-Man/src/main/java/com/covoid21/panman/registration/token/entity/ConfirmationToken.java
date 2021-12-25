package com.covoid21.panman.registration.token.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ConfirmationToken {

    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;
    /*
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "healthcare_personnel_id")
    private HealthcarePersonnel healthcarePersonnel;

    @ManyToOne
    @JoinColumn(name = "administration_personnel_id")
    private AdministrationPersonnel administrationPersonnel;

     */

    private int universityID;

    private String userType;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, int universityID, String userType) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.universityID = universityID;
        this.userType = userType;
        /*
        this.instructor = null;
        this.student = null;
        this.healthcarePersonnel = null;
        this.administrationPersonnel = null;

        if (user.getDiscriminatorValue().equals("student")) {
            this.student = (Student) user;
        }
        else if (user.getDiscriminatorValue().equals("healthcare")) {
            this.healthcarePersonnel = (HealthcarePersonnel) user;
        }
        else if (user.getDiscriminatorValue().equals("instructor")) {
            this.instructor = (Instructor) user;
        }
        else if (user.getDiscriminatorValue().equals("administration")) {
            this.administrationPersonnel = (AdministrationPersonnel) user;
        }
         */

    }
}
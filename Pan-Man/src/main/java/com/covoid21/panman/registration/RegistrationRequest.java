package com.covoid21.panman.registration;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String userType;
    private final int universityID;
    private final String email;
    private final String password;
}

package com.covoid21.panman.registration;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final int universityID;
    private final String password;
    private final String email;
}

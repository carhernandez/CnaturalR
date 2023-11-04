package com.cnaturalr.infraestructure.entry_points.user.dto;

import com.cnaturalr.domain.model.user.User;
import com.cnaturalr.domain.model.user.attributtes.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class LoginDTO {

    private String email;

    private String password;

    public User toDomain(){
        return new User(ID.builder().value(0).build(),
                Name.builder().value("").build(),
                Password.builder().value(password).build(),
                Email.builder().value(email).build(),
                Identification.builder().value(0).build());
    }

}

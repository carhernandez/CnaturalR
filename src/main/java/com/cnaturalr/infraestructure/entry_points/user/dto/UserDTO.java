package com.cnaturalr.infraestructure.entry_points.user.dto;


import com.cnaturalr.domain.model.user.User;
import com.cnaturalr.domain.model.user.attributtes.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder

public class UserDTO {

    private Integer id;

    private String name;

    private String password;

    private String email;

    private Integer identification;

    public User toDomain(){
        return new User(ID.builder().value(id).build(),
                Name.builder().value(name).build(),
                Password.builder().value(password).build(),
                Email.builder().value(email).build(),
                Identification.builder().value(identification).build());
    }

    public static UserDTO fromDomain(User user){
        return new UserDTO(user.getId().getValue(),
                user.getName().getValue(),
                user.getEmail().getValue(),
                user.getPassword().getValue(),
                user.getIdentification().getValue());
    }

    public UserDTO(Integer id, String name, String email, String password, Integer identification) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.identification = identification;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Integer getIdentification() {
        return identification;
    }
}

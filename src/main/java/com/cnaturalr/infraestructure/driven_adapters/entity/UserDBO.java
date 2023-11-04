package com.cnaturalr.infraestructure.driven_adapters.entity;


import com.cnaturalr.domain.model.user.User;
import com.cnaturalr.domain.model.user.attributtes.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name ="users")
@Builder
@Getter
@Setter

public class UserDBO {

    @Id
    private Integer id;

    private String name;

    private String password;

    private String email;

    private Integer identification;

    public static UserDBO fromDomain(User user){
        System.out.println(user.toString());
        return UserDBO.builder()
                .name(user.getName().getValue())
                .password(user.getPassword().getValue())
                .email(user.getEmail().getValue())
                .identification(user.getIdentification().getValue())
                .build();
    }

    public static User toDomain(UserDBO userDBO){
        return new User(
                ID.builder().value(userDBO.getId()).build(),
                Name.builder().value(userDBO.getName()).build(),
                Password.builder().value(userDBO.getPassword()).build(),
                Email.builder().value(userDBO.getEmail()).build(),
                Identification.builder().value(userDBO.getIdentification()).build()
        );
    }

//    public UserDBO( String name, String password, String email, Integer identification) {
//        this.name = name;
//        this.password = password;
//        this.email = email;
//        this.identification = identification;
//    }

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

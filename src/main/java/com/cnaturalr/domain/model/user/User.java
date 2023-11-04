package com.cnaturalr.domain.model.user;

import com.cnaturalr.domain.model.user.attributtes.*;

public class User {

    private ID id;

    private Name name;

    private Password password;

    private Email email;

    private Identification identification;

    public User(ID id, Name name, Password password, Email email, Identification identification) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.identification = identification;
    }

    public ID getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }

    public Email getEmail() {
        return email;
    }

    public Identification getIdentification() {
        return identification;
    }
}

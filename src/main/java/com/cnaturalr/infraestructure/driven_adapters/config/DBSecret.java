package com.cnaturalr.infraestructure.driven_adapters.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DBSecret {


    private String username;
    private String password;
    private String host;
    private Integer port;
    private String database;

    //    private String schema;

}

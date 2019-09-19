package com.mitrais.test.q3.repository.domain;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */

@Entity
@Table(name = "users_type")
public class UsersType implements Serializable {
    @Id
    @Column(name = "users_type")
    private String usersType;
    @Column(name = "users_type_desc")
    private String usersTypeDesc;

    public String getUsersType() {
        return usersType;
    }

    public void setUsersType(String usersType) {
        this.usersType = usersType;
    }

    public String getUsersTypeDesc() {
        return usersTypeDesc;
    }

    public void setUsersTypeDesc(String usersTypeDesc) {
        this.usersTypeDesc = usersTypeDesc;
    }
}


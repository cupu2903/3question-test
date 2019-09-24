package com.mitrais.dkatalis.repository.domain;

import javax.persistence.*;
import java.io.*;
import java.time.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @Column(name = "users_id")
    private String usersId;
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "phone_no")
    private String phoneNo;
    @Column(name = "full_nm")
    private String fullNm;
    @Column(name = "users_type")
    private String usersType;
    @Column(name = "reg_date")
    private LocalDateTime regDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_type", insertable = false, updatable = false)
    private UsersType refUsersType;

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFullNm() {
        return fullNm;
    }

    public void setFullNm(String fullNm) {
        this.fullNm = fullNm;
    }

    public String getUsersType() {
        return usersType;
    }

    public void setUsersType(String usersType) {
        this.usersType = usersType;
    }

    public UsersType getRefUsersType() {
        return refUsersType;
    }

    public void setRefUsersType(UsersType refUsersType) {
        this.refUsersType = refUsersType;
    }
}

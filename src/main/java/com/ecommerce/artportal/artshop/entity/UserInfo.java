package com.ecommerce.artportal.artshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "user_info", schema = "artportal")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "I_USER")
    private Integer iUser;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "L_EMAIL")
    private String email;

    @Column(name = "L_MOBILE_NO")
    private String mobileNo;

    @Column(name = "L_ACTV")
    private Character lActv;

    @Column(name = "L_STAT")
    private Character lStat;

    @Column(name = "L_PWD")
    private String password;

    @Column(name = "LAST_LOGON_TIME")
    private Timestamp lastLogonTime;

    @Column(name = "L_OTP")
    private Integer lOtp;
}

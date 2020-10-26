package com.lucifer.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Member implements Serializable {

    private static final long serialVersionUID = -1l;

    Long id;

    String email;

    String password;

    String phone;

    String nickName;

    String avatar;

    String salt;

    String trueName;

    String gender;

    String status;

    Date birth;

    Date createdAt;

    Date updatedAt;


}

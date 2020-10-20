package com.lucifer.model;

import lombok.Data;

import java.util.Date;

@Data
public class Member {

    Long id;

    String email;

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

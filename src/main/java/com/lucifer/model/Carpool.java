package com.lucifer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Carpool {
    Long id;
    String from;
    String to;
    String pass1;
    String pass2;
    String pass3;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    Date departureTime;
    String comment;
    Integer site;
    String linkman;
    String phone;
    Date createdAt;
    Date updatedAt;
}

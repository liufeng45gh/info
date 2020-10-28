package com.lucifer.model;

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
    Date departureTime;
    String comment;
    Date createdAt;
    Date updatedAt;
}

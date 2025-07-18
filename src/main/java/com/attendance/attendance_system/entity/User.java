package com.attendance.attendance_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
    private boolean active;
}

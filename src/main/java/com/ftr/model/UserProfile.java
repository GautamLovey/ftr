package com.ftr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class UserProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //use??
    int userId;
    @Size(max=20)
    String firstName;
    @Size(max=20)
    String lastName;
    @Email
    String emailId;
    Integer mobileNumber;
    String password;
    @Size(max=20)
    String nationality;
    @Size(min=7, max=12)
    String passportNumber;
    @Size(max = 200)
    String permanentAddress;
    @Size(max=200)
    String officeAddress;

    Long personalIdentificationNumber;
}

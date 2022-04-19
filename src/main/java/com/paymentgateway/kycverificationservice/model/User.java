package com.paymentgateway.kycverificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_users")
@AllArgsConstructor
@NoArgsConstructor
public class User{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true, nullable = false, updatable = false)
    private String id;

    @Transient
    private String  firstName;

    @Transient
    private String  lastName;

    @Transient
    private String fatherName;

    @Transient
    private String motherName;

    @Column
    private String nidNumber;

    @Column
    private String email;

    @Transient
    private String nationality;

    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Transient
    private String gender;

    @Transient
    private String birthCity;

    @Transient
    private String presentAddress;

    @Column
    private String nidFrontImagePath;

    @Column
    private String nidBackImagePath;

    @Column
    private String inPersonWithNid;

    @Column
    private boolean isVerified = false;

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
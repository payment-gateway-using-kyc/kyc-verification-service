package com.paymentgateway.kycverificationservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String firstName;

    private String lastName;

    private String fatherName;

    private String motherName;

    private String nidNumber;

    private String email;

    private String nationality;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String gender;

    private String birthCity;

    private String presentAddress;

    private MultipartFile nidFrontImagePath;

    private MultipartFile nidBackImagePath;

    private MultipartFile inPersonWithNid;

    private boolean isVerified = false;

}
package com.paymentgateway.kycverificationservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    public String fileUploadByNIO(MultipartFile multipartFile);
}

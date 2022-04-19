package com.paymentgateway.kycverificationservice.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class FileServiceImpl implements FileService {

    public static String DIRECTORY;
    public static String UPLOAD_DIR;
    static {
        try {
            UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
            // alternative but didn't use here
            DIRECTORY = System.getProperty("user.home") + "/Downloads/images/";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String fileUploadByNIO(MultipartFile multipartFile) {
//        boolean uploadSuccess = false;
        Path path = get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename());
        try{
            Files.copy(multipartFile.getInputStream(),path, REPLACE_EXISTING);
//            uploadSuccess = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(path.toString());
        System.out.println(path.toAbsolutePath());
        System.out.println(path.normalize());;
        return path.toString();
//        return uploadSuccess;
    }
}

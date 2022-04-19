package com.paymentgateway.kycverificationservice.service;

import com.paymentgateway.kycverificationservice.dto.request.UserRequest;
import com.paymentgateway.kycverificationservice.model.User;
import com.paymentgateway.kycverificationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileService fileService;

    public void save(UserRequest userRequest) {
        var user = new User();
        user.setNidNumber(userRequest.getNidNumber());
        user.setEmail(userRequest.getEmail());
        user.setNidFrontImagePath(fileService.fileUploadByNIO(userRequest.getNidFrontImagePath()));
        user.setNidBackImagePath(fileService.fileUploadByNIO(userRequest.getNidBackImagePath()));
        user.setInPersonWithNid(fileService.fileUploadByNIO(userRequest.getInPersonWithNid()));
        User savedUser = userRepository.save(user);
        System.out.println("saved user: "+ savedUser);
    }

    public User verifyThisUser(String email){
        var user = new User();
        user = userRepository.findByEmail(email);
        System.out.println("saved user: "+ user);
        return user;
    }
}

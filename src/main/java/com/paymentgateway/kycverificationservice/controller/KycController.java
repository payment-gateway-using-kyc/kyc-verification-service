package com.paymentgateway.kycverificationservice.controller;

import com.paymentgateway.kycverificationservice.dto.request.UserRequest;
import com.paymentgateway.kycverificationservice.model.User;
import com.paymentgateway.kycverificationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kyc")
public class KycController {

    @Autowired
    private UserService userService;

    @GetMapping("/verify")
    ResponseEntity<User> requestToVerify(String email){
        return ResponseEntity.ok(userService.verifyThisUser(email));
    }

    @PostMapping("/save")
    ResponseEntity<Void> save(@ModelAttribute UserRequest userRequest){
        userService.save(userRequest);
        return ResponseEntity.ok().build();
    }

}

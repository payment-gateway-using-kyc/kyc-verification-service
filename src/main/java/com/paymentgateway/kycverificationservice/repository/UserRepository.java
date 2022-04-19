package com.paymentgateway.kycverificationservice.repository;

import com.paymentgateway.kycverificationservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);
}

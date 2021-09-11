package com.ecommerce.artportal.artshop.service;

import com.ecommerce.artportal.artshop.model.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoService {

    public String registerUser(RegisterRequest user);
}

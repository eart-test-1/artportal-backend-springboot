package com.ecommerce.artportal.artshop.serviceimpl;

import com.ecommerce.artportal.artshop.entity.UserInfo;
import com.ecommerce.artportal.artshop.model.RegisterRequest;
import com.ecommerce.artportal.artshop.repository.UserInfoRepository;
import com.ecommerce.artportal.artshop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public String registerUser(RegisterRequest user) {
        List<Integer> isUserPresent = userInfoRepository.findUserByEmail(user.getEmail(), user.getMobileNo());
        String message = null;
        if(isUserPresent.isEmpty()) {
            UserInfo userInfo = new UserInfo();
            userInfo.setFirstName(user.getFirstName());
            userInfo.setLastName(user.getLastName());
            userInfo.setEmail(user.getEmail());
            userInfo.setMobileNo(user.getMobileNo());
            userInfo.setLActv('N');
            userInfo.setLStat('Y');
            userInfo.setPassword(user.getPassword());
            userInfoRepository.save(userInfo);
            message = "OTP send to your registered mobile number and email.";
        } else {
            message = "User already exist for the Email or Mobile number.";
        }
        return message;
    }
}

package com.ecommerce.artportal.artshop.repository;

import com.ecommerce.artportal.artshop.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    @Query(value = "SELECT I_USER FROM artportal.user_info WHERE L_EMAIL = ?1 OR L_MOBILE_NO = ?2", nativeQuery = true)
    List<Integer> findUserByEmail(String email, String mobileNo);


    @Modifying
    @Query(value = "UPDATE artportal.user_info SET L_ACTV = 'Y' WHERE L_EMAIL = ?1 OR L_MOBILE_NO = ?2 ", nativeQuery = true)
    void activateUserAccount(String email, String mobileNo);

    @Modifying
    @Query(value = "UPDATE artportal.user_info SET L_STAT = 'X' WHERE I_USER = ?1 ", nativeQuery = true)
    void deleteUserAccount(Integer iUser);





}

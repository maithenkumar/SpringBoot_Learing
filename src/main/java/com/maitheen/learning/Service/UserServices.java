package com.maitheen.learning.Service;

import org.springframework.stereotype.Service;

import com.maitheen.learning.Entity.User;
@Service

public interface UserServices {

    String signinUser(User user);

    String loginUser(User user);

    User getUser(Long id);

    User updateUser(Long id,User user);

    String deleteuser(Long id);
    
}

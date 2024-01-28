package com.maitheen.learning.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maitheen.learning.Entity.User;
import com.maitheen.learning.Service.UserServices;

@RestController
public class UserController {
    @Autowired
    UserServices userServices;

    @PostMapping("/sigin")
    public String loginUserser(@RequestBody User user) {
        try {
            return userServices.signinUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        try {
            return userServices.loginUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable Long id) {
        try {
            return userServices.getUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @PutMapping("/updateuser/{id}")
    public User updateuser(@PathVariable Long id, @RequestBody User user) {
        try {

            return userServices.updateUser(id, user);
        } catch (Exception e) {

            return null;
        }

    }

    @DeleteMapping("/deleteuser/{id}")
    String deleteUser(@PathVariable Long id) {
        return userServices.deleteuser(id);
    }
}
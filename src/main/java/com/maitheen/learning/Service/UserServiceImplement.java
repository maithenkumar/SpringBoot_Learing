package com.maitheen.learning.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maitheen.learning.Entity.User;
import com.maitheen.learning.Repo.UserRepositry;

/**
 * UserServiceImplement
 */
@Service
public class UserServiceImplement implements UserServices {

    @Autowired
    UserRepositry usRepositry;

    @Override
    public String signinUser(User user) {
        try {
            User data=usRepositry.findByEmail(user.getEmail());
            if (data!=null) {
                return "User Already Exixts ";
            }
            usRepositry.save(user);
            return "User Was Successfully created !!";

        } catch (Exception e) {
            return "Some error accour " + e;
        }
    }

    @Override
    public String loginUser(User user ) {
        try {
            User data=usRepositry.findByEmailAndPassword(user.getEmail(),user.getPassword());
            if ( data!=null) {
                return "User successfully login";

            }
            return "this user doesn't exist";
        } catch (Exception e) {
           return  e.getMessage();
        }
    }

    @Override
    public User getUser(Long id) {
        try {
            Optional<User> data =usRepositry.findById(id);
            if (data!=null) {
                return data.get();
            }else{
                System.out.println(" user not found");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
            return null;

        }
    }

    @Override
    public User updateUser(Long id ,User user)  {
        try {
            Optional<User> data=usRepositry.findById(id);
            if ( data!=null) {
                User saveData=new User(id);
                saveData.setEmail(user.getEmail());
                saveData.setPassword(user.getPassword());
                saveData.setUsername(user.getUsername());
                
                return usRepositry.save(saveData);
            }else{
                System.out.println( "User not found");
                return null;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteuser(Long id) {
        try {
            Optional<User> user =usRepositry.findById(id);
            if (user!=null ) {
                usRepositry.deleteById(id);
                return "user  was successfully deleted !! ";
            }else{
                return "user not found with this id";
            }

        } catch (Exception e) {

            return "Some error occurred while deleting : "+ e.getMessage();
        }
    }

}

package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyUser;
import com.example.demo.model.LoginModel;
import com.example.demo.model.RequestResponse;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userrepo;
    public RequestResponse savedata(UserModel userModel)

    {
         RequestResponse  response= new RequestResponse();
         try {
            MyUser user= new MyUser();
            user.setFirstname(userModel.getFirstname());
            user.setLastname(userModel.getLastname());
            user.setEmail(userModel.getEmail());
            user.setUsername(userModel.getUsername());
            user.setPassword(userModel.getPassword());
            userrepo.save(user);
            response.setMessage(" succesfull");
            response.setStatus("200 ok");
            response.setMessgaedeatail("data saved successfully");
               
         } 
         catch (Exception e) {
           e.printStackTrace(); 
         }
         return response;
    }

    public RequestResponse logindata(LoginModel loginModel) {

        RequestResponse returnValaue = new RequestResponse();
        try {
            String myusername = loginModel.getUsername();
            String mypwd = loginModel.getPassword();
            Optional<MyUser> m2 = userrepo.findByUsername(myusername);
            if (m2.isPresent()) {
                String euser = m2.get().getUsername();
                String pwd = m2.get().getPassword();
                if (euser.equals(myusername) && pwd.equals(mypwd)) {
                    returnValaue.setStatus("200 OK");
                    returnValaue.setMessage("Successfull");
                    returnValaue.setMessage("Login Successfully");
                    return returnValaue;
                } else {
                    returnValaue.setStatus("504");
                    returnValaue.setMessage("Failed");
                    returnValaue.setMessage("Invalid Username or password");
                    return returnValaue;
                }
            } else {
                returnValaue.setStatus("404");
                returnValaue.setMessage("Failed");
                returnValaue.setMessage("User not found");
                return returnValaue;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "-------------------------------");
            return returnValaue;
        }

    }
}

     

 

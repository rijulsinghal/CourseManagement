package com.coursemanagement.coursemanagement.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @PostMapping({"/signup"})
    public void getCredentials(@RequestBody String fullname , @RequestBody String password ,  @RequestBody String username  , @RequestBody String repassword){

        System.out.println(fullname);
        System.out.println(password);
        System.out.println(username);
        System.out.println(repassword);
        


    }

}


package com.coursemanagement.coursemanagement.controller;
import com.coursemanagement.coursemanagement.model.LoginModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public void GetLoginDetails(Model model ){
        model.addAttribute("UserDetails", new LoginModel());
    }
    
    @PostMapping("/test")
    public void PostLoginDetails(@ModelAttribute LoginModel loginModel , BindingResult result , Model model){
        model.addAttribute("UserDetails", loginModel);
        System.out.println(loginModel.getPassword());
        System.out.println(loginModel.getUsername());
        
    }
    


}

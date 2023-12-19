package com.example.demo.controller.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/otp")
public class OTPController {

    @PostMapping("/otp_login")
    private String viewOTPLoginForm() {
        return "/auth/otp_login";
    }
}

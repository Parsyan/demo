package com.example.demo.security;


import com.example.demo.exception.InvalidReCaptchaTokenException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.annotations.Filter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;


//public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter {
//    public CustomLoginFilter(String loginUrl, String httpMethod) {
//        setUsernameParameter("email");
//        super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(loginUrl,httpMethod));
//    }
//
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//
//        String reCaptchaFormResponse = request.getParameter("g-recaptcha-response");
//        System.out.println("Before processing authentication ....");
//
//        ReCaptchaSettings reCaptchaSettings = new ReCaptchaSettings();
//
//
//        try {
//           float score = reCaptchaSettings.verify(reCaptchaFormResponse);
//
//            if (score < 0.5) {
//                request.getRequestDispatcher("/otp/otp_login").forward(request,response);
//            }
//
//        } catch (InvalidReCaptchaTokenException | ServletException | IOException e) {
//            try {
//                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
//            } catch (IOException ex) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("Request Uri" + request.getRequestURI());
//        System.out.println(" Request : " + request.getH() + "\n Response : " + response);
//        return super.attemptAuthentication(request, response);
//    }
//}
//
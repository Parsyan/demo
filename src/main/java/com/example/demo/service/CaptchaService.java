package com.example.demo.service;

import com.example.demo.security.ReCaptchaSettings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestOperations;

import java.util.regex.Pattern;

//@Service
public class CaptchaService {

    @Autowired
    private ReCaptchaSettings captchaSettings;

    @Autowired
    private RestOperations restTemplate;

    private static final Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");

//    @Override
    public void processResponse(String response) throws Exception {
        if(!responseSanityCheck(response)) {
            throw new Exception("Response contains invalid characters");
        }

//        URI verifyUri = URI.create(String.format(
//                "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s",
//                getReCaptchaSecret(), response, getClientIP()));
//
//        GoogleResponse googleResponse = restTemplate.getForObject(verifyUri, GoogleResponse.class);
//
//        if(!googleResponse.isSuccess()) {
//            throw new ReCaptchaInvalidException("reCaptcha was not successfully validated");
//        }
    }

    private boolean responseSanityCheck(String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }
}
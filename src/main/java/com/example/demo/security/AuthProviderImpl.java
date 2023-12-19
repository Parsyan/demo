package com.example.demo.security;


import com.example.demo.service.PersonDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
@AllArgsConstructor
public class AuthProviderImpl implements AuthenticationProvider {

    private final PersonDetailsService personDetailsService;

    private final PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name =  authentication.getName();
        String password = authentication.getCredentials().toString();
        Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();

        PersonDetails personDetails = personDetailsService.loadUserByUsername(authentication.getName());
        System.out.println("Authentication User " + name + "\n  password " + password + "\n  isActive : " + personDetails.isEnabled() + "\n  Matches User " + personDetails);

        System.out.println("match result " + passwordEncoder.matches(password, personDetails.getPassword()));
        if (!personDetails.isEnabled()){
            throw new AuthenticationException(" You not activate your account ") {};
        }
        else if (!passwordEncoder.matches(password,personDetails.getPassword())){
            throw new AuthenticationException(" Password not matches ") {};
        }
//        else if (!password.equals(personDetails.getPassword())) {
//            throw new AuthenticationException(" Password not matches ") {};
//        }
        return new UsernamePasswordAuthenticationToken(name, personDetails.getPassword(), personDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

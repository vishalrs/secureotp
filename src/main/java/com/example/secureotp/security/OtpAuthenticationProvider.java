package com.example.secureotp.security;

import com.example.secureotp.common.model.OtpAuthenticationToken;
import com.example.secureotp.common.model.UserPrincipal;
import com.example.secureotp.services.UserPrincipalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

//@Component
public class OtpAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserPrincipalDetailsService userPrincipalDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        OtpAuthenticationToken token = (OtpAuthenticationToken) authentication;
        String username = token.getPrincipal().toString();
        String password = token.getCredentials().toString();
        UserDetails userPrincipal=userPrincipalDetailsService.loadUserByUsername(username);
        if(password.equals(userPrincipal.getPassword().substring(6,userPrincipal.getPassword().length()))){
            OtpAuthenticationToken otpToken = new OtpAuthenticationToken(userPrincipal.getAuthorities(),username,password,null);
            otpToken.setAuthenticated(true);
            return otpToken;
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OtpAuthenticationToken.class.equals(authentication);
    }
}

package com.example.secureotp.security;

import com.example.secureotp.common.model.OtpAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@Component
public class OtpAuthenticationFilter implements Filter {

    private AuthenticationManager authenticationManager;


    public OtpAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager=authenticationManager;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String username = httpServletRequest.getHeader("username");
        String password = httpServletRequest.getHeader("password");
        String otp = httpServletRequest.getHeader("otp");

        OtpAuthenticationToken otpAuthenticationToken = new OtpAuthenticationToken(username, password, otp); // (Object principal, Object credentials)
        Authentication authResult = authenticationManager.authenticate(otpAuthenticationToken);

        if (authResult.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authResult);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

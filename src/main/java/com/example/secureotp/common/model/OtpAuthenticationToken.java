package com.example.secureotp.common.model;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class OtpAuthenticationToken extends AbstractAuthenticationToken {

    private String username;
    private String password;
    private String otp;

    public OtpAuthenticationToken(String username, String password, String otp) {
        super((Collection)null);
        this.username = username;
        this.password = password;
        this.otp = otp;
    }

    public OtpAuthenticationToken(Collection<? extends GrantedAuthority> authorities, String username, String password, String otp) {
        super(authorities);
        this.username = username;
        this.password = password;
        this.otp = otp;
    }

    public String getOtp() {
        return otp;
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }

    @Override
    public Object getPrincipal() {
        return this.username;
    }
}

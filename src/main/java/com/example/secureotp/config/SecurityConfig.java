package com.example.secureotp.config;

import com.example.secureotp.security.OtpAuthenticationFilter;
import com.example.secureotp.security.OtpAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //@Autowired
    //OtpAuthenticationProvider otpAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/h2-console/**", "/users/otp").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterAt(new OtpAuthenticationFilter(authenticationManagerBean()), BasicAuthenticationFilter.class)
                .csrf().disable()
                .headers().frameOptions().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .authenticationProvider(getOtpAuthenticationProvider());
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public OtpAuthenticationProvider getOtpAuthenticationProvider(){
        OtpAuthenticationProvider provider = new OtpAuthenticationProvider();
        return provider;
    }
}

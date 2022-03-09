package com.example.secureotp.services;

import com.example.secureotp.common.model.User;
import com.example.secureotp.common.model.UserPrincipal;
import com.example.secureotp.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.SplittableRandom;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username);
       return new UserPrincipal(user);
    }

    public String generateOtp(String username){
        SplittableRandom rand = new SplittableRandom();
        String otp = Integer.toString(rand.nextInt(10000, 99999));
        User user = userRepository.findByUsername(username);
        user.setOtpSecret(otp);
        userRepository.saveAndFlush(user);
        return otp;
    }

    public User getUser(String username){
        return userRepository.findByUsername(username);
    }
}

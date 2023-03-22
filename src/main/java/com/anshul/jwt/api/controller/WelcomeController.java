package com.anshul.jwt.api.controller;

import com.anshul.jwt.api.util.JwtUtil;
import com.anshul.jwt.api.entity.AuthRequest;
import com.anshul.jwt.api.entity.User;
import com.anshul.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            Optional<User> user = userRepository.findByUserNameAndPassword(authRequest.getUserName(), authRequest.getPassword());
            if(!user.isPresent()){
                User user1= new User();
                user1.setUserName(authRequest.getUserName());
                user1.setPassword(authRequest.getPassword());
                userRepository.save(user1);
            }
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}

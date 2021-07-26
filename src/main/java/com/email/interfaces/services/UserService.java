package com.email.interfaces.services;

import com.email.interfaces.dtos.LoginForm;
import com.email.interfaces.dtos.RequestVerification;
import com.email.interfaces.dtos.SignUpForm;
import com.email.interfaces.entities.User;
import com.email.interfaces.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public RequestVerification verify(LoginForm loginForm) {

        RequestVerification check = new RequestVerification(false);
        Optional<User> user = userRepository.findByEmail(loginForm.getEmail());
        user.ifPresent(x-> check.setExist(true));

        return check;
    }

    public RequestVerification verifyexist(String email) {

        RequestVerification check = new RequestVerification(false);
        Optional<User> user = userRepository.findByEmail(email);
        user.ifPresent(x-> check.setExist(true));

        return check;
    }


    public RequestVerification registerNewUser(SignUpForm signUpForm) {

        RequestVerification check = new RequestVerification(false);
        Optional<User> user = userRepository.findByEmail(signUpForm.getEmail());
        user.ifPresent(x-> check.setExist(true));
        if (!check.getExist()){
            userRepository.save(User.builder()
                    .email(signUpForm.getEmail())
                    .password(signUpForm.getPassword())
                    .build());
            check.setExist(true);
        }

        return check;
    }
}

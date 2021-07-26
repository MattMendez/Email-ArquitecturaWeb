package com.email.interfaces.services;

import com.email.interfaces.dtos.EmailListResponse;
import com.email.interfaces.entities.Email;
import com.email.interfaces.repositories.EmailRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public void saveNewEmail(Email email) {

        emailRepository.save(email);
    }

    public EmailListResponse getAllEmails(String email) throws JsonProcessingException, InterruptedException {

    }

    public String saveNewEmail(Email email, HttpSession httpSession, Model model){



        model.addAttribute("emails",);

        return "home";
    }

}

package com.almo.restaurant.service.serviceImpl;

import com.almo.restaurant.entity.Person;
import com.almo.restaurant.service.serviceInterf.EmailServiceInterf;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailServiceInterf {

//@Autowired
    private JavaMailSender mailSender;

    public void sendActivationEmail(Person person){
        String activationLink = "http://localhost:8080/auth/activate/"+person.getActivationCode();
        SimpleMailMessage activationMailMessage = new SimpleMailMessage();
        activationMailMessage.setTo(person.getEmail());
        activationMailMessage.setSubject("account activation");
        activationMailMessage.setText("S'il vous plait veuillez cliquer sur ce lien pour activer votre compte Utilisateur: "+activationLink);
        mailSender.send(activationMailMessage);
    }
    public void sendResetPasswordEmail(Person person){
        String resetLink = "http://localhost:8080/auth/activate/"+person.getResetCode();
        SimpleMailMessage resetMailMessage = new SimpleMailMessage();
        resetMailMessage.setTo(person.getEmail());
        resetMailMessage.setSubject("password Reset");
        resetMailMessage.setText("please click here to reset your password: "+resetLink);

    }
}

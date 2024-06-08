
package com.example.gym.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.mail.MailException;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String from, String subject, String inquiryType) throws MailException, MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("sawanty737@gmail.com"); // Replace with your recipient's email address
        helper.setSubject(subject);

        String text = "Thank you for reaching out!\n\n";
        text += "We have received your inquiry regarding " + inquiryType + ".\n";
        text += "We will get back to you as soon as possible.\n\n";
        text += "Best regards,\nYour Company Name";

        helper.setText(text, false);
        helper.setFrom(from);

        emailSender.send(message);
    }
}

package com.jsp.ecommerce.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.jsp.ecommerce.dto.UserDto;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine engine;

    @Value("${spring.mail.username}")
    private String from;

    public void sendEmail(UserDto userDto, int otp) {

        try {
            Context context = new Context();
            context.setVariable("otp", otp);
            context.setVariable("name", userDto.getName());

            String text = engine.process("email-template.html", context);

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(from, "Ecommerce Application");
            helper.setTo(userDto.getEmail());
            helper.setSubject("OTP Verification");
            helper.setText(text, true);

            mailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace(); // better debugging
            System.err.println("OTP sending failed. OTP is: " + otp);
        }
    }
}
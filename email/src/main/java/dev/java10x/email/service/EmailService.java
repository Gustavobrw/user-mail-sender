package dev.java10x.email.service;

import dev.java10x.email.domain.EmailModel;
import dev.java10x.email.enums.EmailStatus;
import dev.java10x.email.repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final EmailRepository emailRepository;

    public EmailService(JavaMailSender mailSender, EmailRepository emailRepository) {
        this.mailSender = mailSender;
        this.emailRepository = emailRepository;
    }

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Transactional
    public void sendEmail(EmailModel emailModel) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mailFrom);
            message.setTo(emailModel.getTo());
            message.setSubject(emailModel.getEmailSubject());
            message.setText(emailModel.getBody());
            mailSender.send(message);
            emailModel.setStatusEmail(EmailStatus.SENT);
            emailModel.setSendDateEmail(java.time.LocalDateTime.now());
            emailRepository.save(emailModel);
        } catch (Exception e) {
            emailModel.setStatusEmail(EmailStatus.FAILED);
            System.out.println("Error sending email: " + e.getMessage());
        }
    }

}

package dev.java10x.user.producer;

import dev.java10x.user.domain.UserModel;
import dev.java10x.user.dto.EmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProducer {
    private final RabbitTemplate rabbitTemplate;
    private final String routingKey = "email-queue";

    public void saveAndPublish(UserModel userModel) {
        EmailDto emailDto = new EmailDto();
        emailDto.setUserId(userModel.getUserId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setEmailSubject("Bem-vindo ao nosso sistema!");
        emailDto.setBody("Olá " + userModel.getName() + ",\n\nObrigado por se cadastrar em nosso sistema.");

        rabbitTemplate.convertAndSend(routingKey, emailDto);
    }

}

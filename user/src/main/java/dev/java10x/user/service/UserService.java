package dev.java10x.user.service;

import dev.java10x.user.domain.UserModel;
import dev.java10x.user.producer.UserProducer;
import dev.java10x.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    @Transactional
    public UserModel save(UserModel userModel) {

        userModel = userRepository.save(userModel);
        userProducer.saveAndPublish(userModel);
        return userModel;
    }
}

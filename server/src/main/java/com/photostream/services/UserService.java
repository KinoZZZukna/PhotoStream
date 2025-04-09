package com.photostream.services;

import com.photostream.entity.User;
import com.photostream.entity.enums.ERole;
import com.photostream.exceptions.UserExistsException;
import com.photostream.payload.request.SignupRequest;
import com.photostream.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User createUser(SignupRequest userIn) {
        User user = new User();
        user.setEmail(userIn.getEmail());
        user.setFirstName(userIn.getFirstName());
        user.setLastName(userIn.getLastName());
        user.setUsername(userIn.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userIn.getPassword()));
        user.getRoles().add(ERole.ROLE_USER);

        try {
            logger.info("Creating user: " + userIn.getEmail());
            return userRepository.save(user);
        } catch (Exception e) {
            logger.error("Error creating user: " + userIn.getEmail(), e.getMessage());
            throw new UserExistsException("User " + userIn.getUsername() + " already exists.");
        }
    }
}

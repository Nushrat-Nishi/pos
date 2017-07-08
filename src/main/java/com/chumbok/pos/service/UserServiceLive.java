package com.chumbok.pos.service;

import com.chumbok.pos.entity.User;
import com.chumbok.pos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceLive implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {

        if (userRepository.isUserExists(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists.");
        }

        userRepository.save(user);
        return user;
    }

    @Override
    public void updateUser(User user) {

        User userById = getUser(user.getId());

        userById.setFirstName(user.getFirstName());
        userById.setLastName(user.getLastName());
        userById.setEmail(user.getEmail());
        userById.setDateOfBirth(user.getDateOfBirth());
        userById.setEnable(user.isEnable());

        userRepository.save(user);
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.delete(userId);
    }
}
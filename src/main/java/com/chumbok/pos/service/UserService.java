package com.chumbok.pos.service;

import com.chumbok.pos.entity.User;

import java.util.List;

/**
 * Created by Dell on 06-Jul-17.
 */
public interface UserService {
    List<User> getAllUsers();

    User getUser(long userId);

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(long userId);
}
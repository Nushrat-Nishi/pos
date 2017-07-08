package com.chumbok.pos.service;

import com.chumbok.pos.IUserDAO;
import com.chumbok.pos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dell on 06-Jul-17.
 */
@Transactional
@Service
public class UserServiceLive implements UserService {
    //--------------------------------------------------------------------------
    @Autowired
    private IUserDAO userDAO;

    //--------------------------------------------------------------------------getUserById
    @Override
    public User getUserById(long userId) {
        User obj = userDAO.getUserById(userId);
        return obj;
    }

    //--------------------------------------------------------------------------getAllUsers
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    //--------------------------------------------------------------------------createUser
    @Override
    public User createUser(User user) {

        if (userDAO.isUserExists(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists.");
        }

        userDAO.addUser(user);
        return user;
    }

    //--------------------------------------------------------------------------updateUser
    @Override
    public void updateUser(User user) {

        User userById = getUserById(user.getId());

        userById.setFirstName(user.getFirstName());
        userById.setLastName(user.getLastName());
        userById.setEmail(user.getEmail());
        userById.setDateOfBirth(user.getDateOfBirth());
        userById.setEnable(user.isEnable());

        userDAO.updateUser(user);
    }

    //--------------------------------------------------------------------------deleteUser
    @Override
    public void deleteUser(long userId) {
        userDAO.deleteUser(userId);
    }
    //--------------------------------------------------------------------------
}
package com.chumbok.pos;

import java.util.List;

/**
 * Created by Dell on 06-Jul-17.
 */
public interface UserService {
    List<User> getAllUsers();

    User getUserById(long userId);

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(long userId);
}
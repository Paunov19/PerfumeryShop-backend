package com.perfumery.perfumerywebapp.services;

import com.perfumery.perfumerywebapp.dtos.UserDTO;
import com.perfumery.perfumerywebapp.models.User;
import com.perfumery.perfumerywebapp.payload.request.UpdatedUserRequest;

public interface UserService {

    UserDTO registerUser(User user);
    void updateUserProfile(Long userId, UpdatedUserRequest updatedUser);
}

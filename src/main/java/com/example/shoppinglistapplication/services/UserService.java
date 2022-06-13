package com.example.shoppinglistapplication.services;

import com.example.shoppinglistapplication.models.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}

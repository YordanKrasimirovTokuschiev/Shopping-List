package com.example.shoppinglistapplication.services.impl;

import com.example.shoppinglistapplication.models.entities.User;
import com.example.shoppinglistapplication.models.service.UserServiceModel;
import com.example.shoppinglistapplication.repositories.UserRepository;
import com.example.shoppinglistapplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        userRepository.save(modelMapper.map(userServiceModel, User.class));

    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
       return userRepository
               .findByUsernameAndPassword(username, password)
               .map(user -> modelMapper.map(user, UserServiceModel.class))
               .orElse(null);
    }
}

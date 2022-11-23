package com.josekadeveloper.pollsbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.josekadeveloper.pollsbackend.entities.UserEntity;
import com.josekadeveloper.pollsbackend.models.requests.UserRegisterRequestModel;
import com.josekadeveloper.pollsbackend.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity creaUser(UserRegisterRequestModel user) {
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword(user.getPassword());
        
        return userRepository.save(userEntity);
    }
}

package com.josekadeveloper.pollsbackend.services;

import com.josekadeveloper.pollsbackend.entities.UserEntity;
import com.josekadeveloper.pollsbackend.models.requests.UserRegisterRequestModel;

public interface UserService {
    public UserEntity creaUser(UserRegisterRequestModel user);
}

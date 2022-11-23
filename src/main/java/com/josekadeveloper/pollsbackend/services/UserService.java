package com.josekadeveloper.pollsbackend.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.josekadeveloper.pollsbackend.entities.UserEntity;
import com.josekadeveloper.pollsbackend.models.requests.UserRegisterRequestModel;

public interface UserService extends UserDetailsService {

    public UserDetails loadUserByUsername(String email);

    public UserEntity creaUser(UserRegisterRequestModel user);
}

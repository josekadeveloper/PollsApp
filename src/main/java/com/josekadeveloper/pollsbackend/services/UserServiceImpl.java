package com.josekadeveloper.pollsbackend.services;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.josekadeveloper.pollsbackend.entities.UserEntity;
import com.josekadeveloper.pollsbackend.models.requests.UserRegisterRequestModel;
import com.josekadeveloper.pollsbackend.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserEntity creaUser(UserRegisterRequestModel user) {
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        
        return userRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UserEntity getUser(String email) {
        return userRepository.findByEmail(email);
    }
}

package com.josekadeveloper.pollsbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.josekadeveloper.pollsbackend.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    
}

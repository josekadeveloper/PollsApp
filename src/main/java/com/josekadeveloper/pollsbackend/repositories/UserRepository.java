package com.josekadeveloper.pollsbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.josekadeveloper.pollsbackend.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    public UserEntity findByEmail(String email);
}

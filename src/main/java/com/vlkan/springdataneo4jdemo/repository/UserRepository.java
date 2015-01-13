package com.vlkan.springdataneo4jdemo.repository;

import com.vlkan.springdataneo4jdemo.domain.UserEntity;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface UserRepository extends GraphRepository<UserEntity> {

    public UserEntity findOne(Long id);

    public UserEntity findByUsername(String username);

    public UserEntity findByUsernameAndPassword(String username, String password);

}

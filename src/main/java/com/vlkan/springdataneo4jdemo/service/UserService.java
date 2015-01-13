package com.vlkan.springdataneo4jdemo.service;

import com.vlkan.springdataneo4jdemo.domain.UserEntity;
import com.vlkan.springdataneo4jdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity create(String username, String password) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public Stream<UserEntity> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false);
    }

    public Optional<UserEntity> findById(Long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    public Optional<UserEntity> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    public Optional<UserEntity> findByUsernameAndPassword(String username, String password) {
        return Optional.ofNullable(userRepository.findByUsernameAndPassword(username, password));
    }

}

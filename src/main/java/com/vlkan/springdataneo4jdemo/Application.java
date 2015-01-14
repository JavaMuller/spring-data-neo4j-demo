package com.vlkan.springdataneo4jdemo;

import com.vlkan.springdataneo4jdemo.domain.UserEntity;
import com.vlkan.springdataneo4jdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public void run(String[] args) {
        log.info("Creating users...");
        UserEntity sam = userService.create("Sam", "SamPass");
        UserEntity bob = userService.create("Bob", "BobPass");
        List<UserEntity> users = userService.findAll().collect(Collectors.toList());
        Optional<UserEntity> maybeSam = userService.findById(sam.getId());
        log.info("Sam equals Sam? {}", sam.equals(maybeSam.get()));
        log.info("Users: {}", users);
        for (String username : Arrays.asList("Sam", "Tom"))
            log.info("findByUsername(\"{}\"): {}", username, userService.findByUsername(username));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

package com.diplom.klishin;

import com.diplom.klishin.model.Role;
import com.diplom.klishin.model.User;
import com.diplom.klishin.repository.UserRepository;
import com.diplom.klishin.repository.VoteRepository;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class Application {

    private static final Logger log = getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner startUp(UserRepository repository, VoteRepository voteRepository) {
        log.info("Generate data:");
        return (args) -> {
            log.info("  Creating users.");
            repository.save(new User("user1", "user1", "user1@gmail.com", Boolean.TRUE, new HashSet<>(Arrays.asList(Role.ROLE_USER))));
            repository.save(new User("user2", "user1", "user2@gmail.com", Boolean.TRUE, new HashSet<>(Arrays.asList(Role.ROLE_USER))));
            repository.save(new User("user3", "user1", "user3@gmail.com", Boolean.TRUE, new HashSet<>(Arrays.asList(Role.ROLE_USER))));
            repository.save(new User("admin", "admin", "admin@gmail.com", Boolean.TRUE, new HashSet<>(Arrays.asList(Role.ROLE_ADMIN))));
            log.info("  Generate data: Created {} users. ", repository.findAll().size());
        };


    }
}
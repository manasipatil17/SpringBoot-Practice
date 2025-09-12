package com.myGarageHub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myGarageHub.entity.User;
import com.myGarageHub.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}



package com.myGarageHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myGarageHub.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}

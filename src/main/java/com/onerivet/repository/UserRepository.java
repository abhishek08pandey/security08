package com.onerivet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

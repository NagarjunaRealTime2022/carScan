package com.carscan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carscan.model.UserEntity;
 
@Repository
public interface UserRepository
        extends JpaRepository<UserEntity, Long> {
 
}

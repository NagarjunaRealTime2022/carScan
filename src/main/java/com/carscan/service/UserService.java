package com.carscan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carscan.exception.RecordNotFoundException;
import com.carscan.model.UserEntity;
import com.carscan.repository.UserRepository;
 
@Service
public class UserService {
     
    @Autowired
    UserRepository repository;
     
    public List<UserEntity> getAllUsers()
    {
        List<UserEntity> UserList = repository.findAll();
         
        if(UserList.size() > 0) {
            return UserList;
        } else {
            return new ArrayList<UserEntity>();
        }
    }
     
    public UserEntity getUserById(Long id) throws RecordNotFoundException
    {
        Optional<UserEntity> User = repository.findById(id);
         
        if(User.isPresent()) {
            return User.get();
        } else {
            throw new RecordNotFoundException("No User record exist for given id");
        }
    }
     
    public UserEntity updateUser(UserEntity entity) throws RecordNotFoundException
    {
        Optional<UserEntity> User = repository.findById(entity.getId());
         
        if(User.isPresent())
        {
            UserEntity newEntity = User.get();
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setCity(entity.getCity());
            newEntity.setDob(entity.getDob());
            newEntity.setMobileNumber(entity.getMobileNumber());
            newEntity = repository.save(newEntity);
             
            return newEntity;
        }
        return null;
    }
    
    public UserEntity createUser(UserEntity entity) throws RecordNotFoundException
    {
        UserEntity user = repository.save(entity);
        return user;
    }
     
    public void deleteUserById(Long id) throws RecordNotFoundException
    {
        Optional<UserEntity> User = repository.findById(id);
         
        if(User.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No User record exist for given id");
        }
    }
}
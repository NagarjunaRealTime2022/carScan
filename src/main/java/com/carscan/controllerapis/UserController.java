package com.carscan.controllerapis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carscan.exception.RecordNotFoundException;
import com.carscan.model.UserEntity;
import com.carscan.service.UserService;
 
@RestController
@RequestMapping("/api/v1/userservice")
public class UserController
{
    @Autowired
    UserService service;
 
    /**
     * List out All Users
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> list = service.getAllUsers();
        return new ResponseEntity<List<UserEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    /**
     * get the UserId Details
     * @param id
     * @return
     * @throws RecordNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        UserEntity entity = service.getUserById(id);
        return new ResponseEntity<UserEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    /**
     * Create the User
     * @param User
     * @return
     * @throws RecordNotFoundException
     */
    @PostMapping()
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity User)
                                                    throws RecordNotFoundException {
    	return createOrUpdateUser(User);
    }
    
    /**
     * Method Used to Update the User
     * @param User
     * @return
     * @throws RecordNotFoundException
     */
    @PutMapping()
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity User)
                                                    throws RecordNotFoundException {
    	return createOrUpdateUser(User);
    }
    
 
    /**
     * Method Used to Delete the User
     * @param id
     * @return
     * @throws RecordNotFoundException
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteUserById(id);
        return new ResponseEntity<String>("Successfully Deleted "+id, new HttpHeaders(), HttpStatus.OK);
    }
    
    
    private ResponseEntity<UserEntity> createOrUpdateUser(@RequestBody UserEntity User) throws RecordNotFoundException
    {
    	UserEntity updated = service.createUser(User);
    	return new ResponseEntity<UserEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
 
}
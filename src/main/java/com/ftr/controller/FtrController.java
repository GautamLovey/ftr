package com.ftr.controller;

import com.ftr.exception.FtrCustomException;
import com.ftr.model.UserProfile;
import com.ftr.repository.FtrRepository;
import com.ftr.service.FtrService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userProfile")
@Validated
public class FtrController {
    @Autowired
    FtrService ftrService;
    @PostMapping("/")
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile){
              ftrService.addUserProfile(userProfile);
              return userProfile;
    }
    @GetMapping("/{userId}")
    public UserProfile getUserProfile(@PathVariable int userId) throws FtrCustomException{
           return ftrService.retrieveUserProfile(userId);
    }
    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId,@RequestBody UserProfile userProfile) throws FtrCustomException {
          return ftrService.updateUserDetails(userId,userProfile);


    }
    @DeleteMapping("/{userId}")
    public String deleteUser( @PathVariable  int userId) throws FtrCustomException{
        return  ftrService.deleteUser(userId);


    }
    @PostMapping("/{userId}/{password}")
    public String login(@PathVariable int userId,  @PathVariable String password) throws FtrCustomException{
         return  ftrService.login(userId,password);
    }



}

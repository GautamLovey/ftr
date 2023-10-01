package com.ftr.service;

import com.ftr.exception.FtrCustomException;
import com.ftr.model.UserProfile;
import com.ftr.repository.FtrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class FtrService {
    @Autowired
    FtrRepository ftrRepository;
    public UserProfile addUserProfile(UserProfile userProfile){
            ftrRepository.saveAndFlush(userProfile);
            return userProfile;
    }
    public UserProfile retrieveUserProfile(int userId) throws FtrCustomException{
        Optional<UserProfile> userProfile = ftrRepository.findById(userId);
        // UserProfile userProfile1 = userProfile.get();
        if(userProfile.isEmpty()){
            throw new FtrCustomException("User Not Found","404","User_Type");
        }

            return userProfile.get();
    }
    public String updateUserDetails(int userId,UserProfile userProfile) throws FtrCustomException {

     Optional<UserProfile> userProfile1 = ftrRepository.findById(userId);
        if(userProfile1.isEmpty()){
            throw new FtrCustomException("User Not Found","404","User_Type");
        }

         UserProfile userProfile2 = userProfile1.get();
         userProfile2.setFirstName(userProfile.getFirstName());
         userProfile2.setLastName(userProfile.getLastName());
         userProfile2.setEmailId(userProfile.getEmailId());
         userProfile2.setNationality(userProfile.getNationality());
         userProfile2.setMobileNumber(userProfile.getMobileNumber());
         userProfile2.setPassportNumber(userProfile.getPassportNumber());
         userProfile2.setOfficeAddress(userProfile.getOfficeAddress());
         userProfile2.setPermanentAddress(userProfile.getPermanentAddress());
         userProfile2.setPersonalIdentificationNumber(userProfile.getPersonalIdentificationNumber());
         ftrRepository.save(userProfile2);
         return "Add successfully";

    }
    public String deleteUser(int userId) throws FtrCustomException{
        Optional<UserProfile> userProfile = ftrRepository.findById(userId);
       // UserProfile userProfile1 = userProfile.get();
        if(userProfile.isEmpty()){
            throw new FtrCustomException("User Not Found","404","User_Type");
        }
        else {
            ftrRepository.deleteById(userId);
            return "Deleted";
        }

    }
    public String login(int userId,String password) throws FtrCustomException{
        Optional<UserProfile> userProfile = ftrRepository.findById(userId);
        UserProfile userProfile1 = userProfile.get();

        if(userProfile.isEmpty()){
            throw new FtrCustomException("User Not Found","404","User_Type");
        }
        else{
            if(userProfile1.getPassword().equals(password)){
                return "Credentials are valid";
            }
        }
       return "credentials are not valid";
    }

}

package com.example.demo.Services;

import com.example.demo.Entities.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public List<User> saveAllUsers(List<User> users){
        return userRepo.saveAll(users);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUserById(long id){
        return userRepo.findById(id).orElse(null);
    }

    public String deleteUser(long id){
        userRepo.deleteById(id);
        return "the "+id+" user data has been deleted";
    }

    public User updateUser (User user){
        User existingUser = userRepo.findById(user.getId()).orElse(null);
        existingUser.setId(user.getId());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return userRepo.save(existingUser);
    }
}

package com.demskv.n29;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    public void createUser(User user){
        userRepository.createUser(user);
    }

    public void updateUser(User user){
        userRepository.updateUser(user);
    }

    public void deleteUser(User user){
        userRepository.deleteUser(user);
    }
}

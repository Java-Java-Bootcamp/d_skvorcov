package com.demskv.n29;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRepository {

    public static final File usersFile = new File("N29_CRUD_NoSQL/users.txt");

    public List<User> getAllUsers() {
        System.out.println(usersFile.getAbsolutePath());
        try {
            return Files
                    .readAllLines(usersFile.toPath())
                    .stream()
                    .filter(s->s.length()>3)
                    .map(s -> s.split(","))
                    .map(s -> new User(Integer.parseInt(s[0]), s[1], s[2], s[3]))
                    .collect(Collectors.toUnmodifiableList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public User getUser(int id) {
        return getAllUsers()
                .stream()
                .filter(u->u.getId()==id)
                .findFirst()
                .orElseThrow();
    }

    public void createUser(User user){
        try {
            Files.write(usersFile.toPath(),
                    String.format("%d,%s,%s,%s\n",
                            getAllUsers().stream().map(User::getId).max(Integer::compareTo).orElseThrow()+1,
                            user.getLogin(),
                            user.getFirstName(),
                            user.getLastName()).getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user){
        User oldUser = getUser(user.getId());
        oldUser.setLogin(user.getLogin());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
    }

    public void deleteUser(User user){
        try {
            Files.write(usersFile.toPath(),"".getBytes());
            getAllUsers()
                    .stream()
                    .filter(u->u.getId()!=user.getId())
                    .forEach(this::createUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package n30;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO getUser(int id) {
        return userRepository.getById(id).toDTO();
    }

    public void createUser(UserDTO user){
        userRepository.save(user.toEntity());
    }

    public void updateUser(UserDTO user){
        userRepository.save(user.toEntity());
    }

    public void deleteUser(UserDTO user){
        userRepository.delete(user.toEntity());
    }
}

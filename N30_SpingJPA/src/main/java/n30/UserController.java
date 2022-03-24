package n30;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody UserDTO user){
        userService.createUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody UserDTO user){
        userService.updateUser(user);
    }

    @DeleteMapping("/users")
    public void deleteUser(@RequestBody UserDTO user){
        userService.deleteUser(user);
    }
}

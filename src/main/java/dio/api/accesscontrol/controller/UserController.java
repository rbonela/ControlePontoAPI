package dio.api.accesscontrol.controller;

import dio.api.accesscontrol.model.User;
import dio.api.accesscontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getUserList(){
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserByID(@PathVariable("userId") Long userId) throws Exception {
        return ResponseEntity.ok(userService.getById(userId).orElseThrow(() -> new NoSuchElementException("Error: id not found")));
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUserByID(@PathVariable("userId") Long userId) throws Exception {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok("Element with id " + userId + " successfully deleted");
        }catch (Exception e){
            return new ResponseEntity<>("Error: id not found", HttpStatus.BAD_REQUEST);
        }

    }

}

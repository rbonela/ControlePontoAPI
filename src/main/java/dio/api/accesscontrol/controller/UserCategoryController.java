package dio.api.accesscontrol.controller;

import dio.api.accesscontrol.model.UserCategory;
import dio.api.accesscontrol.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/userCategory")
public class UserCategoryController {

    @Autowired
    UserCategoryService userCategoryService;

    @PostMapping
    public UserCategory createUserCategory(@RequestBody UserCategory userCategory){
        return userCategoryService.saveUserCategory(userCategory);
    }

    @GetMapping
    public List<UserCategory> getUserCategoryList(){
        return userCategoryService.findAll();
    }

    @GetMapping("/{userCategoryId}")
    public ResponseEntity<UserCategory> getUserCategoryByID(@PathVariable("userCategoryId") Long userCategoryId) throws Exception {
        return ResponseEntity.ok(userCategoryService.getById(userCategoryId).orElseThrow(() -> new NoSuchElementException("Error: id not found")));
    }

    @PutMapping
    public UserCategory updateUserCategory(@RequestBody UserCategory userCategory){
        return userCategoryService.updateUserCategory(userCategory);
    }

    @DeleteMapping("/{userCategoryId}")
    public ResponseEntity deleteUserCategoryByID(@PathVariable("userCategoryId") Long userCategoryId) throws Exception {
        try {
            userCategoryService.deleteUserCategory(userCategoryId);
            return ResponseEntity.ok("Element with id " + userCategoryId + " successfully deleted");
        }catch (Exception e){
            return new ResponseEntity<>("Error: id not found", HttpStatus.BAD_REQUEST);
        }

    }

}

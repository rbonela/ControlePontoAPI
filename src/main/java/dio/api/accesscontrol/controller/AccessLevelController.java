package dio.api.accesscontrol.controller;

import dio.api.accesscontrol.model.AccessLevel;
import dio.api.accesscontrol.service.AccessLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/accessLevel")
public class AccessLevelController {

    @Autowired
    AccessLevelService accessLevelService;

    @PostMapping
    public AccessLevel createAccessLevel(@RequestBody AccessLevel accessLevel){
        return accessLevelService.saveAccessLevel(accessLevel);
    }

    @GetMapping
    public List<AccessLevel> getAccessLevelList(){
        return accessLevelService.findAll();
    }

    @GetMapping("/{accessLevelId}")
    public ResponseEntity<AccessLevel> getAccessLevelByID(@PathVariable("accessLevelId") Long accessLevelId) throws Exception {
        return ResponseEntity.ok(accessLevelService.getById(accessLevelId).orElseThrow(() -> new NoSuchElementException("Error: id not found")));
    }

    @PutMapping
    public AccessLevel updateAccessLevel(@RequestBody AccessLevel accessLevel){
        return accessLevelService.updateAccessLevel(accessLevel);
    }

    @DeleteMapping("/{accessLevelId}")
    public ResponseEntity deleteAccessLevelByID(@PathVariable("accessLevelId") Long accessLevelId) throws Exception {
        try {
            accessLevelService.deleteAccessLevel(accessLevelId);
            return ResponseEntity.ok("Element with id " + accessLevelId + " successfully deleted");
        }catch (Exception e){
            return new ResponseEntity<>("Error: id not found", HttpStatus.BAD_REQUEST);
        }

    }

}

package dio.api.accesscontrol.controller;

import dio.api.accesscontrol.model.Movement;
import dio.api.accesscontrol.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movement")
public class MovementController {

    @Autowired
    MovementService movementService;

    @PostMapping
    public Movement createMovement(@RequestBody Movement movement){
        return movementService.saveMovement(movement);
    }

    @GetMapping
    public List<Movement> getMovementList(){
        return movementService.findAll();
    }

    @GetMapping("/{movementId}")
    public ResponseEntity<Movement> getMovementByID(@PathVariable("movementId") Long movementId) throws Exception {
        return ResponseEntity.ok(movementService.getById(movementId).orElseThrow(() -> new NoSuchElementException("Error: id not found")));
    }

    @PutMapping
    public Movement updateMovement(@RequestBody Movement movement){
        return movementService.updateMovement(movement);
    }

    @DeleteMapping("/{movementId}")
    public ResponseEntity deleteMovementByID(@PathVariable("movementId") Long movementId) throws Exception {
        try {
            movementService.deleteMovement(movementId);
            return ResponseEntity.ok("Element with id " + movementId + " successfully deleted");
        }catch (Exception e){
            return new ResponseEntity<>("Error: id not found", HttpStatus.BAD_REQUEST);
        }

    }

}

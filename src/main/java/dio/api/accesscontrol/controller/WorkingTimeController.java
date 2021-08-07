package dio.api.accesscontrol.controller;

import dio.api.accesscontrol.service.WorkingTimeService;
import dio.api.accesscontrol.model.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/workingTime")
public class WorkingTimeController {

    @Autowired
    WorkingTimeService workingTimeService;

    @PostMapping
    public WorkingTime createWorkingTime(@RequestBody WorkingTime workingTime){
        return workingTimeService.saveWorkingTime(workingTime);
    }

    @GetMapping
    public List<WorkingTime> getWorkingTimeList(){
        return workingTimeService.findAll();
    }

    @GetMapping("/{workingTimeId}")
    public ResponseEntity<WorkingTime> getWorkingTimeByID(@PathVariable("workingTimeId") Long workingTimeId) throws Exception {
        return ResponseEntity.ok(workingTimeService.getById(workingTimeId).orElseThrow(() -> new NoSuchElementException("Error: id not found")));
    }

    @PutMapping
    public WorkingTime updateWorkingTime(@RequestBody WorkingTime workingTime){
        return workingTimeService.updateWorkingTime(workingTime);
    }

    @DeleteMapping("/{workingTimeId}")
    public ResponseEntity deleteWorkingTimeByID(@PathVariable("workingTimeId") Long workingTimeId) throws Exception {
        try {
            workingTimeService.deleteWorkingTime(workingTimeId);
            return ResponseEntity.ok("Element with id " + workingTimeId + " successfully deleted");
        }catch (Exception e){
            return new ResponseEntity<>("Error: id not found", HttpStatus.BAD_REQUEST);
        }

    }

}

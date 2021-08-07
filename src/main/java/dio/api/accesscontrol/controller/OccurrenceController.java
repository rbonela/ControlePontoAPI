package dio.api.accesscontrol.controller;

import dio.api.accesscontrol.model.Occurrence;
import dio.api.accesscontrol.service.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/occurrence")
public class OccurrenceController {

    @Autowired
    OccurrenceService occurrenceService;

    @PostMapping
    public Occurrence createOccurrence(@RequestBody Occurrence occurrence){
        return occurrenceService.saveOccurrence(occurrence);
    }

    @GetMapping
    public List<Occurrence> getOccurrenceList(){
        return occurrenceService.findAll();
    }

    @GetMapping("/{occurrenceId}")
    public ResponseEntity<Occurrence> getOccurrenceByID(@PathVariable("occurrenceId") Long occurrenceId) throws Exception {
        return ResponseEntity.ok(occurrenceService.getById(occurrenceId).orElseThrow(() -> new NoSuchElementException("Error: id not found")));
    }

    @PutMapping
    public Occurrence updateOccurrence(@RequestBody Occurrence occurrence){
        return occurrenceService.updateOccurrence(occurrence);
    }

    @DeleteMapping("/{occurrenceId}")
    public ResponseEntity deleteOccurrenceByID(@PathVariable("occurrenceId") Long occurrenceId) throws Exception {
        try {
            occurrenceService.deleteOccurrence(occurrenceId);
            return ResponseEntity.ok("Element with id " + occurrenceId + " successfully deleted");
        }catch (Exception e){
            return new ResponseEntity<>("Error: id not found", HttpStatus.BAD_REQUEST);
        }

    }

}

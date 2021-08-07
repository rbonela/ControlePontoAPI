package dio.api.accesscontrol.controller;

import dio.api.accesscontrol.model.DateType;
import dio.api.accesscontrol.service.DateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/dateType")
public class DateTypeController {

    @Autowired
    DateTypeService dateTypeService;

    @PostMapping
    public DateType createDateType(@RequestBody DateType dateType){
        return dateTypeService.saveDateType(dateType);
    }

    @GetMapping
    public List<DateType> getDateTypeList(){
        return dateTypeService.findAll();
    }

    @GetMapping("/{dateTypeId}")
    public ResponseEntity<DateType> getDateTypeByID(@PathVariable("dateTypeId") Long dateTypeId) throws Exception {
        return ResponseEntity.ok(dateTypeService.getById(dateTypeId).orElseThrow(() -> new NoSuchElementException("Error: id not found")));
    }

    @PutMapping
    public DateType updateDateType(@RequestBody DateType dateType){
        return dateTypeService.updateDateType(dateType);
    }

    @DeleteMapping("/{dateTypeId}")
    public ResponseEntity deleteDateTypeByID(@PathVariable("dateTypeId") Long dateTypeId) throws Exception {
        try {
            dateTypeService.deleteDateType(dateTypeId);
            return ResponseEntity.ok("Element with id " + dateTypeId + " successfully deleted");
        }catch (Exception e){
            return new ResponseEntity<>("Error: id not found", HttpStatus.BAD_REQUEST);
        }

    }

}

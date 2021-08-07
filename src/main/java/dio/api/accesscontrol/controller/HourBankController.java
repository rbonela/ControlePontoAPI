package dio.api.accesscontrol.controller;

import dio.api.accesscontrol.model.HourBank;
import dio.api.accesscontrol.service.HourBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/hourBank")
public class HourBankController {

    @Autowired
    HourBankService hourBankService;

    @PostMapping
    public HourBank createHourBank(@RequestBody HourBank hourBank){
        return hourBankService.saveHourBank(hourBank);
    }

    @GetMapping
    public List<HourBank> getHourBankList(){
        return hourBankService.findAll();
    }

    @GetMapping("/{hourBankId}")
    public ResponseEntity<HourBank> getHourBankByID(@PathVariable("hourBankId") Long hourBankId) throws Exception {
        return ResponseEntity.ok(hourBankService.getById(hourBankId).orElseThrow(() -> new NoSuchElementException("Error: id not found")));
    }

    @PutMapping
    public HourBank updateHourBank(@RequestBody HourBank hourBank){
        return hourBankService.updateHourBank(hourBank);
    }

    @DeleteMapping("/{hourBankId}")
    public ResponseEntity deleteHourBankByID(@PathVariable("hourBankId") Long hourBankId) throws Exception {
        try {
            hourBankService.deleteHourBank(hourBankId);
            return ResponseEntity.ok("Element with id " + hourBankId + " successfully deleted");
        }catch (Exception e){
            return new ResponseEntity<>("Error: id not found", HttpStatus.BAD_REQUEST);
        }

    }

}

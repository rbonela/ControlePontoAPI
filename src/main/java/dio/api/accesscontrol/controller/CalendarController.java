package dio.api.accesscontrol.controller;

import dio.api.accesscontrol.model.Calendar;
import dio.api.accesscontrol.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @PostMapping
    public Calendar createCalendar(@RequestBody Calendar calendar){
        return calendarService.saveCalendar(calendar);
    }

    @GetMapping
    public List<Calendar> getCalendarList(){
        return calendarService.findAll();
    }

    @GetMapping("/{calendarId}")
    public ResponseEntity<Calendar> getCalendarByID(@PathVariable("calendarId") Long calendarId) throws Exception {
        return ResponseEntity.ok(calendarService.getById(calendarId).orElseThrow(() -> new NoSuchElementException("Error: id not found")));
    }

    @PutMapping
    public Calendar updateCalendar(@RequestBody Calendar calendar){
        return calendarService.updateCalendar(calendar);
    }

    @DeleteMapping("/{calendarId}")
    public ResponseEntity deleteCalendarByID(@PathVariable("calendarId") Long calendarId) throws Exception {
        try {
            calendarService.deleteCalendar(calendarId);
            return ResponseEntity.ok("Element with id " + calendarId + " successfully deleted");
        }catch (Exception e){
            return new ResponseEntity<>("Error: id not found", HttpStatus.BAD_REQUEST);
        }

    }

}

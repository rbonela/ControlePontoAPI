package dio.api.accesscontrol.controller;

import dio.api.accesscontrol.model.Location;
import dio.api.accesscontrol.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping
    public Location createLocation(@RequestBody Location location){
        return locationService.saveLocation(location);
    }

    @GetMapping
    public List<Location> getLocationList(){
        return locationService.findAll();
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<Location> getLocationByID(@PathVariable("locationId") Long locationId) throws Exception {
        return ResponseEntity.ok(locationService.getById(locationId).orElseThrow(() -> new NoSuchElementException("Error: id not found")));
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location){
        return locationService.updateLocation(location);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity deleteLocationByID(@PathVariable("locationId") Long locationId) throws Exception {
        try {
            locationService.deleteLocation(locationId);
            return ResponseEntity.ok("Element with id " + locationId + " successfully deleted");
        }catch (Exception e){
            return new ResponseEntity<>("Error: id not found", HttpStatus.BAD_REQUEST);
        }

    }

}

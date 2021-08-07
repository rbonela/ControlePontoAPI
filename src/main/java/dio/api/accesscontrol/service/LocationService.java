package dio.api.accesscontrol.service;

import dio.api.accesscontrol.model.Location;
import dio.api.accesscontrol.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    LocationRepository locationRepository;
    @Autowired
    public LocationService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    public Location saveLocation(Location location){
        return locationRepository.save(location);
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Optional<Location> getById(Long locationId) {
        return locationRepository.findById(locationId);
    }

    public Location updateLocation(Location location){
        return locationRepository.save(location);
    }

    public void deleteLocation(Long locationId) {
        locationRepository.deleteById(locationId);
    }
}

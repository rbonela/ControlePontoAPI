package dio.api.accesscontrol.service;

import dio.api.accesscontrol.model.AccessLevel;
import dio.api.accesscontrol.repository.AccessLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccessLevelService {

    AccessLevelRepository accessLevelRepository;
    @Autowired
    public AccessLevelService(AccessLevelRepository accessLevelRepository){
        this.accessLevelRepository = accessLevelRepository;
    }

    public AccessLevel saveAccessLevel(AccessLevel accessLevel){
        return accessLevelRepository.save(accessLevel);
    }

    public List<AccessLevel> findAll() {
        return accessLevelRepository.findAll();
    }

    public Optional<AccessLevel> getById(Long accessLevelId) {
        return accessLevelRepository.findById(accessLevelId);
    }

    public AccessLevel updateAccessLevel(AccessLevel accessLevel){
        return accessLevelRepository.save(accessLevel);
    }

    public void deleteAccessLevel(Long accessLevelId) {
        accessLevelRepository.deleteById(accessLevelId);
    }
}

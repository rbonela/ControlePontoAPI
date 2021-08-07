package dio.api.accesscontrol.service;

import dio.api.accesscontrol.model.Movement;
import dio.api.accesscontrol.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementService {

    MovementRepository movementRepository;
    @Autowired
    public MovementService(MovementRepository movementRepository){
        this.movementRepository = movementRepository;
    }

    public Movement saveMovement(Movement movement){
        return movementRepository.save(movement);
    }

    public List<Movement> findAll() {
        return movementRepository.findAll();
    }

    public Optional<Movement> getById(Long movementId) {
        return movementRepository.findById(movementId);
    }

    public Movement updateMovement(Movement movement){
        return movementRepository.save(movement);
    }

    public void deleteMovement(Long movementId) {
        movementRepository.deleteById(movementId);
    }
}

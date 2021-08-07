package dio.api.accesscontrol.service;

import dio.api.accesscontrol.model.Occurrence;
import dio.api.accesscontrol.repository.OccurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccurrenceService {

    OccurrenceRepository occurrenceRepository;
    @Autowired
    public OccurrenceService(OccurrenceRepository occurrenceRepository){
        this.occurrenceRepository = occurrenceRepository;
    }

    public Occurrence saveOccurrence(Occurrence occurrence){
        return occurrenceRepository.save(occurrence);
    }

    public List<Occurrence> findAll() {
        return occurrenceRepository.findAll();
    }

    public Optional<Occurrence> getById(Long occurrenceId) {
        return occurrenceRepository.findById(occurrenceId);
    }

    public Occurrence updateOccurrence(Occurrence occurrence){
        return occurrenceRepository.save(occurrence);
    }

    public void deleteOccurrence(Long occurrenceId) {
        occurrenceRepository.deleteById(occurrenceId);
    }
}

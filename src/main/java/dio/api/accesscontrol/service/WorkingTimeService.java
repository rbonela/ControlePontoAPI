package dio.api.accesscontrol.service;

import dio.api.accesscontrol.repository.WorkingTimeRepository;
import dio.api.accesscontrol.model.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkingTimeService {

    WorkingTimeRepository workingTimeRepository;
    @Autowired
    public WorkingTimeService(WorkingTimeRepository workingTimeRepository){
        this.workingTimeRepository = workingTimeRepository;
    }

    public WorkingTime saveWorkingTime(WorkingTime workingTime){
        return workingTimeRepository.save(workingTime);
    }

    public List<WorkingTime> findAll() {
        return workingTimeRepository.findAll();
    }

    public Optional<WorkingTime> getById(Long workingTimeId) {
        return workingTimeRepository.findById(workingTimeId);
    }

    public WorkingTime updateWorkingTime(WorkingTime workingTime){
        return workingTimeRepository.save(workingTime);
    }

    public void deleteWorkingTime(Long workingTimeId) {
        workingTimeRepository.deleteById(workingTimeId);
    }
}

package dio.api.accesscontrol.service;

import dio.api.accesscontrol.model.DateType;
import dio.api.accesscontrol.repository.DateTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DateTypeService {

    DateTypeRepository dateTypeRepository;
    @Autowired
    public DateTypeService(DateTypeRepository dateTypeRepository){
        this.dateTypeRepository = dateTypeRepository;
    }

    public DateType saveDateType(DateType dateType){
        return dateTypeRepository.save(dateType);
    }

    public List<DateType> findAll() {
        return dateTypeRepository.findAll();
    }

    public Optional<DateType> getById(Long dateTypeId) {
        return dateTypeRepository.findById(dateTypeId);
    }

    public DateType updateDateType(DateType dateType){
        return dateTypeRepository.save(dateType);
    }

    public void deleteDateType(Long dateTypeId) {
        dateTypeRepository.deleteById(dateTypeId);
    }
}

package dio.api.accesscontrol.service;

import dio.api.accesscontrol.model.HourBank;
import dio.api.accesscontrol.repository.HourBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HourBankService {

    HourBankRepository hourBankRepository;
    @Autowired
    public HourBankService(HourBankRepository hourBankRepository){
        this.hourBankRepository = hourBankRepository;
    }

    public HourBank saveHourBank(HourBank hourBank){
        return hourBankRepository.save(hourBank);
    }

    public List<HourBank> findAll() {
        return hourBankRepository.findAll();
    }

    public Optional<HourBank> getById(Long hourBankId) {
        return hourBankRepository.findById(hourBankId);
    }

    public HourBank updateHourBank(HourBank hourBank){
        return hourBankRepository.save(hourBank);
    }

    public void deleteHourBank(Long hourBankId) {
        hourBankRepository.deleteById(hourBankId);
    }
}

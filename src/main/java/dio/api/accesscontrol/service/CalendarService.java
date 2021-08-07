package dio.api.accesscontrol.service;

import dio.api.accesscontrol.model.Calendar;
import dio.api.accesscontrol.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {

    CalendarRepository calendarRepository;
    @Autowired
    public CalendarService(CalendarRepository calendarRepository){
        this.calendarRepository = calendarRepository;
    }

    public Calendar saveCalendar(Calendar calendar){
        return calendarRepository.save(calendar);
    }

    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    public Optional<Calendar> getById(Long calendarId) {
        return calendarRepository.findById(calendarId);
    }

    public Calendar updateCalendar(Calendar calendar){
        return calendarRepository.save(calendar);
    }

    public void deleteCalendar(Long calendarId) {
        calendarRepository.deleteById(calendarId);
    }
}

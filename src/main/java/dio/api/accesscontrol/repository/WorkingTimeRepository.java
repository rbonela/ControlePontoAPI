package dio.api.accesscontrol.repository;

import dio.api.accesscontrol.model.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingTimeRepository extends JpaRepository<WorkingTime, Long> {

}

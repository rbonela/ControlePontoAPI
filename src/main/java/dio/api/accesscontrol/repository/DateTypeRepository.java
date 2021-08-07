package dio.api.accesscontrol.repository;

import dio.api.accesscontrol.model.DateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTypeRepository extends JpaRepository<DateType, Long> {

}

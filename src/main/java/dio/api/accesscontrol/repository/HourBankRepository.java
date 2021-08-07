package dio.api.accesscontrol.repository;

import dio.api.accesscontrol.model.HourBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HourBankRepository extends JpaRepository<HourBank, Long> {

}

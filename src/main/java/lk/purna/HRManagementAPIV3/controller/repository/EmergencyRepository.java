package lk.purna.HRManagementAPIV3.controller.repository;

import lk.purna.HRManagementAPIV3.controller.model.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRepository extends JpaRepository<Emergency,Long> {


}

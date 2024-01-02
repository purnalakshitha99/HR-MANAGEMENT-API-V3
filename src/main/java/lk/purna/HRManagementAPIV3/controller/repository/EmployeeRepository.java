package lk.purna.HRManagementAPIV3.controller.repository;

import lk.purna.HRManagementAPIV3.controller.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}

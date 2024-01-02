package lk.purna.HRManagementAPIV3.controller.repository;

import lk.purna.HRManagementAPIV3.controller.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}

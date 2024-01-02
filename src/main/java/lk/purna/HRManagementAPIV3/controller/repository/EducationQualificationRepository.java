package lk.purna.HRManagementAPIV3.controller.repository;


import lk.purna.HRManagementAPIV3.controller.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationQualificationRepository extends JpaRepository<Education,Long> {
}

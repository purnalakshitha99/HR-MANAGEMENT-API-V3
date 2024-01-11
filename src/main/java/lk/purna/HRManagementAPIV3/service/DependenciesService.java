package lk.purna.HRManagementAPIV3.service;

import lk.purna.HRManagementAPIV3.controller.request.DependenciesRq;
import lk.purna.HRManagementAPIV3.controller.response.DependenciesResponse;
import lk.purna.HRManagementAPIV3.controller.response.DependenciesResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.exception.DependenciesNotFoundException;
import lk.purna.HRManagementAPIV3.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DependenciesService {

    DependenciesResponse add(DependenciesRq dependenciesRq);

    DependenciesResponse get(Long id);

    List<DependenciesResponse> getAll();



    List<DependenciesResponse2> getAll2();

    MessageResponse delete(Long id);

    DependenciesResponse update(Long id, DependenciesRq dependenciesRq);

    DependenciesResponse addDependencies(Long employeeId,DependenciesRq dependenciesRq)throws  EmployeeNotFoundException;

    List<DependenciesResponse2> getDependencies(Long employeeId)throws EmployeeNotFoundException;

    DependenciesResponse getSpecificDependencies(Long employeeId, Long dependenciesId)throws EmployeeNotFoundException,DependenciesNotFoundException;

    DependenciesResponse updateSpecificDependencies(Long employeeId, Long dependenciesId, DependenciesRq dependenciesRq)throws EmployeeNotFoundException,DependenciesNotFoundException;
}

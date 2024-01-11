package lk.purna.HRManagementAPIV3.service;

import lk.purna.HRManagementAPIV3.controller.request.CreateInsuranceRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateInsuranceResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateInsuranceResponse2;
import lk.purna.HRManagementAPIV3.controller.response.IdResponse;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InsuranceService {


    CreateInsuranceResponse add(CreateInsuranceRq createInsuranceRq);

    CreateInsuranceResponse get(Long id);

    List<CreateInsuranceResponse> getAll(CreateInsuranceRq createInsuranceRq);

    MessageResponse delete(Long id);

    CreateInsuranceResponse update(Long id, CreateInsuranceRq createInsuranceRq);

    List<CreateInsuranceResponse2> getAll2(CreateInsuranceRq createInsuranceRq);

    CreateInsuranceResponse create(Long id,CreateInsuranceRq createInsuranceRq)throws EmployeeNotFoundException;

    CreateInsuranceResponse updateInsurances(Long employeeId,Long insuranceId, CreateInsuranceRq createInsuranceRq);

    IdResponse deleteInsurances(Long employeeId,Long insuranceId);
}

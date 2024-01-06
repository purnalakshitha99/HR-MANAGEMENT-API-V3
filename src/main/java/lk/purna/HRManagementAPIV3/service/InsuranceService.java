package lk.purna.HRManagementAPIV3.service;

import lk.purna.HRManagementAPIV3.controller.request.CreateInsuranceRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateInsuranceResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateInsuranceResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InsuranceService {


    CreateInsuranceResponse add(CreateInsuranceRq createInsuranceRq);

    CreateInsuranceResponse get(int id);

    List<CreateInsuranceResponse> getAll(CreateInsuranceRq createInsuranceRq);

    MessageResponse delete(int id);

    CreateInsuranceResponse update(int id, CreateInsuranceRq createInsuranceRq);

    List<CreateInsuranceResponse2> getAll2(CreateInsuranceRq createInsuranceRq);

    CreateInsuranceResponse create(Long id,CreateInsuranceRq createInsuranceRq);
}

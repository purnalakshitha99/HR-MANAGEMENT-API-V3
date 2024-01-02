package lk.purna.HRManagementAPIV3.service;

import lk.purna.HRManagementAPIV3.controller.model.Employee;
import lk.purna.HRManagementAPIV3.controller.request.CreateEmpRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateEmpResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateEmpResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;

import java.util.List;

public interface EmpService {



    CreateEmpResponse save(CreateEmpRq createEmpRq);
    CreateEmpResponse getSpecific(Long id);

    MessageResponse delete(Long id);

    CreateEmpResponse update(Long id,CreateEmpRq createEmpRq);

    List<CreateEmpResponse> getAll();
    
    List<CreateEmpResponse2>getAll2();
}

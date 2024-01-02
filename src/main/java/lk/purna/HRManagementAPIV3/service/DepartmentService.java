package lk.purna.HRManagementAPIV3.service;

import lk.purna.HRManagementAPIV3.controller.request.CreateDepartmentRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateDepartmentResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateDepartmentResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;

import java.util.List;


public interface DepartmentService {

    CreateDepartmentResponse add(CreateDepartmentRq createDepartmentRq);
    List<CreateDepartmentResponse> getAll();

    CreateDepartmentResponse getSpecific(int id);

    MessageResponse delete(int id);

    CreateDepartmentResponse update(int id, CreateDepartmentRq createDepartmentRq);

    List<CreateDepartmentResponse2> getAll2();
}

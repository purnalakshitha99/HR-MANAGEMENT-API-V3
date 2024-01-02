package lk.purna.HRManagementAPIV3.service;

import lk.purna.HRManagementAPIV3.controller.request.CreateDesignationRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateDesignationResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateDesignationResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;

import java.util.List;

public interface DesignationService {
    CreateDesignationResponse add(CreateDesignationRq createDesignationRq);


    CreateDesignationResponse get(Long id);

    List<CreateDesignationResponse2> getAll(CreateDesignationRq createDesignationRq);

    MessageResponse delete(Long id);

    CreateDesignationResponse update(Long id, CreateDesignationRq createDesignationRq);
}

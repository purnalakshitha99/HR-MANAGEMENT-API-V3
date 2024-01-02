package lk.purna.HRManagementAPIV3.service;

import lk.purna.HRManagementAPIV3.controller.request.CreateWorkingExperienceRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateWorkingExperienceResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateWorkingExperienceResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkingExperienceService {
     List<CreateWorkingExperienceResponse> getAll();

    CreateWorkingExperienceResponse add(CreateWorkingExperienceRq createWorkingExperienceRq);

    CreateWorkingExperienceResponse get(int id);

    MessageResponse delete(int id);

    CreateWorkingExperienceResponse update(int id, CreateWorkingExperienceRq createWorkingExperienceRq);

    List<CreateWorkingExperienceResponse2> getAll2();
}

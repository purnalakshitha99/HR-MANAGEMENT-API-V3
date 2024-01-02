package lk.purna.HRManagementAPIV3.service;

import lk.purna.HRManagementAPIV3.controller.request.EducationQualificationRq;
import lk.purna.HRManagementAPIV3.controller.response.EducationQualificationResponse;
import lk.purna.HRManagementAPIV3.controller.response.EducationQualificationResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;

import java.util.List;

public interface EducationQualificationService {

    EducationQualificationResponse add(EducationQualificationRq educationQualificationRq);

    EducationQualificationResponse get(Long id);

    List<EducationQualificationResponse2> getAll();

    EducationQualificationResponse update(Long id,EducationQualificationRq educationQualificationRq);

    MessageResponse delete(Long id);
}

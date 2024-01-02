package lk.purna.HRManagementAPIV3.service;


import lk.purna.HRManagementAPIV3.controller.request.EmergencyContactRq;
import lk.purna.HRManagementAPIV3.controller.response.EmergencyContactResponse;
import lk.purna.HRManagementAPIV3.controller.response.EmergencyContactResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;

import java.util.List;

public interface EmergencyService {
    EmergencyContactResponse add(EmergencyContactRq emergencyContactRq);

    EmergencyContactResponse get(Long id);

    EmergencyContactResponse update(Long id, EmergencyContactRq emergencyContactRq);

    List<EmergencyContactResponse> getAll();

    List<EmergencyContactResponse2> getAll2();

    MessageResponse delete(Long id);
}

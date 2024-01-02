package lk.purna.HRManagementAPIV3.service;

import lk.purna.HRManagementAPIV3.controller.request.DependenciesRq;
import lk.purna.HRManagementAPIV3.controller.response.DependenciesResponse;
import lk.purna.HRManagementAPIV3.controller.response.DependenciesResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;

import java.util.List;


public interface DependenciesService {

    DependenciesResponse add(DependenciesRq dependenciesRq);

    DependenciesResponse get(Long id);

    List<DependenciesResponse> getAll();



    List<DependenciesResponse2> getAll2();

    MessageResponse delete(Long id);

    DependenciesResponse update(Long id, DependenciesRq dependenciesRq);
}

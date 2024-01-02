package lk.purna.HRManagementAPIV3.controller;

import lk.purna.HRManagementAPIV3.controller.request.CreateDesignationRq;
import lk.purna.HRManagementAPIV3.controller.request.CreateInsuranceRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateDesignationResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateDesignationResponse2;
import lk.purna.HRManagementAPIV3.controller.response.CreateInsuranceResponse;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @PostMapping("/designations")
    public CreateDesignationResponse add(@RequestBody CreateDesignationRq createDesignationRq){
        return designationService.add(createDesignationRq);
    }


    @GetMapping("/designations/{id}")
    public CreateDesignationResponse get(@PathVariable Long id){
        return designationService.get(id);
    }

    @GetMapping("/designations")
    public List<CreateDesignationResponse2> getAll(@RequestBody CreateDesignationRq createDesignationRq){
        return designationService.getAll(createDesignationRq);
    }

    @DeleteMapping("/designations/{id}")
    public MessageResponse delete(@PathVariable Long id){
        return  designationService.delete(id);
    }

    @PutMapping("/designations/{id}")
    public CreateDesignationResponse update(@PathVariable Long id,@RequestBody CreateDesignationRq createDesignationRq){
        return designationService.update(id,createDesignationRq);
    }


}

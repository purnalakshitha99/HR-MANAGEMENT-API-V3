package lk.purna.HRManagementAPIV3.controller;

import lk.purna.HRManagementAPIV3.controller.request.CreateWorkingExperienceRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateEmpResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateWorkingExperienceResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateWorkingExperienceResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.WorkingExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkingExperienceController {

    @Autowired
    private WorkingExperienceService workingExperienceService;

    @PostMapping("/experiences")
    public CreateWorkingExperienceResponse add(@RequestBody CreateWorkingExperienceRq createWorkingExperienceRq){
        return workingExperienceService.add(createWorkingExperienceRq);
    }


    @GetMapping(value = "/experiences",headers ="Version=v1")
    public List<CreateWorkingExperienceResponse> getAll(){
        return workingExperienceService.getAll();
    }



    @GetMapping(value ="/experiences",headers = "Version=V2")
    public List<CreateWorkingExperienceResponse2> getAll2(){
        return workingExperienceService.getAll2();
    }


    @GetMapping("/experiences/{id}")
    public CreateWorkingExperienceResponse get(@PathVariable int id){
        return workingExperienceService.get(id);
    }



    @DeleteMapping("/experiences/{id}")
    public MessageResponse delete(@PathVariable int id){
        return workingExperienceService.delete(id);
    }

    @PutMapping("/experiences/{id}")
    public CreateWorkingExperienceResponse update(@PathVariable int id,@RequestBody CreateWorkingExperienceRq createWorkingExperienceRq){
        return workingExperienceService.update(id,createWorkingExperienceRq);
    }
}

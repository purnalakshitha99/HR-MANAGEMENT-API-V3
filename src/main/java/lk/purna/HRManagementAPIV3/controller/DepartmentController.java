package lk.purna.HRManagementAPIV3.controller;

import lk.purna.HRManagementAPIV3.controller.request.CreateDepartmentRq;
import lk.purna.HRManagementAPIV3.controller.request.CreateEmpRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateDepartmentResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateDepartmentResponse2;
import lk.purna.HRManagementAPIV3.controller.response.CreateEmpResponse;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public CreateDepartmentResponse add(@RequestBody CreateDepartmentRq createDepartmentRq){
       return departmentService.add(createDepartmentRq);
    }

    @GetMapping("/departments")
    public List<CreateDepartmentResponse> getAll(){
        return departmentService.getAll();
    }

    @GetMapping(value = "/departments",headers = "version=V2")
    public List<CreateDepartmentResponse2> getAll2(){
        System.out.println("in the gett all2");
        return departmentService.getAll2();
    }

    @GetMapping("/departments/{id}")
    public CreateDepartmentResponse getSpecific(@PathVariable int id){
        return departmentService.getSpecific(id);
    }

    @DeleteMapping("/departments/{id}")
    public MessageResponse delete(@PathVariable int id){
       return departmentService.delete(id);
    }

    @PutMapping("/departments/{id}")
    public CreateDepartmentResponse update(@PathVariable int id,@RequestBody CreateDepartmentRq createDepartmentRq){
        return departmentService.update(id,createDepartmentRq);
    }
}

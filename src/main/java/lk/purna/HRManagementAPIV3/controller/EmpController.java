package lk.purna.HRManagementAPIV3.controller;

import lk.purna.HRManagementAPIV3.controller.model.Employee;
import lk.purna.HRManagementAPIV3.controller.request.CreateEmpRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateEmpResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateEmpResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;


    @PostMapping("/employees")
    public CreateEmpResponse add(@RequestBody CreateEmpRq createEmpRq){
       return empService.save(createEmpRq);

    }



    @GetMapping("/employees/{id}")
    public CreateEmpResponse getSpecific(@PathVariable Long id){
        return empService.getSpecific(id);
    }

    @GetMapping("/employees")
    public List<CreateEmpResponse> getAll(){
        return  empService.getAll();
    }


    @GetMapping(name = "/employees",headers ="version=V2")
    public List<CreateEmpResponse2> getAll2(){
        return  empService.getAll2();
    }

    @DeleteMapping("/employees/{id}")
    public MessageResponse delete(@PathVariable Long id){
        System.out.println(id);
        return empService.delete(id);
    }

    @PutMapping("/employees/{id}")
    public CreateEmpResponse update(@PathVariable Long id,@RequestBody CreateEmpRq createEmpRq){
        return empService.update(id,createEmpRq);
    }


}

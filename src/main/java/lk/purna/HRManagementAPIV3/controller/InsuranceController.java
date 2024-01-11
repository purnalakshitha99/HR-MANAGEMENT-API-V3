package lk.purna.HRManagementAPIV3.controller;

import jakarta.persistence.Id;
import lk.purna.HRManagementAPIV3.controller.request.CreateInsuranceRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateInsuranceResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateInsuranceResponse2;
import lk.purna.HRManagementAPIV3.controller.response.IdResponse;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.exception.EmployeeNotFoundException;
import lk.purna.HRManagementAPIV3.exception.InsuranceNotFoundException;
import lk.purna.HRManagementAPIV3.service.InsuranceService;
import org.hibernate.metamodel.mapping.internal.IdClassRepresentationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @PostMapping("/insurances")
    public CreateInsuranceResponse add(@RequestBody CreateInsuranceRq createInsuranceRq){
        return insuranceService.add(createInsuranceRq);
    }

    @GetMapping("/insurances/{id}")

    public CreateInsuranceResponse get(@PathVariable Long id){
        return insuranceService.get(id);
    }

    @GetMapping("/insurances")

    public List<CreateInsuranceResponse> getAll(@RequestBody CreateInsuranceRq createInsuranceRq){
        return insuranceService.getAll(createInsuranceRq);
    }

    @GetMapping(value = "/insurances",headers = "version=V2")

    public List<CreateInsuranceResponse2> getAll2(@RequestBody CreateInsuranceRq createInsuranceRq){
        return insuranceService.getAll2(createInsuranceRq);
    }

    @DeleteMapping("/insurances/{id}")
    public MessageResponse delete(@PathVariable Long id){
        return  insuranceService.delete(id);
    }

    @PutMapping("/insurances/{id}")
    public CreateInsuranceResponse update(@PathVariable Long id,@RequestBody CreateInsuranceRq createInsuranceRq){
        return insuranceService.update(id,createInsuranceRq);
    }


    //insurance

    @PostMapping("/employees/{id}/insurances")
    public CreateInsuranceResponse create(@PathVariable Long id,@RequestBody CreateInsuranceRq createInsuranceRq)throws EmployeeNotFoundException {


        System.out.println("insurance create ");

     return    insuranceService.create(id,createInsuranceRq);


    }


    @PutMapping("/employees/{employee-id}/insurances/{insurance-id}")
    public CreateInsuranceResponse updateInsurance(@PathVariable("employee-id") Long employeeId ,@PathVariable("insurance-id")Long insuranceId,@RequestBody CreateInsuranceRq createInsuranceRq)throws EmployeeNotFoundException, InsuranceNotFoundException {

        System.out.println("updateInsurances");

       return insuranceService.updateInsurances(employeeId,insuranceId,createInsuranceRq);
    }


    @DeleteMapping("/employees/{employee-id}/insurances/{insurance-id}")
    public IdResponse deleteInsurances(@PathVariable("employee-id")Long employeeId,@PathVariable("insurance-id")Long insurancesId)throws InsuranceNotFoundException,EmployeeNotFoundException{

        System.out.println("delelele insurance by employee");

        return  insuranceService.deleteInsurances(employeeId,insurancesId);


    }


    @GetMapping("/employees/{employee-id}/insurances/{insurance-id}")
    public CreateInsuranceResponse getSpecificInsurance(@PathVariable("employee-id")Long employeeId,@PathVariable("insurance-id")Long insuranceId)throws EmployeeNotFoundException,InsuranceNotFoundException{
        System.out.println("get specific insurance by employee");

      return   insuranceService.getSpecificInsurance(employeeId,insuranceId);
    }
}

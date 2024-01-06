package lk.purna.HRManagementAPIV3.controller;

import lk.purna.HRManagementAPIV3.controller.request.CreateInsuranceRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateInsuranceResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateInsuranceResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.InsuranceService;
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

    public CreateInsuranceResponse get(@PathVariable int id){
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
    public MessageResponse delete(@PathVariable int id){
        return  insuranceService.delete(id);
    }

    @PutMapping("/insurances/{id}")
    public CreateInsuranceResponse update(@PathVariable int id,@RequestBody CreateInsuranceRq createInsuranceRq){
        return insuranceService.update(id,createInsuranceRq);
    }


    //insurance

    @PostMapping("/employees/{id}/insurances")
    public CreateInsuranceResponse create(@PathVariable Long id,@RequestBody CreateInsuranceRq createInsuranceRq){


        System.out.println("insurance create ");

     return    insuranceService.create(id,createInsuranceRq);


    }
}

package lk.purna.HRManagementAPIV3.controller;


import lk.purna.HRManagementAPIV3.controller.model.Emergency;
import lk.purna.HRManagementAPIV3.controller.request.EmergencyContactRq;
import lk.purna.HRManagementAPIV3.controller.response.EmergencyContactResponse;
import lk.purna.HRManagementAPIV3.controller.response.EmergencyContactResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.EmergencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmergencyContactController {


    private EmergencyService emergencyService;


    @PostMapping("/emergencyContacts")
    public EmergencyContactResponse add(@RequestBody EmergencyContactRq emergencyContactRq){
        System.out.println("added success");

        return emergencyService.add(emergencyContactRq);

    }


    @GetMapping ("/emergencyContacts/{id}")
    public  EmergencyContactResponse get(@PathVariable Long id){
        System.out.println("get");

        return emergencyService.get(id);
    }





    @PutMapping("/emergencyContacts/{id}")
    public EmergencyContactResponse update(@PathVariable Long id,@RequestBody EmergencyContactRq emergencyContactRq){
        System.out.println("update");

        return emergencyService.update(id,emergencyContactRq);
    }


    @GetMapping("/emergencyContacts")
    public List<EmergencyContactResponse> getAll(){
        System.out.println("get all");

       return emergencyService.getAll();
    }

    @GetMapping(value = "/emergencyContacts",headers = "version=V2")
    public List<EmergencyContactResponse2> getAll2(){
        System.out.println("get all version 2");

        return emergencyService.getAll2();
    }

    @DeleteMapping("/emergencyContacts/{id}")
    public MessageResponse delete(@PathVariable Long id){
        System.out.println("delete by id");

        return emergencyService.delete(id);
    }

}

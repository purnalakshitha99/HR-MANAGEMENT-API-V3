package lk.purna.HRManagementAPIV3.controller;

import lk.purna.HRManagementAPIV3.controller.request.ChildrenRq;
import lk.purna.HRManagementAPIV3.controller.response.ChildrenResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChildrenController {


    @PostMapping(value = "/childrens",headers ="Version=v1")
    public ChildrenResponse add(@RequestBody ChildrenRq childrenRq){
        System.out.println("adding children");


       ChildrenResponse childrenResponse = new ChildrenResponse(childrenRq.getId(),childrenRq.getName());



       return childrenResponse;
    }




}

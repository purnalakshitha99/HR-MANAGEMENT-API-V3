package lk.purna.HRManagementAPIV3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/test",headers ="version=v1")

    public void get(){
        System.out.println("version 01");


    }

    @GetMapping(value = "/test",headers="version=v2")
    public void get2(){
        System.out.println("version 02");


    }


}

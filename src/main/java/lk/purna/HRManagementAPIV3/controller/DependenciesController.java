package lk.purna.HRManagementAPIV3.controller;

import lk.purna.HRManagementAPIV3.controller.request.DependenciesRq;
import lk.purna.HRManagementAPIV3.controller.response.DependenciesResponse;
import lk.purna.HRManagementAPIV3.controller.response.DependenciesResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.exception.DependenciesNotFoundException;
import lk.purna.HRManagementAPIV3.exception.EmployeeNotFoundException;
import lk.purna.HRManagementAPIV3.service.DependenciesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DependenciesController {

    private DependenciesService dependenciesService;

    @PostMapping("/dependencies")
    public DependenciesResponse add(@RequestBody DependenciesRq dependenciesRq){
        System.out.println("added");

        return dependenciesService.add(dependenciesRq);

    }

    @GetMapping("/dependencies/{id}")
    public DependenciesResponse get(@PathVariable Long id){
        System.out.println("get");

        return dependenciesService.get(id);
    }

@GetMapping("/dependencies")
    public List<DependenciesResponse> getAll(){
        System.out.println("get all");

        return dependenciesService.getAll();
    }

    @GetMapping(value = "/dependencies",headers ="version=V2")
    public List<DependenciesResponse2> getAll2(){
        System.out.println("get all 2");

       return dependenciesService.getAll2();
    }

    @DeleteMapping("/dependencies/{id}")
    public MessageResponse delete(@PathVariable Long id){
        System.out.println("delete ");

        return dependenciesService.delete(id);
    }

    @PutMapping("/dependencies/{id}")
    public DependenciesResponse update(@PathVariable Long id,@RequestBody DependenciesRq dependenciesRq){
        System.out.println("updated ");

       return dependenciesService.update(id,dependenciesRq);
    }


    //dependencies add for employee
    @PostMapping("/employees/{employee-id}/dependencies")
    public DependenciesResponse addDependencies(@PathVariable("employee-id")Long employeeId,@RequestBody DependenciesRq dependenciesRq)throws  EmployeeNotFoundException {
        System.out.println("add dependencies for employee");

      return   dependenciesService.addDependencies(employeeId,dependenciesRq);
    }

}

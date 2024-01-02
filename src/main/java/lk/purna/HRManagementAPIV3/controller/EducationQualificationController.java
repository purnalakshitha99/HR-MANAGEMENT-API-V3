package lk.purna.HRManagementAPIV3.controller;

import lk.purna.HRManagementAPIV3.controller.request.EducationQualificationRq;
import lk.purna.HRManagementAPIV3.controller.response.EducationQualificationResponse;
import lk.purna.HRManagementAPIV3.controller.response.EducationQualificationResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.EducationQualificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EducationQualificationController {

    private EducationQualificationService educationQualificationService;

    @PostMapping("/educations")
    public EducationQualificationResponse add(@RequestBody EducationQualificationRq educationQualificationRq){
        System.out.println("add");

        return educationQualificationService.add(educationQualificationRq);

    }

    @GetMapping("/educations/{id}")
    public EducationQualificationResponse get(@PathVariable Long id){
        System.out.println("get specific");

        return educationQualificationService.get(id);
    }

    @GetMapping("/educations")
    public List<EducationQualificationResponse2> getAll(){
        System.out.println("get All");

       return educationQualificationService.getAll();
    }

    @PutMapping("/educations/{id}")
    public EducationQualificationResponse update(@PathVariable Long id,@RequestBody EducationQualificationRq educationQualificationRq){
        System.out.println("update");

        return educationQualificationService.update(id,educationQualificationRq);
    }

    @DeleteMapping("/educations/{id}")
    public MessageResponse delete(@PathVariable Long id){
        System.out.println("delete");

      return   educationQualificationService.delete(id);
    }
}

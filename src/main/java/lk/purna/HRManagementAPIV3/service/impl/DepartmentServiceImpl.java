package lk.purna.HRManagementAPIV3.service.impl;

import lk.purna.HRManagementAPIV3.controller.model.Department;

import lk.purna.HRManagementAPIV3.controller.repository.DepartmentRepository;
import lk.purna.HRManagementAPIV3.controller.request.CreateDepartmentRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateDepartmentResponse;

import lk.purna.HRManagementAPIV3.controller.response.CreateDepartmentResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public CreateDepartmentResponse add(CreateDepartmentRq createDepartmentRq) {

        Department department = new Department();

        department.setName(createDepartmentRq.getName());
        department.setLocation(createDepartmentRq.getLocation());


        departmentRepository.save(department);

        CreateDepartmentResponse createDepartmentResponse = new CreateDepartmentResponse();

        createDepartmentResponse.setDepId(department.getDepId());
        createDepartmentResponse.setName(createDepartmentRq.getName());
        createDepartmentResponse.setLocation(createDepartmentRq.getLocation());

        return createDepartmentResponse;
    }

    public CreateDepartmentResponse getSpecific(int id){

        Optional<Department> departmentOptional = departmentRepository.findById(id);
        CreateDepartmentResponse createDepartmentResponse = new CreateDepartmentResponse();

        if (departmentOptional.isPresent()){

            Department department = departmentOptional.get();

            createDepartmentResponse.setDepId(department.getDepId());
            createDepartmentResponse.setName(department.getName());
            createDepartmentResponse.setLocation(department.getLocation());

            return createDepartmentResponse;

        }

        return  null;

//
//        System.out.println("get specific departments");
//        CreateDepartmentResponse createDepartmentResponse = new CreateDepartmentResponse();
//
//
//        createDepartmentResponse.setDepId(createDepartmentRq.getDepId());
//        createDepartmentResponse.setName(createDepartmentRq.getName());
//        createDepartmentResponse.setLocation(createDepartmentRq.getLocation());
//
//        return  createDepartmentResponse;

    }


    public List<CreateDepartmentResponse> getAll(){

        List<Department> departments = departmentRepository.findAll();

        List<CreateDepartmentResponse> createDepartmentResponseList = new ArrayList<>();

        for (Department department : departments){
            CreateDepartmentResponse createDepartmentResponse = new CreateDepartmentResponse();

            createDepartmentResponse.setDepId(department.getDepId());
            createDepartmentResponse.setName(department.getName());
            createDepartmentResponse.setLocation(department.getLocation());

            createDepartmentResponseList.add(createDepartmentResponse);


        }

        return createDepartmentResponseList;

//
//        System.out.println("get all departments");
//        CreateDepartmentResponse createDepartmentResponse = new CreateDepartmentResponse();
//        CreateDepartmentResponse createDepartmentResponse1 = new CreateDepartmentResponse();
//        CreateDepartmentResponse createDepartmentResponse2 = new CreateDepartmentResponse();
//
//
//        createDepartmentResponse.setDepId(createDepartmentRq.getDepId());
//        createDepartmentResponse.setName(createDepartmentRq.getName());
//        createDepartmentResponse.setLocation(createDepartmentRq.getLocation());
//
//        createDepartmentResponse1.setDepId(23);
//        createDepartmentResponse1.setName("Nimal");
//        createDepartmentResponse1.setLocation("Anuradhapura");
//
//
//        createDepartmentResponse2.setDepId(34);
//        createDepartmentResponse2.setName("Aruna");
//        createDepartmentResponse2.setLocation("Jaffna");
//
//
//
//        List<CreateDepartmentResponse> createDepartmentResponseList = new ArrayList<>();
//
//        createDepartmentResponseList.add(createDepartmentResponse);
//        createDepartmentResponseList.add(createDepartmentResponse1);
//        createDepartmentResponseList.add(createDepartmentResponse2);
//
//        return createDepartmentResponseList;

    }



    @Override
    public MessageResponse delete(int id) {

        System.out.println("delete by id");
        departmentRepository.deleteById(id);

        MessageResponse messageResponse = new MessageResponse();

        messageResponse.setMessage("successfully deleted "+id+" Department");

        return messageResponse;


//        MessageResponse messageResponse = new MessageResponse();
//
//        messageResponse.setMessage("successfully delete "+id+" Department");
//
//        return  messageResponse;
    }

    @Override
    public CreateDepartmentResponse update(int id, CreateDepartmentRq createDepartmentRq) {

        Optional<Department> departmentOptional = departmentRepository.findById(id);

        if (departmentOptional.isPresent()){

            Department department = departmentOptional.get();

            department.setDepId(department.getDepId());  //mekama dannath puluwan naththan mokuth dannema nathuwa innath puluwan //mekama dammoth wenne department table eke thiyena id ekatama thama watenne //meka nodemmath e value ekatama thama set wenne
            department.setLocation(createDepartmentRq.getLocation());
            department.setName(createDepartmentRq.getName());


            Department updateDepartment = departmentRepository.save(department);

            CreateDepartmentResponse createDepartmentResponse = new CreateDepartmentResponse();

            createDepartmentResponse.setLocation(updateDepartment.getLocation());
            createDepartmentResponse.setDepId(updateDepartment.getDepId());
            createDepartmentResponse.setName(updateDepartment.getName());

            return createDepartmentResponse;
        }

        return null;

//        CreateDepartmentResponse createDepartmentResponse = new CreateDepartmentResponse();
//
//        if (id == 43){
//            System.out.println("update departments");
//            createDepartmentResponse.setDepId(245);
//            createDepartmentResponse.setName("IT");
//            createDepartmentResponse.setLocation("Rathnapura");
//        }else {
//            System.out.println("wrong id");
//        }
//        return  createDepartmentResponse;

    }


    public List<CreateDepartmentResponse2> getAll2(){


        List<Department> departmentList = departmentRepository.findAll();

        List<CreateDepartmentResponse2> createDepartmentResponseList = departmentList.stream()
                .map(department -> CreateDepartmentResponse2.builder().name(department.getName()).location(department.getLocation()).depId(department.getDepId()).build()).toList();

        return createDepartmentResponseList;
//        List<Department> departmentOptional = departmentRepository.findAll();
//        List<CreateDepartmentResponse> createDepartmentResponseList = new ArrayList<>();
//        CreateDepartmentResponse createDepartmentResponse = new CreateDepartmentResponse();
//
//       for (Department department : departmentOptional){
//
//           createDepartmentResponse.setName(department.getName());
//           createDepartmentResponse.setLocation(department.getLocation());
//           createDepartmentResponse.setDepId(department.getDepId());
//
//
//            createDepartmentResponseList.add(createDepartmentResponse);
//       }
//
//       return createDepartmentResponseList;
    }
}

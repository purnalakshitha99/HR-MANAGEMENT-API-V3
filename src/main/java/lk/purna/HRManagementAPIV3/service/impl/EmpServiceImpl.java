package lk.purna.HRManagementAPIV3.service.impl;

import lk.purna.HRManagementAPIV3.controller.model.Employee;
import lk.purna.HRManagementAPIV3.controller.repository.EmployeeRepository;
import lk.purna.HRManagementAPIV3.controller.request.CreateEmpRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateEmpResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateEmpResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public CreateEmpResponse save(CreateEmpRq createEmpRq) {
        System.out.println("employee added");

        Employee employee = new Employee();

        employee.setName(createEmpRq.getName());
        employee.setAddress(createEmpRq.getAddress());

        employeeRepository.save(employee);


        CreateEmpResponse createEmpResponse = new CreateEmpResponse();

        createEmpResponse.setId(employee.getId());
        createEmpResponse.setName(createEmpRq.getName());
        createEmpResponse.setAddress(createEmpRq.getAddress());


return createEmpResponse;

    }

    public CreateEmpResponse getSpecific(Long id){

        System.out.println("get employee");

        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        CreateEmpResponse createEmpResponse = new CreateEmpResponse();

        if (employeeOptional.isPresent()){

            Employee employee = employeeOptional.get();

            createEmpResponse.setId(employee.getId());
            createEmpResponse.setAddress(employee.getAddress());
            createEmpResponse.setName(employee.getName());

            return createEmpResponse;

        }

        return  null;

//        CreateEmpResponse createEmpResponse = new CreateEmpResponse();
//
//
//
//        if (id == 123){
//            createEmpResponse.setId(123);
//            createEmpResponse.setName("lakshitha");
//            createEmpResponse.setAddress("Kandy");
//        }
//
//        System.out.println("wrong entered");
//
//
//        return createEmpResponse;
    }

//    public List<Employee> getAll(){
//        return employeeRepository.findAll();
//    }


    @Override
    public List<CreateEmpResponse> getAll() {

        List<Employee> employees= employeeRepository.findAll();

        List<CreateEmpResponse> createEmpResponseList = new ArrayList<>();

        for (Employee employee : employees){

            CreateEmpResponse createEmpResponse = new CreateEmpResponse();

            createEmpResponse.setId(employee.getId());
            createEmpResponse.setAddress(employee.getAddress());
            createEmpResponse.setName(employee.getName());

            createEmpResponseList.add(createEmpResponse);
        }

        return createEmpResponseList;




//        CreateEmpResponse createEmpResponse = new CreateEmpResponse();
//        CreateEmpResponse createEmpResponse1 = new CreateEmpResponse();
//
//        createEmpResponse.setId(createEmpRq.getId());
//        createEmpResponse.setName(createEmpRq.getName());
//        createEmpResponse.setAddress(createEmpRq.getAddress());
//
//        createEmpResponse1.setId(234);
//        createEmpResponse1.setName("Pulathisi");
//        createEmpResponse1.setAddress("Balangoda");
//
//        List<CreateEmpResponse> createEmpResponseList = new ArrayList<>();
//
//        createEmpResponseList.add(createEmpResponse);
//        createEmpResponseList.add(createEmpResponse1);
//
//        return createEmpResponseList;
    }

    @Override
    public List<CreateEmpResponse2> getAll2() {

        System.out.println("version 2");
        List<Employee> employeeList = employeeRepository.findAll();

        return employeeList.stream().map(employee -> CreateEmpResponse2.builder().id(employee.getId()).name(employee.getName()).address(employee.getAddress()).build()).toList();
    }

    public MessageResponse delete(Long id){
        System.out.println("Delete employee");

         employeeRepository.deleteById(id);

        MessageResponse messageResponse = new MessageResponse();

        messageResponse.setMessage("successfully deleted "+id+" Employee");

        return messageResponse;
//        MessageResponse messageResponse = new MessageResponse();
//        messageResponse.setMessage("Successfully Delete "+id+" Employee");
//
//        return messageResponse;
    }

    @Override
    public CreateEmpResponse update(Long id, CreateEmpRq createEmpRq) {

       Optional<Employee> employeeOptional = employeeRepository.findById(id);

       if (employeeOptional.isPresent()){

           Employee employee = employeeOptional.get();

           employee.setId(employee.getId());
           employee.setName(createEmpRq.getName());
           employee.setAddress(createEmpRq.getAddress());

           Employee updateEmployee = employeeRepository.save(employee);

           CreateEmpResponse createEmpResponse = new CreateEmpResponse();

           createEmpResponse.setName(updateEmployee.getName());
           createEmpResponse.setId(updateEmployee.getId());
           createEmpResponse.setAddress(updateEmployee.getAddress());

           return createEmpResponse;
       }

       return null;



//        CreateEmpResponse createEmpResponse = new CreateEmpResponse();
//
//        if (id == 123){
//
//            System.out.println("update Employee");
//            createEmpResponse.setId(133);
//            createEmpResponse.setName("Malinga");
//            createEmpResponse.setAddress("Galle");
//
//
//        }else{
//            System.out.println("wrong id");
//        }
//
//        return createEmpResponse;
    }

    


}



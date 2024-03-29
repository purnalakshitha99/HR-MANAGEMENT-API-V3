package lk.purna.HRManagementAPIV3.service.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import lk.purna.HRManagementAPIV3.controller.model.Employee;
import lk.purna.HRManagementAPIV3.controller.model.Insurance;
import lk.purna.HRManagementAPIV3.controller.repository.EmployeeRepository;
import lk.purna.HRManagementAPIV3.controller.repository.InsuranceRepository;
import lk.purna.HRManagementAPIV3.controller.request.CreateInsuranceRq;
import lk.purna.HRManagementAPIV3.controller.response.*;
import lk.purna.HRManagementAPIV3.exception.EmployeeNotFoundException;
import lk.purna.HRManagementAPIV3.exception.InsuranceNotFoundException;
import lk.purna.HRManagementAPIV3.service.InsuranceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {


    private InsuranceRepository insuranceRepository;

    private EmployeeRepository employeeRepository;


    @Override
    public CreateInsuranceResponse add(CreateInsuranceRq createInsuranceRq) {

        System.out.println("add insurance");

        Insurance insurance = new Insurance();

        insurance.setType(createInsuranceRq.getType());
        insurance.setCompany(createInsuranceRq.getCompany());

        insuranceRepository.save(insurance);

        CreateInsuranceResponse createInsuranceResponse = new CreateInsuranceResponse();

        createInsuranceResponse.setId(insurance.getId());
        createInsuranceResponse.setCompany(createInsuranceRq.getCompany());
        createInsuranceResponse.setType(createInsuranceRq.getType());

        return createInsuranceResponse;

//        CreateInsuranceResponse createInsuranceResponse = new CreateInsuranceResponse();
//
//        createInsuranceResponse.setId(createInsuranceRq.getId());
//        createInsuranceResponse.setType(createInsuranceRq.getType());
//
//        return  createInsuranceResponse;
    }

    @Override
    public CreateInsuranceResponse get(Long id) {

        System.out.println("get insurances");


        Optional<Insurance> insuranceOptional = insuranceRepository.findById(id);

        if (insuranceOptional.isPresent()){

            Insurance insurance = insuranceOptional.get();

            CreateInsuranceResponse createInsuranceResponse = new CreateInsuranceResponse();

            createInsuranceResponse.setId(insurance.getId());
            createInsuranceResponse.setType(insurance.getType());
            createInsuranceResponse.setCompany(insurance.getCompany());

            return createInsuranceResponse;
        }

        return null;
//        CreateInsuranceResponse createInsuranceResponse = new CreateInsuranceResponse();
//
//        createInsuranceResponse.setId(createInsuranceRq.getId());
//        createInsuranceResponse.setType(createInsuranceRq.getType());
//
//        return createInsuranceResponse;
    }

    @Override
    public List<CreateInsuranceResponse> getAll(CreateInsuranceRq createInsuranceRq) {


        List<Insurance> insuranceList = insuranceRepository.findAll();
        List<CreateInsuranceResponse> createInsuranceResponsesList = new ArrayList<>();

        for (Insurance insurance : insuranceList){

            CreateInsuranceResponse createInsuranceResponse = new CreateInsuranceResponse();

            createInsuranceResponse.setId(insurance.getId());
            createInsuranceResponse.setCompany(insurance.getCompany());
            createInsuranceResponse.setType(insurance.getCompany());

            createInsuranceResponsesList.add(createInsuranceResponse);


        }
        return createInsuranceResponsesList;
    }

    @Override
    public MessageResponse delete(Long id) {

        insuranceRepository.deleteById(id);

        MessageResponse messageResponse = new MessageResponse();

        messageResponse.setMessage("you are successfully deleted the "+id+",that Student");

        return messageResponse;


    }

    @Override
    public CreateInsuranceResponse update(Long id, CreateInsuranceRq createInsuranceRq) {

        Optional<Insurance> insuranceOptional = insuranceRepository.findById(id);

        if(insuranceOptional.isPresent()){

            Insurance insurance = insuranceOptional.get();

            insurance.setId(insurance.getId());
            insurance.setType(createInsuranceRq.getType());
            insurance.setCompany(createInsuranceRq.getCompany());

            Insurance updatedInsurance = insuranceRepository.save(insurance);

            CreateInsuranceResponse createInsuranceResponse = new CreateInsuranceResponse();

            createInsuranceResponse.setId(insurance.getId());
            createInsuranceResponse.setType(updatedInsurance.getType());
            createInsuranceResponse.setCompany(updatedInsurance.getCompany());

            return createInsuranceResponse;
        }

        return  null;


    }

    @Override
    public List<CreateInsuranceResponse2> getAll2(CreateInsuranceRq createInsuranceRq) {
        List<Insurance> insuranceList = insuranceRepository.findAll();

        return insuranceList.stream().map(insurance -> CreateInsuranceResponse2.builder().id(insurance.getId()).type(insurance.getType()).company(insurance.getCompany()).build()).toList();


    }


    //insurance service

    public CreateInsuranceResponse create(Long id,CreateInsuranceRq createInsuranceRq)throws EmployeeNotFoundException {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (!optionalEmployee.isPresent()){

           throw new EmployeeNotFoundException("That employee not in the system "+id);

        }

        Employee employee = optionalEmployee.get();

        Insurance insurance = new Insurance();

        insurance.setType(createInsuranceRq.getType());
        insurance.setCompany(createInsuranceRq.getCompany());
        insurance.setEmployee(employee);

        insuranceRepository.save(insurance);

        CreateInsuranceResponse createInsuranceResponse = new CreateInsuranceResponse();

        createInsuranceResponse.setId(insurance.getId());
        createInsuranceResponse.setCompany(insurance.getCompany());
        createInsuranceResponse.setType(insurance.getType());

        return createInsuranceResponse;

    }

    @Override
    public CreateInsuranceResponse updateInsurances(Long employeeId,Long insuranceId, CreateInsuranceRq createInsuranceRq)throws EmployeeNotFoundException, InsuranceNotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        CreateInsuranceResponse createInsuranceResponse = new CreateInsuranceResponse();
        if (!employeeOptional.isPresent()){
            System.out.println("That employee not in the system :"+employeeId);
            throw new EmployeeNotFoundException("That employee not in the system");

        }
        Employee employee = employeeOptional.get();
        List<Insurance>insuranceList = employee.getInsurancesList();



        Insurance insuranceToUpdate = insuranceList.stream()
                .filter(insurance -> insurance.getId().equals(insuranceId)).findFirst().orElse(null);

        if (insuranceToUpdate == null){
            System.out.println("That Insurance not in the system :"+insuranceId);
            throw new InsuranceNotFoundException("That Insurance Not in the system");



        }
        insuranceToUpdate.setCompany(createInsuranceRq.getCompany());
        insuranceToUpdate.setType(createInsuranceRq.getType());

        insuranceToUpdate.setEmployee(employee);

        insuranceRepository.save(insuranceToUpdate);

        createInsuranceResponse.setId(insuranceId);
        createInsuranceResponse.setCompany(insuranceToUpdate.getCompany());
        createInsuranceResponse.setType(insuranceToUpdate.getType());


        return createInsuranceResponse;

    }








    public IdResponse deleteInsurances(Long employeeId, Long insuranceId) throws EmployeeNotFoundException,InsuranceNotFoundException{
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        IdResponse idResponse = new IdResponse();
        if (!optionalEmployee.isPresent()) {
            System.out.println("That employee Not found in the system "+employeeId);
            throw new EmployeeNotFoundException("That employee Not found in the system");
        }
        else {



            Employee employee = optionalEmployee.get();
            List<Insurance> insuranceList = employee.getInsurancesList();


//            System.out.println(insuranceList);

            Insurance insuranceToDelete = insuranceList.stream()
                    .filter(insurance -> insurance.getId().equals(insuranceId))
                    .findFirst()
                    .orElse(null);

            if (insuranceToDelete != null) {
                System.out.println("That Insurance Not in the system "+insuranceId);
               throw new InsuranceNotFoundException("That Insurance Not in the system "+insuranceId);
            }
            else {
                insuranceList.remove(insuranceToDelete);
//                employeeRepository.save(employee);
                insuranceRepository.deleteById(insuranceId);


                idResponse.setId(insuranceId);
                return idResponse;

            }
        }


    }

    @Override
    public CreateInsuranceResponse getSpecificInsurance(Long employeeId, Long insuranceId) throws InsuranceNotFoundException,EmployeeNotFoundException{

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        CreateInsuranceResponse createInsuranceResponse = new CreateInsuranceResponse();
        if (!employeeOptional.isPresent()){
            System.out.println("That Employee not in the this System "+employeeId);
           throw new EmployeeNotFoundException("That Employee not in the this system "+employeeId);
        }
        Employee employee = employeeOptional.get();
        List<Insurance> insuranceList = employee.getInsurancesList();

        Insurance insuranceListToGet = insuranceList.stream().filter(insurance -> insurance.getId().equals(insuranceId)).findFirst().orElse(null);

        if (insuranceListToGet == null){
            System.out.println("That Insurance not in the this System "+insuranceId);
            throw new InsuranceNotFoundException("That Insurance not in the this System");


        }
        createInsuranceResponse.setId(insuranceId);
        createInsuranceResponse.setType(insuranceListToGet.getType());
        createInsuranceResponse.setCompany(insuranceListToGet.getCompany());
        return createInsuranceResponse;
    }


}




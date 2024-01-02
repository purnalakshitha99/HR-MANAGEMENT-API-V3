package lk.purna.HRManagementAPIV3.service.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import lk.purna.HRManagementAPIV3.controller.model.Insurance;
import lk.purna.HRManagementAPIV3.controller.repository.InsuranceRepository;
import lk.purna.HRManagementAPIV3.controller.request.CreateInsuranceRq;
import lk.purna.HRManagementAPIV3.controller.response.CreateDepartmentResponse2;
import lk.purna.HRManagementAPIV3.controller.response.CreateInsuranceResponse;
import lk.purna.HRManagementAPIV3.controller.response.CreateInsuranceResponse2;
import lk.purna.HRManagementAPIV3.controller.response.MessageResponse;
import lk.purna.HRManagementAPIV3.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;


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
    public CreateInsuranceResponse get(int id) {

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
    public MessageResponse delete(int id) {

        insuranceRepository.deleteById(id);

        MessageResponse messageResponse = new MessageResponse();

        messageResponse.setMessage("you are successfully deleted the "+id+",that Student");

        return messageResponse;


    }

    @Override
    public CreateInsuranceResponse update(int id, CreateInsuranceRq createInsuranceRq) {

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


}
